package com.hiczp.bilibili.api.app

import com.hiczp.bilibili.api.app.model.IndexPage
import com.hiczp.bilibili.api.app.model.Mine
import com.hiczp.bilibili.api.app.model.MyInfo
import com.hiczp.bilibili.api.app.model.Sidebar
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.Instant

/**
 * 提供通用信息的接口
 */
@Suppress("DeferredIsResult")
interface AppAPI {
    /**
     * 登陆完成后将请求一次此接口以获得个人资料
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/account/myinfo")
    fun myInfo(): Deferred<MyInfo>

    /**
     * 登陆后也会访问此接口, 返回内容大致与 myInfo() 相同
     */
    @GET("/x/v2/account/mine")
    fun mine(): Deferred<Mine>

    /**
     * 侧边栏中动态增加的按钮, 返回信息包含 URI 地址(到对应的 activity)
     */
    @GET("/x/resource/sidebar")
    fun sidebar(): Deferred<Sidebar>

    /**
     * 首页内容
     * 首页 -> 推荐
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/feed/index")
    fun index(
            @Query("ad_extra") adExtra: String? = null,
            @Query("autoplay_card") autoplayCard: Int = 0,
            @Query("banner_hash") bannerHash: String? = null,
            @Query("column") column: Int = 2,
            @Query("device_type") deviceType: Int = 0,
            @Query("flush") flush: Int = 0,
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("force_host") forceHost: Int = 0,
            @Query("idx") index: Long = Instant.now().epochSecond,
            @Query("login_event") loginEvent: Int = 2,
            @Query("network") network: String = "mobile",
            @Query("open_event") openEvent: String? = null,
            @Query("pull") pull: Boolean = true,
            @Query("qn") qn: Int = 32,
            @Query("recsys_mode") recsysMode: Int = 0
    ): Deferred<IndexPage>
}
