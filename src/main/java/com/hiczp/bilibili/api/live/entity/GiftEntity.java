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

    public GiftEntity(long giftId, long bagId, long number, long roomId, long roomUserId) {
        this.giftId = giftId;
        this.bagId = bagId;
        this.number = number;
        this.roomId = roomId;
        this.roomUserId = roomUserId;
    }

    public GiftEntity(long giftId, long bagId, long number, LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity) {
        this(giftId, bagId, number, liveRoomEntity.getRoomId(), liveRoomEntity.getMid());
    }

    public GiftEntity(PlayerBagEntity.BagGiftEntity bagGiftEntity, long number, long roomId, long roomUserId) {
        this(bagGiftEntity.getGiftId(), bagGiftEntity.getId(), number, roomId, roomUserId);
    }

    public GiftEntity(PlayerBagEntity.BagGiftEntity bagGiftEntity, long number, LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity) {
        this(bagGiftEntity.getGiftId(), bagGiftEntity.getId(), number, liveRoomEntity.getRoomId(), liveRoomEntity.getMid());
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
