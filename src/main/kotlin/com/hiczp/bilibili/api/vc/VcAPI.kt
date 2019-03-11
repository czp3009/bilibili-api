package com.hiczp.bilibili.api.vc

import com.hiczp.bilibili.api.vc.model.AttentionList
import com.hiczp.bilibili.api.vc.model.DynamicNumber
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 小视频(好像 动态 也是在这个站)
 */
@Suppress("DeferredIsResult")
interface VcAPI {
    /**
     * //TODO 接口意义不明
     * 可能是一个通知接口
     */
    @GET("/dynamic_svr/v1/dynamic_svr/dynamic_num")
    fun dynamicNumber(
            @Query("rsp_type") rspType: Int,
            @Query("type_list") typeList: Long? = null,
            @Query("update_num_dy_id") updateNumberDynamicId: Int = 0
    ): Deferred<DynamicNumber>

    /**
     * 关注列表
     */
    @GET("/feed/v1/feed/get_attention_list")
    fun getAttentionList(): Deferred<AttentionList>
}
