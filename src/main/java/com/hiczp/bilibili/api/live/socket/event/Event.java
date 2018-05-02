package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;

import java.util.EventObject;

public abstract class Event extends EventObject {
    Event(LiveClient source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return source;
    }

    public LiveClient getSource0() {
        return (LiveClient) source;
    }
}
