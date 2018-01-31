package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.ActivityEventEntity;

import java.util.EventObject;

public class ActivityEventPackageEvent extends EventObject {
    private ActivityEventEntity activityEventEntity;

    public ActivityEventPackageEvent(Object source, ActivityEventEntity activityEventEntity) {
        super(source);
        this.activityEventEntity = activityEventEntity;
    }

    public ActivityEventEntity getActivityEventEntity() {
        return activityEventEntity;
    }
}
