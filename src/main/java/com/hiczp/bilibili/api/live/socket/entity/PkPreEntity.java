package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkPreEntity implements DataEntity {
    /**
     * cmd : PK_PRE
     * pk_id : 3597
     * pk_status : 200
     * data : {"init_id":9615419,"match_id":10185039,"count_down":5,"pk_topic":"模仿游戏角色让对方猜","pk_pre_time":1529476609,"pk_start_time":1529476614,"pk_end_time":1529476914,"end_time":1529477034}
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
         * count_down : 5
         * pk_topic : 模仿游戏角色让对方猜
         * pk_pre_time : 1529476609
         * pk_start_time : 1529476614
         * pk_end_time : 1529476914
         * end_time : 1529477034
         */

        @SerializedName("init_id")
        private long initId;
        @SerializedName("match_id")
        private long matchId;
        @SerializedName("count_down")
        private int countDown;
        @SerializedName("pk_topic")
        private String pkTopic;
        @SerializedName("pk_pre_time")
        private long pkPreTime;
        @SerializedName("pk_start_time")
        private long pkStartTime;
        @SerializedName("pk_end_time")
        private long pkEndTime;
        @SerializedName("end_time")
        private long endTime;

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

        public int getCountDown() {
            return countDown;
        }

        public void setCountDown(int countDown) {
            this.countDown = countDown;
        }

        public String getPkTopic() {
            return pkTopic;
        }

        public void setPkTopic(String pkTopic) {
            this.pkTopic = pkTopic;
        }

        public long getPkPreTime() {
            return pkPreTime;
        }

        public void setPkPreTime(long pkPreTime) {
            this.pkPreTime = pkPreTime;
        }

        public long getPkStartTime() {
            return pkStartTime;
        }

        public void setPkStartTime(long pkStartTime) {
            this.pkStartTime = pkStartTime;
        }

        public long getPkEndTime() {
            return pkEndTime;
        }

        public void setPkEndTime(long pkEndTime) {
            this.pkEndTime = pkEndTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }
    }
}
