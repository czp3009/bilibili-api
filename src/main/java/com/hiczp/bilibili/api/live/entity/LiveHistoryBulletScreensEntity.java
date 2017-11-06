package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveHistoryBulletScreensEntity {
    /**
     * code : 0
     * message : OK
     * data : {"room":[{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:40:10","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:40:59","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:03","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:08","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:26","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:31","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:46","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"感谢 czp3009 的 辣条","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:43:31","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"感谢 czp3009 的 辣条","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 17:41:29","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"感谢 czp3009 的 辣条","uid":20293030,"nickname":"czp3009","timeline":"2017-10-21 01:10:51","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0}],"admin":[]}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataEntity data;

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

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        @SerializedName("room")
        private List<LiveHistoryBulletScreenEntity> room;
        @SerializedName("admin")
        private List<?> admin;

        public List<LiveHistoryBulletScreenEntity> getRoom() {
            return room;
        }

        public void setRoom(List<LiveHistoryBulletScreenEntity> room) {
            this.room = room;
        }

        public List<?> getAdmin() {
            return admin;
        }

        public void setAdmin(List<?> admin) {
            this.admin = admin;
        }

        public static class LiveHistoryBulletScreenEntity {
            /**
             * text : 这是自动发送的弹幕
             * uid : 20293030
             * nickname : czp3009
             * timeline : 2017-10-20 02:40:10
             * isadmin : 0
             * vip : 0
             * svip : 0
             * medal : []
             * title : [""]
             * user_level : [12,0,6406234,">50000"]
             * rank : 10000
             * teamid : 0
             * rnd : -979658878
             * user_title :
             * guard_level : 0
             */

            @SerializedName("text")
            private String text;
            @SerializedName("uid")
            private int uid;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("timeline")
            private String timeline;
            @SerializedName("isadmin")
            private int isadmin;
            @SerializedName("vip")
            private int vip;
            @SerializedName("svip")
            private int svip;
            @SerializedName("rank")
            private int rank;
            @SerializedName("teamid")
            private int teamid;
            @SerializedName("rnd")
            private long rnd;
            @SerializedName("user_title")
            private String userTitle;
            @SerializedName("guard_level")
            private int guardLevel;
            @SerializedName("medal")
            private List<?> medal;
            @SerializedName("title")
            private List<String> title;
            @SerializedName("user_level")
            private List<String> userLevel;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getTimeline() {
                return timeline;
            }

            public void setTimeline(String timeline) {
                this.timeline = timeline;
            }

            public int getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(int isadmin) {
                this.isadmin = isadmin;
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

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getTeamid() {
                return teamid;
            }

            public void setTeamid(int teamid) {
                this.teamid = teamid;
            }

            public long getRnd() {
                return rnd;
            }

            public void setRnd(long rnd) {
                this.rnd = rnd;
            }

            public String getUserTitle() {
                return userTitle;
            }

            public void setUserTitle(String userTitle) {
                this.userTitle = userTitle;
            }

            public int getGuardLevel() {
                return guardLevel;
            }

            public void setGuardLevel(int guardLevel) {
                this.guardLevel = guardLevel;
            }

            public List<?> getMedal() {
                return medal;
            }

            public void setMedal(List<?> medal) {
                this.medal = medal;
            }

            public List<String> getTitle() {
                return title;
            }

            public void setTitle(List<String> title) {
                this.title = title;
            }

            public List<String> getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(List<String> userLevel) {
                this.userLevel = userLevel;
            }
        }
    }
}
