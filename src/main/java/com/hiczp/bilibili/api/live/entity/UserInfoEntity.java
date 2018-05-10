package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class UserInfoEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : OK
     * message : OK
     * data : {"silver":129890,"gold":16102,"medal":{"medal_name":"欧皇","level":3,"color":6406234,"medal_color":6406234},"vip":1,"svip":1,"svip_time":"2019-02-09 11:03:54","vip_time":"2019-02-09 11:03:54","wearTitle":{"title":"title-111-1","activity":"bilibili Link"},"isSign":0,"user_level":22,"user_level_color":5805790,"room_id":29434,"use_count":0,"vip_view_status":1}
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
         * silver : 129890
         * gold : 16102
         * medal : {"medal_name":"欧皇","level":3,"color":6406234,"medal_color":6406234}
         * vip : 1
         * svip : 1
         * svip_time : 2019-02-09 11:03:54
         * vip_time : 2019-02-09 11:03:54
         * wearTitle : {"title":"title-111-1","activity":"bilibili Link"}
         * isSign : 0
         * user_level : 22
         * user_level_color : 5805790
         * room_id : 29434
         * use_count : 0
         * vip_view_status : 1
         */

        @SerializedName("silver")
        private int silver;
        @SerializedName("gold")
        private int gold;
        @SerializedName("medal")
        private Medal medal;
        @SerializedName("vip")
        private int vip;
        @SerializedName("svip")
        private int svip;
        @SerializedName("svip_time")
        private String svipTime;
        @SerializedName("vip_time")
        private String vipTime;
        @SerializedName("wearTitle")
        private WearTitle wearTitle;
        @SerializedName("isSign")
        private boolean isSign;
        @SerializedName("user_level")
        private int userLevel;
        @SerializedName("user_level_color")
        private int userLevelColor;
        @SerializedName("room_id")
        private int roomId;
        @SerializedName("use_count")
        private int useCount;
        @SerializedName("vip_view_status")
        private int vipViewStatus;

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

        public Medal getMedal() {
            return medal;
        }

        public void setMedal(Medal medal) {
            this.medal = medal;
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

        public String getSvipTime() {
            return svipTime;
        }

        public void setSvipTime(String svipTime) {
            this.svipTime = svipTime;
        }

        public String getVipTime() {
            return vipTime;
        }

        public void setVipTime(String vipTime) {
            this.vipTime = vipTime;
        }

        public WearTitle getWearTitle() {
            return wearTitle;
        }

        public void setWearTitle(WearTitle wearTitle) {
            this.wearTitle = wearTitle;
        }

        public boolean isIsSign() {
            return isSign;
        }

        public void setIsSign(boolean isSign) {
            this.isSign = isSign;
        }

        public int getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }

        public int getUserLevelColor() {
            return userLevelColor;
        }

        public void setUserLevelColor(int userLevelColor) {
            this.userLevelColor = userLevelColor;
        }

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public int getUseCount() {
            return useCount;
        }

        public void setUseCount(int useCount) {
            this.useCount = useCount;
        }

        public int getVipViewStatus() {
            return vipViewStatus;
        }

        public void setVipViewStatus(int vipViewStatus) {
            this.vipViewStatus = vipViewStatus;
        }

        public static class Medal {
            /**
             * medal_name : 欧皇
             * level : 3
             * color : 6406234
             * medal_color : 6406234
             */

            @SerializedName("medal_name")
            private String medalName;
            @SerializedName("level")
            private int level;
            @SerializedName("color")
            private int color;
            @SerializedName("medal_color")
            private int medalColor;

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

            public int getColor() {
                return color;
            }

            public void setColor(int color) {
                this.color = color;
            }

            public int getMedalColor() {
                return medalColor;
            }

            public void setMedalColor(int medalColor) {
                this.medalColor = medalColor;
            }
        }

        public static class WearTitle {
            /**
             * title : title-111-1
             * activity : bilibili Link
             */

            @SerializedName("title")
            private String title;
            @SerializedName("activity")
            private String activity;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getActivity() {
                return activity;
            }

            public void setActivity(String activity) {
                this.activity = activity;
            }
        }
    }
}
