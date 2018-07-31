package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class RoomBlockMsgEntity implements DataEntity {
    /**
     * cmd : ROOM_BLOCK_MSG
     * uid : 60244207
     * uname : 承包rose
     * roomid : 5279
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("uid")
    private String userId;
    @SerializedName("uname")
    private String username;
    @SerializedName("roomid")
    private long roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
