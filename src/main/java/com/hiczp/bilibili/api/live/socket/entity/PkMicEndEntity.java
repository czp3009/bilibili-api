package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class PkMicEndEntity implements DataEntity {
    /**
     * cmd : PK_MIC_END
     * pk_id : 3596
     * pk_status : 1300
     * data : {"type":0}
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
         * type : 0
         */

        @SerializedName("type")
        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
