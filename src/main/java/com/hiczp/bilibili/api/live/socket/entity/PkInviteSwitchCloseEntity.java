package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkInviteSwitchCloseEntity implements DataEntity {
    /**
     * cmd : PK_INVITE_SWITCH_CLOSE
     * roomid : 1938890
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private long roomId;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
