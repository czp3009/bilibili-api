package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkEndEntity implements DataEntity {
    /**
     * cmd : PK_END
     * pk_id : 8797
     * pk_status : 400
     * data : {"init_id":8049573,"match_id":1409458,"punish_topic":"惩罚：模仿面筋哥"}
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
         * init_id : 8049573
         * match_id : 1409458
         * punish_topic : 惩罚：模仿面筋哥
         */

        @SerializedName("init_id")
        private long initId;
        @SerializedName("match_id")
        private long matchId;
        @SerializedName("punish_topic")
        private String punishTopic;

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

        public String getPunishTopic() {
            return punishTopic;
        }

        public void setPunishTopic(String punishTopic) {
            this.punishTopic = punishTopic;
        }
    }
}
