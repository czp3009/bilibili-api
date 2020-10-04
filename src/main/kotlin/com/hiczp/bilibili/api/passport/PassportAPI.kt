package com.hiczp.bilibili.api.passport

import com.hiczp.bilibili.api.BilibiliClientProperties
import com.hiczp.bilibili.api.passport.model.GetKeyResponse
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.passport.model.OAuth2Info
import com.hiczp.bilibili.api.passport.model.RevokeResponse
import com.hiczp.caeruleum.annotation.*

/**
 * Bilibili OAuth2 V3 API
 */
@Suppress("SpellCheckingInspection")
@BaseUrl("https://passport.bilibili.com")
interface PassportAPI {
    /**
     * 获得 RSA 公钥
     * 固定参数 appkey, build, channel, mobi_app, platform, statistics, ts, sign
     */
    @Post("/api/oauth2/getKey")
    suspend fun getKey(): GetKeyResponse

    /**
     * 登陆
     * 多次错误的登陆尝试后将要求验证码
     */
    @Post("/api/v3/oauth2/login")
    @FormUrlEncoded
    suspend fun login(
        @Field username: String, @Field password: String,
        //极验所需字段
        @Field challenge: String? = null,
        @Field("seccode") secCode: String? = null,
        @Field validate: String? = null,
        //统计字段
        @Field("buvid") buvid: String = BilibiliClientProperties.DEFAULT.buvid,
        @Field("device") device: String = BilibiliClientProperties.DEFAULT.device,
        @Field("device_id") deviceId: String = BilibiliClientProperties.DEFAULT.deviceId,
        @Field("bili_local_id") bilibiliLocalId: String = deviceId,
        @Field("device_name") deviceName: String = BilibiliClientProperties.DEFAULT.deviceName,
        @Field("device_platform") devicePlatform: String = BilibiliClientProperties.DEFAULT.devicePlatform,
        @Field("local_id") localId: String = buvid
    ): LoginResponse

    /**
     * 获取用户 ID
     */
    @Get("/api/v3/oauth2/info")
    suspend fun info(
        @Query("access_token") accessToken: String,
        @QueryMap cookieMap: Map<String, String> = emptyMap(),
        //统计字段
        @Field("buvid") buvid: String = BilibiliClientProperties.DEFAULT.buvid,
        @Field("device") device: String = BilibiliClientProperties.DEFAULT.device,
        @Field("device_id") deviceId: String = BilibiliClientProperties.DEFAULT.deviceId,
        @Field("bili_local_id") bilibiliLocalId: String = deviceId,
        @Field("device_name") deviceName: String = BilibiliClientProperties.DEFAULT.deviceName,
        @Field("device_platform") devicePlatform: String = BilibiliClientProperties.DEFAULT.devicePlatform,
        @Field("local_id") localId: String = buvid
    ): OAuth2Info

    /**
     * 登出
     */
    @Post("/x/passport-login/revoke")
    @FormUrlEncoded
    suspend fun revoke(
        @Field("access_token") accessToken: String,
        /**
         * 用户 ID
         */
        @Field mid: Long,
        /**
         * 名为 SESSDATA 的 cookie 的值
         */
        @Field session: String,
        //统计字段
        @Field("buvid") buvid: String = BilibiliClientProperties.DEFAULT.buvid,
        @Field("device") device: String = BilibiliClientProperties.DEFAULT.device,
        @Field("device_id") deviceId: String = BilibiliClientProperties.DEFAULT.deviceId,
        @Field("bili_local_id") bilibiliLocalId: String = deviceId,
        @Field("device_name") deviceName: String = BilibiliClientProperties.DEFAULT.deviceName,
        @Field("device_platform") devicePlatform: String = BilibiliClientProperties.DEFAULT.devicePlatform,
        @Field("local_id") localId: String = buvid
    ): RevokeResponse
}
