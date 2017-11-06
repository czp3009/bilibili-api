package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class BulletScreenConfigEntity {
    /**
     * code : 0
     * message : OK
     * data : {"refresh_row_factor":0.125,"refresh_rate":100,"max_delay":5000}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataEntity data;

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
         * refresh_row_factor : 0.125
         * refresh_rate : 100
         * max_delay : 5000
         */

        @SerializedName("refresh_row_factor")
        private double refreshRowFactor;
        @SerializedName("refresh_rate")
        private int refreshRate;
        @SerializedName("max_delay")
        private int maxDelay;

        public double getRefreshRowFactor() {
            return refreshRowFactor;
        }

        public void setRefreshRowFactor(double refreshRowFactor) {
            this.refreshRowFactor = refreshRowFactor;
        }

        public int getRefreshRate() {
            return refreshRate;
        }

        public void setRefreshRate(int refreshRate) {
            this.refreshRate = refreshRate;
        }

        public int getMaxDelay() {
            return maxDelay;
        }

        public void setMaxDelay(int maxDelay) {
            this.maxDelay = maxDelay;
        }
    }
}
