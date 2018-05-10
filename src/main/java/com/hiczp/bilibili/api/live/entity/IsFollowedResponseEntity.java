package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class IsFollowedResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : {"follow":1}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private Data data;

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
         * follow : 1
         */

        @SerializedName("follow")
        private int follow;

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }
    }
}
