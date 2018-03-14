package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;

public class SendHeartBeatPackageEvent extends Event {
    public SendHeartBeatPackageEvent(LiveClient source) {
        super(source);
    }
}
