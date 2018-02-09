package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.RoomBlockMsgEntity;

public class RoomBlockMsgPackageEvent extends ReceivePackageEvent<RoomBlockMsgEntity> {
    public RoomBlockMsgPackageEvent(Object source, RoomBlockMsgEntity entity) {
        super(source, entity);
    }
}
