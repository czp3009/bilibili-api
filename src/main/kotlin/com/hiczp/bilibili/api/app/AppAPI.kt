package com.hiczp.bilibili.api.app

import com.hiczp.bilibili.api.app.model.*
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.Instant
import java.util.*

/**
 * 总站 API
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
     * 首页内容(客户端通过解析返回的内容来生成页面内容, 下同)
     * 首页 -> 推荐
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/feed/index")
    fun homePage(
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
            @Query("login_event") loginEvent: Int = 0,
            @Query("network") network: String = "mobile",
            @Query("open_event") openEvent: String? = null,
            @Query("pull") pull: Boolean = true,
            @Query("qn") qn: Int = 32,
            @Query("recsys_mode") recsysMode: Int = 0
    ): Deferred<HomePage>

    /**
     * 热门页面
     * 首页 -> 热门
     */
    @GET("/x/v2/show/popular/index")
    fun popularPage(
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("force_host") forceHost: Int = 0,
            @Query("idx") index: Long = 0,
            @Query("last_param") lastParam: String? = null,
            @Query("login_event") loginEvent: Int = 0,
            @Query("qn") qn: Int = 32,
            @Query("ver") ver: Long? = null //ver 的值为上一次请求该接口时的 timestamp-1
    ): Deferred<PopularPage>

    /**
     * 视频页面
     * 包含视频基本信息, 推荐和广告
     *
     * @param aid 视频的唯一标识
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/v2/view")
    fun view(
            @Query("ad_extra") adExtra: String? = null,
            @Query("aid") aid: Long,
            @Query("autoplay") autoplay: Int = 0,
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("force_host") forceHost: Int = 0,
            @Query("from") from: Int? = null,
            @Query("plat") plat: Int = 0,
            @Query("qn") qn: Int = 32,
            @Query("trackid") trackId: String? = null //all_10.shylf-ai-recsys-120.1550674524909.237
    ): Deferred<View>

    //TODO 这里的 appkey 变为 iVGUTjsxvpLeuDCf
    /**
     * 获得视频的播放地址
     *
     * @param expire 默认为下个月的这一天的时间戳
     * @param mid 当前用户 ID
     * @param cid 在 view() 接口的返回值里
     * @param aid 视频的唯一标识
     */
    @Suppress("SpellCheckingInspection")
    @GET("/x/playurl")
    fun playUrl(
            @Query("device") device: String = "android",
            @Query("expire") expire: Long = Calendar.getInstance().apply { add(Calendar.MONTH, 1) }.toInstant().epochSecond,
            @Query("force_host") forceHost: Int = 0,
            @Query("mid") mid: Long? = null,
            @Query("fnval") fnVal: Int = 16,
            @Query("qn") qn: Int = 32,
            @Query("npcybs") npcybs: Int = 0,
            @Query("cid") cid: Long? = null,
            @Query("otype") otype: String = "json",
            @Query("fnver") fnVer: Int = 0,
            @Query("buvid") buildVersionId: String? = null,
            @Query("aid") aid: Long
    ): Deferred<PlayUrl>
}
