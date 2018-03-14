package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.EventCmdEntity;

public class EventCmdPackageEvent extends ReceiveDataPackageEvent<EventCmdEntity> {
    public EventCmdPackageEvent(LiveClient source, EventCmdEntity entity) {
        super(source, entity);
    }
}
