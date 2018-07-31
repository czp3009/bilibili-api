package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;

public class InfoEntity extends ResponseEntity {
    /**
     * ts : 1509555703
     * code : 0
     * data : {"mid":20293030,"appid":878,"access_token":"ef3981aefcf27013dce6d0571eca79d9","expires_in":1465966,"userid":"bili_1178318619","uname":"czp3009"}
     */

    @SerializedName("ts")
    private long timestamp;
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * mid : 20293030
         * appid : 878
         * access_token : ef3981aefcf27013dce6d0571eca79d9
         * expires_in : 1465966
         * userid : bili_1178318619
         * uname : czp3009
         */

        @SerializedName("mid")
        private long userId;
        @SerializedName("appid")
        private int appId;
        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("expires_in")
        private long expiresIn;
        @SerializedName("userid")
        private String userIdString;
        @SerializedName("uname")
        private String username;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
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

        public String getUserIdString() {
            return userIdString;
        }

        public void setUserIdString(String userIdString) {
            this.userIdString = userIdString;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
