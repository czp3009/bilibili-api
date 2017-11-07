package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class UserInfoEntity {
    /**
     * code : 0
     * message : ok
     * data : {"silver":1896,"gold":0,"vip":0,"svip":0,"svip_time":"0000-00-00 00:00:00","vip_time":"0000-00-00 00:00:00","room_id":1110317,"user_level":20,"user_level_color":6406234,"vip_view_status":1,"isSign":1,"use_count":0,"wearTitle":{"title":"0","activity":"0"}}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private UserEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getData() {
        return data;
    }

    public void setData(UserEntity data) {
        this.data = data;
    }

    public static class UserEntity {
        /**
         * silver : 1896
         * gold : 0
         * vip : 0
         * svip : 0
         * svip_time : 0000-00-00 00:00:00
         * vip_time : 0000-00-00 00:00:00
         * room_id : 1110317
         * user_level : 20
         * user_level_color : 6406234
         * vip_view_status : 1
         * isSign : 1
         * use_count : 0
         * wearTitle : {"title":"0","activity":"0"}
         */

        @SerializedName("silver")
        private int silver;
        @SerializedName("gold")
        private int gold;
        @SerializedName("vip")
        private int vip;
        @SerializedName("svip")
        private int svip;
        @SerializedName("svip_time")
        private String svipTime;
        @SerializedName("vip_time")
        private String vipTime;
        @SerializedName("room_id")
        private int roomId;
        @SerializedName("user_level")
        private int userLevel;
        @SerializedName("user_level_color")
        private int userLevelColor;
        @SerializedName("vip_view_status")
        private int vipViewStatus;
        @SerializedName("isSign")
        private int isSign;
        @SerializedName("use_count")
        private int useCount;
        @SerializedName("wearTitle")
        private WearTitleEntity wearTitle;

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

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
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

        public int getVipViewStatus() {
            return vipViewStatus;
        }

        public void setVipViewStatus(int vipViewStatus) {
            this.vipViewStatus = vipViewStatus;
        }

        public int getIsSign() {
            return isSign;
        }

        public void setIsSign(int isSign) {
            this.isSign = isSign;
        }

        public int getUseCount() {
            return useCount;
        }

        public void setUseCount(int useCount) {
            this.useCount = useCount;
        }

        public WearTitleEntity getWearTitle() {
            return wearTitle;
        }

        public void setWearTitle(WearTitleEntity wearTitle) {
            this.wearTitle = wearTitle;
        }

        public static class WearTitleEntity {
            /**
             * title : 0
             * activity : 0
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
