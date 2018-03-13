package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.ChangeRoomInfoEntity;

public class ChangeRoomInfoPackageEvent extends ReceiveDataPackageEvent<ChangeRoomInfoEntity> {
    public ChangeRoomInfoPackageEvent(Object source, ChangeRoomInfoEntity entity) {
        super(source, entity);
    }
}
