package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class WarningEntity implements DataEntity {
    /**
     * cmd : WARNING
     * msg : 违反直播分区规范，请立即更换至游戏区
     * roomid : 1365604
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("msg")
    private String message;
    @SerializedName("roomid")
    private long roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
