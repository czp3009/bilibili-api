package com.hiczp.bilibili.rest.service.passport

import com.hiczp.bilibili.rest.BilibiliClientInherent
import com.hiczp.bilibili.rest.ktor.appendMissing
import com.hiczp.bilibili.rest.ktor.commonParams
import com.hiczp.bilibili.rest.ktor.logging
import com.hiczp.bilibili.rest.service.passport.model.GetKeyResponse
import com.hiczp.bilibili.rest.service.passport.model.LoginResponse
import com.hiczp.bilibili.rest.service.passport.model.OAuth2Info
import com.hiczp.bilibili.rest.service.passport.model.RevokeResponse
import com.hiczp.caeruleum.annotation.*
import com.hiczp.caeruleum.create
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.UserAgent
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.headers
import io.ktor.util.InternalAPI
import io.ktor.util.KtorExperimentalAPI
import java.time.Instant

private const val getKeyUrl = "/api/oauth2/getKey"
private const val loginUrl = "/api/v3/oauth2/login"
private const val revokeUrl = "/api/v2/oauth2/revoke"
private const val infoUrl = "/api/v3/oauth2/info"

@Suppress("SpellCheckingInspection")
@BaseUrl("https://passport.bilibili.com")
interface PassportService {
    @Post(getKeyUrl)
    suspend fun getKey(): GetKeyResponse

    /**
     * 多次错误的登陆尝试后将要求验证码
     */
    @Post(loginUrl)
    @FormUrlEncoded
    suspend fun login(
            @Field username: String, @Field password: String,
            //以下为极验所需字段
            @Field challenge: String? = null,
            @Field("seccode") secCode: String? = null,
            @Field validate: String? = null,
            //统计字段
            @Field("device_id") deviceId: String = BilibiliClientInherent.deviceId,
            @Field("bili_local_id") bilibiliLocalId: String = deviceId,
            @Field("device_name") deviceName: String = BilibiliClientInherent.deviceName,
            @Field("device_platform") devicePlatform: String = BilibiliClientInherent.devicePlatform,
            @Field("local_id") localId: String = BilibiliClientInherent.buvid
    ): LoginResponse

    /**
     * 除了 accessToken, 其他全部都是 cookie 的值
     */
    @Post(revokeUrl)
    @FormUrlEncoded
    suspend fun revoke(
            @Field("access_token") accessToken: String,
            @Field("DedeUserID") dedeUserId: String? = null,
            @Field("DedeUserID__ckMd5") ckMd5: String? = null,
            @Field("SESSDATA") sessData: String? = null,
            @Field("bili_jct") biliJct: String? = null,
            @Field sid: String? = null
    ): RevokeResponse

    /**
     * 将所有 cookie 以 Map 形式传入
     */
    @Post(revokeUrl)
    @FormUrlEncoded
    suspend fun revoke(
            @Field("access_token") accessToken: String,
            @FieldMap cookieMap: Map<String, String> = emptyMap()
    ): RevokeResponse

    /**
     * 获取 OAuth2 信息
     */
    @Get(infoUrl)
    suspend fun info(
            @Query("access_token") accessToken: String,
            @Query("DedeUserID") dedeUserId: String? = null,
            @Query("DedeUserID__ckMd5") ckMd5: String? = null,
            @Query("SESSDATA") sessData: String? = null,
            @Query("bili_jct") biliJct: String? = null,
            @Query sid: String? = null,
            //统计字段
            @Query("device_id") deviceId: String = BilibiliClientInherent.deviceId,
            @Query("bili_local_id") bilibiliLocalId: String = deviceId,
            @Query("device_name") deviceName: String = BilibiliClientInherent.deviceName,
            @Query("device_platform") devicePlatform: String = BilibiliClientInherent.devicePlatform,
            @Query("local_id") localId: String = BilibiliClientInherent.buvid
    ): OAuth2Info

    @Get(infoUrl)
    suspend fun info(
            @Query("access_token") accessToken: String,
            @QueryMap cookieMap: Map<String, String> = emptyMap(),
            //统计字段
            @Query("device_id") deviceId: String = BilibiliClientInherent.deviceId,
            @Query("bili_local_id") bilibiliLocalId: String = deviceId,
            @Query("device_name") deviceName: String = BilibiliClientInherent.deviceName,
            @Query("device_platform") devicePlatform: String = BilibiliClientInherent.devicePlatform,
            @Query("local_id") localId: String = BilibiliClientInherent.buvid
    ): OAuth2Info

    companion object : PassportService by passportService
}

@Suppress("SpellCheckingInspection")
@UseExperimental(KtorExperimentalAPI::class, InternalAPI::class)
private val passportService = HttpClient(CIO) {
    install(UserAgent) {
        agent = BilibiliClientInherent.userAgent
    }
    defaultRequest {
        headers {
            with(BilibiliClientInherent) {
                appendMissing("Display-ID", buvid)
                appendMissing("Buvid", buvid)
                appendMissing("Device-ID", hardwareId)
                appendMissing("env", env)
                appendMissing("APP-KEY", platform)
            }
        }
    }
    commonParams {
        with(BilibiliClientInherent) {
            appendMissing("appkey", appKey)
            appendMissing("build", build)
            appendMissing("buvid", buvid)
            appendMissing("channel", channel)
            appendMissing("mobi_app", platform)
            appendMissing("platform", platform)
            appendMissing("statistics", statistics)
            appendMissing("ts", Instant.now().epochSecond.toString())
        }
    }
    install(JsonFeature) {
        serializer = GsonSerializer()
    }
    logging { }
}.create<PassportService>()
