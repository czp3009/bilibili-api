package com.hiczp.bilibili.api.live.websocket

import com.hiczp.bilibili.api.BilibiliClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.wss
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.map
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.io.errors.IOException
import java.math.BigInteger

/**
 * 直播客户端
 *
 * @param maybeShortRoomId 可能为短房间号的房间号
 * @param fetchRoomId 是否在连接前先获取房间号(长号)
 * @param fetchDanmakuConfig 是否在连接前先获取弹幕推送服务器地址
 * @param doEntryRoomAction 是否产生直播间观看历史记录
 */
class LiveClient(
        private val bilibiliClient: BilibiliClient,
        private val maybeShortRoomId: Long,
        private val fetchRoomId: Boolean = true,
        private val fetchDanmakuConfig: Boolean = true,
        private val doEntryRoomAction: Boolean = false
) {
    var roomId = maybeShortRoomId
        private set

    @UseExperimental(KtorExperimentalAPI::class, kotlinx.coroutines.ObsoleteCoroutinesApi::class)
    suspend fun start() {
        val liveAPI = bilibiliClient.liveAPI

        //得到原始房间号和房间主用户ID
        var anchorUserId = 0L
        if (fetchRoomId) {
            liveAPI.mobileRoomInit(maybeShortRoomId).await().data.also {
                roomId = it.roomId
                anchorUserId = it.uid
            }
        }

        //获得 wss 地址和端口(推荐服务器)
        @Suppress("SpellCheckingInspection")
        var host = "tx-hk-live-comet-01.chat.bilibili.com"
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
            pingIntervalMillis = -1

            try {
                //发送进房数据包
                send(PresetPacket.enterRoomPacket(anchorUserId, roomId))
                if (incoming.receive().toPacket().packetType != PacketType.ENTER_ROOM_RESPONSE) {
                    //impossible
                    close(IOException("Receive incorrect server response"))
                }

                //发送心跳包
                launch {
                    while (true) {
                        send(PresetPacket.heartbeatPacket())
                        delay(30_000)
                    }
                }

                incoming.map { it.toPacket() }.consumeEach {
                    println(
                            when (it.packetType) {
                                PacketType.POPULARITY -> "Current popularity: ${BigInteger(it.content).longValueExact()}"
                                PacketType.COMMAND -> "${it.getJsonContent()}"
                                else -> "Other packet: $it"
                            }
                    )
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
