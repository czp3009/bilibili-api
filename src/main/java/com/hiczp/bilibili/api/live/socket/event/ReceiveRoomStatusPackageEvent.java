package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.RoomStatusEntity;

public class ReceiveRoomStatusPackageEvent<T extends RoomStatusEntity> extends ReceiveDataPackageEvent<T> {
    public ReceiveRoomStatusPackageEvent(Object source, T entity) {
        super(source, entity);
    }
}
