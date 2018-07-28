package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkClickAgainEntity;

public class PkClickAgainPackageEvent extends ReceiveDataPackageEvent<PkClickAgainEntity> {
    public PkClickAgainPackageEvent(LiveClient source, PkClickAgainEntity entity) {
        super(source, entity);
    }
}
