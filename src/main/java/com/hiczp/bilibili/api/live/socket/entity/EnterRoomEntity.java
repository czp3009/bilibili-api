package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class EnterRoomEntity {
    @SerializedName("roomid")
    private long roomId;
    @SerializedName("uid")
    private long userId;

    public EnterRoomEntity(long roomId, long userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
