package com.hiczp.bilibili.api.live;

import com.hiczp.bilibili.api.BilibiliClientProperties;
import com.hiczp.bilibili.api.live.entity.*;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * 常见参数含义
 * mid: 用户 id, 也可能是指主播的用户 id
 * cid: 房间 id, 可以指 room_id 也可以指 show_room_id, 推荐所有 API 都使用 room_id 进行访问
 */
public interface LiveService {
    /**
     * 获取弹幕设置
     *
     * @param type 必须是 "all", 否则返回的所有字段的值都是 0
     */
    @GET("AppRoom/danmuConfig")
    Call<BulletScreenConfigEntity> getBulletScreenConfig(@Query("type") String type);

    /**
     * 获取弹幕设置的快捷调用
     */
    default Call<BulletScreenConfigEntity> getBulletScreenConfig() {
        return getBulletScreenConfig("all");
    }

    /**
     * 获得房间的历史弹幕(十条)
     *
     * @param roomId 房间号
     */
    @GET("AppRoom/msg")
    Call<LiveHistoryBulletScreensEntity> getHistoryBulletScreens(@Query("room_id") long roomId);

    /**
     * 获取直播间信息
     * 登录后访问该 API 将在服务器新增一条直播间观看历史
     *
     * 2018-05-11 现在用假的房间 ID 也能获得正确的信息
     *
     * @param roomId 房间号
     */
    @GET("AppRoom/index")
    Call<LiveRoomInfoEntity> getRoomInfo(@Query("room_id") long roomId);

    /**
     * 获得是否关注了一个主播
     *
     * @param hostUserId 主播的用户 ID
     * @return 未登录时返回 401
     */
    @POST("feed/v1/feed/isFollowed")
    Call<IsFollowedResponseEntity> isFollowed(@Query("follow") long hostUserId);

    //TODO sendDaily
    //该 API 意义不明
    @GET("AppBag/sendDaily")
    Call<SendDailyResponseEntity> sendDaily();

    /**
     * 获得所有礼物的列表
     */
    @GET("AppIndex/getAllItem")
    Call<ItemsEntity> getAllItem();

    /**
     * 查看可用的小电视抽奖
     *
     * @param roomId 房间号
     * @return 当目标房间没有可用的小电视抽奖时返回 -400
     */
    @GET("AppSmallTV/index")
    Call<AppSmallTVEntity> getAppSmallTV(@Query("roomid") long roomId);

    /**
     * 参与小电视抽奖
     * 房间号必须与小电视号对应
     * SYS_MSG 里面取得的小电视编号是一个字符串, 实际上它肯定是一个数字
     *
     * @param roomId 房间号
     * @param tvId   小电视号
     * @return 目标小电视不存在时(房间号与小电视号不匹配时也视为不存在)返回 -400 "不存在小电视信息"
     */
    @POST("AppSmallTV/join")
    Call<JoinAppSmallTVResponseEntity> joinAppSmallTV(@Query("roomid") long roomId, @Query("id") String tvId);

    /**
     * 通过 getAppSmallTV 取得的小电视编号是一个数字
     *
     * @param roomId 房间号
     * @param tvId   小电视号
     */
    default Call<JoinAppSmallTVResponseEntity> joinAppSmallTV(long roomId, long tvId) {
        return joinAppSmallTV(roomId, String.valueOf(tvId));
    }

    /**
     * 获得小电视抽奖结果(不访问这个 API, 奖励也会自动进入背包)
     *
     * @param tvId 小电视号
     * @return 返回内容中的 status 为 0 时, 表示返回正常开奖结果, 1 为没有参与抽奖或小电视已过期, 2 为正在开奖过程中
     */
    @GET("AppSmallTV/getReward")
    Call<GetAppSmallTVRewardResponseEntity> getAppSmallTVReward(@Query("id") long tvId);

    /**
     * 获得所有头衔的列表
     * 这里的 Title 是头衔的意思
     */
    @GET("appUser/getTitle")
    Call<TitlesEntity> getTitle();

    //TODO 查看房间里是否有节奏风暴
    @GET("SpecialGift/room/{roomId}")
    Call<SpecialGiftEntity> getSpecialGift(@Path("roomId") long roomId);
    //TODO 参与节奏风暴抽奖
    //TODO 查看节奏风暴奖励

    /**
     * 获取自己的用户信息(live 站的个人信息, 非总站)
     *
     * @return 未登录时返回 3
     */
    @GET("mobile/getUser")
    Call<UserInfoEntity> getUserInfo();

