package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class SendReplyTest {
    @Test
    fun sendRootReply() {
        runBlocking {
            bilibiliClient.mainAPI.sendReply(
                    oid = 9498716,
                    message = "这是自动发送的评论 ${System.currentTimeMillis()}"
            ).await()
        }
    }
}
