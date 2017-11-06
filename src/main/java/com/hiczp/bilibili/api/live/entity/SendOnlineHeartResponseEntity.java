package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendOnlineHeartResponseEntity {
    /**
     * code : 0
     * message : ok
     * data : {"giftlist":[]}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
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

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        @SerializedName("giftlist")
        private List<?> giftlist;

        public List<?> getGiftlist() {
            return giftlist;
        }

        public void setGiftlist(List<?> giftlist) {
            this.giftlist = giftlist;
        }
    }
}
