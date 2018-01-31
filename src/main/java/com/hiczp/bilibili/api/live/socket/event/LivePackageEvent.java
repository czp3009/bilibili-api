package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.LiveEntity;

import java.util.EventObject;

public class LivePackageEvent extends EventObject {
    private LiveEntity liveEntity;

    public LivePackageEvent(Object source, LiveEntity liveEntity) {
        super(source);
        this.liveEntity = liveEntity;
    }

    public LiveEntity getLiveEntity() {
        return liveEntity;
    }
}
