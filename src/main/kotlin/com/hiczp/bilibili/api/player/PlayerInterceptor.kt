package com.hiczp.bilibili.api.player

import com.hiczp.bilibili.api.BilibiliClientProperties
import com.hiczp.bilibili.api.calculateSign
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.retrofit.Charsets.UTF_8
import com.hiczp.bilibili.api.retrofit.Header
import com.hiczp.bilibili.api.retrofit.Param
import okhttp3.Interceptor
import okhttp3.Response
import java.net.URLEncoder
import java.time.Instant

/**
 * PlayerAPI 专用的拦截器
 *
 * @see PlayerAPI
 */
class PlayerInterceptor(
        private val bilibiliClientProperties: BilibiliClientProperties,
        private val loginResponseExpression: () -> LoginResponse?
) : Interceptor {
    @Suppress("SpellCheckingInspection")
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        //添加 header
        val header = request.headers().newBuilder().apply {
            add("Accept", "*/*")
            add("User-Agent", "Bilibili Freedoooooom/MarkII")
            add("Accept-Language", Header.ZH_CN)
        }.build()

        //添加 Query Params
        val oldUrl = request.url()
        //如果是视频播放地址这个 API, 要用特殊的 appKey
        val isVideo = oldUrl.toString().startsWith(PlayerAPI.videoPlayUrl)
        val url = StringBuilder(oldUrl.encodedQuery() ?: "").apply {
            //appKey
            addParamEncode(Param.APP_KEY, if (isVideo) bilibiliClientProperties.videoAppKey else bilibiliClientProperties.appKey)
            //凭证有关
            val loginRespons = loginResponseExpression()
            if (loginRespons != null) {
                //expire 的值为 token过期时间+2s
                addParamEncode(Param.EXPIRE, (loginRespons.ts + loginRespons.data.tokenInfo.expiresIn + 2).toString())
                addParamEncode(Param.ACCESS_KEY, loginRespons.token)
                addParamEncode(Param.MID, loginRespons.userId.toString())
            } else {
                addParamEncode(Param.EXPIRE, "0")
                addParamEncode(Param.MID, "0")
            }
            //公共参数
            addParamEncode("device", bilibiliClientProperties.platform)
            addParamEncode("mobi_app", bilibiliClientProperties.platform)
            addParamEncode("platform", bilibiliClientProperties.platform)
            addParamEncode("otype", "json")
            addParamEncode("ts", Instant.now().epochSecond.toString())
            addParamEncode("build", bilibiliClientProperties.build)
            addParamEncode("buvid", bilibiliClientProperties.buildVersionId)
        }.toString().let {
            //排序
            val sortedEncodedQuery = it.split('&').sorted().joinToString(separator = "&")
            //添加 sign
            val sign = calculateSign(sortedEncodedQuery, if (isVideo) bilibiliClientProperties.videoAppSecret else bilibiliClientProperties.appSecret)
            "$sortedEncodedQuery&${Param.SIGN}=$sign"
        }.let {
            oldUrl.newBuilder().encodedQuery(it).build()
        }

        return chain.proceed(
                request.newBuilder()
                        .headers(header)
                        .url(url)
                        .build()
        )
    }
}

private fun StringBuilder.addParamEncode(name: String, value: String) {
    if (length != 0) append('&')
    append(name)
    append('=')
    append(URLEncoder.encode(value, UTF_8))
}
