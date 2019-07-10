package com.hiczp.bilibili.rest.service.app

import com.hiczp.bilibili.rest.service.Response
import com.hiczp.caeruleum.annotation.BaseUrl
import com.hiczp.caeruleum.annotation.Get
import com.hiczp.caeruleum.annotation.Query

@BaseUrl("https://app.bilibili.com")
interface AppService {
    @Get("/x/v2/account/mine")
    suspend fun mine(): Response

    @Get("/x/v2/account/myinfo")
    suspend fun myInfo(): Response

    /**
     * 直播观看历史
     */
    @Get("/x/v2/history/liveList")
    suspend fun liveHistory(
            @Query("pn") pageNumber: Long = 1,
            @Query("ps") pageSize: Long = 20
    ): Response
}
