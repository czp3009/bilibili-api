package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class AssistantRoomInfoEntity extends ResponseEntity {
    /**
     * code : 0
     * message : ok
     * msg : ok
     * data : {"roomId":29434,"face":"https://i1.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg","uname":"hyx5020","rcost":35946,"online":519,"status":0,"fansNum":548,"title":"SpaceX重型猎鹰（FH）发射重播","istry":0,"try_time":"0000-00-00 00:00:00","is_medal":1,"medal_name":"502零","medal_status":1,"medal_rename_status":1,"master_score":8786,"master_level":11,"master_level_color":5805790,"master_next_level":12,"master_level_current":12450,"max_level":40,"end_day":-1,"identification":1,"identification_check_status":1,"area":33,"open_medal_level":10,"is_set_medal":1,"fulltext":"LV等级5级或UP等级10级才能开通粉丝勋章哦~加油！"}
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
         * roomId : 29434
         * face : https://i1.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg
         * uname : hyx5020
         * rcost : 35946
         * online : 519
         * status : 0
         * fansNum : 548
         * title : SpaceX重型猎鹰（FH）发射重播
         * istry : 0
         * try_time : 0000-00-00 00:00:00
         * is_medal : 1
         * medal_name : 502零
         * medal_status : 1
         * medal_rename_status : 1
         * master_score : 8786
         * master_level : 11
         * master_level_color : 5805790
         * master_next_level : 12
         * master_level_current : 12450
         * max_level : 40
         * end_day : -1
         * identification : 1
         * identification_check_status : 1
         * area : 33
         * open_medal_level : 10
         * is_set_medal : 1
         * fulltext : LV等级5级或UP等级10级才能开通粉丝勋章哦~加油！
         */

        @SerializedName("roomId")
        private int roomId;
        @SerializedName("face")
        private String face;
        @SerializedName("uname")
        private String username;
        @SerializedName("rcost")
        private int roomCost;
        @SerializedName("online")
        private int online;
        @SerializedName("status")
        private int status;
        @SerializedName("fansNum")
        private int fansNum;
        @SerializedName("title")
        private String title;
        @SerializedName("istry")
        private int isTry;
        @SerializedName("try_time")
        private String tryTime;
        @SerializedName("is_medal")
        private int isMedal;
        @SerializedName("medal_name")
        private String medalName;
        @SerializedName("medal_status")
        private int medalStatus;
        @SerializedName("medal_rename_status")
        private int medalRenameStatus;
        @SerializedName("master_score")
        private int masterScore;
        @SerializedName("master_level")
        private int masterLevel;
        @SerializedName("master_level_color")
        private int masterLevelColor;
        @SerializedName("master_next_level")
        private int masterNextLevel;
        @SerializedName("master_level_current")
        private int masterLevelCurrent;
        @SerializedName("max_level")
        private int maxLevel;
        @SerializedName("end_day")
        private int endDay;
        @SerializedName("identification")
        private int identification;
        @SerializedName("identification_check_status")
        private int identificationCheckStatus;
        @SerializedName("area")
        private int area;
        @SerializedName("open_medal_level")
        private int openMedalLevel;
        @SerializedName("is_set_medal")
        private int isSetMedal;
        @SerializedName("fulltext")
        private String fulltext;

        public int getRoomId() {
            return roomId;
        }

        public void setRoomId(int roomId) {
            this.roomId = roomId;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getRoomCost() {
            return roomCost;
        }

        public void setRoomCost(int roomCost) {
            this.roomCost = roomCost;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getFansNum() {
            return fansNum;
        }

        public void setFansNum(int fansNum) {
            this.fansNum = fansNum;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIsTry() {
            return isTry;
        }

        public void setIsTry(int isTry) {
            this.isTry = isTry;
        }

        public String getTryTime() {
            return tryTime;
        }

        public void setTryTime(String tryTime) {
            this.tryTime = tryTime;
        }

        public int getIsMedal() {
            return isMedal;
        }

        public void setIsMedal(int isMedal) {
            this.isMedal = isMedal;
        }

        public String getMedalName() {
            return medalName;
        }

        public void setMedalName(String medalName) {
            this.medalName = medalName;
        }

        public int getMedalStatus() {
            return medalStatus;
        }

        public void setMedalStatus(int medalStatus) {
            this.medalStatus = medalStatus;
        }

        public int getMedalRenameStatus() {
            return medalRenameStatus;
        }

        public void setMedalRenameStatus(int medalRenameStatus) {
            this.medalRenameStatus = medalRenameStatus;
        }

        public int getMasterScore() {
            return masterScore;
        }

        public void setMasterScore(int masterScore) {
            this.masterScore = masterScore;
        }

        public int getMasterLevel() {
            return masterLevel;
        }

        public void setMasterLevel(int masterLevel) {
            this.masterLevel = masterLevel;
        }

        public int getMasterLevelColor() {
            return masterLevelColor;
        }

        public void setMasterLevelColor(int masterLevelColor) {
            this.masterLevelColor = masterLevelColor;
        }

        public int getMasterNextLevel() {
            return masterNextLevel;
        }

        public void setMasterNextLevel(int masterNextLevel) {
            this.masterNextLevel = masterNextLevel;
        }

        public int getMasterLevelCurrent() {
            return masterLevelCurrent;
        }

        public void setMasterLevelCurrent(int masterLevelCurrent) {
            this.masterLevelCurrent = masterLevelCurrent;
        }

        public int getMaxLevel() {
            return maxLevel;
        }

        public void setMaxLevel(int maxLevel) {
            this.maxLevel = maxLevel;
        }

        public int getEndDay() {
            return endDay;
        }

        public void setEndDay(int endDay) {
            this.endDay = endDay;
        }

        public int getIdentification() {
            return identification;
        }

        public void setIdentification(int identification) {
            this.identification = identification;
        }

        public int getIdentificationCheckStatus() {
            return identificationCheckStatus;
        }

        public void setIdentificationCheckStatus(int identificationCheckStatus) {
            this.identificationCheckStatus = identificationCheckStatus;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int getOpenMedalLevel() {
            return openMedalLevel;
        }

        public void setOpenMedalLevel(int openMedalLevel) {
            this.openMedalLevel = openMedalLevel;
        }

        public int getIsSetMedal() {
            return isSetMedal;
        }

        public void setIsSetMedal(int isSetMedal) {
            this.isSetMedal = isSetMedal;
        }

        public String getFulltext() {
            return fulltext;
        }

        public void setFulltext(String fulltext) {
            this.fulltext = fulltext;
        }
    }
}
