package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkMatchEntity implements DataEntity {
    /**
     * cmd : PK_MATCH
     * pk_status : 100
     * pk_id : 3596
     * data : {"init_id":9615419,"match_id":10185039,"escape_time":5,"is_portrait":false,"uname":"茉莉艿","face":"http://i2.hdslb.com/bfs/face/3f2833a3ac598d9757ba33b79ec219cf941bdda8.jpg","uid":18963076}
     * roomid : 9615419
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("pk_status")
    private int pkStatus;
    @SerializedName("pk_id")
    private long pkId;
    @SerializedName("data")
    private Data data;
    @SerializedName("roomid")
    private long roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getPkStatus() {
        return pkStatus;
    }

    public void setPkStatus(int pkStatus) {
        this.pkStatus = pkStatus;
    }

    public long getPkId() {
        return pkId;
    }

    public void setPkId(long pkId) {
        this.pkId = pkId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public static class Data {
        /**
         * init_id : 9615419
         * match_id : 10185039
         * escape_time : 5
         * is_portrait : false
         * uname : 茉莉艿
         * face : http://i2.hdslb.com/bfs/face/3f2833a3ac598d9757ba33b79ec219cf941bdda8.jpg
         * uid : 18963076
         */

        @SerializedName("init_id")
        private long initId;
        @SerializedName("match_id")
        private long matchId;
        @SerializedName("escape_time")
        private int escapeTime;
        @SerializedName("is_portrait")
        private boolean isPortrait;
        @SerializedName("uname")
        private String username;
        @SerializedName("face")
        private String face;
        @SerializedName("uid")
        private long userId;

        public long getInitId() {
            return initId;
        }

        public void setInitId(long initId) {
            this.initId = initId;
        }

        public long getMatchId() {
            return matchId;
        }

        public void setMatchId(long matchId) {
            this.matchId = matchId;
        }

        public int getEscapeTime() {
            return escapeTime;
        }

        public void setEscapeTime(int escapeTime) {
            this.escapeTime = escapeTime;
        }

        public boolean isIsPortrait() {
            return isPortrait;
        }

        public void setIsPortrait(boolean isPortrait) {
            this.isPortrait = isPortrait;
        }

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

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }
    }
}
