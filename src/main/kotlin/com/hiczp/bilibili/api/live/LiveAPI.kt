package com.hiczp.bilibili.api.live

import com.hiczp.bilibili.api.live.model.*
import com.hiczp.bilibili.api.retrofit.CommonResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 * 直播站 API
 */
@Suppress("DeferredIsResult")
interface LiveAPI {
    /**
     * 获取一个房间的基本信息
     *
     * @param id 房间号或房间短号
     */
    @GET("/room/v1/Room/mobileRoomInit")
    fun mobileRoomInit(@Query("id") id: Long): Deferred<MobileRoom>

    /**
     * 进入房间时客户端将访问该接口
     * 访问该接口将在自己的账户中产生一条观看直播的历史记录
     *
     * @param roomId 房间号(没试过能不能用短号, 下同)
     */
    @POST("/room/v1/Room/room_entry_action")
    @FormUrlEncoded
    fun roomEntryAction(
            @Field("room_id") roomId: Long,
            @Field("jumpFrom") jumpFrom: Int? = 0
    ): Deferred<CommonResponse>

    /**
     * 获取一个房间的详细信息
     *
     * @param id 房间号
     */
    @GET("/room/v1/Room/get_info")
    fun getInfo(@Query("id") id: Long): Deferred<RoomInfo>

    /**
     * 获取弹幕服务器
     *
     * @param roomId 房间号
     */
    @GET("/room/v1/Danmu/getConf")
    fun getDanmakuConfig(
            @Field("room_id") roomId: Long
    ): Deferred<DanmakuConfig>


    /**
     * 获取该房间的主播的头像和等级一类的信息
     *
     * @param roomId 房间号
     */
    @Suppress("SpellCheckingInspection")
    @GET("/live_user/v1/UserInfo/get_anchor_in_room")
    fun getAnchorInRoom(@Query("roomid") roomId: Long): Deferred<AnchorInRoom>

    /**
     * 获取自己在直播站的基本信息, 包括自己的直播间号, 银瓜子, 金瓜子数量等
     */
    @GET("/mobile/getUser")
    fun getUser(): Deferred<User>

    /**
     * 获取自己在当前直播间的信息, 包括自己的权限以及是否是管理员等
     *
     * @param roomId 房间号
     */
    @Suppress("SpellCheckingInspection")
    @GET("/live_user/v1/UserInfo/get_info_in_room")
    fun getUserInfoInRoom(@Query("roomid") roomId: Long): Deferred<UserInfoInRoom>

    /**
     * 获取所有头衔
     *
     * @param scale 屏幕尺寸
     */
    @GET("/appUser/getTitle")
    fun getTitle(@Query("scale") scale: String = "xxhdpi"): Deferred<Title>

    /**
     * 查询是否关注了当前主播
     */
    @POST("/relation/v1/Feed/isFollowed")
    @FormUrlEncoded
    fun isFollowed(@Field("follow") follow: Long): Deferred<Follow>
}