    /**
     * 获取一个直播间的流地址(flv)
     *
     * @param cid        必须用实际的 room_id, 不能使用 show_room_id, 否则得不到 playUrl. 实际 room_id 要首先通过 getRoomInfo() 获取
     * @param outputType 为固定值 "json", 否则返回一个空的 JsonArray (以前是返回一个 XML)
     */
    @GET("api/playurl")
    Call<PlayUrlEntity> getPlayUrl(@Query("cid") long cid, @Query("otype") String outputType);

    /**
     * 获取直播间推流地址的快捷调用
     *
     * @param cid 房间号
     */
    default Call<PlayUrlEntity> getPlayUrl(long cid) {
        return getPlayUrl(cid, "json");
    }

    /**
     * 获取当前这段时间的活动(不定期活动, 每次持续几周)和信仰任务
     *
     * @param roomId 房间号
     */
    @GET("activity/v1/Common/mobileActivity")
    Call<MobileActivityEntity> getMobileActivity(@Query("roomid") long roomId);

    /**
     * 获取用户的信仰任务列表
     *
     * @return 2018-02 现在只有 double_watch_task 这个任务是有效的
     */
    @GET("activity/v1/task/user_tasks")
    Call<UserTasksEntity> getUserTasks();

    /**
     * 领取一个信仰任务
     *
     * @param taskId 任务名
     * @return 任务未完成或者已领取返回 -400
     */
    @POST("activity/v1/task/receive_award")
    Call<ReceiveUserTaskAward> receiveUserTaskAward(@Query("task_id") String taskId);

    /**
     * 领取 double_watch_task 任务的奖励
     */
    default Call<ReceiveUserTaskAward> receiveDoubleWatchTaskAward() {
        return receiveUserTaskAward("double_watch_task");
    }

    //TODO 查看一个房间是否有活动抽奖
    //TODO 参与活动抽奖
    //TODO 查看活动抽奖奖励

    /**
     * 发送一个 Restful 心跳包, 五分钟一次. 这被用于统计观看直播的时间, 可以提升观众等级
     * 2018-03-06 开始, 只有老爷才能通过观看直播获得经验
     *
     * @param roomId 房间号
     * @param scale  屏幕大小
     * @return 未登录时返回 3
     */
    @POST("mobile/userOnlineHeart")
    @FormUrlEncoded
    Call<SendOnlineHeartResponseEntity> sendOnlineHeart(@Field("room_id") long roomId, @Field("scale") String scale);

    /**
     * 发送心跳包的快捷调用
     *
     * @param roomId 房间号
     */
    default Call<SendOnlineHeartResponseEntity> sendOnlineHeart(long roomId) {
        return sendOnlineHeart(roomId, BilibiliClientProperties.defaultSetting().getScale());
    }

    /**
     * 发送一条弹幕
     *
     * @param roomId      房间号
     * @param userId      自己的用户 ID
     * @param message  内容
     * @param random   随机数
     * @param mode     弹幕模式
     * @param pool     弹幕池
     * @param type     必须为 "json"
     * @param color    颜色
     * @param fontSize 字体大小
     * @param playTime 播放时间
     * @see BulletScreenEntity
     */
    @POST("api/sendmsg")
    @FormUrlEncoded
    Call<SendBulletScreenResponseEntity> sendBulletScreen(@Field("cid") long roomId,
                                                          @Field("mid") long userId,
                                                          @Field("msg") String message,
                                                          @Field("rnd") long random,
                                                          @Field("mode") int mode,
                                                          @Field("pool") int pool,
                                                          @Field("type") String type,
                                                          @Field("color") int color,
                                                          @Field("fontsize") int fontSize,
                                                          @Field("playTime") String playTime);

    /**
     * 发送弹幕的快捷调用
     *
     * @param bulletScreenEntity 弹幕实体类
     */
    default Call<SendBulletScreenResponseEntity> sendBulletScreen(BulletScreenEntity bulletScreenEntity) {
        return sendBulletScreen(
                bulletScreenEntity.getRoomId(),
                bulletScreenEntity.getUserId(),
                bulletScreenEntity.getMessage(),
                bulletScreenEntity.getRandom(),
                bulletScreenEntity.getMode(),
                bulletScreenEntity.getPool(),
                bulletScreenEntity.getType(),
                bulletScreenEntity.getColor(),
                bulletScreenEntity.getFontSize(),
                bulletScreenEntity.getPlayTime()
        );
    }

    /**
     * 获取下一个宝箱任务的信息
     */
    @GET("mobile/freeSilverCurrentTask")
    Call<FreeSilverCurrentTaskEntity> getFreeSilverCurrentTask();

