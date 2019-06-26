package com.hiczp.bilibili.websocket

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.websocket.DefaultClientWebSocketSession
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.wss
import io.ktor.util.InternalAPI
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.error
import io.ktor.util.moveToByteArray
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import mu.KotlinLogging

private val logger = KotlinLogging.logger { }

typealias BilibiliClientWebSocketSession = DefaultClientWebSocketSession

@UseExperimental(ObsoleteCoroutinesApi::class, InternalCoroutinesApi::class, ExperimentalCoroutinesApi::class, InternalAPI::class)
val BilibiliClientWebSocketSession.resolvedPackets
    get() = produce {
        incoming.consumeEach { frame ->
            frame.toPackets().forEach { packet ->
                when (packet.packetType) {
                    PacketType.COMMAND -> send(CommandPacket(packet.content))
                    PacketType.POPULARITY -> send(PopularityPacket(packet.content))
                    else -> logger.error {
                        """
                            Unknown packet: $packet
                            Content: ${packet.content.moveToByteArray().joinToString(separator = " ") { "%02x".format(it) }}
                         """.trimIndent()
                    }
                }
            }
        }
    }

/**
 * 直播客户端
 *
 * @param roomId 房间号, 如果使用短号可能得不到正确的人气值信息
 * @param anchorUserId 房间主播的 ID
 * @param host 服务器地址
 * @param port 端口
 */
@Suppress("MemberVisibilityCanBePrivate")
class LiveClient(
        val roomId: Long,
        val anchorUserId: Long = 0,
        @Suppress("SpellCheckingInspection")
        val host: String = "broadcastlv.chat.bilibili.com",
        val port: Int = 443,
        private val block: suspend BilibiliClientWebSocketSession.(LiveClient) -> Unit
) {
    @UseExperimental(InternalAPI::class, KtorExperimentalAPI::class, ExperimentalCoroutinesApi::class)
    suspend fun connect() = httpClient.wss(host = host, port = port, path = "/sub") {
        send(PresetPacket.enterRoom(anchorUserId, roomId))
        //impossible
        if (incoming.receive().toPackets().first().packetType != PacketType.ENTER_ROOM_RESPONSE) {
            error("Unexpected packet type")
        }
        logger.debug { "Connected to room $roomId" }

        //心跳包, 30s 一次
        val heartBeatJob = launch(coroutineContext) {
            try {
                while (!outgoing.isClosedForSend) {
                    send(PresetPacket.heartbeat())
                    logger.trace { "Send heartbeat in room $roomId" }
                    delay(30_000)
                }
            } catch (ignore: CancellationException) {
                //ignore
            } catch (e: Exception) {
                logger.error(e)
            } finally {
                logger.trace { "Stop heartbeat sending for room $roomId" }
            }
        }

        try {
            block(this@LiveClient)
        } finally {
            heartBeatJob.cancel()
            logger.debug { "Connection closed from room $roomId" }
        }
    }

    companion object {
        @UseExperimental(KtorExperimentalAPI::class)
        private val httpClient by lazy {
            HttpClient(CIO).config {
                install(WebSockets)
            }
        }
    }
}
