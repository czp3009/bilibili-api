package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkPreEntity;

public class PkPrePackageEvent extends ReceiveDataPackageEvent<PkPreEntity> {
    public PkPrePackageEvent(LiveClient source, PkPreEntity entity) {
        super(source, entity);
    }
}
