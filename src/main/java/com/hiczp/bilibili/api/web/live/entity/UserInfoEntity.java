package com.hiczp.bilibili.api.web.live.entity;

import com.google.gson.annotations.SerializedName;

public class UserInfoEntity extends ResponseEntity {
    /**
     * code : REPONSE_OK
     * msg : ok
     * data : {"uname":"czp3009","face":"http://i2.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","silver":22528,"gold":0,"achieve":135,"vip":0,"svip":0,"user_level":25,"user_next_level":26,"user_intimacy":926000,"user_next_intimacy":10000000,"user_level_rank":">50000","billCoin":699}
     */

    @SerializedName("code")
    private String code;
    @SerializedName("data")
    private Data data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
         * uname : czp3009
         * face : http://i2.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg
         * silver : 22528
         * gold : 0
         * achieve : 135
         * vip : 0
         * svip : 0
         * user_level : 25
         * user_next_level : 26
         * user_intimacy : 926000
         * user_next_intimacy : 10000000
         * user_level_rank : >50000
         * billCoin : 699
         */

        @SerializedName("uname")
        private String username;
        @SerializedName("face")
        private String face;
        @SerializedName("silver")
        private int silver;
        @SerializedName("gold")
        private int gold;
        @SerializedName("achieve")
        private int achieve;
        @SerializedName("vip")
        private int vip;
        @SerializedName("svip")
        private int svip;
        @SerializedName("user_level")
        private int userLevel;
        @SerializedName("user_next_level")
        private int userNextLevel;
        @SerializedName("user_intimacy")
        private int userIntimacy;
        @SerializedName("user_next_intimacy")
        private int userNextIntimacy;
        @SerializedName("user_level_rank")
        private String userLevelRank;
        @SerializedName("billCoin")
        private int billCoin;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getSilver() {
            return silver;
        }

        public void setSilver(int silver) {
            this.silver = silver;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getAchieve() {
            return achieve;
        }

        public void setAchieve(int achieve) {
            this.achieve = achieve;
        }

        public int getVip() {
            return vip;
        }

        public void setVip(int vip) {
            this.vip = vip;
        }

        public int getSvip() {
            return svip;
        }

        public void setSvip(int svip) {
            this.svip = svip;
        }

        public int getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }

        public int getUserNextLevel() {
            return userNextLevel;
        }

        public void setUserNextLevel(int userNextLevel) {
            this.userNextLevel = userNextLevel;
        }

        public int getUserIntimacy() {
            return userIntimacy;
        }

        public void setUserIntimacy(int userIntimacy) {
            this.userIntimacy = userIntimacy;
        }

        public int getUserNextIntimacy() {
            return userNextIntimacy;
        }

        public void setUserNextIntimacy(int userNextIntimacy) {
            this.userNextIntimacy = userNextIntimacy;
        }

        public String getUserLevelRank() {
            return userLevelRank;
        }

        public void setUserLevelRank(String userLevelRank) {
            this.userLevelRank = userLevelRank;
        }

        public int getBillCoin() {
            return billCoin;
        }

        public void setBillCoin(int billCoin) {
            this.billCoin = billCoin;
        }
    }
}
