package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class JoinAppSmallTVResponseEntity {
    /**
     * code : 0
     * msg : OK
     * message : OK
     * data : {"id":40147,"dtime":179,"status":1}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        private int id;
        @SerializedName("dtime")
        private int dtime;
        @SerializedName("status")
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
