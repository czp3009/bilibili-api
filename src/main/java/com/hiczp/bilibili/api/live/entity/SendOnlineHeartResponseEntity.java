package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendOnlineHeartResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * message : ok
     * data : {"giftlist":[]}
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
        @SerializedName("giftlist")
        private List<JsonElement> giftList;

        public List<JsonElement> getGiftList() {
            return giftList;
        }

        public void setGiftList(List<JsonElement> giftList) {
            this.giftList = giftList;
        }
    }
}
