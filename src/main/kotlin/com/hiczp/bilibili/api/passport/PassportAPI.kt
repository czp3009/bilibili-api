package com.hiczp.bilibili.api.passport

import com.hiczp.bilibili.api.passport.model.GetKeyResponse
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.passport.model.OAuth2Info
import com.hiczp.bilibili.api.retrofit.CommonResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 * 用户鉴权相关的接口
 */
@Suppress("DeferredIsResult")
interface PassportAPI {
    @POST("/api/oauth2/getKey")
    fun getKey(): Deferred<GetKeyResponse>

    /**
     * 多次错误的登陆尝试后, 服务器将返回 {"ts":1550569982,"code":-105,"data":{"url":"https://passport.bilibili.com/register/verification.html?success=1&gt=b6e5b7fad7ecd37f465838689732e788&challenge=9a67afa4d42ede71a93aeaaa54a4b6fe&ct=1&hash=105af2e7cc6ea829c4a95205f2371dc5"},"message":"验证码错误!"}
     */
    @Suppress("SpellCheckingInspection")
    @POST("/api/v3/oauth2/login")
    @FormUrlEncoded
    fun login(
            @Field("username") username: String, @Field("password") password: String,
            //以下为极验所需字段
            @Field("challenge") challenge: String? = null,
            @Field("seccode") secCode: String? = null,
            @Field("validate") validate: String? = null
    ): Deferred<LoginResponse>

    /**
     * 除了 accessToken, 其他全部都是 cookie 的值
     */
    @Suppress("SpellCheckingInspection")
    @POST("/api/v2/oauth2/revoke")
    @FormUrlEncoded
    fun revoke(
            @Field("DedeUserID") dedeUserId: String,
            @Field("DedeUserID__ckMd5") ckMd5: String,
            @Field("SESSDATA") sessData: String,
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

    /**
     * 获取 OAuth2 信息
     */
    @Suppress("SpellCheckingInspection")
    @GET("/api/v2/oauth2/info")
    fun info(
            @Query("DedeUserID") dedeUserId: String,
            @Query("DedeUserID__ckMd5") ckMd5: String,
            @Query("SESSDATA") sessData: String,
            @Query("access_token") accessToken: String,
            @Query("bili_jct") biliJct: String,
            @Query("sid") sid: String
    ): Deferred<OAuth2Info>

    @GET("/api/v2/oauth2/info")
    fun info(
            @QueryMap cookieMap: Map<String, String>,
            @Query("access_token") accessToken: String
    ): Deferred<OAuth2Info>
}
