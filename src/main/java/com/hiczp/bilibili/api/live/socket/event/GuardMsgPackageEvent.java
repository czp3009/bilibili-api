package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.GuardMsgEntity;

public class GuardMsgPackageEvent extends ReceiveDataPackageEvent<GuardMsgEntity> {
    public GuardMsgPackageEvent(Object source, GuardMsgEntity entity) {
        super(source, entity);
    }
}
