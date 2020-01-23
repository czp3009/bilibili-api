package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class UserInfoTest {
    @Test
    fun appInfo() {
        runBlocking {
            bilibiliClient.appAPI.myInfo().await()
        }
    }

    @Test
    fun oauthInfo() {
        runBlocking {
            bilibiliClient.passportAPI.info(accessToken = bilibiliClient.token!!).await()
        }
    }
}
