package com.hiczp.bilibili.api

import com.hiczp.bilibili.api.passport.PassportAPI
import com.hiczp.bilibili.api.retrofit.ParamType
import com.hiczp.bilibili.api.retrofit.interceptor.CommonHeaderInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.CommonParamInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.SortAndSignInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import mu.KotlinLogging
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Instant

private val logger = KotlinLogging.logger {}

/**
 * 此类表示一个模拟的 Bilibili 客户端(Android), 所有调用由此开始.
 * 多个 BilibiliClient 实例之间不共享登陆状态.
 * 不能严格保证线程安全.
 *
 * @param billingClientProperties 客户端的固有属性, 是一种常量
 * @param autoRefreshToken 当 Token 过期时是否自动重新登录
 * @param logLevel 日志打印等级
 */
class BilibiliClient(
        @Suppress("MemberVisibilityCanBePrivate")
        val billingClientProperties: BilibiliClientProperties = BilibiliClientProperties(),
        private val autoRefreshToken: Boolean = true,
        private val logLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.NONE
) {
    /**
     * 客户端被打开的时间(BilibiliClient 被实例化的时间)
     */
    private val initTime = Instant.now().epochSecond

    /**
     * 是否已登录
     */
    @Suppress("MemberVisibilityCanBePrivate")
    var isLogin = false

    @Suppress("SpellCheckingInspection")
    val passportAPI: PassportAPI by lazy {
        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(CommonHeaderInterceptor(
                    "Display-ID" to {
                        if (isLogin) {
                            "${billingClientProperties.buildVersionId}-$initTime"
                        } else {
                            billingClientProperties.buildVersionId
                        }
                    },
                    "Buvid" to { billingClientProperties.buildVersionId },
                    "User-Agent" to { "Mozilla/5.0 BiliDroid/5.37.0 (bbcallen@gmail.com)" },
                    "Device-ID" to { billingClientProperties.hardwareId }
            ))
            addInterceptor(CommonParamInterceptor(ParamType.FORM_URL_ENCODED,
                    "appkey" to { billingClientProperties.appKey },
                    "build" to { billingClientProperties.build },
                    "channel" to { billingClientProperties.channel },
                    "mobi_app" to { billingClientProperties.platform },
                    "platform" to { billingClientProperties.platform },
                    "ts" to { Instant.now().epochSecond.toString() }
            ))
            addInterceptor(SortAndSignInterceptor(ParamType.FORM_URL_ENCODED, billingClientProperties.appSecret))

            //log
            if (logLevel != HttpLoggingInterceptor.Level.NONE) {
                addNetworkInterceptor(HttpLoggingInterceptor().setLevel(logLevel))
            }
        }.build()

        Retrofit.Builder()
                .baseUrl(BaseUrl.passport)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(okHttpClient)
                .build()
                .create(PassportAPI::class.java)
    }

    /**
     * 登陆
     */
    suspend fun login(username: String, password: String) {
        val (hash, key) = passportAPI.getKey().await().data.let {
            it.hash to it.key
        }

    }

    /**
     * 登出
     */
    fun logout() {
        TODO()
    }
}
