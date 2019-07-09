package com.hiczp.bilibili.rest.service.live

import com.hiczp.bilibili.rest.BilibiliClientInherent
import com.hiczp.bilibili.rest.service.Response
import com.hiczp.caeruleum.annotation.*

/**
 * 直播
 */
@BaseUrl("https://api.live.bilibili.com")
interface LiveService {
    /**
     * 房间基本信息
     */
    @Get("/xlive/app-room/v1/index/getInfoByRoom")
    suspend fun getInfoByRoom(@Query("room_id") roomId: Long): Response

    /**
     * 当前房间未开播时显示的其他直播推荐
     */
    @Get("/xlive/app-room/v1/index/getOffLiveList")
    suspend fun getOffLiveList(
            @Query("area_id") areaId: Int,
            @Query("room_id") roomId: Long,
            @Query("device_name") deviceName: String = BilibiliClientInherent.mobileModel,
            @Query qn: Int = 0
    ): Response

    /**
     * 弹幕推送服务器列表
     */
    @Get("/xlive/app-room/v1/index/getDanmuInfo")
    suspend fun getDanmuInfo(@Query("room_id") roomId: Long): Response

    /**
     * 自己在房间中的身份信息, 包括头衔, 是否房管, 金瓜子数量等
     */
    @Get("/xlive/app-room/v1/index/getInfoByUser")
    suspend fun getInfoByUser(@Query("room_id") roomId: Long): Response

    /**
     * 房间中的历史弹幕(最近十条)
     */
    @Get("/xlive/app-room/v1/dM/gethistory")
    suspend fun getHistory(@Query("room_id") roomId: Long): Response

    /**
     * 头衔列表
     */
    @Get("/rc/v1/Title/getTitle")
    suspend fun getTitle(@Query scale: String = BilibiliClientInherent.scale): Response

    /**
     * 礼物列表
     */
    @Get("/gift/v3/live/gift_config")
    suspend fun giftConfig(
            @Query("area_v2_id") areaV2Id: Int,
            @Query("area_v2_parent_id") areaV2ParentId: Int,
            @Query("room_id") roomId: Long
    ): Response

    /**
     * 查看当前房间的抽奖信息
     */
    @Get("/xlive/lottery-interface/v1/lottery/getLotteryInfo")
    suspend fun getLotteryInfo(@Query("roomid") roomId: Long): Response

    /**
     * 进房时发送的数据, 该操作将产生一条房间浏览记录
     */
    @Post("/room/v1/Room/room_entry_action")
    @FormUrlEncoded
    suspend fun roomEntryAction(
            @Field("room_id") roomId: Long,
            @Field jumpFrom: Long = 0
    ): Response

    /**
     * 皮肤列表
     */
    @Get("/room/v1/Skin/list")
    suspend fun skinList(
            @Query("skin_platform") skinPlatform: String = BilibiliClientInherent.platform,
            @Query("skin_version") skinVersion: Int = 1
    ): Response
}
