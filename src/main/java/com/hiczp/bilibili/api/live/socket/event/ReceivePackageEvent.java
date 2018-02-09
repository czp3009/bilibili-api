package com.hiczp.bilibili.api.live.socket.event;

import java.util.EventObject;

public abstract class ReceivePackageEvent<T> extends EventObject {
    private T entity;

    ReceivePackageEvent(Object source, T entity) {
        super(source);
        this.entity = entity;
    }

    public T getEntity() {
        return entity;
    }
}
