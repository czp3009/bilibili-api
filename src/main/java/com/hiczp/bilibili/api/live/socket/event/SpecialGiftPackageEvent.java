package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.SpecialGiftEntity;

public class SpecialGiftPackageEvent extends ReceiveDataPackageEvent<SpecialGiftEntity> {
    public SpecialGiftPackageEvent(Object source, SpecialGiftEntity entity) {
        super(source, entity);
    }
}
