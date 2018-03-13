package com.hiczp.bilibili.api.live.socket.event;

import com.google.gson.JsonObject;

import java.util.EventObject;

//这个事件用于调试, 任何 Data 数据包都会触发一次这个事件
public class ReceiveDataPackageDebugEvent extends EventObject {
    private JsonObject jsonObject;

    public ReceiveDataPackageDebugEvent(Object source, JsonObject jsonObject) {
        super(source);
        this.jsonObject = jsonObject;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }
}
