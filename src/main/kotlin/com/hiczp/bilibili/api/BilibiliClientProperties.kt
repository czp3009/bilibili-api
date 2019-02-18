package com.hiczp.bilibili.api

/**
 * 客户端固有属性. 包括版本号, 密钥以及硬件编码.
 * 默认值对应 5.37.0(release-b220051) 版本.
 */
class BilibiliClientProperties {
    /**
     * Android 平台的 appKey
     */
    var appKey = "1d8b6e7d45233436"

    /**
     * 由反编译 so 文件得到的 appSecret, 与 appKey 必须匹配
     */
    @Suppress("SpellCheckingInspection")
    var appSecret = "560c52ccd288fed045859ed18bffd973"

    /**
     * 客户端平台
     */
    var platform = "android"

    /**
     * 客户端类型
     * 此属性在旧版客户端不存在
     */
    var channel = "html5_app_bili"

    /**
     * 硬件 ID, 尚不明确生成算法
     */
    @Suppress("SpellCheckingInspection")
    var hardwareId = "aBRoDWAVeRhsA3FDewMzS3lLMwM"

    /**
     * 屏幕尺寸, 大屏手机(已经没有小屏手机了)统一为 xxhdpi
     */
    var scale = "xxhdpi"

    /**
     * 版本号
     */
    var version = "5.37.0.5370000"

    /**
     * 构建版本号
     */
    var build = "5370000"

    /**
     * 构建版本 ID, 可能是某种 Hash
     */
    var buildVersionId = "XXD9E43D7A1EBB6669597650E3EE417D9E7F5"
}
