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
            with(bilibiliClient) {
                passportAPI.info(
                        loginResponse!!.data.cookieInfo.cookies.associate {
                            it.name to it.value
                        },
                        token!!
                ).await()
            }
        }
    }
}
