package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;

public class ConnectionCloseEvent extends Event {
    public ConnectionCloseEvent(LiveClient source) {
        super(source);
    }
}
