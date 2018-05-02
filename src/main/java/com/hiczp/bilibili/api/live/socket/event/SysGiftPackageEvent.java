package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.SysGiftEntity;

public class SysGiftPackageEvent extends ReceiveDataPackageEvent<SysGiftEntity> {
    public SysGiftPackageEvent(LiveClient source, SysGiftEntity entity) {
        super(source, entity);
    }
}
