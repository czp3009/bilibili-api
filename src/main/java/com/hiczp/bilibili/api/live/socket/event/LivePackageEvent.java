package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.LiveEntity;

public class LivePackageEvent extends ReceivePackageEvent<LiveEntity> {
    public LivePackageEvent(Object source, LiveEntity entity) {
        super(source, entity);
    }
}
