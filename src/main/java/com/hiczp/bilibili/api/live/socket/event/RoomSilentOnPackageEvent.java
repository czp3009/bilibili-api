package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.RoomSilentOnEntity;

public class RoomSilentOnPackageEvent extends ReceiveDataPackageEvent<RoomSilentOnEntity> {
    public RoomSilentOnPackageEvent(Object source, RoomSilentOnEntity entity) {
        super(source, entity);
    }
}
