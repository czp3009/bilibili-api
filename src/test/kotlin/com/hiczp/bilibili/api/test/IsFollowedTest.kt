package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class IsFollowedTest {
    @Test
    fun followLive() {
        runBlocking {
            bilibiliClient.liveAPI.isFollowed(20293030).await()
        }
    }
}
