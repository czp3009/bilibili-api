package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class ActivityEventEntity implements DataEntity {
    /**
     * cmd : ACTIVITY_EVENT
     * data : {"keyword":"newspring_2018","type":"cracker","limit":300000,"progress":158912}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * keyword : newspring_2018
         * type : cracker
         * limit : 300000
         * progress : 158912
         */

        @SerializedName("keyword")
        private String keyword;
        @SerializedName("type")
        private String type;
        @SerializedName("limit")
        private int limit;
        @SerializedName("progress")
        private int progress;

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }
    }
}
