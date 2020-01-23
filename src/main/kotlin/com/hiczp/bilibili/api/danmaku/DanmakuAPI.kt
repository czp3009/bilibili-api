package com.hiczp.bilibili.api.danmaku

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

@Suppress("DeferredIsResult")
interface DanmakuAPI {
    /**
     * 获取弹幕(视频或者番剧)
     *
     * @param aid 视频的唯一标识
     * @param oid 注意, 此处的 oid 是 cid
     *
     * @return 返回的内容是二进制数据, 由于数据量可能很大, 此处不做解析
     */
    @GET("/x/v2/dm/list.so")
    fun list(
            @Query("aid") aid: Long,
            @Query("oid") oid: Long,
            @Query("plat") plat: Int? = 2,
            @Query("ps") pageSize: Int = 0,
            @Query("type") type: Int = 1
    ): Deferred<ResponseBody>
}
