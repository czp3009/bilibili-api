package com.hiczp.bilibili.api.test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class EnterRoomTest {
    @Test
    fun enterRoom() {
        runBlocking {
            with(bilibiliClient.liveAPI) {
                //下面模拟一个客户端进房时会访问的接口
                val (roomId, uid) = mobileRoomInit(3).await().data.let { it.roomId to it.uid }
                roomEntryAction(roomId).await()
                val data = getInfo(roomId).await().data
                isFollowed(uid).await()
                getAnchorInRoom(roomId).await()
                getUser().await()
                getUserInfoInRoom(roomId).await()
                getTitle().await()
                mobileTab(roomId).await()
                roomMessage(roomId).await().data.room.forEach {
                    println("${it.nickname}: ${it.text}")
                }
                val (areaId, parentAreaId) = data.let { it.areaId to it.parentAreaId }
                mobileRoomBanner(areaId, parentAreaId, roomId, uid).await()
                getGiftConfig(areaId, parentAreaId, roomId).await()
                roomRank(areaId, parentAreaId, roomId, uid).await()
                getDanmakuConfig(roomId).await()
            }
        }
    }
}
