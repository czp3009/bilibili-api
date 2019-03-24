package com.hiczp.bilibili.api.live.websocket

import com.google.gson.JsonObject
import com.hiczp.bilibili.api.BilibiliClient
import com.hiczp.bilibili.api.jsonParser
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.wss
import io.ktor.http.cio.websocket.CloseReason
import io.ktor.http.cio.websocket.WebSocketSession
import io.ktor.http.cio.websocket.close
import io.ktor.util.InternalAPI
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.decodeString
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.io.errors.IOException

/**
 * 直播客户端
 *
 * @param maybeShortRoomId 可能为短房间号的房间号
 * @param fetchRoomId 是否在连接前先获取房间号(长号)
 * @param fetchDanmakuConfig 是否在连接前先获取弹幕推送服务器地址
 * @param doEntryRoomAction 是否产生直播间观看历史记录
 * @param onConnect 回调函数, 连接成功时触发
 * @param onPopularityPacket 回调函数, 接收到人气值数据包时触发
 * @param onCommandPacket 回调函数, 接收到 Command 数据包时触发
 * @param onClose 回调函数, 连接断开时触发
 */
@Suppress("CanBeParameter")
class LiveClient(
        private val bilibiliClient: BilibiliClient,
        private val maybeShortRoomId: Long,
        private val fetchRoomId: Boolean = true,
        private val fetchDanmakuConfig: Boolean = true,
        private val doEntryRoomAction: Boolean = false,
        private val onConnect: (LiveClient) -> Unit,
        private val onPopularityPacket: (LiveClient, Int) -> Unit,
        private val onCommandPacket: (LiveClient, JsonObject) -> Unit,
        private val onClose: (LiveClient, CloseReason?) -> Unit
) {
    private val liveAPI = bilibiliClient.liveAPI
    private var websocketSession: WebSocketSession? = null

    var roomId = maybeShortRoomId
        private set

    /**
     * 开启连接, 注意此方法是 suspend 的
     */
    @UseExperimental(KtorExperimentalAPI::class, ObsoleteCoroutinesApi::class, InternalAPI::class)
    suspend fun start() {
        //得到原始房间号和主播的用户ID
        var anchorUserId = 0L
        if (fetchRoomId) {
            liveAPI.mobileRoomInit(maybeShortRoomId).await().data.also {
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
        if (doEntryRoomAction) liveAPI.roomEntryAction(roomId)

        //开启 websocket
        HttpClient(CIO).config { install(WebSockets) }.wss(host = host, port = port, path = "/sub") {
            websocketSession = this
            pingIntervalMillis = -1

            //发送进房数据包
            send(PresetPacket.enterRoomPacket(anchorUserId, roomId))
            if (incoming.receive().toPackets()[0].packetType == PacketType.ENTER_ROOM_RESPONSE) {
                try {
                    onConnect(this@LiveClient)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                //impossible
                close(IOException("Receive unreadable server response"))
            }

            //发送心跳包
            launch {
                while (true) {
                    send(PresetPacket.heartbeatPacket())
                    delay(30_000)
                }
            }

            incoming.consumeEach { frame ->
                frame.toPackets().forEach {
                    try {
                        @Suppress("NON_EXHAUSTIVE_WHEN")
                        when (it.packetType) {
                            PacketType.POPULARITY -> onPopularityPacket(this@LiveClient, it.content.int)
                            PacketType.COMMAND -> onCommandPacket(this@LiveClient, jsonParser.parse(it.content.decodeString()).asJsonObject)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            launch {
                val closeReason = closeReason.await()
                try {
                    onClose(this@LiveClient, closeReason)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    /**
     * 关闭连接
     */
    suspend fun close() = websocketSession?.run {
        websocketSession = null
        close(CloseReason(CloseReason.Codes.NORMAL, "user close"))
    } ?: Unit
}
