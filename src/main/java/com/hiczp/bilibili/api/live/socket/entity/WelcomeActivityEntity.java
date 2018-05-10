package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class WelcomeActivityEntity implements DataEntity {
    /**
     * cmd : WELCOME_ACTIVITY
     * data : {"uid":49427998,"uname":"起个名真tm费事","type":"forever_love","display_mode":1}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * uid : 49427998
         * uname : 起个名真tm费事
         * type : forever_love
         * display_mode : 1
         */

        @SerializedName("uid")
        private long uid;
        @SerializedName("uname")
        private String username;
        @SerializedName("type")
        private String type;
        @SerializedName("display_mode")
        private int displayMode;

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getDisplayMode() {
            return displayMode;
        }

        public void setDisplayMode(int displayMode) {
            this.displayMode = displayMode;
        }
    }
}
