package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class ComboEndEntity implements DataEntity {
    /**
     * cmd : COMBO_END
     * data : {"uname":"打死安迷修-雷狮","r_uname":"Jinko_神子","combo_num":1,"price":200,"gift_name":"flag","gift_id":20002,"start_time":1527929335,"end_time":1527929335}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

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
         * uname : 打死安迷修-雷狮
         * r_uname : Jinko_神子
         * combo_num : 1
         * price : 200
         * gift_name : flag
         * gift_id : 20002
         * start_time : 1527929335
         * end_time : 1527929335
         */

        @SerializedName("uname")
        private String username;
        @SerializedName("r_uname")
        private String roomUsername;
        @SerializedName("combo_num")
        private int comboNumber;
        @SerializedName("price")
        private int price;
        @SerializedName("gift_name")
        private String giftName;
        @SerializedName("gift_id")
        private int giftId;
        @SerializedName("start_time")
        private long startTime;
        @SerializedName("end_time")
        private long endTime;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRoomUsername() {
            return roomUsername;
        }

        public void setRoomUsername(String roomUsername) {
            this.roomUsername = roomUsername;
        }

        public int getComboNumber() {
            return comboNumber;
        }

        public void setComboNumber(int comboNumber) {
            this.comboNumber = comboNumber;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
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

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }
    }
}
