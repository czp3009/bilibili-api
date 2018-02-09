package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.DanMuMsgEntity;

public class DanMuMsgPackageEvent extends ReceivePackageEvent<DanMuMsgEntity> {
    public DanMuMsgPackageEvent(Object source, DanMuMsgEntity entity) {
        super(source, entity);
    }
}
