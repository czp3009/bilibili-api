package com.hiczp.bilibili.rest.service.app

import com.hiczp.bilibili.rest.service.Response
import com.hiczp.caeruleum.annotation.BaseUrl
import com.hiczp.caeruleum.annotation.Get

@BaseUrl("https://app.bilibili.com")
interface AppService {
    @Get("/x/v2/account/mine")
    suspend fun mine(): Response

    @Suppress("SpellCheckingInspection")
    @Get("/x/v2/account/myinfo")
    suspend fun myInfo(): Response
}
