package com.hiczp.bilibili.api.test

import com.hiczp.bilibili.api.BilibiliClient
import kotlinx.coroutines.runBlocking
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Test

class LoginTest {
    @Test
    fun login() {
        runBlocking {
            BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY)
                    .login(Config.username, Config.password)
        }
    }
}
