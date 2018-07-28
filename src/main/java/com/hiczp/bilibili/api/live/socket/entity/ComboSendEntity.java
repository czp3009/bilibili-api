package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class ComboSendEntity implements DataEntity {
    /**
     * cmd : COMBO_SEND
     * data : {"uid":33012231,"uname":"我就是讨厌你这样","combo_num":3,"gift_name":"凉了","gift_id":20010,"action":"赠送"}
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
         * uid : 33012231
         * uname : 我就是讨厌你这样
         * combo_num : 3
         * gift_name : 凉了
         * gift_id : 20010
         * action : 赠送
         */

        @SerializedName("uid")
        private long uid;
        @SerializedName("uname")
        private String userName;
        @SerializedName("combo_num")
        private int comboNumber;
        @SerializedName("gift_name")
        private String giftName;
        @SerializedName("gift_id")
        private int giftId;
        @SerializedName("action")
        private String action;

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

        public int getComboNumber() {
            return comboNumber;
        }

        public void setComboNumber(int comboNumber) {
            this.comboNumber = comboNumber;
        }

        public String getGiftName() {
            return giftName;
        }

        public void setGiftName(String giftName) {
            this.giftName = giftName;
        }

        public int getGiftId() {
            return giftId;
        }

        public void setGiftId(int giftId) {
            this.giftId = giftId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }
}
