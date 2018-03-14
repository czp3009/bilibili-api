package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.DanMuMsgEntity;

public class DanMuMsgPackageEvent extends ReceiveDataPackageEvent<DanMuMsgEntity> {
    public DanMuMsgPackageEvent(LiveClient source, DanMuMsgEntity entity) {
        super(source, entity);
    }
}
