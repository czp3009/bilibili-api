package com.hiczp.bilibili.api.live

import com.hiczp.bilibili.api.live.model.*
import com.hiczp.bilibili.api.retrofit.CommonResponse
import com.hiczp.bilibili.api.retrofit.Header
import kotlinx.coroutines.Deferred
import retrofit2.http.*
import kotlin.random.Random

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
            @Query("room_id") roomId: Long
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
     *
     * @param follow 所查询的主播的用户 ID
     */
    @POST("/relation/v1/Feed/isFollowed")
    @FormUrlEncoded
    fun isFollowed(@Field("follow") follow: Long): Deferred<Follow>

    /**
     * 进入直播间的时候, 客户端会访问该接口来动态获取上方的 Tab. 包括 互动, 主播, 贡献榜 等
     *
     * @param roomId 房间号
     */
    @Suppress("SpellCheckingInspection")
    @GET("/room/v2/Room/mobileTab")
    fun mobileTab(@Query("roomid") roomId: Long): Deferred<MobileTab>

    /**
     * 获取房间的历史弹幕(10条)
     *
     * @param roomId 房间号
     */
    @GET("/AppRoom/msg")
    fun roomMessage(@Query("room_id") roomId: Long): Deferred<RoomMessage>

    /**
     * 获取进房后右下角显示的那些东西, 通常是一些活动, 它们导向 H5 页面
     *
     * @param roomId 房间号
     * @param roomUserId 主播的用户 ID
     */
    @Suppress("SpellCheckingInspection")
    @GET("/activity/v1/Common/mobileRoomBanner")
    fun mobileRoomBanner(
            @Query("area_v2_id") areaV2Id: Int,
            @Query("area_v2_parent_id") areaV2ParentId: Int,
            @Query("roomid") roomId: Long,
            @Query("ruid") roomUserId: Long
    ): Deferred<MobileRoomBanner>

    /**
     * 获取各种礼物的基本信息, 包括贴图地址, 描述, 价格等
     */
    @Suppress("SpellCheckingInspection")
    @GET("/gift/v3/live/gift_config")
    fun getGiftConfig(
            @Query("area_v2_id") areaV2Id: Int,
            @Query("area_v2_parent_id") areaV2ParentId: Int,
            @Query("roomid") roomId: Long
    ): Deferred<GiftConfig>

    /**
     * 获取访问 小时总榜 的地址(H5)
     */
    @Suppress("SpellCheckingInspection")
    @GET("/rankdb/v1/Common/roomRank")
    fun roomRank(
            @Query("area_v2_id") areaV2Id: Int,
            @Query("area_v2_parent_id") areaV2ParentId: Int,
            @Query("roomid") roomId: Long,
            @Query("ruid") roomUserId: Long
    ): Deferred<RoomRank>

    /**
     * 直播站首页
     * 首页 -> 直播
     */
    @Suppress("SpellCheckingInspection")
    @GET("/xlive/app-interface/v2/index/getAllList")
    fun homePage(
            @Query("quality") quality: Int = 0,
            @Query("rec_page") recPage: Int = 2,
            @Query("relation_page") relationPage: Int = 2,
            @Query("scale") scale: String = "xxhdpi"
    ): Deferred<HomePage>

    /**
     * 获取某个直播分类下的全部子分类
     */
    @GET("/room/v1/Area/getList")
    fun getAreaList(@Query("parent_id") parentId: Int): Deferred<AreaList>

    /**
     * 根据某种维度来获取房间列表
     * area, parent, category 为 0 表示不筛选这些维度
     * sortType 为 null 表示不排序
     *
     * 首页 -> 直播 -> 查看更多/全部直播
     *
     * @param page 分页, 从 1 开始
     * @param sortType 排序维度, 已知的有 online(最热直播), live_time(最新开播)
     */
    @GET("/room/v3/Area/getRoomList")
    fun getRoomList(
            @Query("area_id") areaId: Int = 0,
            @Query("parent_area_id") parentAreaId: Int = 0,
            @Query("cate_id") categoryId: Int = 0,
            @Query("page") page: Int = 1,
            @Query("page_size") pageSize: Int = 30,
            @Query("sort_type") sortType: String? = null
    ): Deferred<RoomList>

    /**
     * 发送弹幕(直播)
     *
     * @param bubble 气泡, 不明确含义
     * @param cid 房间号
     * @param mid 发送者的用户 ID
     * @param message 弹幕内容
     * @param random 随机数, 不包括符号位有 9 位 或者 10 位
     * @param mode 弹幕模式, 可能与视频弹幕的模式含义相同, 可能需要特殊身份才能使用额外模式, 下同
     * @param pool 弹幕池
     * @param type 固定为 "json"
     * @param color 弹幕颜色
     * @param fontSize 弹幕字号
     * @param playTime 不明确
     */
    @Suppress("SpellCheckingInspection")
    @POST("/api/sendmsg")
    @FormUrlEncoded
    @Headers(Header.FORCE_QUERY)
    fun sendMessage(
            @Field("bubble") bubble: Int = 0,
            @Field("cid") cid: Long,
            @Field("mid") mid: Long,
            @Field("msg") message: String,
            @Field("rnd") random: Int = (if (Random.nextBoolean()) 1 else -1) * Random.nextInt(100000000, Int.MAX_VALUE),
            @Field("mode") mode: Int = 1,
            @Field("pool") pool: Int = 0,
            @Field("type") type: String = "json",
            @Field("color") color: Int = 16777215,
            @Field("fontsize") fontSize: Int = 25,
            @Field("playTime") playTime: Float = 0.0f
    ): Deferred<CommonResponse>

    /**
     * 用于确认客户端在看直播的心跳包(与弹幕推送无关)
     * 每五分钟发送一次
     */
    @POST("/mobile/userOnlineHeart")
    @FormUrlEncoded
    @Headers(Header.FORCE_QUERY)
    fun userOnlineHeart(
            @Field("room_id") roomId: Long,
            @Field("scale") scale: String = "xxhdpi"
    ): Deferred<CommonResponse>
}
