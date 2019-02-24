package com.hiczp.bilibili.api.player

import com.hiczp.bilibili.api.md5
import com.hiczp.bilibili.api.player.model.BangumiPlayUrl
import com.hiczp.bilibili.api.player.model.VideoPlayUrl
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import java.lang.management.ManagementFactory

/**
 * 这里是播放器会访问的 API
 */
@Suppress("DeferredIsResult", "SpellCheckingInspection")
interface PlayerAPI {
    /**
     * 获得视频的播放地址
     * 这个 API 需要使用特别的 appKey
     *
     * @param cid 在获取视频详情页面的接口的返回值里
     * @param aid 视频的唯一标识
     *
     * @see com.hiczp.bilibili.api.app.AppAPI.view
     */
    @GET(videoPlayUrl)
    fun videoPlayUrl(
            @Query("force_host") forceHost: Int = 0,
            @Query("fnval") fnVal: Int = 16,
            @Query("qn") qn: Int = 32,
            @Query("npcybs") npcybs: Int = 0,
            @Query("cid") cid: Long,
            @Query("fnver") fnVer: Int = 0,
            @Query("aid") aid: Long
    ): Deferred<VideoPlayUrl>

    /**
     * 获得番剧的播放地址
     *
     * @param aid 番剧的唯一标识
     * @param cid 在番剧详情页的返回值里
     * @param seasonType 分级类型, 不明确, 似乎总为 1
     * @param session 其值为 系统已运行时间(ms)的MD5值, 此处的默认值为 JVM 已启动时间, 在 Android 上请使用 SystemClock
     * @param trackPath 不明确
     *
     * @see com.hiczp.bilibili.api.main.MainAPI.season
     */
    @GET("https://api.bilibili.com/pgc/player/api/playurl")
    fun bangumiPlayUrl(
            @Query("aid") aid: Long,
            @Query("cid") cid: Long,
            @Query("fnval") fnVal: Int = 16,
            @Query("fnver") fnVer: Int = 0,
            @Query("module") module: String = "bangumi",
            @Query("npcybs") npcybs: Int = 0,
            @Query("qn") qn: Int = 32,
            @Query("season_type") seasonType: Int = 1,
            @Query("session") session: String = (System.currentTimeMillis() - ManagementFactory.getRuntimeMXBean().startTime).toString().md5(),
            @Query("track_path") trackPath: Int? = null
    ): Deferred<BangumiPlayUrl>

    companion object {
        const val videoPlayUrl = "https://app.bilibili.com/x/playurl"
    }
}
