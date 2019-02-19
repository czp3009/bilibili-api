package com.hiczp.bilibili.api.passport

import com.hiczp.bilibili.api.passport.model.GetKeyResponse
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.retrofit.CommonResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

@Suppress("DeferredIsResult")
interface PassportAPI {
    @POST("/api/oauth2/getKey")
    fun getKey(): Deferred<GetKeyResponse>

    @POST("/api/v3/oauth2/login")
    @FormUrlEncoded
    fun login(@Field("username") username: String, @Field("password") password: String): Deferred<LoginResponse>

    /**
     * 除了 accessToken, 其他全部都是 cookie 的值
     */
    @POST("/api/v2/oauth2/revoke")
    @FormUrlEncoded
    fun revoke(
            @Field("DedeUserID") dedeUserId: String,
            @Field("DedeUserID__ckMd5") ckMd5: String,
            @Suppress("SpellCheckingInspection") @Field("SESSDATA") sessData: String,
            @Field("access_token") accessToken: String,
            @Field("bili_jct") biliJct: String,
            @Field("sid") sid: String
    ): Deferred<CommonResponse>

    /**
     * 将所有 cookie 以 Map 形式传入
     */
    @POST("/api/v2/oauth2/revoke")
    @FormUrlEncoded
    fun revoke(
            @FieldMap cookieMap: Map<String, String>,
            @Field("access_token") accessToken: String
    ): Deferred<CommonResponse>
}
