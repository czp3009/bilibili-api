package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;

public class GiftEntity {
    @SerializedName("giftId")
    private int giftId;

    @SerializedName("bag_id")
    private int bagId;

    @SerializedName("num")
    private int number;

    @SerializedName("roomid")
    private int roomId;

    @SerializedName("ruid")
    private int roomUserId;

    @SerializedName("timestamp")
    private long timeStamp = Instant.now().getEpochSecond();

    //该随机数有 10 位, 暂时未见到负数的情况
    @SerializedName("rnd")
    private long random = (long) (Math.random() * 9999999999L);

    public GiftEntity(int giftId, int bagId, int number, int roomId, int roomUserId) {
        this.giftId = giftId;
        this.bagId = bagId;
        this.number = number;
        this.roomId = roomId;
        this.roomUserId = roomUserId;
    }

    public GiftEntity(int giftId, int bagId, int number, LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity) {
        this(giftId, bagId, number, liveRoomEntity.getRoomId(), liveRoomEntity.getMid());
    }

    public GiftEntity(PlayerBagEntity.BagGiftEntity bagGiftEntity, int number, int roomId, int roomUserId) {
        this(bagGiftEntity.getGiftId(), bagGiftEntity.getId(), number, roomId, roomUserId);
    }

    public GiftEntity(PlayerBagEntity.BagGiftEntity bagGiftEntity, int number, LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity) {
        this(bagGiftEntity.getGiftId(), bagGiftEntity.getId(), number, liveRoomEntity.getRoomId(), liveRoomEntity.getMid());
    }

    public int getGiftId() {
        return giftId;
    }

    public GiftEntity setGiftId(int giftId) {
        this.giftId = giftId;
        return this;
    }

    public int getBagId() {
        return bagId;
    }

    public GiftEntity setBagId(int bagId) {
        this.bagId = bagId;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public GiftEntity setNumber(int number) {
        this.number = number;
        return this;
    }

    public int getRoomId() {
        return roomId;
    }

    public GiftEntity setRoomId(int roomId) {
        this.roomId = roomId;
        return this;
    }

    public int getRoomUserId() {
        return roomUserId;
    }

    public GiftEntity setRoomUserId(int roomUserId) {
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
