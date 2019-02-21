package com.hiczp.bilibili.api.test

import com.hiczp.bilibili.api.BilibiliClient
import kotlinx.coroutines.runBlocking
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Test

class FetchReplyTest {
    @Test
    fun fetchReply() {
        runBlocking {
            BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY)
                    .mainAPI.reply(oid = 44154463).await()
        }
    }

    @Test
    fun fetchChildReply() {
        runBlocking {
            BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY)
                    .mainAPI.childReply(oid = 16622855, root = 1405602348).await()
        }
    }
}
