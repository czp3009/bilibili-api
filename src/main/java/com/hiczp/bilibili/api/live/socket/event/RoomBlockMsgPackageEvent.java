package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.RoomBlockMsgEntity;

public class RoomBlockMsgPackageEvent extends ReceiveDataPackageEvent<RoomBlockMsgEntity> {
    public RoomBlockMsgPackageEvent(LiveClient source, RoomBlockMsgEntity entity) {
        super(source, entity);
    }
}
