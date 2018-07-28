package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkAgainEntity;

public class PkAgainPackageEvent extends ReceiveDataPackageEvent<PkAgainEntity> {
    public PkAgainPackageEvent(LiveClient source, PkAgainEntity entity) {
        super(source, entity);
    }
}
