package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkStartEntity;

public class PkStartPackageEvent extends ReceiveDataPackageEvent<PkStartEntity> {
    public PkStartPackageEvent(LiveClient source, PkStartEntity entity) {
        super(source, entity);
    }
}
