package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.RoomSilentOffEntity;

public class RoomSilentOffPackageEvent extends ReceiveDataPackageEvent<RoomSilentOffEntity> {
    public RoomSilentOffPackageEvent(Object source, RoomSilentOffEntity entity) {
        super(source, entity);
    }
}
