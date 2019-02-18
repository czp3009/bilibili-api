package com.hiczp.bilibili.api.passport

import com.hiczp.bilibili.api.passport.model.GetKeyResponse
import com.hiczp.bilibili.api.passport.model.LoginResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

@Suppress("DeferredIsResult")
interface PassportAPI {
    @POST("/api/oauth2/getKey")
    fun getKey(): Deferred<GetKeyResponse>

    @POST("/api/v3/oauth2/login")
    @FormUrlEncoded
    fun login(@Field("username") username: String, @Field("password") password: String): Deferred<LoginResponse>
}
