package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.WishBottleEntity;

public class WishBottlePackageEvent extends ReceiveDataPackageEvent<WishBottleEntity> {
    public WishBottlePackageEvent(Object source, WishBottleEntity entity) {
        super(source, entity);
    }
}
