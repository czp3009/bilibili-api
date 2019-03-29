package com.hiczp.bilibili.api.live.websocket

import com.github.salomonbrys.kotson.obj
import com.google.gson.JsonObject
import com.hiczp.bilibili.api.BilibiliClient
import com.hiczp.bilibili.api.jsonParser
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.wss
import io.ktor.http.cio.websocket.CloseReason
import io.ktor.http.cio.websocket.close
import io.ktor.util.InternalAPI
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.decodeString
import io.ktor.util.error
import kotlinx.coroutines.*
import mu.KotlinLogging

private val logger = KotlinLogging.logger { }

/**
 * 直播客户端
 * 注意该类是有状态的
 *
 * @param maybeShortRoomId 可能为短房间号的房间号
 * @param fetchRoomId 是否在连接前先获取房间号(长号)
 * @param fetchDanmakuConfig 是否在连接前先获取弹幕推送服务器地址
 * @param doEntryRoomAction 是否产生直播间观看历史记录
 * @param sendUserOnlineHeart 是否发送 rest 心跳包, 这会增加观看直播的时长, 用于服务端统计(与弹幕推送无关)
 * @param callback 回调
 */
@Suppress("CanBeParameter")
class LiveClient(
        private val bilibiliClient: BilibiliClient,
        maybeShortRoomId: Long,
        private val fetchRoomId: Boolean = true,
        private val fetchDanmakuConfig: Boolean = true,
        private val doEntryRoomAction: Boolean = false,
        private val sendUserOnlineHeart: Boolean = false,
        callback: LiveClientCallbackDSL.() -> Unit
) {
    private val callback = LiveClientCallbackDSL().apply { callback() }
    private val liveAPI = bilibiliClient.liveAPI

    var roomId = maybeShortRoomId
        private set

    /**
     * 开启连接
     */
    @UseExperimental(KtorExperimentalAPI::class, ObsoleteCoroutinesApi::class, InternalAPI::class)
    fun launch() = GlobalScope.launch(CoroutineExceptionHandler { _, throwable ->
        callback.onError?.invoke(this, throwable) ?: logger.error(throwable)
    }) {
        //得到原始房间号和主播的用户ID
        var anchorUserId = 0L
        if (fetchRoomId) {
            liveAPI.mobileRoomInit(roomId).await().data.also {
                roomId = it.roomId
                anchorUserId = it.uid
            }
        }

        //获得 wss 地址和端口(推荐服务器)
        @Suppress("SpellCheckingInspection")
        var host = "broadcastlv.chat.bilibili.com"
        var port = 443
        if (fetchDanmakuConfig) {
            liveAPI.getDanmakuConfig(roomId).await().data.also { data ->
                host = data.host
                data.hostServerList.find { it.host == host }?.wssPort?.also {
                    port = it
                }
            }
        }

        //产生历史记录
        @Suppress("DeferredResultUnused")
        if (doEntryRoomAction && bilibiliClient.isLogin) liveAPI.roomEntryAction(roomId)

        //开启 websocket
        HttpClient(CIO).config { install(WebSockets) }.wss(host = host, port = port, path = "/sub") {
            //发送进房数据包
            send(PresetPacket.enterRoomPacket(anchorUserId, roomId))
            val enterRoomResponsePacket = incoming.receive().toPackets()[0]
            if (enterRoomResponsePacket.packetType == PacketType.ENTER_ROOM_RESPONSE) {
                try {
                    callback.onConnect?.invoke(this@LiveClient)
                } catch (e: Exception) {
                    logger.error(e)
                }
            } else {
                //impossible
                logger.error { "Receive unreadable server response: $enterRoomResponsePacket" }
                close(CloseReason(CloseReason.Codes.NOT_CONSISTENT, ""))
                return@wss
            }

            //发送 rest 心跳包
            //五分钟一次
            val restHeartBeatJob = if (sendUserOnlineHeart && bilibiliClient.isLogin) {
                launch {
                    val scale = bilibiliClient.billingClientProperties.scale
                    while (true) {
                        liveAPI.userOnlineHeart(roomId, scale).invokeOnCompletion {
                            if (it != null) logger.error(it)
                        }
                        delay(300_000)
                    }
                }
            } else {
                null
            }

            //发送 websocket 心跳包
            //30 秒一次
            val websocketHeartBeatJob = launch {
                try {
                    while (true) {
                        send(PresetPacket.heartbeatPacket())
                        delay(30_000)
                    }
                } catch (ignore: CancellationException) {
                    //ignore
                } catch (e: Exception) {
                    logger.error(e)
                }
            }

            try {
                while (true) {
                    withTimeout(40_000) {
                        incoming.receive()
                    }.toPackets().forEach {
                        try {
                            @Suppress("NON_EXHAUSTIVE_WHEN")
                            when (it.packetType) {
                                PacketType.POPULARITY -> callback.onPopularityPacket?.invoke(
                                        this@LiveClient,
                                        it.content.int
                                )
                                PacketType.COMMAND -> callback.onCommandPacket?.invoke(
                                        this@LiveClient,
                                        jsonParser.parse(it.content.decodeString()).obj
                                )
                            }
                        } catch (e: Exception) {
                            logger.error(e)
                        }
                    }
                }
            } catch (e: TimeoutCancellationException) {
                throw e
            } catch (e: CancellationException) {
                close()
            } finally {
                restHeartBeatJob?.cancel()
                websocketHeartBeatJob.cancel()
                launch {
                    val closeReason = closeReason.await()
                    try {
                        callback.onClose?.invoke(this@LiveClient, closeReason)
                    } catch (e: Exception) {
                        logger.error(e)
                    }
                }
            }
        }
    }

    /**
     * 发送弹幕
     */
    fun sendMessage(message: String) =
            liveAPI.sendMessage(cid = roomId, mid = bilibiliClient.userId ?: 0, message = message)
}

class LiveClientCallbackDSL {
    /**
     * 成功进入房间时触发
     */
    var onConnect: ((LiveClient) -> Unit)? = null

    /**
     * 抛出异常时触发
     */
    var onError: ((LiveClient, Throwable) -> Unit)? = null

    /**
     * 收到人气值数据包
     */
    var onPopularityPacket: ((LiveClient, Int) -> Unit)? = null

    /**
     * 收到 command 数据包
     */
    var onCommandPacket: ((LiveClient, JsonObject) -> Unit)? = null

    /**
     * 连接关闭时触发
     */
    var onClose: ((LiveClient, CloseReason?) -> Unit)? = null
}

/**
 * 打开一个直播客户端
 */
fun BilibiliClient.liveClient(
        roomId: Long,
        fetchRoomId: Boolean = true,
        fetchDanmakuConfig: Boolean = true,
        doEntryRoomAction: Boolean = false,
        sendUserOnlineHeart: Boolean = false,
        callback: LiveClientCallbackDSL.() -> Unit
) = LiveClient(
        this, roomId, fetchRoomId, fetchDanmakuConfig, doEntryRoomAction, sendUserOnlineHeart,
        callback
)
