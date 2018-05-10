package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomSilentOffEntity implements DataEntity {
    /**
     * cmd : ROOM_SILENT_OFF
     * data : []
     * roomid : 29434
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private String roomId;
    @SerializedName("data")
    private List<JsonElement> data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<JsonElement> getData() {
        return data;
    }

    public void setData(List<JsonElement> data) {
        this.data = data;
    }
}
