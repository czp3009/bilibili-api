package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveHistoryBulletScreensEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : {"room":[{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:40:10","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:40:59","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:03","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:08","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:26","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:31","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"这是自动发送的弹幕","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:42:46","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"感谢 czp3009 的 辣条","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 02:43:31","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"感谢 czp3009 的 辣条","uid":20293030,"nickname":"czp3009","timeline":"2017-10-20 17:41:29","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0},{"text":"感谢 czp3009 的 辣条","uid":20293030,"nickname":"czp3009","timeline":"2017-10-21 01:10:51","isadmin":0,"vip":0,"svip":0,"medal":[],"title":[""],"user_level":[12,0,6406234,">50000"],"rank":10000,"teamid":0,"rnd":-979658878,"user_title":"","guard_level":0}],"admin":[]}
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
        @SerializedName("room")
        private List<LiveHistoryBulletScreen> liveHistoryBulletScreens;
        @SerializedName("admin")
        private List<?> admin;

        public List<LiveHistoryBulletScreen> getLiveHistoryBulletScreens() {
            return liveHistoryBulletScreens;
        }

        public void setLiveHistoryBulletScreens(List<LiveHistoryBulletScreen> liveHistoryBulletScreens) {
            this.liveHistoryBulletScreens = liveHistoryBulletScreens;
        }

        public List<?> getAdmin() {
            return admin;
        }

        public void setAdmin(List<?> admin) {
            this.admin = admin;
        }

        public static class LiveHistoryBulletScreen {
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
            private long userId;
            @SerializedName("nickname")
            private String nickname;
            @SerializedName("timeline")
            private String timeLine;
            @SerializedName("isadmin")
            private int isAdmin;
            @SerializedName("vip")
            private int vip;
            @SerializedName("svip")
            private int svip;
            @SerializedName("rank")
            private int rank;
            @SerializedName("teamid")
            private int teamId;
            @SerializedName("rnd")
            private long rnd;
            @SerializedName("user_title")
            private String userTitle;
            @SerializedName("guard_level")
            private int guardLevel;
            @SerializedName("medal")
            private List<JsonElement> medal;
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

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getTimeLine() {
                return timeLine;
            }

            public void setTimeLine(String timeLine) {
                this.timeLine = timeLine;
            }

            public int getIsAdmin() {
                return isAdmin;
            }

            public void setIsAdmin(int isAdmin) {
                this.isAdmin = isAdmin;
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

            public int getTeamId() {
                return teamId;
            }

            public void setTeamId(int teamId) {
                this.teamId = teamId;
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

            public List<JsonElement> getMedal() {
                return medal;
            }

            public void setMedal(List<JsonElement> medal) {
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
