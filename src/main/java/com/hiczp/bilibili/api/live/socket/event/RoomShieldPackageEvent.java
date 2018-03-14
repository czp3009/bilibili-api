package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RoomShieldEntity;

public class RoomShieldPackageEvent extends ReceiveDataPackageEvent<RoomShieldEntity> {
    public RoomShieldPackageEvent(LiveClient source, RoomShieldEntity entity) {
        super(source, entity);
    }
}
