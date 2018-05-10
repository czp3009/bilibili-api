package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CancelTitleResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : []
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private List<?> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
