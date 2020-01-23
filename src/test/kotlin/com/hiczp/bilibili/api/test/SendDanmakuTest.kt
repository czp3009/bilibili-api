package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class SendDanmakuTest {
    @Test
    fun sendDanmaku() {
        runBlocking {
            bilibiliClient.mainAPI.sendDanmaku(aid = 40675923, cid = 71438168, progress = 2297, message = "2333").await()
        }
    }
}
