package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkMatchEntity;

public class PkMatchPackageEvent extends ReceiveDataPackageEvent<PkMatchEntity> {
    public PkMatchPackageEvent(LiveClient source, PkMatchEntity entity) {
        super(source, entity);
    }
}
