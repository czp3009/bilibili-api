package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class JoinAppSmallTVResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : OK
     * message : OK
     * data : {"id":40147,"dtime":179,"status":1}
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
        /**
         * id : 40147
         * dtime : 179
         * status : 1
         */

        @SerializedName("id")
        private long id;
        @SerializedName("dtime")
        private int dtime;
        @SerializedName("status")
        private int status;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getDtime() {
            return dtime;
        }

        public void setDtime(int dtime) {
            this.dtime = dtime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
