package com.hiczp.bilibili.api.live.socket.event;

import java.util.EventObject;

public class SendHeartBeatPackageEvent extends EventObject {
    public SendHeartBeatPackageEvent(Object source) {
        super(source);
    }
}
