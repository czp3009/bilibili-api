package com.hiczp.bilibili.api.web.live.entity;

import com.google.gson.annotations.SerializedName;

public abstract class ResponseEntity {
    //有一些返回的模型中的 code 是字符串, 所以这个父类不能包含 code
    @SerializedName("msg")
    private String msg;
    @SerializedName("message")
    private String message;

    public String getMsg() {
        return msg;
    }

    public ResponseEntity setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}
