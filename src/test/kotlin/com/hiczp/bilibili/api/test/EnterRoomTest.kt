package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class EnterRoomTest {
    @Test
    fun enterRoom() {
        runBlocking {
            val roomId = bilibiliClient.liveAPI.mobileRoomInit(3).await().data.roomId
            bilibiliClient.liveAPI.roomEntryAction(roomId).await()
            bilibiliClient.liveAPI.getInfo(roomId).await()
        }
    }
}
