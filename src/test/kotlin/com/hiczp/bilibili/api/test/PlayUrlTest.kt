package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class PlayUrlTest {
    @Test
    fun videoPlayUrl() {
        runBlocking {
            Config.noLoginBilibiliClient.playerAPI.run {
                videoPlayUrl(aid = 41517911, cid = 72913641).await()
            }
        }
    }

    @Test
    fun bangumiPlayUrl() {
        runBlocking {
            Config.noLoginBilibiliClient.playerAPI.run {
                bangumiPlayUrl(aid = 42714241, cid = 74921228, seasonType = 1).await()
            }
        }
    }
}
