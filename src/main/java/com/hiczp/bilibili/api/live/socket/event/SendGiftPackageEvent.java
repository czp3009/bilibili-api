package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.SendGiftEntity;

public class SendGiftPackageEvent extends ReceiveDataPackageEvent<SendGiftEntity> {
    public SendGiftPackageEvent(Object source, SendGiftEntity entity) {
        super(source, entity);
    }
}
