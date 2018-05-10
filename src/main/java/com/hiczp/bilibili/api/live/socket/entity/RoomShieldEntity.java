package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomShieldEntity implements DataEntity {
    /**
     * cmd : ROOM_SHIELD
     * type : 1
     * user : []
     * keyword : ["暗号","摄像头","色相头"]
     * roomid : 505447
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("type")
    private int type;
    @SerializedName("roomid")
    private long roomId;
    @SerializedName("user")
    private List<String> user;
    @SerializedName("keyword")
    private List<String> keyword;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public List<String> getUser() {
        return user;
    }

    public void setUser(List<String> user) {
        this.user = user;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }
}
