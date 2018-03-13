package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.CutOffEntity;

public class CutOffPackageEvent extends ReceiveDataPackageEvent<CutOffEntity> {
    public CutOffPackageEvent(Object source, CutOffEntity entity) {
        super(source, entity);
    }
}
