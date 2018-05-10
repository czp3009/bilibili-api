package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WearMedalResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : []
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private List<JsonElement> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<JsonElement> getData() {
        return data;
    }

    public void setData(List<JsonElement> data) {
        this.data = data;
    }
}
