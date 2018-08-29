package com.hiczp.bilibili.api.live.socket.event;

import com.google.gson.JsonObject;
import com.hiczp.bilibili.api.live.socket.LiveClient;

/**
 * 这个事件在收到 cmd 为未知值的 Data 数据包时触发
 */
public class UnknownPackageEvent extends Event {
    private JsonObject jsonObject;
    private String cmd;

    public UnknownPackageEvent(LiveClient source, JsonObject jsonObject, String cmd) {
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
