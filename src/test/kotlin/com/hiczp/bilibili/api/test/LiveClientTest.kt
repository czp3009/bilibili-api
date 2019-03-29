package com.hiczp.bilibili.api.test

import com.github.salomonbrys.kotson.byString
import com.hiczp.bilibili.api.BilibiliClient
import com.hiczp.bilibili.api.isNotEmpty
import com.hiczp.bilibili.api.live.websocket.DanmakuMessage
import com.hiczp.bilibili.api.live.websocket.liveClient
import io.ktor.http.cio.websocket.CloseReason
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import java.time.Instant

class LiveClientTest {
    @Test
    fun liveClient() {
        val path = Paths.get("record/直播弹幕/").also {
            it.toFile().mkdirs()
        }

        BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BASIC)
                .apply {
                    loginResponse = bilibiliClient.loginResponse
                }
                .liveClient(roomId = 3, sendUserOnlineHeart = true) {
                    onConnect = {
                        println("Connected ${Instant.now()}")
                    }

                    onPopularityPacket = { _, popularity ->
                        println("Current popularity: $popularity ${Instant.now()}")
                    }

                    onCommandPacket = { _, jsonObject ->
                        val json = jsonObject.toString()
                        val cmd by jsonObject.byString
                        path.resolve("$cmd.json").toFile().run {
                            if (!exists()) writeText(json)
                        }

                        println(
                                if (cmd == "DANMU_MSG") {
                                    with(DanmakuMessage(jsonObject)) {
                                        "${if (fansMedalInfo.isNotEmpty()) "[$fansMedalName $fansMedalLevel] " else ""}[UL$userLevel] $nickname: $message"
                                    }
                                } else {
                                    json
                                }
                        )
                    }

                    onClose = { liveClient, closeReason ->
                        println("$closeReason ${Instant.now()}")
                        if (closeReason?.code != CloseReason.Codes.NORMAL.code) liveClient.launch()
                    }
                }.launch()

        runBlocking {
            delay(99999999999999999)
        }
    }
}
