package com.hiczp.bilibili.api

import java.time.Instant

/**
 * 此类表示一个模拟的 Bilibili 客户端(Android), 所有调用由此开始.
 * 多个 BilibiliClient 实例之间不共享登陆状态.
 * 不能严格保证线程安全.
 *
 * @param billingClientProperties 客户端的固有属性, 是一种常量
 */
class BilibiliClient(
        @Suppress("MemberVisibilityCanBePrivate")
        var billingClientProperties: BilibiliClientProperties = BilibiliClientProperties()
) {
    /**
     * 客户端被打开的时间(BilibiliClient 被实例化的时间)
     */
    val clientInitTime = Instant.now().epochSecond

    /**
     * 登陆
     */
    fun login(username: String, password: String) {
        TODO()
    }

    /**
     * 登出
     */
    fun logout() {
        TODO()
    }
}
