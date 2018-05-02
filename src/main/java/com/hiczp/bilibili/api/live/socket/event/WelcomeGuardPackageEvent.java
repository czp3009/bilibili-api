package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.WelcomeGuardEntity;

public class WelcomeGuardPackageEvent extends ReceiveDataPackageEvent<WelcomeGuardEntity> {
    public WelcomeGuardPackageEvent(LiveClient source, WelcomeGuardEntity entity) {
        super(source, entity);
    }
}
