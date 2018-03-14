package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RoomStatusEntity;

public abstract class ReceiveRoomStatusPackageEvent<T extends RoomStatusEntity> extends ReceiveDataPackageEvent<T> {
    ReceiveRoomStatusPackageEvent(LiveClient source, T entity) {
        super(source, entity);
    }

    @Override
    public RoomStatusEntity getEntity0() {
        return entity;
    }
}
