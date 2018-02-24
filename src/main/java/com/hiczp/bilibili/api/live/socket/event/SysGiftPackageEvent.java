package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.SysGiftEntity;

public class SysGiftPackageEvent extends ReceiveDataPackageEvent<SysGiftEntity> {
    public SysGiftPackageEvent(Object source, SysGiftEntity entity) {
        super(source, entity);
    }
}
