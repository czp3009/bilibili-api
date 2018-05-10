package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomAdminsEntity implements DataEntity {
    /**
     * cmd : ROOM_ADMINS
     * uids : [4561799,432672,2179804,7928207,94380,1626161,3168349,13182672]
     * roomid : 5279
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private long roomId;
    @SerializedName("uids")
    private List<Long> userIds;

    @Override
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

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
