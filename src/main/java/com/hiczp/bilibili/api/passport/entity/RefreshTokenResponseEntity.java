package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;
import com.hiczp.bilibili.api.BilibiliAccount;

public class RefreshTokenResponseEntity extends ResponseEntity {
    /**
     * ts : 1509734125
     * code : 0
     * data : {"mid":20293030,"refresh_token":"19d64022154e033574df4c753fc7926d","access_token":"f64530df1fb491ae090b67e191d86f58","expires_in":2592000}
     */

    @SerializedName("ts")
    private long ts;
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private Data data;

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

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

    public BilibiliAccount toBilibiliAccount() {
        return new BilibiliAccount(
                this.data.accessToken,
                this.data.refreshToken,
                this.data.userId,
                this.data.expiresIn,
                this.ts
        );
    }

    public static class Data {
        /**
         * mid : 20293030
         * refresh_token : 19d64022154e033574df4c753fc7926d
         * access_token : f64530df1fb491ae090b67e191d86f58
         * expires_in : 2592000
         */

        @SerializedName("mid")
        private long userId;
        @SerializedName("refresh_token")
        private String refreshToken;
        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("expires_in")
        private long expiresIn;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public long getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(long expiresIn) {
            this.expiresIn = expiresIn;
        }
    }
}
