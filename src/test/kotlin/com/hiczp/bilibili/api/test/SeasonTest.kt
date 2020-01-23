package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class SeasonTest {
    @Test
    fun season() {
        runBlocking {
            noLoginBilibiliClient.mainAPI.season(episodeId = 250536).await()
        }
    }
}
