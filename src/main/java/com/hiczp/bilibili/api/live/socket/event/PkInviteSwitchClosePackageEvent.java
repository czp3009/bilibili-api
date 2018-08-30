package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkInviteSwitchCloseEntity;

public class PkInviteSwitchClosePackageEvent extends ReceiveDataPackageEvent<PkInviteSwitchCloseEntity> {
    public PkInviteSwitchClosePackageEvent(LiveClient source, PkInviteSwitchCloseEntity entity) {
        super(source, entity);
    }
}
