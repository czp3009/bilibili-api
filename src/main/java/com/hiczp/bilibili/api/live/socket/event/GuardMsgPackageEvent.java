package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.GuardMsgEntity;

public class GuardMsgPackageEvent extends ReceiveDataPackageEvent<GuardMsgEntity> {
    public GuardMsgPackageEvent(LiveClient source, GuardMsgEntity entity) {
        super(source, entity);
    }
}
