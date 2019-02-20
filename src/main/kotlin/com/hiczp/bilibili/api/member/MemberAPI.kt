package com.hiczp.bilibili.api.member

import com.hiczp.bilibili.api.member.model.Pre
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * 创作中心
 */
@Suppress("DeferredIsResult")
interface MemberAPI {
    /**
     * 刚登陆时会访问该 API, 使用返回的 url 来创建一个指向一系列 H5 页面的 ListView
     * 侧拉抽屉 -> 创作中心 -> 更多功能
     */
    @GET("/x/app/pre")
    fun pre(): Deferred<Pre>
}
