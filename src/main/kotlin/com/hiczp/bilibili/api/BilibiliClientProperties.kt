package com.hiczp.bilibili.api

/**
 * 客户端固有属性
 * 5.54.0
 */
@Suppress("MemberVisibilityCanBePrivate", "SpellCheckingInspection")
class BilibiliClientProperties {
    /**
     * 版本号
     */
    var version = "5.54.0"

    /**
     * 构建版本号
     */
    var build = "5540500"

    /**
     * 默认 UA, 用于大多数访问
     */
    var userAgent = "Mozilla/5.0 BiliDroid/$version (bbcallen@gmail.com)"

    /**
     * Android 平台的 appKey(该默认值为普通版客户端, 非概念版)
     */
    var appKey = "1d8b6e7d45233436"

    /**
     * 由反编译 so 文件得到的 appSecret, 与 appKey 必须匹配
     */
    var appSecret = "560c52ccd288fed045859ed18bffd973"

    /**
     * 获取视频播放地址使用的 appKey, 与访问其他 RestFulAPI 所用的 appKey 不一致
     */
    var videoAppKey = "iVGUTjsxvpLeuDCf"

    /**
     * 获取视频播放地址所用的 appSecret
     */
    var videoAppSecret = "aHRmhWMLkdeMuILqORnYZocwMBpMEOdt"

    /**
     * 可能指普通版客户端
     */
    var appId = 1

    /**
     * 客户端平台
     */
    var platform = "android"

    /**
     * 客户端平台代码
     */
    var platformCode = 3

    /**
     * 可能是 APK 下载来源
     */
    var channel = "bilih5"

    /**
     * 硬件 ID, 尚不明确生成算法
     */
    var hardwareId = "bxNvCmcSfh9rBHZFdQ09RXUNPQ"

    /**
     * 屏幕尺寸, 大屏手机统一为 xxhdpi
     * 此参数在新版客户端已经较少使用
     */
    var scale = "xxhdpi"

    /**
     * 可能是某种哈希
     */
    var buvid = "XXF2498F337ECA0882990F812CC49EC370244"

    /**
     * Profile
     */
    var env = "prod"

    /**
     * A/B test
     */
    var abTest = ""

    var actionKey = "appkey"

    /**
     * 统计用的组合参数
     */
    var statistics = """{"appId":$appId,"platform":$platformCode,"version":"$version","abtest":"$abTest"}"""

    /**
     * 在一些统计信息中使用
     */
    var deviceToken = "190e35f7e01c444c9d9"
    var mobileBrand = "MI"
    var mobileModel = "MI 8"
    var mobileVersion = "9.0"
    var notifySwitch = 1
    var pushSDK = 9
    var teenagersMode = 0
    var timeZone = 8

    var device = "phone"
    var deviceName = "$mobileBrand$mobileModel"
    var devicePlatform = "Android$mobileVersion$deviceName"

    /**
     * 安装客户端时生成的指纹
     */
    var deviceId = "1f11ac09664ee6a7426df602439a7fe420200312163841f3f232301c061f7df6"

    companion object {
        val DEFAULT = BilibiliClientProperties()
    }
}
