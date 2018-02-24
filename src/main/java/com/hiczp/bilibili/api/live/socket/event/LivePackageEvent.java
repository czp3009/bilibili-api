package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.LiveEntity;

public class LivePackageEvent extends ReceiveRoomStatusPackageEvent<LiveEntity> {
    public LivePackageEvent(Object source, LiveEntity entity) {
        super(source, entity);
    }
}
