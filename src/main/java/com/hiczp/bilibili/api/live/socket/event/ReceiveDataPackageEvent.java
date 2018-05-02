package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.DataEntity;

public abstract class ReceiveDataPackageEvent<T extends DataEntity> extends ReceivePackageEvent<T> {
    ReceiveDataPackageEvent(LiveClient source, T entity) {
        super(source, entity);
    }

    public DataEntity getEntity0() {
        return entity;
    }
}
