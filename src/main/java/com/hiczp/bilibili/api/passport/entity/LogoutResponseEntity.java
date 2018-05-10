package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;

public class LogoutResponseEntity extends ResponseEntity {
    /**
     * message : access_key not found.
     * ts : 1509555707
     * code : -901
     */

    @SerializedName("ts")
    private long timestamp;
    @SerializedName("code")
    private int code;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
