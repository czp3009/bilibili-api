package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkProcessEntity implements DataEntity {
    /**
     * cmd : PK_PROCESS
     * pk_id : 8798
     * pk_status : 300
     * data : {"uid":0,"init_votes":30,"match_votes":20,"user_votes":0}
     * roomid : 346075
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
         * uid : 0
         * init_votes : 30
         * match_votes : 20
         * user_votes : 0
         */

        @SerializedName("uid")
        private long userId;
        @SerializedName("init_votes")
        private int initVotes;
        @SerializedName("match_votes")
        private int matchVotes;
        @SerializedName("user_votes")
        private int userVotes;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public int getInitVotes() {
            return initVotes;
        }

        public void setInitVotes(int initVotes) {
            this.initVotes = initVotes;
        }

        public int getMatchVotes() {
            return matchVotes;
        }

        public void setMatchVotes(int matchVotes) {
            this.matchVotes = matchVotes;
        }

        public int getUserVotes() {
            return userVotes;
        }

        public void setUserVotes(int userVotes) {
            this.userVotes = userVotes;
        }
    }
}
