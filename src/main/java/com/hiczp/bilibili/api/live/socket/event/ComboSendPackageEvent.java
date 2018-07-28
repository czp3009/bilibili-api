package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.ComboSendEntity;

public class ComboSendPackageEvent extends ReceiveDataPackageEvent<ComboSendEntity> {
    public ComboSendPackageEvent(LiveClient source, ComboSendEntity entity) {
        super(source, entity);
    }
}
