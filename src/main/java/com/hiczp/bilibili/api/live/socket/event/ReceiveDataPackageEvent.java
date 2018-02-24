package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.DataEntity;

public abstract class ReceiveDataPackageEvent<T extends DataEntity> extends ReceivePackageEvent<T> {
    ReceiveDataPackageEvent(Object source, T entity) {
        super(source, entity);
    }

    public DataEntity getEntity0() {
        return entity;
    }
}
