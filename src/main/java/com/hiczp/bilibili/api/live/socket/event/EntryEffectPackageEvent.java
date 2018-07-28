package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.EntryEffectEntity;

public class EntryEffectPackageEvent extends ReceiveDataPackageEvent<EntryEffectEntity> {
    public EntryEffectPackageEvent(LiveClient source, EntryEffectEntity entity) {
        super(source, entity);
    }
}
