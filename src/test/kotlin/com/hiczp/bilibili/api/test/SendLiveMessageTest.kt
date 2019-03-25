package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class SendLiveMessageTest {
    @Test
    fun sendMessage() {
        runBlocking {
            bilibiliClient.liveAPI
                    .sendMessage(cid = 29434, mid = 20293030, message = "自动捧场机器人").await()
        }
    }
}
