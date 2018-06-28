package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkStartEntity implements DataEntity {
    /**
     * cmd : PK_START
     * pk_id : 3597
     * pk_status : 300
     * data : {"init_id":9615419,"match_id":10185039,"pk_topic":"模仿游戏角色让对方猜"}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("pk_id")
    private long pkId;
    @SerializedName("pk_status")
    private int pkStatus;
    @SerializedName("data")
    private Data data;

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

    public static class Data {
        /**
         * init_id : 9615419
         * match_id : 10185039
         * pk_topic : 模仿游戏角色让对方猜
         */

        @SerializedName("init_id")
        private long initId;
        @SerializedName("match_id")
        private long matchId;
        @SerializedName("pk_topic")
        private String pkTopic;

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

        public String getPkTopic() {
            return pkTopic;
        }

        public void setPkTopic(String pkTopic) {
            this.pkTopic = pkTopic;
        }
    }
}
