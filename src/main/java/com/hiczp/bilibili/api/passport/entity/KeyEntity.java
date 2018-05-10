package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;

public class KeyEntity extends ResponseEntity {
    /**
     * ts : 1509555699
     * code : 0
     * data : {"hash":"8b9030ef5ff6d9f6","key":"-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdScM09sZJqFPX7bvmB2y6i08J\nbHsa0v4THafPbJN9NoaZ9Djz1LmeLkVlmWx1DwgHVW+K7LVWT5FV3johacVRuV98\n37+RNntEK6SE82MPcl7fA++dmW2cLlAjsIIkrX+aIvvSGCuUfcWpWFy3YVDqhuHr\nNDjdNcaefJIQHMW+sQIDAQAB\n-----END PUBLIC KEY-----\n"}
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
         * hash : 8b9030ef5ff6d9f6
         * key : -----BEGIN PUBLIC KEY-----
         * MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdScM09sZJqFPX7bvmB2y6i08J
         * bHsa0v4THafPbJN9NoaZ9Djz1LmeLkVlmWx1DwgHVW+K7LVWT5FV3johacVRuV98
         * 37+RNntEK6SE82MPcl7fA++dmW2cLlAjsIIkrX+aIvvSGCuUfcWpWFy3YVDqhuHr
         * NDjdNcaefJIQHMW+sQIDAQAB
         * -----END PUBLIC KEY-----
         */

        @SerializedName("hash")
        private String hash;
        @SerializedName("key")
        private String key;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
