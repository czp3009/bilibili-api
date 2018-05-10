package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class SendDailyResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * message : ok
     * data : {"result":2}
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
         * result : 2
         */

        @SerializedName("result")
        private int result;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }
}
