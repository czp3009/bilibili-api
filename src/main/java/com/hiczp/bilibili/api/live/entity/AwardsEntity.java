package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AwardsEntity {
    /**
     * code : 0
     * message : OK
     * data : {"list":[],"use_count":0,"count":0}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * list : []
         * use_count : 0
         * count : 0
         */

        @SerializedName("use_count")
        private int useCount;
        @SerializedName("count")
        private int count;
        @SerializedName("list")
        private List<JsonObject> list;

        public int getUseCount() {
            return useCount;
        }

        public void setUseCount(int useCount) {
            this.useCount = useCount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<JsonObject> list) {
            this.list = list;
        }
    }
}
