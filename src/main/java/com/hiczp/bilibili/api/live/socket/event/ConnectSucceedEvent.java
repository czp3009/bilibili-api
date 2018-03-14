package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;

public class ConnectSucceedEvent extends Event {
    public ConnectSucceedEvent(LiveClient source) {
        super(source);
    }
}
