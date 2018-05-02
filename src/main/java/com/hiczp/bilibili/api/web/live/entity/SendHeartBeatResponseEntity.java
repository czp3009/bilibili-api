package com.hiczp.bilibili.api.web.live.entity;

import com.google.gson.annotations.SerializedName;

public class SendHeartBeatResponseEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : {"open":1,"has_new":0,"count":0}
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
         * open : 1
         * has_new : 0
         * count : 0
         */

        @SerializedName("open")
        private int open;
        @SerializedName("has_new")
        private int hasNew;
        @SerializedName("count")
        private int count;

        public int getOpen() {
            return open;
        }

        public void setOpen(int open) {
            this.open = open;
        }

        public int getHasNew() {
            return hasNew;
        }

        public void setHasNew(int hasNew) {
            this.hasNew = hasNew;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
