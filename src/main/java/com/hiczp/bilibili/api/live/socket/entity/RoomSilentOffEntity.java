package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomSilentOffEntity {
    /**
     * cmd : ROOM_SILENT_OFF
     * data : []
     * roomid : 29434
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private String roomid;
    @SerializedName("data")
    private List<?> data;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
