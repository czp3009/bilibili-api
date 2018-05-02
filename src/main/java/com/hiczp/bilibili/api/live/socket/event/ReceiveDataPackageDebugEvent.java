package com.hiczp.bilibili.api.live.socket.event;

import com.google.gson.JsonObject;
import com.hiczp.bilibili.api.live.socket.LiveClient;

/**
 * 这个事件用于调试, 任何 Data 数据包都会触发一次这个事件
 */
public class ReceiveDataPackageDebugEvent extends Event {
    private JsonObject jsonObject;
    private String cmd;

    public ReceiveDataPackageDebugEvent(LiveClient source, JsonObject jsonObject, String cmd) {
        super(source);
        this.jsonObject = jsonObject;
        this.cmd = cmd;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public String getCmd() {
        return cmd;
    }
}