    /**
     * 领取宝箱
     */
    @GET("mobile/freeSilverAward")
    Call<FreeSilverAwardEntity> getFreeSilverAward();

    /**
     * 查看自己的背包(礼物)
     */
    @GET("AppBag/playerBag")
    Call<PlayerBagEntity> getPlayerBag();

    /**
     * 查看哪些礼物是活动礼物, 在客户端上, 活动礼物会有一个右上角标记 "活动"
     *
     * @param roomId 房间号
     */
    @GET("AppRoom/activityGift")
    Call<ActivityGiftsEntity> getActivityGifts(@Query("room_id") long roomId);

    /**
     * 送礼物
     *
     * @param giftId     礼物 ID
     * @param number     数量
     * @param roomUserId 主播的用户 ID
     * @param roomId     房间号
     * @param timeStamp  时间戳
     * @param bagId      礼物在自己背包里的 ID
     * @param random     随机数
     * @return roomUserId 与 roomId 不匹配时返回 200012
     * bagId 错误时(背包里没有这个礼物)返回 200019
     */
    @POST("AppBag/send")
    @FormUrlEncoded
    Call<SendGiftResponseEntity> sendGift(@Field("giftId") long giftId,
                                          @Field("num") long number,
                                          @Field("ruid") long roomUserId,
                                          @Field("roomid") long roomId,
                                          @Field("timestamp") long timeStamp,
                                          @Field("bag_id") long bagId,
                                          @Field("rnd") long random);

    /**
     * 送礼物的快捷调用
     *
     * @param giftEntity 礼物实体类
     */
    default Call<SendGiftResponseEntity> sendGift(GiftEntity giftEntity) {
        return sendGift(
                giftEntity.getGiftId(),
                giftEntity.getNumber(),
                giftEntity.getRoomUserId(),
                giftEntity.getRoomId(),
                giftEntity.getTimeStamp(),
                giftEntity.getBagId(),
                giftEntity.getRandom()
        );
    }

    /**
     * 获得礼物榜(七日榜)
     *
     * @param roomId 房间号
     */
    @GET("AppRoom/getGiftTop")
    Call<GiftTopEntity> getGiftTop(@Query("room_id") int roomId);

    /**
     * "直播" 页面(这个页面对应的后台数据, 包括 banner, 推荐主播, 各种分区的推荐等)
     *
     * @param device 这个 API 会读取 "_device"(固定参数) 或者 "device" 来判断平台, 只需要有一个就能正常工作, 客户端上是两个都有, 且值都为 "android"
     */
    @GET("room/v1/AppIndex/getAllList")
    Call<AllListEntity> getAllList(@Query("device") String device);

    /**
     * 获取 "直播" 页面数据的快捷调用
     */
    default Call<AllListEntity> getAllList() {
        return getAllList("android");
    }

    /**
     * 刷新 "推荐主播" 区域, 必须有 device, platform, scala
     * scala 为 xxhdpi 时返回 12 个, 客户端显示六个, 刷新两次后再次访问该 API
     * 该 API 返回的内容结构与 getAllList 返回的内容中的 recommend_data 字段是一样的
     * 该 API 返回的 banner_data 是在普通分区的推荐的上面的那个 banner, 在新版 APP 中, 点击这个 banner 会固定的跳转到 bilibili 相簿的 画友 标签页
     *
     * @param device 设备类型
     */
    @GET("room/v1/AppIndex/recRefresh")
    Call<RecommendRoomRefreshResponseEntity> recommendRefresh(@Query("device") String device);

    /**
     * 刷新 "推荐主播" 区域 的快捷调用
     */
    default Call<RecommendRoomRefreshResponseEntity> recommendRefresh() {
        return recommendRefresh("android");
    }

    /**
     * 获取对应分类和状态的直播间
     *
     * @param areaId       分区 ID
     * @param categoryId   不明确其含义
     * @param parentAreaId 父分区 ID
     * @param sortType     排序方式
     * @param page         页码, 可以为 null(第一页)
     */
    @GET("room/v1/Area/getRoomList")
    Call<RoomListEntity> getRoomList(
            @Query("area_id") int areaId,
            @Query("cate_id") int categoryId,
            @Query("parent_area_id") int parentAreaId,
            @Query("sort_type") String sortType,
            @Query("page") Long page
    );

