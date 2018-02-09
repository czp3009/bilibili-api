package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class RoomBlockMsgEntity {
    /**
     * cmd : ROOM_BLOCK_MSG
     * uid : 60244207
     * uname : 承包rose
     * roomid : 5279
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("uid")
    private String uid;
    @SerializedName("uname")
    private String uname;
    @SerializedName("roomid")
    private long roomid;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }
}
