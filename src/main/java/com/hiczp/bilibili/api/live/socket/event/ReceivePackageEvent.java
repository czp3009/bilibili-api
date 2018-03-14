package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;

public abstract class ReceivePackageEvent<T> extends Event {
    protected T entity;

    ReceivePackageEvent(LiveClient source, T entity) {
        super(source);
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }
}
