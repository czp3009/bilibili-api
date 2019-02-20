package com.hiczp.bilibili.api

import com.hiczp.bilibili.api.app.AppAPI
import com.hiczp.bilibili.api.member.MemberAPI
import com.hiczp.bilibili.api.message.MessageAPI
import com.hiczp.bilibili.api.passport.PassportAPI
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.retrofit.ParamType
import com.hiczp.bilibili.api.retrofit.exception.BilibiliApiException
import com.hiczp.bilibili.api.retrofit.interceptor.CommonHeaderInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.CommonParamInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.FailureResponseInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.SortAndSignInterceptor
import com.hiczp.bilibili.api.vc.VcAPI
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import javax.crypto.Cipher

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

    //快捷方式
    @Suppress("MemberVisibilityCanBePrivate")
    val userId
        get() = loginResponse?.userId
    @Suppress("MemberVisibilityCanBePrivate")
    val token
        get() = loginResponse?.token

    @Suppress("SpellCheckingInspection")
    private val defaultCommonHeaderInterceptor = CommonHeaderInterceptor(
            "Display-ID" to { "${billingClientProperties.buildVersionId}-$initTime" },
            "Buvid" to { billingClientProperties.buildVersionId },
            "User-Agent" to { "Mozilla/5.0 BiliDroid/5.37.0 (bbcallen@gmail.com)" },
            "Device-ID" to { billingClientProperties.hardwareId }
    )

    @Suppress("SpellCheckingInspection")
    private val defaultCommonParamArray = arrayOf(
            "access_key" to { token },
            "appkey" to { billingClientProperties.appKey },
            "build" to { billingClientProperties.build },
            "channel" to { billingClientProperties.channel },
            "mobi_app" to { billingClientProperties.platform },
            "platform" to { billingClientProperties.platform },
            "ts" to { Instant.now().epochSecond.toString() }
    )

    private val defaultCommonQueryParamInterceptor = CommonParamInterceptor(ParamType.QUERY, *defaultCommonParamArray)
    private val defaultQuerySignInterceptor = SortAndSignInterceptor(ParamType.QUERY, billingClientProperties.appSecret)

    /**
     * 用户鉴权相关的接口
     */
    @Suppress("SpellCheckingInspection")
    val passportAPI by lazy {
        createAPI<PassportAPI>(BaseUrl.passport,
                defaultCommonHeaderInterceptor,
                CommonParamInterceptor(ParamType.FORM_URL_ENCODED,
                        "appkey" to { billingClientProperties.appKey },
                        "build" to { billingClientProperties.build },
                        "channel" to { billingClientProperties.channel },
                        "mobi_app" to { billingClientProperties.platform },
                        "platform" to { billingClientProperties.platform },
                        "ts" to { Instant.now().epochSecond.toString() }
                ),
                SortAndSignInterceptor(ParamType.FORM_URL_ENCODED, billingClientProperties.appSecret)
        )
    }

    /**
     * 消息通知有关的接口
     */
    @Suppress("SpellCheckingInspection")
    val messageAPI by lazy {
        createAPI<MessageAPI>(BaseUrl.message,
                defaultCommonHeaderInterceptor,
                CommonParamInterceptor(ParamType.QUERY, *defaultCommonParamArray,
                        "actionKey" to { "appkey" },
                        "has_up" to { "1" }
                ),
                defaultQuerySignInterceptor
        )
    }

    /**
     * 总站 API
     */
    @Suppress("SpellCheckingInspection")
    val appAPI by lazy {
        createAPI<AppAPI>(BaseUrl.app,
                defaultCommonHeaderInterceptor,
                defaultCommonQueryParamInterceptor,
                defaultQuerySignInterceptor
        )
    }

    /**
     * 小视频相关接口
     */
    @Suppress("SpellCheckingInspection")
    val vcAPI by lazy {
        createAPI<VcAPI>(BaseUrl.vc,
                defaultCommonHeaderInterceptor,
                CommonParamInterceptor(ParamType.QUERY, *defaultCommonParamArray,
                        "_device" to { billingClientProperties.platform },
                        "_hwid" to { billingClientProperties.hardwareId },
                        "src" to { billingClientProperties.channel },
                        "trace_id" to { generateTraceId() },
                        "uid" to { userId?.toString() },
                        "version" to { billingClientProperties.version }
                ),
                defaultQuerySignInterceptor
        )
    }

    /**
     * 创作中心
     */
    val memberAPI by lazy {
        createAPI<MemberAPI>(BaseUrl.member,
                defaultCommonHeaderInterceptor,
                defaultCommonQueryParamInterceptor,
                defaultQuerySignInterceptor
        )
    }

    /**
     * 登陆
     * v3 登陆接口会同时返回 cookies 和 token
     * 如果要求验证码, 访问 data 中提供的 url 将打开一个弹窗, 里面会加载 js 并显示极验
     * 极验会调用 https://api.geetest.com/ajax.php 上传滑动轨迹, 然后获得 validate 的值
     * secCode 的值为 "$validate|jordan"
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

    private inline fun <reified T : Any> createAPI(
            baseUrl: String,
            vararg interceptors: Interceptor
    ) = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(coroutineCallAdapterFactory)
            .client(OkHttpClient.Builder().apply {
                interceptors.forEach {
                    addInterceptor(it)
                }
                addInterceptor(FailureResponseInterceptor)
                //log
                if (logLevel != HttpLoggingInterceptor.Level.NONE) {
                    addNetworkInterceptor(HttpLoggingInterceptor().setLevel(logLevel))
                }
            }.build())
            .build()
            .create(T::class.java)

    companion object {
        @Suppress("SpellCheckingInspection")
        private val gsonConverterFactory = GsonConverterFactory.create()
        private val coroutineCallAdapterFactory = CoroutineCallAdapterFactory()
        private val traceIdFormat = SimpleDateFormat("yyyyMMddHHmm000ss")
        private fun generateTraceId() = traceIdFormat.format(Date())
    }
}
