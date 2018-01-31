package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.PreparingEntity;

import java.util.EventObject;

public class PreparingPackageEvent extends EventObject {
    private PreparingEntity preparingEntity;

    public PreparingPackageEvent(Object source, PreparingEntity preparingEntity) {
        super(source);
        this.preparingEntity = preparingEntity;
    }

    public PreparingEntity getPreparingEntity() {
        return preparingEntity;
    }
}
