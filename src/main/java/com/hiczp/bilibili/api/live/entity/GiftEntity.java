package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;

public class GiftEntity {
    @SerializedName("giftId")
    private long giftId;

    @SerializedName("bag_id")
    private long bagId;

    @SerializedName("num")
    private long number;

    @SerializedName("roomid")
    private long roomId;

    @SerializedName("ruid")
    private long roomUserId;

    @SerializedName("timestamp")
    private long timeStamp = Instant.now().getEpochSecond();

    //该随机数有 10 位, 暂时未见到负数的情况
    @SerializedName("rnd")
    private long random = (long) (Math.random() * 9999999999L);

    /**
     * 礼物的构造器, giftId 与 bagId 必须匹配, roomId 与 roomUserId 必须匹配
     *
     * @param giftId     礼物 ID
     * @param bagId      礼物在背包中的 ID
     * @param number     数量
     * @param roomId     房间号
     * @param roomUserId 房间主播的用户 ID
     */
    public GiftEntity(long giftId, long bagId, long number, long roomId, long roomUserId) {
        this.giftId = giftId;
        this.bagId = bagId;
        this.number = number;
        this.roomId = roomId;
        this.roomUserId = roomUserId;
    }

    public GiftEntity(long giftId, long bagId, long number, LiveRoomInfoEntity.LiveRoom liveRoom) {
        this(giftId, bagId, number, liveRoom.getRoomId(), liveRoom.getUserId());
    }

    public GiftEntity(PlayerBagEntity.BagGift bagGift, long number, long roomId, long roomUserId) {
        this(bagGift.getGiftId(), bagGift.getId(), number, roomId, roomUserId);
    }

    public GiftEntity(PlayerBagEntity.BagGift bagGift, long number, LiveRoomInfoEntity.LiveRoom liveRoom) {
        this(bagGift.getGiftId(), bagGift.getId(), number, liveRoom.getRoomId(), liveRoom.getUserId());
    }

    public long getGiftId() {
        return giftId;
    }

    public GiftEntity setGiftId(long giftId) {
        this.giftId = giftId;
        return this;
    }

    public long getBagId() {
        return bagId;
    }

    public GiftEntity setBagId(long bagId) {
        this.bagId = bagId;
        return this;
    }

    public long getNumber() {
        return number;
    }

    public GiftEntity setNumber(long number) {
        this.number = number;
        return this;
    }

    public long getRoomId() {
        return roomId;
    }

    public GiftEntity setRoomId(long roomId) {
        this.roomId = roomId;
        return this;
    }

    public long getRoomUserId() {
        return roomUserId;
    }

    public GiftEntity setRoomUserId(long roomUserId) {
        this.roomUserId = roomUserId;
        return this;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public GiftEntity setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public long getRandom() {
        return random;
    }

    public GiftEntity setRandom(long random) {
        this.random = random;
        return this;
    }
}
