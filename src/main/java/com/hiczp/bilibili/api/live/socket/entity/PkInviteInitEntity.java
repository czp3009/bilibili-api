package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkInviteInitEntity implements DataEntity {
    /**
     * cmd : PK_INVITE_INIT
     * pk_invite_status : 200
     * invite_id : 408
     * face : http://i0.hdslb.com/bfs/face/e1ad4df39e95180e990fdd565b216662bdb2503c.jpg
     * uname : Tocci椭奇
     * area_name : 视频聊天
     * user_level : 24
     * master_level : 31
     * roomid : 883802
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("pk_invite_status")
    private int pkInviteStatus;
    @SerializedName("invite_id")
    private long inviteId;
    @SerializedName("face")
    private String face;
    @SerializedName("uname")
    private String userName;
    @SerializedName("area_name")
    private String areaName;
    @SerializedName("user_level")
    private int userLevel;
    @SerializedName("master_level")
    private int masterLevel;
    @SerializedName("roomid")
    private long roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getPkInviteStatus() {
        return pkInviteStatus;
    }

    public void setPkInviteStatus(int pkInviteStatus) {
        this.pkInviteStatus = pkInviteStatus;
    }

    public long getInviteId() {
        return inviteId;
    }

    public void setInviteId(long inviteId) {
        this.inviteId = inviteId;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getMasterLevel() {
        return masterLevel;
    }

    public void setMasterLevel(int masterLevel) {
        this.masterLevel = masterLevel;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }
}
