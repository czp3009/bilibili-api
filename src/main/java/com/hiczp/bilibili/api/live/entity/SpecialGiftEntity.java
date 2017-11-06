package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class SpecialGiftEntity {
    /**
     * code : 0
     * message : OK
     * msg : OK
     * data : {"gift39":null}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * gift39 : null
         */

        @SerializedName("gift39")
        private Object gift39;

        public Object getGift39() {
            return gift39;
        }

        public void setGift39(Object gift39) {
            this.gift39 = gift39;
        }
    }
}
