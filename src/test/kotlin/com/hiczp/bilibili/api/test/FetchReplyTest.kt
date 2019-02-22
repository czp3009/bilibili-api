package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FetchReplyTest {
    @Test
    fun fetchReply() {
        runBlocking {
            Config.noLoginBilibiliClient.mainAPI.reply(oid = 44154463).await()
        }
    }

    @Test
    fun fetchChildReply() {
        runBlocking {
            Config.noLoginBilibiliClient.mainAPI.childReply(oid = 16622855, root = 1405602348).await()
        }
    }
}