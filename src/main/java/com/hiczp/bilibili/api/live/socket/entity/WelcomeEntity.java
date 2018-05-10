package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class WelcomeEntity implements DataEntity {
    /**
     * cmd : WELCOME
     * data : {"uid":516505,"uname":"圣蝎","is_admin":false,"vip":1}
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
         * uid : 516505
         * uname : 圣蝎
         * is_admin : false
         * vip : 1
         */

        @SerializedName("uid")
        private long uid;
        @SerializedName("uname")
        private String userName;
        @SerializedName("is_admin")
        private boolean isAdmin;
        @SerializedName("vip")
        private int vip;

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
        }

        public int getVip() {
            return vip;
        }

        public void setVip(int vip) {
            this.vip = vip;
        }
    }
}
