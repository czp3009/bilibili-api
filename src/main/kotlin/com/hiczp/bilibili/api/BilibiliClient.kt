package com.hiczp.bilibili.api

import com.hiczp.bilibili.api.exception.BilibiliApiException
import com.hiczp.bilibili.api.passport.PassportAPI
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.retrofit.ParamType
import com.hiczp.bilibili.api.retrofit.interceptor.CommonHeaderInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.CommonParamInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.FailureResponseInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.SortAndSignInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import mu.KotlinLogging
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.time.Instant
import java.util.*
import javax.crypto.Cipher

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
        private val autoRefreshToken: Boolean = true,   //TODO 自动 refreshToken
        private val logLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.NONE
) {
    /**
     * 客户端被打开的时间(BilibiliClient 被实例化的时间)
     */
    private val initTime = Instant.now().epochSecond

    /**
     * 登陆操作得到的 Response
     */
    @Suppress("MemberVisibilityCanBePrivate")
    var loginResponse: LoginResponse? = null

    /**
     * 是否已登录
     */
    @Suppress("MemberVisibilityCanBePrivate")
    val isLogin
        get() = loginResponse != null

    @Suppress("SpellCheckingInspection")
    val passportAPI: PassportAPI by lazy {
        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(CommonHeaderInterceptor(
                    "Display-ID" to { "${billingClientProperties.buildVersionId}-$initTime" },
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
            addInterceptor(FailureResponseInterceptor)

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
     * v3 登陆接口会同时返回 cookies 和 token
     *
     * @throws BilibiliApiException 用户名与密码不匹配(-629)或者需要验证码(极验)(-105)
     */
    @Throws(BilibiliApiException::class)
    suspend fun login(
            username: String, password: String,
            //如果登陆请求返回了 "验证码错误!"(-105) 的结果, 那么下一次发送登陆请求就需要带上验证码
            challenge: String? = null,
            secCode: String? = null,
            validate: String? = null
    ): LoginResponse {
        //取得 hash 和 RSA 公钥
        val (hash, key) = passportAPI.getKey().await().data.let { data ->
            data.hash to data.key.split('\n').filterNot { it.startsWith('-') }.joinToString(separator = "")
        }

        //解析 RSA 公钥
        val publicKey = X509EncodedKeySpec(Base64.getDecoder().decode(key)).let {
            KeyFactory.getInstance("RSA").generatePublic(it)
        }
        //加密密码
        //兼容 Android
        val cipheredPassword = Cipher.getInstance("RSA/ECB/PKCS1Padding").apply {
            init(Cipher.ENCRYPT_MODE, publicKey)
        }.doFinal((hash + password).toByteArray()).let {
            Base64.getEncoder().encode(it)
        }.let {
            String(it)
        }

        return passportAPI.login(username, cipheredPassword, challenge, secCode, validate).await().also {
            this.loginResponse = it
        }
    }

    /**
     * 登出
     * 这个方法不一定是线程安全的, 登出的同时如果进行登陆操作可能引发错误
     */
    suspend fun logout() {
        val response = loginResponse ?: return
        val cookieMap = response.data.cookieInfo.cookies
                .associate {
                    it.name to it.value
                }
        passportAPI.revoke(cookieMap, response.token).await()
        loginResponse = null
    }
}
