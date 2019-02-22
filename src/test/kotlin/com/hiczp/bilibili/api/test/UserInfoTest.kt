package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class UserInfoTest {
    @Test
    fun info() {
        runBlocking {
            Config.bilibiliClient.appAPI.myInfo().await()
        }
    }
}
