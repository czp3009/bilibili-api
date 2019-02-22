package com.hiczp.bilibili.api.player

import com.hiczp.bilibili.api.player.model.BangumiPlayUrl
import com.hiczp.bilibili.api.player.model.VideoPlayUrl
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * 这里是播放器会访问的 API
 */
@Suppress("DeferredIsResult", "SpellCheckingInspection")
interface PlayerAPI {
    /**
     * 获得视频的播放地址
     * 这个 API 需要使用特别的 appKey
     *
     * @param expire 默认为下个月的这一天的时间戳
     * @param cid 在获取视频详情页面的接口的返回值里
     * @param aid 视频的唯一标识
     *
     * @see com.hiczp.bilibili.api.app.AppAPI.view
     */
    @GET(videoPlayUrl)
    fun videoPlayUrl(
            @Query("expire") expire: Long = nextMonthTimestamp(),
            @Query("force_host") forceHost: Int = 0,
            @Query("fnval") fnVal: Int = 16,
            @Query("qn") qn: Int = 32,
            @Query("npcybs") npcybs: Int = 0,
            @Query("cid") cid: Long,
            @Query("otype") otype: String = "json",
            @Query("fnver") fnVer: Int = 0,
            @Query("aid") aid: Long
    ): Deferred<VideoPlayUrl>

    /**
     * 获得番剧的播放地址
     *
     * @param aid 番剧的唯一标识
     * @param cid 在番剧详情页的返回值里
     * @param seasonType 番剧分季(第一季, 第二季)(从 1 开始)
     * @param session 不明确其含义
     * @param trackPath 不明确
     */
    @GET("https://api.bilibili.com/pgc/player/api/playurl")
    fun bangumiPlayUrl(
            @Query("aid") aid: Long,
            @Query("cid") cid: Long,
            @Query("expire") expire: Long = nextMonthTimestamp(),
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("module") module: String = "bangumi",
            @Query("npcybs") npcybs: Int = 0,
            @Query("otype") otype: String = "json",
            @Query("qn") qn: Int = 32,
            @Query("season_type") seasonType: Int,
            @Query("session") session: String? = null,
            @Query("track_path") trackPath: Int? = null
    ): Deferred<BangumiPlayUrl>

    companion object {
        const val videoPlayUrl = "https://app.bilibili.com/x/playurl"
        private fun nextMonthTimestamp() = Calendar.getInstance().apply { add(Calendar.MONTH, 1) }.toInstant().epochSecond
    }
}
