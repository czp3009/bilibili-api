package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RoomLockEntity;

public class RoomLockPackageEvent extends ReceiveDataPackageEvent<RoomLockEntity> {
    public RoomLockPackageEvent(LiveClient source, RoomLockEntity entity) {
        super(source, entity);
    }
}
