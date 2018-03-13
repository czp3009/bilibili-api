package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.RaffleEndEntity;

public class RaffleEndPackageEvent extends ReceiveDataPackageEvent<RaffleEndEntity> {
    public RaffleEndPackageEvent(Object source, RaffleEndEntity entity) {
        super(source, entity);
    }
}
