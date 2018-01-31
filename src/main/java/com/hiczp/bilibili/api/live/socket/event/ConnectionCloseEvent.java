package com.hiczp.bilibili.api.live.socket.event;

import java.util.EventObject;

public class ConnectionCloseEvent extends EventObject {
    public ConnectionCloseEvent(Object source) {
        super(source);
    }
}
