package com.hiczp.bilibili.api.live;

import com.hiczp.bilibili.api.BilibiliClientProperties;
import com.hiczp.bilibili.api.live.entity.*;
import retrofit2.Call;
import retrofit2.http.*;

/*  常见参数含义
    mid: 用户 id, 也可能是指主播的用户 id
    cid: 房间 id, 可以指 room_id 也可以指 show_room_id, 推荐所有 API 都使用 room_id 进行访问
*/
public interface LiveService {
    //type 必须是 "all", 否则返回的所有字段的值都是 0
    @GET("AppRoom/danmuConfig")
    Call<BulletScreenConfigEntity> getBulletScreenConfig(@Query("type") String type);

    default Call<BulletScreenConfigEntity> getBulletScreenConfig() {
        return getBulletScreenConfig("all");
    }

    //获得房间的历史弹幕(十条)
    @GET("AppRoom/msg")
    Call<LiveHistoryBulletScreensEntity> getHistoryBulletScreens(@Query("room_id") long roomId);

    //获取直播间信息
    //登录后访问该 API 将在服务器新增一条直播间观看历史
    @GET("AppRoom/index")
    Call<LiveRoomInfoEntity> getRoomInfo(@Query("room_id") long roomId);

    //获得是否关注了一个主播
    //未登录时返回 401
    @POST("feed/v1/feed/isFollowed")
    Call<IsFollowedResponseEntity> isFollowed(@Query("follow") long hostUserId);

    //该 API 意义不明(似乎跟什么 每日背包任务 有关)
    @GET("AppBag/sendDaily")
    Call<SendDailyResponseEntity> sendDaily();

    //获得所有礼物的列表
    @GET("AppIndex/getAllItem")
    Call<ItemsEntity> getAllItem();

    //查看可用的小电视抽奖
    //当目标房间没有可用的小电视抽奖时返回 -400
    @GET("AppSmallTV/index")
    Call<AppSmallTVEntity> getAppSmallTV(@Query("roomid") long roomId);
    //TODO 参与抽奖
    //TODO 查看抽奖结果

    //获得所有头衔的列表
    //这里的 Title 是头衔的意思
    @GET("appUser/getTitle")
    Call<TitlesEntity> getTitle();

    //这个 API 不是很明确, 似乎和 节奏风暴 有关系
    @GET("SpecialGift/room/{roomId}")
    Call<SpecialGiftEntity> getSpecialGift(@Path("roomId") long roomId);

    //获取自己的用户信息(live 站的个人信息, 非总站)
    //未登录时返回 3
    @GET("mobile/getUser")
    Call<UserInfoEntity> getUserInfo();

    //获取一个直播间的流地址(flv)
    //这里的 cid 必须用实际的 room_id, 不能使用 show_room_id, 否则得不到 playUrl. 实际 room_id 要首先通过 getRoomInfo() 获取
    //outputType 为固定值 "json", 否则返回一个空的 JsonArray (以前是返回一个 XML)
    @GET("api/playurl")
    Call<PlayUrlEntity> getPlayUrl(@Query("cid") long cid, @Query("otype") String outputType);

    default Call<PlayUrlEntity> getPlayUrl(long cid) {
        return getPlayUrl(cid, "json");
    }

    //发送一个 Restful 的心跳包, 五分钟一次. 这被用于统计观看直播的时间, 可以提升观众等级
    //未登录时返回 3
    @POST("mobile/userOnlineHeart")
    @FormUrlEncoded
    Call<SendOnlineHeartResponseEntity> sendOnlineHeart(@Field("room_id") long roomId, @Field("scale") String scale);

    default Call<SendOnlineHeartResponseEntity> sendOnlineHeart(long roomId) {
        return sendOnlineHeart(roomId, BilibiliClientProperties.defaultSetting().getScale());
    }

