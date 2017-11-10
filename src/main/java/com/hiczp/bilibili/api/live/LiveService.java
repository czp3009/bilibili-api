package com.hiczp.bilibili.api.live;

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

    @GET("AppRoom/msg")
    Call<LiveHistoryBulletScreensEntity> getHistoryBulletScreens(@Query("room_id") int roomId);

    @GET("AppRoom/index")
    Call<LiveRoomInfoEntity> getRoomInfo(@Query("room_id") int roomId);

    @POST("feed/v1/feed/isFollowed")
    Call<IsFollowedResponseEntity> isFollowed(@Query("follow") int hostUserId);

    //该 API 意义不明
    @GET("AppBag/sendDaily")
    Call<SendDailyResponseEntity> sendDaily();

    @GET("AppIndex/getAllItem")
    Call<ItemsEntity> getAllItem();

    //该 API 的返回值意义不明确, 所有房间似乎都一样, 且返回的 code 为 -400
    @GET("AppSmallTV/index")
    Call<AppSmallTVEntity> getAppSmallTV();

    //这里的 Title 是头衔的意思
    @GET("appUser/getTitle")
    Call<TitlesEntity> getTitle();

    //这个 API 不是很明确, 所有房间都一样
    @GET("SpecialGift/room/{roomId}")
    Call<SpecialGiftEntity> getSpecialGift(@Path("roomId") int roomId);

    @GET("mobile/getUser")
    Call<UserInfoEntity> getUserInfo();

    //这里的 cid 必须用实际的 room_id, 不能使用 show_room_id, 否则得不到 playUrl. 实际 room_id 要首先通过 getRoomInfo() 获取
    //outputType 为固定值 "json", 否则返回的内容是 XML, 如下所示(本 API 无法解析, 将直接抛出 JsonParseException)
    //<video>
    //  <result>suee</result>
    //  <timelength>0</timelength>
    //  <stream><![CDATA[http]]></stream>
    //  <src>0</src>
    //  <durl>
    //    <order>1</order>
    //    <length>0</length>
    //    <url><![CDATA[http://bvc.live-play.acgvideo.com/live-bvc/968975/live_11153765_9369560_1500.flv?wsSecret=42bc37176fc35d4dd216f85dab65764b&wsTime=1510309331]]></url>
    //    <b1url><![CDATA[http://txy.live-play.acgvideo.com/live-txy/305517/live_11153765_9369560_1500.flv?wsSecret=98c58195769412b97118664a488647dc&wsTime=1510309331]]></b1url>
    //    <b2url><![CDATA[http://qn.live-play.acgvideo.com/live-qn/143985/live_11153765_9369560_1500.flv?wsSecret=876c89db6d97d3516b4e53f1866b8cc7&wsTime=1510309331]]></b2url>
    //    <b3url><![CDATA[http://alx.live-play.acgvideo.com/live-alx/744409/live_11153765_9369560_1500.flv?wsSecret=769f731c9a75f35cc1e0f7f1e14e5c9e&wsTime=1510309331]]></b3url>
    //  </durl>
    //  <accept_quality><![CDATA[3,4]]></accept_quality>
    //  <current_quality>3</current_quality>
    //</video>
    @GET("api/playurl")
    Call<PlayUrlEntity> getPlayUrl(@Query("cid") int cid, @Query("otype") String outputType);

    @POST("mobile/userOnlineHeart")
    @FormUrlEncoded
    Call<SendOnlineHeartResponseEntity> sendOnlineHeart(@Field("room_id") int roomId, @Field("scale") String scale);

    @POST("api/sendmsg")
    @FormUrlEncoded
    Call<SendBulletScreenResponseEntity> sendBulletScreen(@Field("cid") int cid,
                                                          @Field("mid") int mid,
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

    @GET("mobile/freeSilverCurrentTask")
    Call<FreeSilverCurrentTaskEntity> getFreeSilverCurrentTask();

    @GET("mobile/freeSilverAward")
    Call<FreeSilverAwardEntity> getFreeSilverAward();

    @GET("AppBag/playerBag")
    Call<PlayerBagEntity> getPlayerBag();

    @GET("AppRoom/activityGift")
    Call<ActivityGiftsEntity> getActivityGifts(@Query("room_id") int roomId);

    @POST("AppBag/send")
    @FormUrlEncoded
    Call<SendGiftResponseEntity> sendGift(@Field("giftId") int giftId,
                                          @Field("num") int number,
                                          @Field("ruid") int roomUserId,
                                          @Field("roomid") int roomId,
                                          @Field("timestamp") long timeStamp,
                                          @Field("bag_id") int bagId,
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

    @GET("AppRoom/getGiftTop")
    Call<GiftTopEntity> getGiftTop(@Query("room_id") int roomId);

    //无论是否已经签到, 返回的 code 都是 0. 除了字符串比对, 要想知道是否已经签到要通过 getUserInfo().getIsSign()
    @GET("AppUser/getSignInfo")
    Call<SignInfoEntity> getSignInfo();
}
