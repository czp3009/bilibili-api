package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;

public class LoginResponseEntity {
    /**
     * code : 0
     * data : {"access_token":"8501735069b043dd62c3bb88810444fd","refresh_token":"d41affc888082ffa11d7d2c37ad0cf2c","mid":20293030,"expires_in":2592000}
     * ts : 1509734025
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataEntity data;
    @SerializedName("ts")
    private int ts;

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

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public static class DataEntity {
        /**
         * access_token : 8501735069b043dd62c3bb88810444fd
         * refresh_token : d41affc888082ffa11d7d2c37ad0cf2c
         * mid : 20293030
         * expires_in : 2592000
         */

        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("refresh_token")
        private String refreshToken;
        @SerializedName("mid")
        private int mid;
        @SerializedName("expires_in")
        private int expiresIn;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }
    }
}
