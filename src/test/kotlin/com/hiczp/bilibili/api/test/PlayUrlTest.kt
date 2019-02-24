package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class PlayUrlTest {
    @Test
    fun videoPlayUrl() {
        runBlocking {
            bilibiliClient.playerAPI.run {
                videoPlayUrl(aid = 41517911, cid = 72913641).await()
            }
        }
    }

    @Test
    fun bangumiPlayUrl() {
        runBlocking {
            bilibiliClient.playerAPI.run {
                bangumiPlayUrl(aid = 42714241, cid = 74921228).await()
            }
        }
    }
}
