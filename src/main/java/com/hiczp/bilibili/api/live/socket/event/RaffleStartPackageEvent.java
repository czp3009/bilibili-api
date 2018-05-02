package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RaffleStartEntity;

public class RaffleStartPackageEvent extends ReceiveDataPackageEvent<RaffleStartEntity> {
    public RaffleStartPackageEvent(LiveClient source, RaffleStartEntity entity) {
        super(source, entity);
    }
}
