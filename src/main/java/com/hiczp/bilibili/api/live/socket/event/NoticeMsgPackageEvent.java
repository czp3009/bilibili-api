package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.NoticeMsgEntity;

public class NoticeMsgPackageEvent extends ReceiveDataPackageEvent<NoticeMsgEntity> {
    public NoticeMsgPackageEvent(LiveClient source, NoticeMsgEntity entity) {
        super(source, entity);
    }
}
