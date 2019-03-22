package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class LiveClientTest {
    @Test
    fun liveClient() {
        runBlocking {
            bilibiliClient.liveClient(roomId = 3).start()
        }
    }
}
