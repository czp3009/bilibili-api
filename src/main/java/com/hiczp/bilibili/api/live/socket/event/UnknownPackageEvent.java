package com.hiczp.bilibili.api.live.socket.event;

import com.google.gson.JsonObject;
import com.hiczp.bilibili.api.live.socket.LiveClient;

public class UnknownPackageEvent extends Event {
    private JsonObject jsonObject;

    public UnknownPackageEvent(LiveClient source, JsonObject jsonObject) {
        super(source);
        this.jsonObject = jsonObject;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }
}
