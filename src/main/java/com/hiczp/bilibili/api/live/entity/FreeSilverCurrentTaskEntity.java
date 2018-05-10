package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class FreeSilverCurrentTaskEntity extends ResponseEntity {
    /**
     * code : 0
     * message :
     * data : {"minute":3,"silver":30,"time_start":1509821442,"time_end":1509821622,"times":1,"max_times":3}
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
         * minute : 3
         * silver : 30
         * time_start : 1509821442
         * time_end : 1509821622
         * times : 1
         * max_times : 3
         */

        @SerializedName("minute")
        private int minute;
        @SerializedName("silver")
        private int silver;
        @SerializedName("time_start")
        private int timeStart;
        @SerializedName("time_end")
        private int timeEnd;
        @SerializedName("times")
        private int times;
        @SerializedName("max_times")
        private int maxTimes;

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSilver() {
            return silver;
        }

        public void setSilver(int silver) {
            this.silver = silver;
        }

        public int getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(int timeStart) {
            this.timeStart = timeStart;
        }

        public int getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(int timeEnd) {
            this.timeEnd = timeEnd;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public int getMaxTimes() {
            return maxTimes;
        }

        public void setMaxTimes(int maxTimes) {
            this.maxTimes = maxTimes;
        }
    }
}
