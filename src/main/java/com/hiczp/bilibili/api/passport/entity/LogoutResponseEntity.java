package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;

public class LogoutResponseEntity {
    /**
     * message : access_key not found.
     * ts : 1509555707
     * code : -901
     */

    @SerializedName("message")
    private String message;
    @SerializedName("ts")
    private int ts;
    @SerializedName("code")
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
