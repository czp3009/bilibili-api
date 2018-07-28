package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkAgainEntity implements DataEntity {
    /**
     * cmd : PK_AGAIN
     * pk_id : 60672
     * pk_status : 400
     * data : {"new_pk_id":60678,"init_id":10817769,"match_id":1489926,"escape_all_time":10,"escape_time":10,"is_portrait":false,"uname":"穆阿是给你的mua","face":"http://i0.hdslb.com/bfs/face/07fa1057b60afe74cdd477f123c6ccf460ee8f2c.jpg","uid":38105366}
     * roomid : 1489926
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("pk_id")
    private long pkId;
    @SerializedName("pk_status")
    private int pkStatus;
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

    public long getPkId() {
        return pkId;
    }

    public void setPkId(long pkId) {
        this.pkId = pkId;
    }

    public int getPkStatus() {
        return pkStatus;
    }

    public void setPkStatus(int pkStatus) {
        this.pkStatus = pkStatus;
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
         * new_pk_id : 60678
         * init_id : 10817769
         * match_id : 1489926
         * escape_all_time : 10
         * escape_time : 10
         * is_portrait : false
         * uname : 穆阿是给你的mua
         * face : http://i0.hdslb.com/bfs/face/07fa1057b60afe74cdd477f123c6ccf460ee8f2c.jpg
         * uid : 38105366
         */

        @SerializedName("new_pk_id")
        private long newPkId;
        @SerializedName("init_id")
        private long initId;
        @SerializedName("match_id")
        private long matchId;
        @SerializedName("escape_all_time")
        private int escapeAllTime;
        @SerializedName("escape_time")
        private int escapeTime;
        @SerializedName("is_portrait")
        private boolean isPortrait;
        @SerializedName("uname")
        private String userName;
        @SerializedName("face")
        private String face;
        @SerializedName("uid")
        private long uid;

        public long getNewPkId() {
            return newPkId;
        }

        public void setNewPkId(long newPkId) {
            this.newPkId = newPkId;
        }

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

        public int getEscapeAllTime() {
            return escapeAllTime;
        }

        public void setEscapeAllTime(int escapeAllTime) {
            this.escapeAllTime = escapeAllTime;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }
    }
}