    /**
     * 直播页面 下面的 普通分区(复数) 的刷新, 一次会返回 20 个结果, 客户端显示 6 个, 数据用完了之后再次访问该 API
     *
     * @param parentAreaId 父分区 ID
     */
    default Call<RoomListEntity> getRoomList(int parentAreaId) {
        return getRoomList(0, 0, parentAreaId, "dynamic", null);
    }

    /**
     * 直播 -> 某个分区 -> 查看更多
     * 获取该页面上方的分类标签
     *
     * @param parentAreaId 父分区 ID
     */
    @GET("room/v1/Area/getList")
    Call<AreaListEntity> getAreaList(@Query("parent_id") int parentAreaId);

    /**
     * 获取该页面下的的直播间(areaId 为 0 表示选择了 "全部"(上方的分类标签), areaId 如果和 parentAreaId 不匹配将返回空的 data 字段)
     *
     * @param areaId       分区 ID
     * @param parentAreaId 父分区 ID
     * @param page         页码
     */
    default Call<RoomListEntity> getRoomList(int areaId, int parentAreaId, long page) {
        return getRoomList(areaId, 0, parentAreaId, "online", page);
    }

    /**
     * 直播 -> 全部直播(直播页面的最下面的一个按钮)
     *
     * @param areaId 分区 ID
     * @param page   页码
     * @param sort   分类
     */
    @GET("mobile/rooms")
    Call<RoomsEntity> getRooms(@Query("area_id") int areaId, @Query("page") int page, @Query("sort") String sort);

    /**
     * 推荐直播
     *
     * @param page 页码
     */
    default Call<RoomsEntity> getSuggestionRooms(int page) {
        return getRooms(0, page, "suggestion");
    }

    /**
     * 最热直播
     *
     * @param page 页码
     */
    default Call<RoomsEntity> getHottestRooms(int page) {
        return getRooms(0, page, "hottest");
    }

    /**
     * 最新直播
     *
     * @param page 页码
     */
    default Call<RoomsEntity> getLatestRooms(int page) {
        return getRooms(0, page, "latest");
    }

    /**
     * 视频轮播
     *
     * @param page 页码
     */
    default Call<RoomsEntity> getRoundRooms(int page) {
        return getRooms(0, page, "roundroom");
    }

    /**
     * live 站的搜索("直播" 页面)
     *
     * @param keyword  关键字
     * @param page     页码
     * @param pageSize 页容量
     * @param type     为 room 时只返回 房间 的搜索结果, 为 user 时只返回 用户 的搜索结果, all 时 房间 与 用户 的搜索结果都有
     */
    @GET("AppSearch/index")
    Call<SearchResponseEntity> search(@Query("keyword") String keyword, @Query("page") long page, @Query("pagesize") long pageSize, @Query("type") String type);

    /**
     * 搜索的快捷调用
     *
     * @param keyword  关键字
     * @param page     页码
     * @param pageSize 页容量
     */
    default Call<SearchResponseEntity> search(String keyword, long page, long pageSize) {
        return search(keyword, page, pageSize, "all");
    }

    /**
     * 侧拉抽屉 -> 直播中心 -> 右上角日历图标
     * 签到(live 站签到, 非总站(虽然我也不知道总站有没有签到功能))
     *
     * @return 无论是否已经签到, 返回的 code 都是 0. 除了字符串比对, 要想知道是否已经签到要通过 getUserInfo().getIsSign()
     */
    @GET("AppUser/getSignInfo")
    Call<SignInfoEntity> getSignInfo();

    /**
     * 侧拉抽屉 -> 直播中心 -> 我的关注
     * 获得关注列表
     * 未登录时返回 32205
     *
     * @param page     页码
     * @param pageSize 页容量
     */
    @GET("AppFeed/index")
    Call<FollowedHostsEntity> getFollowedHosts(@Query("page") long page, @Query("pagesize") long pageSize);

    /**
     * 侧拉抽屉 -> 直播中心 -> 观看历史
     *
     * @param page     页码
     * @param pageSize 页容量
     */
    @GET("AppUser/history")
    Call<HistoryEntity> getHistory(@Query("page") long page, @Query("pagesize") long pageSize);

    /**
     * 佩戴中心
     * 侧拉抽屉 -> 直播中心 -> 佩戴中心 -> 粉丝勋章
     * 获得用户拥有的粉丝勋章
     */
    @GET("AppUser/medal")
    Call<MyMedalListEntity> getMyMedalList();

    /**
     * 佩戴粉丝勋章
     *
     * @param medalId 勋章 ID
     */
    @POST("AppUser/wearMedal")
    Call<WearMedalResponseEntity> wearMedal(@Query("medal_id") int medalId);

