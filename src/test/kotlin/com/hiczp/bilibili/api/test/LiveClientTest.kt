package com.hiczp.bilibili.api.test

import com.github.salomonbrys.kotson.byString
import com.hiczp.bilibili.api.isNotEmpty
import com.hiczp.bilibili.api.live.websocket.DanmakuMessage
import kotlinx.coroutines.launch
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
            val liveClient = bilibiliClient.liveClient(
                    roomId = 3,
                    sendUserOnlineHeart = true,
                    onConnect = {
                        println("Connected")
                        //想要这么做的人一定逻辑学有问题
//                        launch {
//                            delay(5_000)
//                            it.close()
//                        }
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
            )
            val job = launch {
                liveClient.start()
            }
            job.join()
        }
    }
}
