package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RaffleEndEntity;

public class RaffleEndPackageEvent extends ReceiveDataPackageEvent<RaffleEndEntity> {
    public RaffleEndPackageEvent(LiveClient source, RaffleEndEntity entity) {
        super(source, entity);
    }
}
