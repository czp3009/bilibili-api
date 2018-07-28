package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkClickAgainEntity implements DataEntity {
    /**
     * pk_status : 400
     * pk_id : 60672
     * cmd : PK_CLICK_AGAIN
     * roomid : 1489926
     */

    @SerializedName("pk_status")
    private int pkStatus;
    @SerializedName("pk_id")
    private long pkId;
    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private long roomId;

    public int getPkStatus() {
        return pkStatus;
    }

    public void setPkStatus(int pkStatus) {
        this.pkStatus = pkStatus;
    }

    public long getPkId() {
        return pkId;
    }

    public void setPkId(long pkId) {
        this.pkId = pkId;
    }

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
}
