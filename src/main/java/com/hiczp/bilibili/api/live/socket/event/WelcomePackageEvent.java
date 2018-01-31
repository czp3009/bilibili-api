package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.WelcomeEntity;

import java.util.EventObject;

public class WelcomePackageEvent extends EventObject {
    private WelcomeEntity welcomeEntity;

    public WelcomePackageEvent(Object source, WelcomeEntity welcomeEntity) {
        super(source);
        this.welcomeEntity = welcomeEntity;
    }

    public WelcomeEntity getWelcomeEntity() {
        return welcomeEntity;
    }
}
