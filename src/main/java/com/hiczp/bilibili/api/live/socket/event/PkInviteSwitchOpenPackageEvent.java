package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.PkInviteSwitchOpenEntity;

public class PkInviteSwitchOpenPackageEvent extends ReceiveDataPackageEvent<PkInviteSwitchOpenEntity> {
    public PkInviteSwitchOpenPackageEvent(LiveClient source, PkInviteSwitchOpenEntity entity) {
        super(source, entity);
    }
}
