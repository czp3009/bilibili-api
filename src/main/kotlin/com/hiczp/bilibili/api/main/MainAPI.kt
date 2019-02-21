package com.hiczp.bilibili.api.main

import com.hiczp.bilibili.api.main.model.ChildReply
import com.hiczp.bilibili.api.main.model.Reply
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 这也是总站 API
 */
@Suppress("DeferredIsResult")
interface MainAPI {
    /**
     * 获取一个视频下的评论
     * 注意, 评论是倒序排序的, 即楼层大的楼排在前面, 所以返回值中的 next 会比 prev 小
     * 返回值中的 rpid 为评论 id. parent 为父评论的 id, parent 为 0 的是顶级评论
     *
     * @param oid 就是 aid, 视频的唯一标识
     * @param pageSize 分页大小
     * @param next 下一页的起始楼层, 注意, 翻页是越翻楼层越小的. 如果为 null 则从最后一楼开始
     */
    @GET("/x/v2/reply/main")
    fun reply(
            @Query("mode") mode: Int = 1,
            @Query("next") next: Long? = null,
            @Query("oid") oid: Long,
            @Query("plat") plat: Int? = 2,
            @Query("ps") pageSize: Int = 20,
            @Query("type") type: Int = 1
    ): Deferred<Reply>

    /**
     * 获取一个视频下的评论的子评论
     *
     * @param minId 想要请求的子评论(复数)的第一个子评论的 id(子评论默认升序排序), 为 null 时从 0 楼开始
     * @param oid aid
     * @param root 父评论的 id
     * @param size 分页大小
     */
    @GET("/x/v2/reply/reply/cursor")
    fun childReply(
            @Query("min_id") minId: Long? = null,
            @Query("oid") oid: Long,
            @Query("plat") plat: Int? = 2,
            @Query("root") root: Long,
            @Query("size") size: Int = 20,
            @Query("sort") sort: Int = 0,
            @Query("type") type: Int = 1
    ): Deferred<ChildReply>
}
