package com.hiczp.bilibili.api.message

import com.hiczp.bilibili.api.message.model.NotifyCount
import com.hiczp.bilibili.api.message.model.UplmList
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 * 消息推送有关的接口
 */
@Suppress("DeferredIsResult")
interface MessageAPI {
    /**
     * 获取消息数量
     * 首页 -> 右上角 talk 图标
     */
    @GET("/api/notify/query.notify.count.do")
    fun queryNotifyCount(): Deferred<NotifyCount>

    /**
     * 荣誉周报
     */
    @Suppress("SpellCheckingInspection")
    @GET("/api/notify/get.uplm.list.do")
    fun getUplmList(): Deferred<UplmList>
}
