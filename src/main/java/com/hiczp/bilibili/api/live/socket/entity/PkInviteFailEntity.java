package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkInviteFailEntity implements DataEntity {
    /**
     * cmd : PK_INVITE_FAIL
     * pk_invite_status : 1100
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("pk_invite_status")
    private int pkInviteStatus;

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
}
