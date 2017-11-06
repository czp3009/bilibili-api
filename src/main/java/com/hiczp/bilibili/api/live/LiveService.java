package com.hiczp.bilibili.api.live;

import com.hiczp.bilibili.api.live.entity.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface LiveService {
    @GET("AppRoom/danmuConfig")
    Call<BulletScreenConfigEntity> getBulletScreenConfig(@Query("type") String type);

    @GET("AppRoom/msg")
    Call<LiveHistoryBulletScreensEntity> getHistoryBulletScreens(@Query("room_id") int roomId);

    @GET("AppRoom/index")
    Call<LiveRoomInfoEntity> getRoomInfo(@Query("room_id") int roomId);

    @POST("feed/v1/feed/isFollowed")
    Call<IsFollowedResponseEntity> isFollowed(@Query("follow") int follow);

    @GET("AppBag/sendDaily")
    Call<SendDailyResponseEntity> sendDaily();

    @GET("AppIndex/getAllItem")
    Call<ItemsEntity> getAllItem();

    @GET("AppSmallTV/index")
    Call<AppSmallTVEntity> getAppSmallTV();

    @GET("appUser/getTitle")
    Call<TitlesEntity> getTitle();

    @GET("SpecialGift/room/{roomId}")
    Call<SpecialGiftEntity> getSpecialGift(@Path("roomId") int roomId);

    @GET("mobile/getUser")
    Call<UserEntity> getUserInfo();

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

    @GET("AppUser/getSignInfo")
    Call<SignInfoEntity> getSignInfo();
}
