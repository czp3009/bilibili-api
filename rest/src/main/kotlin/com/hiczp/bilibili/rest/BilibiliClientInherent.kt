package com.hiczp.bilibili.rest

/**
 * 客户端固有属性
 * 5.44.0
 */
@Suppress("MemberVisibilityCanBePrivate")
object BilibiliClientInherent {
    /**
     * 默认 UA, 用于大多数访问
     */
    @Suppress("SpellCheckingInspection")
    const val userAgent = "Mozilla/5.0 BiliDroid/5.44.0 (bbcallen@gmail.com)"

    /**
     * Android 平台的 appKey(该默认值为普通版客户端, 非概念版)
     */
    const val appKey = "1d8b6e7d45233436"

    /**
     * 由反编译 so 文件得到的 appSecret, 与 appKey 必须匹配
     */
    @Suppress("SpellCheckingInspection")
    const val appSecret = "560c52ccd288fed045859ed18bffd973"

    /**
     * 获取视频播放地址使用的 appKey, 与访问其他 RestFulAPI 所用的 appKey 不一致
     */
    @Suppress("SpellCheckingInspection")
    const val videoAppKey = "iVGUTjsxvpLeuDCf"

    /**
     * 获取视频播放地址所用的 appSecret
     */
    @Suppress("SpellCheckingInspection")
    const val videoAppSecret = "aHRmhWMLkdeMuILqORnYZocwMBpMEOdt"

    /**
     * 新版客户端出现的某种 ID
     */
    const val appId = 1

    /**
     * 客户端平台
     */
    const val platform = "android"

    /**
     * 客户端平台代码
     */
    const val platformCode = 3

    /**
     * 可能是 APK 下载来源, "html5_app_bili" 表示从网页下载
     */
    const val channel = "html5_app_bili"

    /**
     * 硬件 ID, 尚不明确生成算法
     */
    @Suppress("SpellCheckingInspection")
    const val hardwareId = "aBRoDWAVeRhsA3FDewMzS3lLMwM"

    /**
     * 屏幕尺寸, 大屏手机统一为 xxhdpi
     * 此参数在新版客户端已经较少使用
     */
    const val scale = "xxhdpi"

    /**
     * 版本号
     */
    const val version = "5.44.0"

    /**
     * 构建版本号
     */
    const val build = "5440900"

    /**
     * 可能是某种指纹
     */
    @Suppress("SpellCheckingInspection")
    const val buvid = "XXD9E43D7A1EBB6669597650E3EE417D9E7F5"

    /**
     * Profile
     */
    const val env = "prod"

    /**
     * A/B test
     */
    const val abTest = ""

    @Suppress("SpellCheckingInspection")
    const val actionKey = "appkey"

    /**
     * 统计用的组合参数
     */
    @Suppress("SpellCheckingInspection")
    const val statistics = """{"appId":$appId,"platform":$platformCode,"version":$version,"abtest":$abTest}"""

    /**
     * 在一些统计信息中使用
     */
    const val deviceToken = "190e35f7e01c444c9d9"
    const val mobileBrand = "MI"
    const val mobileModel = "MI 8"
    const val mobileVersion = "9.0"
    const val notifySwitch = 1
    const val pushSDK = 9
    const val teenagersMode = 0
    const val timeZone = 8

    const val deviceName = "$mobileBrand$mobileModel"
    const val devicePlatform = "Android$mobileVersion$deviceName"

    /**
     * 安装客户端时生成的指纹
     */
    @Suppress("SpellCheckingInspection")
    const val deviceId = "2019070720581656bd5dddabaa8e883dda67e1320dafe3494562035b27691b"
}
