package com.hiczp.bilibili.websocket

import com.hiczp.bilibili.websocket.model.asDanmakuMessage
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

@UseExperimental(ObsoleteCoroutinesApi::class)
class LiveClientTest {
    @Test
    fun connect() {
        val liveClient = LiveClient(roomId = 23058, anchorUserId = 11153765) {
            resolvedPackets.consumeEach {
                when (it) {
                    is CommandPacket -> {
                        val command = it.content
                        println("[${command.cmd}] ${if (command.cmd == "DANMU_MSG") {
                            with(command.asDanmakuMessage()) {
                                "$nickname: $message"
                            }
                        } else {
                            command.toString()
                        }}")
                    }
                    is PopularityPacket -> {
                        println("Popularity: ${it.content}")
                    }
                }
            }
        }
        runBlocking {
            liveClient.connect()
        }
    }

    @Test
    fun close() {
        val liveClient = LiveClient(roomId = 23058) {
            println("Connected")
            resolvedPackets.consumeEach {
                //process
            }
        }
        runBlocking {
            val job = launch { liveClient.connect() }
            delay(5_000)
            println("Prepare to close it")
            job.cancel()
            delay(5_000)
        }
    }

    @Test
    fun multi() {
        val block: suspend BilibiliClientWebSocketSession.(LiveClient) -> Unit = { liveClient ->
            println("Connected to room ${liveClient.roomId}")
            resolvedPackets.consumeEach {
                print("Room ${liveClient.roomId}: ")
                when (it) {
                    is CommandPacket -> {
                        with(it.content) {
                            println("[$cmd] $this")
                        }
                    }
                    is PopularityPacket -> {
                        println("[Popularity] ${it.content}")
                    }
                }
            }
        }

        val liveClients = listOf(
                LiveClient(roomId = 23058, block = block),
                LiveClient(roomId = 5279, block = block)
        )

        runBlocking {
            liveClients.forEach {
                launch {
                    while (true) {
                        it.connect()
                        println("Reconnect after 1 second")
                        delay(1_000)
                    }
                }
            }
        }
    }
}
