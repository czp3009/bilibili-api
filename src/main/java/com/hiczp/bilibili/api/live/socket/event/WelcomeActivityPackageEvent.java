package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.WelcomeActivityEntity;

public class WelcomeActivityPackageEvent extends ReceiveDataPackageEvent<WelcomeActivityEntity> {
    public WelcomeActivityPackageEvent(LiveClient source, WelcomeActivityEntity entity) {
        super(source, entity);
    }
}
