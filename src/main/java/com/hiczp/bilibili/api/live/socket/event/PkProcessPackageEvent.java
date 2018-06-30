package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkProcessEntity;

public class PkProcessPackageEvent extends ReceiveDataPackageEvent<PkProcessEntity> {
    public PkProcessPackageEvent(LiveClient source, PkProcessEntity entity) {
        super(source, entity);
    }
}
