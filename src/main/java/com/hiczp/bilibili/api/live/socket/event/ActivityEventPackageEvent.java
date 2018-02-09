package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.ActivityEventEntity;

public class ActivityEventPackageEvent extends ReceivePackageEvent<ActivityEventEntity> {
    public ActivityEventPackageEvent(Object source, ActivityEventEntity entity) {
        super(source, entity);
    }
}
