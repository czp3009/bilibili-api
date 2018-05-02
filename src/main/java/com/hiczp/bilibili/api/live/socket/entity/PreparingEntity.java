package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PreparingEntity implements RoomStatusEntity {
    /**
     * cmd : PREPARING
     * roomid : 1110317
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private String roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