    //发送一条弹幕
    @POST("api/sendmsg")
    @FormUrlEncoded
    Call<SendBulletScreenResponseEntity> sendBulletScreen(@Field("cid") long cid,
                                                          @Field("mid") long mid,
                                                          @Field("msg") String message,
                                                          @Field("rnd") long random,
                                                          @Field("mode") int mode,
                                                          @Field("pool") int pool,
                                                          @Field("type") String type,
                                                          @Field("color") int color,
                                                          @Field("fontsize") int fontSize,
                                                          @Field("playTime") String playTime);

    default Call<SendBulletScreenResponseEntity> sendBulletScreen(BulletScreenEntity bulletScreenEntity) {
        return sendBulletScreen(
                bulletScreenEntity.getCid(),
                bulletScreenEntity.getMid(),
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

    //获取下一个宝箱任务的信息
    @GET("mobile/freeSilverCurrentTask")
    Call<FreeSilverCurrentTaskEntity> getFreeSilverCurrentTask();

    //领取宝箱
    @GET("mobile/freeSilverAward")
    Call<FreeSilverAwardEntity> getFreeSilverAward();

    //查看自己的背包(礼物)
    @GET("AppBag/playerBag")
    Call<PlayerBagEntity> getPlayerBag();

    //查看哪些礼物是活动礼物, 在客户端上, 活动礼物会有一个右上角标记 "活动"
    @GET("AppRoom/activityGift")
    Call<ActivityGiftsEntity> getActivityGifts(@Query("room_id") long roomId);

    //送礼物
    @POST("AppBag/send")
    @FormUrlEncoded
    Call<SendGiftResponseEntity> sendGift(@Field("giftId") long giftId,
                                          @Field("num") long number,
                                          @Field("ruid") long roomUserId,
                                          @Field("roomid") long roomId,
                                          @Field("timestamp") long timeStamp,
                                          @Field("bag_id") long bagId,
                                          @Field("rnd") long random);

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

    //获得礼物榜(七日榜)
    @GET("AppRoom/getGiftTop")
    Call<GiftTopEntity> getGiftTop(@Query("room_id") int roomId);

    //live 站的搜索("直播" 页面)
    //type 为 room 时只返回 房间 的搜索结果
    //type 为 user 时只返回 用户 的搜索结果
    //type 为 all 时 房间 与 用户 的搜索结果都有
    @GET("AppSearch/index")
    Call<SearchResponseEntity> search(@Query("keyword") String keyword, @Query("page") long page, @Query("pagesize") long pageSize, @Query("type") String type);

    default Call<SearchResponseEntity> search(String keyword, long page, long pageSize) {
        return search(keyword, page, pageSize, "all");
    }

    //"直播" 页面(这个页面对应的后台数据, 包括 banner, 推荐主播, 各种分区的推荐等)
    //这个 API 会读取 "_device"(固定参数) 或者 "device" 来判断平台, 只需要有一个就能正常工作, 客户端上是两个都有, 且值都为 "android"
    @GET("room/v1/AppIndex/getAllList")
    Call<AllListEntity> getAllList(@Query("device") String device);

    default Call<AllListEntity> getAllList() {
        return getAllList("android");
    }

    //直播 -> 全部直播 -> 推荐直播
    //似乎 推荐直播 与 最热直播 的返回值是一样的
    @GET("mobile/rooms")
    Call<RoomsEntity> getRooms();

    //侧拉抽屉 -> 直播中心 -> 右上角日历图标
    //签到(live 站签到, 非总站(虽然我也不知道总站有没有签到功能))
    //无论是否已经签到, 返回的 code 都是 0. 除了字符串比对, 要想知道是否已经签到要通过 getUserInfo().getIsSign()
    @GET("AppUser/getSignInfo")
    Call<SignInfoEntity> getSignInfo();

    //侧拉抽屉 -> 直播中心 -> 我的关注
    //获得关注列表
    //未登录时返回 32205
    @GET("AppFeed/index")
    Call<FollowedHostsEntity> getFollowedHosts(@Query("page") long page, @Query("pagesize") long pageSize);

    //侧拉抽屉 -> 直播中心 -> 观看历史
    @GET("AppUser/history")
    Call<HistoryEntity> getHistory(@Query("page") long page, @Query("pagesize") long pageSize);

    //TODO 佩戴中心
    //侧拉抽屉 -> 直播中心 -> 佩戴中心 -> 粉丝勋章
    //获得用户拥有的粉丝勋章
    @GET("AppUser/medal")
    Call<MyMedalListEntity> getMyMedalList();

    //TODO 佩戴粉丝勋章
    //TODO 删除粉丝勋章

    //侧拉抽屉 -> 直播中心 -> 佩戴中心 -> 我的头衔 -> 佩戴头衔
    //获得用户拥有的头衔
    @GET("appUser/myTitleList")
    Call<MyTitleListEntity> getMyTitleList();

    //获得当前佩戴着的头衔的详情
    //当前未佩戴任何东西时, 返回的 code 为 -1, message 为 "nodata"
    @GET("appUser/getWearTitle")
    Call<WearTitleEntity> getWearTitle();

    //佩戴头衔
    //是的, 你没看错, 是 GET 方式
    @GET("AppUser/wearTitle")
    Call<WearTitleResponseEntity> wearTitle(@Query("title") String title);
    //TODO 取消佩戴

    //TODO 获奖记录
    @GET("AppUser/awards")
    Call<AwardsEntity> getAwards();

    //瓜子商店
    //侧拉抽屉 -> 直播中心 -> 瓜子商店 -> 银瓜子兑换 -> 硬币银瓜子互换 ->　兑换硬币
    //将 700 银瓜子兑换为 1 硬币, 每个用户每天只能换一次
    //actionKey 是固定值, 为 "appkey"
    //已经兑换过时返回 403
    @POST("AppExchange/silver2coin")
    Call<Silver2CoinResponseEntity> silver2Coin(@Query("actionKey") String actionKey);

    default Call<Silver2CoinResponseEntity> silver2Coin() {
        return silver2Coin("appkey");
    }

    //扭蛋机
    //侧拉抽屉 -> 直播中心 -> 扭蛋机 -> 普通扭蛋
    //获得 扭蛋机(普通扭蛋) 这个页面对应的后台数据
    @GET("AppUser/capsuleInfo")
    Call<CapsuleInfoEntity> getCapsuleInfo();

    //抽扭蛋
    //count 只能为 1, 10, 100
    @POST("AppUser/capsuleInfoOpen")
    @FormUrlEncoded
    Call<OpenCapsuleResponseEntity> openCapsule(@Field("count") long count, @Field("type") String type);

    //抽普通扭蛋
    //侧拉抽屉 -> 直播中心 -> 扭蛋机 -> 普通扭蛋 -> 扭
    //普通扭蛋的 type 为 "normal"
    default Call<OpenCapsuleResponseEntity> openNormalCapsule(long count) {
        return openCapsule(count, "normal");
    }

    //TODO 梦幻扭蛋(没抽过, 不知道 type 的值)

    //房间设置
    //侧拉抽屉 -> 直播中心 -> 房间设置 -> (上面的个人信息, 包括 房间号, 粉丝数, UP 经验)
    //根据用户 ID 来获取房间信息, 通常用于获取自己的直播间信息(可以用来获取他人的房间信息)
    //该 API 不会增加直播间观看历史
    @GET("assistant/getRoomInfo")
    Call<AssistantRoomInfoEntity> getAssistantRoomInfo(@Query("uId") long userId);

    //侧拉抽屉 -> 直播中心 -> 房间设置 -> 我的封面
    //获取自己的直播间的封面(获取其他人的封面会 -403)
    @GET("mhand/assistant/getCover")
    Call<CoverEntity> getCover(@Query("roomId") long roomId);

    //TODO 粉丝勋章(尚未达到开通粉丝勋章的最低要求, 无法对该 API 截包)
}
