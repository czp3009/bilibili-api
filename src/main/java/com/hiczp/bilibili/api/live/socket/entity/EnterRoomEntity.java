package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class EnterRoomEntity {
    @SerializedName("roomid")
    private int roomId;
    @SerializedName("uid")
    private int userId;

    public EnterRoomEntity(int roomId, int userId) {
        this.roomId = roomId;
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
