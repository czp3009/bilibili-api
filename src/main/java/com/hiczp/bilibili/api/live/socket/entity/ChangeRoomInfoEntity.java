package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class ChangeRoomInfoEntity implements DataEntity {
    /**
     * cmd : CHANGE_ROOM_INFO
     * background : http://static.hdslb.com/live-static/images/bg/4.jpg
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("background")
    private String background;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
