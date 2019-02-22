package com.hiczp.bilibili.api.player

import com.hiczp.bilibili.api.BilibiliClientProperties
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.retrofit.Header
import com.hiczp.bilibili.api.retrofit.Param
import okhttp3.Interceptor
import okhttp3.Response
import java.time.Instant

/**
 * PlayerAPI 专用的拦截器
 *
 * @see PlayerAPI
 */
class PlayerInterceptor(
        private val bilibiliClientProperties: BilibiliClientProperties,
        private val loginResponse: LoginResponse?
) : Interceptor {
    @Suppress("SpellCheckingInspection")
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val header = request.headers().newBuilder().apply {
            add("Accept", "*/*")
            add("User-Agent", "Bilibili Freedoooooom/MarkII")
            add("Accept-Language", Header.ZH_CN)
        }.build()

        val url = request.url().newBuilder().apply {
            //视频播放地址(非番剧)这个接口要用 videoAppKey
            if (request.url().toString().startsWith(PlayerAPI.videoPlayUrl)) {
                addQueryParameter(Param.APP_KEY, bilibiliClientProperties.videoAppKey)
            } else {
                addQueryParameter(Param.APP_KEY, bilibiliClientProperties.appKey)
            }
            //公共参数
            addQueryParameter("device", bilibiliClientProperties.platform)
            addQueryParameter("mobi_app", bilibiliClientProperties.platform)
            if (loginResponse != null) {
                addQueryParameter("mid", loginResponse.userId.toString())
                addQueryParameter(Param.ACCESS_KEY, loginResponse.token)
            }
            addQueryParameter("platform", bilibiliClientProperties.platform)
            addQueryParameter("ts", Instant.now().epochSecond.toString())
            addQueryParameter("build", bilibiliClientProperties.build)
            addQueryParameter("buvid", bilibiliClientProperties.buildVersionId)
        }.build()

        return chain.proceed(
                request.newBuilder()
                        .headers(header)
                        .url(url)
                        .build()
        )
    }
}
