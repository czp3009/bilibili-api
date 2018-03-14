package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RoomSilentOnEntity;

public class RoomSilentOnPackageEvent extends ReceiveDataPackageEvent<RoomSilentOnEntity> {
    public RoomSilentOnPackageEvent(LiveClient source, RoomSilentOnEntity entity) {
        super(source, entity);
    }
}
