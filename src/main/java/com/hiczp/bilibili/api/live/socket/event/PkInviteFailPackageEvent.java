package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkInviteFailEntity;

public class PkInviteFailPackageEvent extends ReceiveDataPackageEvent<PkInviteFailEntity> {
    public PkInviteFailPackageEvent(LiveClient source, PkInviteFailEntity entity) {
        super(source, entity);
    }
}
