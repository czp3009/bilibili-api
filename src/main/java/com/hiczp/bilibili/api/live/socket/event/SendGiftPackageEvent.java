package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.SendGiftEntity;

import java.util.EventObject;

public class SendGiftPackageEvent extends EventObject {
    private SendGiftEntity sendGiftEntity;

    public SendGiftPackageEvent(Object source, SendGiftEntity sendGiftEntity) {
        super(source);
        this.sendGiftEntity = sendGiftEntity;
    }

    public SendGiftEntity getSendGiftEntity() {
        return sendGiftEntity;
    }
}
