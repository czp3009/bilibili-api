package com.hiczp.bilibili.api.test

import com.github.salomonbrys.kotson.byString
import com.hiczp.bilibili.api.isNotEmpty
import com.hiczp.bilibili.api.live.websocket.DanmakuMessage
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class LiveClientTest {
    @Test
    fun liveClient() {
        val path = Paths.get("record/直播弹幕/").also {
            it.toFile().mkdirs()
        }

        runBlocking {
            bilibiliClient.liveClient(
                    roomId = 3,
                    onConnect = {
                        println("Connected")
                    },
                    onPopularityPacket = { _, popularity ->
                        println("Current popularity: $popularity")
                    },
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
                    },
                    onClose = { _, closeReason ->
                        println(closeReason)
                    }
            ).start()
        }
    }
}
