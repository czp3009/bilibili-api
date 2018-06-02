package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.ComboEndEntity;

public class ComboEndPackageEvent extends ReceiveDataPackageEvent<ComboEndEntity> {
    public ComboEndPackageEvent(LiveClient source, ComboEndEntity entity) {
        super(source, entity);
    }
}
