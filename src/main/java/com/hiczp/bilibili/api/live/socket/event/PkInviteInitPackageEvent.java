package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkInviteInitEntity;

public class PkInviteInitPackageEvent extends ReceiveDataPackageEvent<PkInviteInitEntity> {
    public PkInviteInitPackageEvent(LiveClient source, PkInviteInitEntity entity) {
        super(source, entity);
    }
}
