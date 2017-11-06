package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;

public class InfoEntity {
    /**
     * ts : 1509555703
     * code : 0
     * data : {"mid":20293030,"appid":878,"access_token":"ef3981aefcf27013dce6d0571eca79d9","expires_in":1465966,"userid":"bili_1178318619","uname":"czp3009"}
     */

    @SerializedName("ts")
    private int ts;
    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataEntity data;

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
        /**
         * mid : 20293030
         * appid : 878
         * access_token : ef3981aefcf27013dce6d0571eca79d9
         * expires_in : 1465966
         * userid : bili_1178318619
         * uname : czp3009
         */

        @SerializedName("mid")
        private int mid;
        @SerializedName("appid")
        private int appid;
        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("expires_in")
        private int expiresIn;
        @SerializedName("userid")
        private String userid;
        @SerializedName("uname")
        private String uname;

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getAppid() {
            return appid;
        }

        public void setAppid(int appid) {
            this.appid = appid;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }
    }
}
