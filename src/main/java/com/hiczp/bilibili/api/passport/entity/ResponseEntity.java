package com.hiczp.bilibili.api.passport.entity;

import com.google.gson.annotations.SerializedName;

public abstract class ResponseEntity {
    //有一些返回的模型中的 code 是字符串, 所以这个父类不能包含 code
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public ResponseEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}
