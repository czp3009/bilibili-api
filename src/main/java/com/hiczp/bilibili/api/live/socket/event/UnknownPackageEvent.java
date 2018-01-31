package com.hiczp.bilibili.api.live.socket.event;

import java.util.EventObject;

public class UnknownPackageEvent extends EventObject {
    private String json;

    public UnknownPackageEvent(Object source, String json) {
        super(source);
        this.json = json;
    }

    public String getJson() {
        return json;
    }
}
