package com.hiczp.bilibili.api.test

import com.hiczp.bilibili.api.BilibiliClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Test

class LoginTest {
    @Test
    fun loginAndLogout() {
        runBlocking {
            BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY)
                    .run {
                        login(Config.username, Config.password)
                        delay(1000)
                        logout()
                    }
        }
    }
}
