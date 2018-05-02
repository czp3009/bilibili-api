package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.WishBottleEntity;

public class WishBottlePackageEvent extends ReceiveDataPackageEvent<WishBottleEntity> {
    public WishBottlePackageEvent(LiveClient source, WishBottleEntity entity) {
        super(source, entity);
    }
}
