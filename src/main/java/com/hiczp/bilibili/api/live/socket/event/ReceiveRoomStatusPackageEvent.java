package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.RoomStatusEntity;

public abstract class ReceiveRoomStatusPackageEvent<T extends RoomStatusEntity> extends ReceiveDataPackageEvent<T> {
    ReceiveRoomStatusPackageEvent(Object source, T entity) {
        super(source, entity);
    }

    public RoomStatusEntity getEntity0() {
        return entity;
    }
}
