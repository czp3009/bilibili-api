package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;
import com.hiczp.bilibili.api.BilibiliAccount;

public class LoginResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * data : {"access_token":"8501735069b043dd62c3bb88810444fd","refresh_token":"d41affc888082ffa11d7d2c37ad0cf2c","mid":20293030,"expires_in":2592000}
     * ts : 1509734025
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private Data data;
    @SerializedName("ts")
    private long timestamp;

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BilibiliAccount toBilibiliAccount() {
        return new BilibiliAccount(
                this.data.accessToken,
                this.data.refreshToken,
                this.data.userId,
                this.data.expiresIn,
                this.timestamp
        );
    }

    public static class Data {
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
        private long userId;
        @SerializedName("expires_in")
        private long expiresIn;

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

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }
    }
}
