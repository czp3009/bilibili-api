package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkSettleEntity;

public class PkSettlePackageEvent extends ReceiveDataPackageEvent<PkSettleEntity> {
    public PkSettlePackageEvent(LiveClient source, PkSettleEntity entity) {
        super(source, entity);
    }
}
