package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class CutOffEntity implements DataEntity {
    /**
     * cmd : CUT_OFF
     * msg : 禁播游戏
     * roomid : 8446134
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("msg")
    private String msg;
    @SerializedName("roomid")
    private long roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
