package com.hiczp.bilibili.api

import com.hiczp.bilibili.api.app.AppAPI
import com.hiczp.bilibili.api.danmaku.DanmakuAPI
import com.hiczp.bilibili.api.main.MainAPI
import com.hiczp.bilibili.api.member.MemberAPI
import com.hiczp.bilibili.api.message.MessageAPI
import com.hiczp.bilibili.api.passport.PassportAPI
import com.hiczp.bilibili.api.passport.model.LoginResponse
import com.hiczp.bilibili.api.player.PlayerAPI
import com.hiczp.bilibili.api.player.PlayerInterceptor
import com.hiczp.bilibili.api.retrofit.Header
import com.hiczp.bilibili.api.retrofit.Param
import com.hiczp.bilibili.api.retrofit.exception.BilibiliApiException
import com.hiczp.bilibili.api.retrofit.interceptor.CommonHeaderInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.CommonParamInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.FailureResponseInterceptor
import com.hiczp.bilibili.api.retrofit.interceptor.SortAndSignInterceptor
import com.hiczp.bilibili.api.vc.VcAPI
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
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
 * @param logLevel 日志打印等级
 */
@Suppress("unused")
class BilibiliClient(
        @Suppress("MemberVisibilityCanBePrivate")
        val billingClientProperties: BilibiliClientProperties = BilibiliClientProperties(),
        private val logLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.NONE
) {
    /**
     * 客户端被打开的时间(BilibiliClient 被实例化的时间)
     */
    private val initTime = Instant.now().epochSecond

    /**
     * 登陆操作得到的 Response
     */
    var loginResponse: LoginResponse? = null

    /**
     * 是否已登录
     */
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
            Header.DISPLAY_ID to { "${billingClientProperties.buildVersionId}-$initTime" },
            Header.BUILD_VERSION_ID to { billingClientProperties.buildVersionId },
            Header.USER_AGENT to { billingClientProperties.defaultUserAgent },
            Header.DEVICE_ID to { billingClientProperties.hardwareId }
    )

    @Suppress("SpellCheckingInspection")
    private val defaultCommonParamArray = arrayOf(
            Param.ACCESS_KEY to { token },
            Param.APP_KEY to { billingClientProperties.appKey },
            Param.BUILD to { billingClientProperties.build },
            Param.CHANNEL to { billingClientProperties.channel },
            Param.MOBILE_APP to { billingClientProperties.platform },
            Param.PLATFORM to { billingClientProperties.platform },
            Param.TIMESTAMP to { Instant.now().epochSecond.toString() }
    )

    private val defaultCommonParamInterceptor = CommonParamInterceptor(*defaultCommonParamArray)

    /**
     * 用户鉴权相关的接口
     */
    @Suppress("SpellCheckingInspection")
    val passportAPI by lazy {
        createAPI<PassportAPI>(BaseUrl.passport,
                defaultCommonHeaderInterceptor,
                CommonParamInterceptor(
                        Param.APP_KEY to { billingClientProperties.appKey },
                        Param.BUILD to { billingClientProperties.build },
                        Param.CHANNEL to { billingClientProperties.channel },
                        Param.MOBILE_APP to { billingClientProperties.platform },
                        Param.PLATFORM to { billingClientProperties.platform },
                        Param.TIMESTAMP to { Instant.now().epochSecond.toString() }
                )
        )
    }

    /**
     * 消息通知有关的接口
     */
    @Suppress("SpellCheckingInspection")
    val messageAPI by lazy {
        createAPI<MessageAPI>(BaseUrl.message,
                defaultCommonHeaderInterceptor,
                CommonParamInterceptor(*defaultCommonParamArray,
                        Param.ACTION_KEY to { Param.APP_KEY },
                        "has_up" to { "1" }
                )
        )
    }

    /**
     * 总站 API
     */
    @Suppress("SpellCheckingInspection")
    val appAPI by lazy {
        createAPI<AppAPI>(BaseUrl.app,
                defaultCommonHeaderInterceptor,
                defaultCommonParamInterceptor
        )
    }

    /**
     * 这也是总站 API
     */
    @Suppress("SpellCheckingInspection")
    val mainAPI by lazy {
        createAPI<MainAPI>(BaseUrl.main,
                CommonHeaderInterceptor(
                        //如果未登陆则没有 Display-ID
                        Header.DISPLAY_ID to { userId?.let { "$it-$initTime" } },
                        Header.BUILD_VERSION_ID to { billingClientProperties.buildVersionId },
                        Header.USER_AGENT to { billingClientProperties.defaultUserAgent },
                        Header.DEVICE_ID to { billingClientProperties.hardwareId }
                ),
                defaultCommonParamInterceptor
        )
    }

    /**
     * 小视频相关接口
     */
    @Suppress("SpellCheckingInspection")
    val vcAPI by lazy {
        createAPI<VcAPI>(BaseUrl.vc,
                defaultCommonHeaderInterceptor,
                CommonParamInterceptor(*defaultCommonParamArray,
                        Param._DEVICE to { billingClientProperties.platform },
                        Param._HARDWARE_ID to { billingClientProperties.hardwareId },
                        Param.SOURCE to { billingClientProperties.channel },
                        Param.TRACE_ID to { generateTraceId() },
                        Param.USER_ID to { userId?.toString() },
                        Param.VERSION to { billingClientProperties.version }
                )
        )
    }

    /**
     * 创作中心
     */
    val memberAPI by lazy {
        createAPI<MemberAPI>(BaseUrl.member,
                defaultCommonHeaderInterceptor,
                defaultCommonParamInterceptor
        )
    }

    /**
     * 播放器所需的 API, 用于获取视频播放地址
     */
    val playerAPI: PlayerAPI by lazy {
        Retrofit.Builder()
                .baseUrl("https://bilibili.com")    //这里的 baseUrl 是没用的
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(coroutineCallAdapterFactory)
                .client(OkHttpClient.Builder().apply {
                    addInterceptor(PlayerInterceptor(billingClientProperties) { loginResponse })
                    addInterceptor(FailureResponseInterceptor)
                    addNetworkInterceptor(httpLoggingInterceptor)
                }.build())
                .build()
                .create(PlayerAPI::class.java)
    }

    /**
     * 获取弹幕所用的 API
     */
    val danmakuAPI: DanmakuAPI by lazy {
        Retrofit.Builder()
                .baseUrl(BaseUrl.main)
                .addCallAdapterFactory(coroutineCallAdapterFactory)
                .client(OkHttpClient.Builder().apply {
                    addInterceptor(CommonHeaderInterceptor(
                            Header.ACCEPT to { "application/xhtml+xml,application/xml" },
                            Header.ACCEPT_ENCODING to { "gzip, deflate" },
                            Header.USER_AGENT to { billingClientProperties.defaultUserAgent }
                    ))
                    addInterceptor(defaultCommonParamInterceptor)
                    addInterceptor(sortAndSignInterceptor)
                    addNetworkInterceptor(httpLoggingInterceptor)
                }.build())
                .build()
                .create(DanmakuAPI::class.java)
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
     * 返回 Future 类型的 login 接口, 用于兼容 Java, 下同
     */
    fun loginFuture(username: String, password: String,
                    challenge: String?,
                    secCode: String?,
                    validate: String?
    ) = GlobalScope.future { login(username, password, challenge, secCode, validate) }

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

    /**
     * 返回 Future 类型的 logout 接口
     */
    fun logoutFuture() = GlobalScope.future { logout() }

    private val sortAndSignInterceptor = SortAndSignInterceptor(billingClientProperties.appSecret)
    private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(logLevel)
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
                addInterceptor(sortAndSignInterceptor)
                addInterceptor(FailureResponseInterceptor)
                addNetworkInterceptor(httpLoggingInterceptor)
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
