package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.RoomAdminsEntity;

public class RoomAdminsPackageEvent extends ReceiveDataPackageEvent<RoomAdminsEntity> {
    public RoomAdminsPackageEvent(Object source, RoomAdminsEntity entity) {
        super(source, entity);
    }
}