    /**
     * 取消佩戴粉丝勋章(取消佩戴当前佩戴着的粉丝勋章)
     * URL 上的 canel 不是拼写错误, 它原本就是这样的
     */
    @GET("AppUser/canelMedal")
    Call<CancelMedalResponseEntity> cancelMedal();

    /**
     * 侧拉抽屉 -> 直播中心 -> 佩戴中心 -> 我的头衔
     * 获得用户拥有的头衔
     */
    @GET("appUser/myTitleList")
    Call<MyTitleListEntity> getMyTitleList();

    /**
     * 获得当前佩戴着的头衔的详情
     *
     * @return 当前未佩戴任何东西时, 返回的 code 为 -1, message 为 "nodata"
     */
    @GET("appUser/getWearTitle")
    Call<WearTitleEntity> getWearTitle();

    /**
     * 佩戴头衔
     *
     * @param title 头衔名
     */
    @POST("AppUser/wearTitle")
    Call<WearTitleResponseEntity> wearTitle(@Query("title") String title);

    /**
     * 取消佩戴头衔(取消佩戴当前佩戴着的头衔)
     */
    @GET("appUser/cancelTitle")
    Call<CancelTitleResponseEntity> cancelTitle();

    //TODO 头衔工坊(没有可升级头衔, 暂不明确此 API)

    /**
     * 侧拉抽屉 -> 直播中心 -> 获奖记录
     * 获得用户的获奖记录
     */
    @GET("AppUser/awards")
    Call<AwardsEntity> getAwardRecords();

    /**
     * 瓜子商店
     * 侧拉抽屉 -> 直播中心 -> 瓜子商店 -> 银瓜子兑换 -> 硬币银瓜子互换 ->　兑换硬币
     * 将 700 银瓜子兑换为 1 硬币, 每个用户每天只能换一次
     *
     * @return 已经兑换过时返回 403
     * 2018-03-15 访问此 API 必须有一个合法的 UA, 否则返回 65530
     */
    @POST("AppExchange/silver2coin")
    Call<Silver2CoinResponseEntity> silver2Coin();

    /**
     * 扭蛋机
     * 侧拉抽屉 -> 直播中心 -> 扭蛋机 -> 普通扭蛋
     * 获得 扭蛋机(普通扭蛋) 这个页面对应的后台数据
     */
    @GET("AppUser/capsuleInfo")
    Call<CapsuleInfoEntity> getCapsuleInfo();

    /**
     * 抽扭蛋
     *
     * @param count 数量, 只能为 1, 10, 100
     * @param type  扭蛋类型, 只能为 "normal" 或 "colorful"
     */
    @POST("AppUser/capsuleInfoOpen")
    @FormUrlEncoded
    Call<OpenCapsuleResponseEntity> openCapsule(@Field("count") int count, @Field("type") String type);

    /**
     * 抽普通扭蛋
     * 侧拉抽屉 -> 直播中心 -> 扭蛋机 -> 普通扭蛋 -> 扭
     * 普通扭蛋的 type 为 "normal"
     *
     * @param count 数量, 只能为 1, 10, 100
     */
    default Call<OpenCapsuleResponseEntity> openNormalCapsule(int count) {
        return openCapsule(count, "normal");
    }

    /**
     * 抽梦幻扭蛋
     *
     * @param count 数量, 只能为 1, 10, 100
     */
    default Call<OpenCapsuleResponseEntity> openColorfulCapsule(int count) {
        return openCapsule(count, "colorful");
    }

    /**
     * 房间设置
     * 侧拉抽屉 -> 直播中心 -> 房间设置 -> (上面的个人信息, 包括 房间号, 粉丝数, UP 经验)
     * 根据用户 ID 来获取房间信息, 通常用于获取自己的直播间信息(可以用来获取他人的房间信息)
     * 该 API 不会增加直播间观看历史
     *
     * @param userId 用户 ID
     */
    @GET("assistant/getRoomInfo")
    Call<AssistantRoomInfoEntity> getAssistantRoomInfo(@Query("uId") long userId);

    /**
     * 侧拉抽屉 -> 直播中心 -> 房间设置 -> 我的封面
     * 获取自己的直播间的封面
     *
     * @param roomId 房间号
     * @return 获取其他人的封面会 -403
     */
    @GET("mhand/assistant/getCover")
    Call<CoverEntity> getCover(@Query("roomId") long roomId);

    //TODO 粉丝勋章(尚未达到开通粉丝勋章的最低要求, 无法对该 API 截包)
}
