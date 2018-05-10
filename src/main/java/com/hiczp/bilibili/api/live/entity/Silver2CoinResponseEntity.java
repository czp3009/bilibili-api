package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class Silver2CoinResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : 兑换成功
     * message : 兑换成功
     * data : {"silver":"22494","gold":"0","tid":"e32cb3fc6bca9a7dff343469b1ff981f2123","coin":1}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * silver : 22494
         * gold : 0
         * tid : e32cb3fc6bca9a7dff343469b1ff981f2123
         * coin : 1
         */

        @SerializedName("silver")
        private String silver;
        @SerializedName("gold")
        private String gold;
        @SerializedName("tid")
        private String tid;
        @SerializedName("coin")
        private int coin;

        public String getSilver() {
            return silver;
        }

        public void setSilver(String silver) {
            this.silver = silver;
        }

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }
    }
}
