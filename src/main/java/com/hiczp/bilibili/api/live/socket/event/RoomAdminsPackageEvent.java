package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RoomAdminsEntity;

public class RoomAdminsPackageEvent extends ReceiveDataPackageEvent<RoomAdminsEntity> {
    public RoomAdminsPackageEvent(LiveClient source, RoomAdminsEntity entity) {
        super(source, entity);
    }
}
