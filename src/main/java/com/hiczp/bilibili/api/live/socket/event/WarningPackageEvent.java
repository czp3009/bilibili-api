package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.WarningEntity;

public class WarningPackageEvent extends ReceiveDataPackageEvent<WarningEntity> {
    public WarningPackageEvent(LiveClient source, WarningEntity entity) {
        super(source, entity);
    }
}
