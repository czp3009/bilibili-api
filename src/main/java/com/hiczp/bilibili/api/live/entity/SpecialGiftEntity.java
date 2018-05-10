package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class SpecialGiftEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * msg : OK
     * data : {"gift39":null}
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
         * gift39 : null
         */

        @SerializedName("gift39")
        private JsonElement gift39;

        public JsonElement getGift39() {
            return gift39;
        }

        public void setGift39(JsonObject gift39) {
            this.gift39 = gift39;
        }
    }
}
