package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkEndEntity;

public class PkEndPackageEvent extends ReceiveDataPackageEvent<PkEndEntity> {
    public PkEndPackageEvent(LiveClient source, PkEndEntity entity) {
        super(source, entity);
    }
}
