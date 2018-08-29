package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

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
    //user 可能是 JsonArray 也可能是 String
    @SerializedName("user")
    private JsonElement user;
    //同上
    @SerializedName("keyword")
    private JsonElement keyword;

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

    public JsonElement getUser() {
        return user;
    }

    public void setUser(JsonElement user) {
        this.user = user;
    }

    public JsonElement getKeyword() {
        return keyword;
    }

    public void setKeyword(JsonElement keyword) {
        this.keyword = keyword;
    }
}
