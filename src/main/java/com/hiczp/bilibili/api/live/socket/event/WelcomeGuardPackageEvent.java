package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.WelcomeGuardEntity;

import java.util.EventObject;

public class WelcomeGuardPackageEvent extends EventObject {
    private WelcomeGuardEntity welcomeGuardEntity;

    public WelcomeGuardPackageEvent(Object source, WelcomeGuardEntity welcomeGuardEntity) {
        super(source);
        this.welcomeGuardEntity = welcomeGuardEntity;
    }

    public WelcomeGuardEntity getWelcomeGuardEntity() {
        return welcomeGuardEntity;
    }
}
