package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RoomRankEntity;

public class RoomRankPackageEvent extends ReceiveDataPackageEvent<RoomRankEntity> {
    public RoomRankPackageEvent(LiveClient source, RoomRankEntity entity) {
        super(source, entity);
    }
}
