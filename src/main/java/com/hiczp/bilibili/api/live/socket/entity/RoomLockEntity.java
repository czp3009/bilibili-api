package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class RoomLockEntity implements DataEntity {
    /**
     * cmd : ROOM_LOCK
     * expire : 2018-03-15 10:24:18
     * roomid : 6477301
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("expire")
    private String expire;
    @SerializedName("roomid")
    private long roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
