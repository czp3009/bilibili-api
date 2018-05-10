package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyMedalListEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : [{"medal_id":7,"medal_name":"欧皇","level":3,"uname":"哔哩哔哩直播","intimacy":218,"next_intimacy":500,"status":1,"color":6406234,"guard_type":0,"buff_msg":""},{"medal_id":296,"medal_name":"滚滚","level":2,"uname":"iPanda熊猫频道","intimacy":200,"next_intimacy":300,"status":0,"color":6406234,"guard_type":0,"buff_msg":""},{"medal_id":1411,"medal_name":"工程师","level":1,"uname":"ici2cc","intimacy":0,"next_intimacy":201,"status":0,"color":6406234,"guard_type":0,"buff_msg":""},{"medal_id":13197,"medal_name":"QPC","level":2,"uname":"QPCKerman","intimacy":299,"next_intimacy":300,"status":0,"color":6406234,"guard_type":0,"buff_msg":""}]
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private List<Medal> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Medal> getData() {
        return data;
    }

    public void setData(List<Medal> data) {
        this.data = data;
    }

    public static class Medal {
        /**
         * medal_id : 7
         * medal_name : 欧皇
         * level : 3
         * uname : 哔哩哔哩直播
         * intimacy : 218
         * next_intimacy : 500
         * status : 1
         * color : 6406234
         * guard_type : 0
         * buff_msg :
         */

        @SerializedName("medal_id")
        private int medalId;
        @SerializedName("medal_name")
        private String medalName;
        @SerializedName("level")
        private int level;
        @SerializedName("uname")
        private String username;
        @SerializedName("intimacy")
        private int intimacy;
        @SerializedName("next_intimacy")
        private int nextIntimacy;
        @SerializedName("status")
        private int status;
        @SerializedName("color")
        private int color;
        @SerializedName("guard_type")
        private int guardType;
        @SerializedName("buff_msg")
        private String buffMsg;

        public int getMedalId() {
            return medalId;
        }

        public void setMedalId(int medalId) {
            this.medalId = medalId;
        }

        public String getMedalName() {
            return medalName;
        }

        public void setMedalName(String medalName) {
            this.medalName = medalName;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getIntimacy() {
            return intimacy;
        }

        public void setIntimacy(int intimacy) {
            this.intimacy = intimacy;
        }

        public int getNextIntimacy() {
            return nextIntimacy;
        }

        public void setNextIntimacy(int nextIntimacy) {
            this.nextIntimacy = nextIntimacy;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public int getGuardType() {
            return guardType;
        }

        public void setGuardType(int guardType) {
            this.guardType = guardType;
        }

        public String getBuffMsg() {
            return buffMsg;
        }

        public void setBuffMsg(String buffMsg) {
            this.buffMsg = buffMsg;
        }
    }
}
