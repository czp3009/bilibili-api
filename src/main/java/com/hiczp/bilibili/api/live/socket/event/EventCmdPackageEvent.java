package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.EventCmdEntity;

public class EventCmdPackageEvent extends ReceiveDataPackageEvent<EventCmdEntity> {
    public EventCmdPackageEvent(Object source, EventCmdEntity entity) {
        super(source, entity);
    }
}
