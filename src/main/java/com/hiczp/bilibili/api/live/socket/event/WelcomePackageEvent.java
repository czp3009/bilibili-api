package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.WelcomeEntity;

public class WelcomePackageEvent extends ReceiveDataPackageEvent<WelcomeEntity> {
    public WelcomePackageEvent(LiveClient source, WelcomeEntity entity) {
        super(source, entity);
    }
}
