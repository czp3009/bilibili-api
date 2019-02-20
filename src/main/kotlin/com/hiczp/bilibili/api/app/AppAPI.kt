package com.hiczp.bilibili.api.app

import com.hiczp.bilibili.api.app.model.MyInfo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

@Suppress("DeferredIsResult")
interface AppAPI {
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/account/myinfo")
    fun myInfo(): Deferred<MyInfo>
}
