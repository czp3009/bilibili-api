package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkMicEndEntity;

public class PkMicEndPackageEvent extends ReceiveDataPackageEvent<PkMicEndEntity> {
    public PkMicEndPackageEvent(LiveClient source, PkMicEndEntity entity) {
        super(source, entity);
    }
}
