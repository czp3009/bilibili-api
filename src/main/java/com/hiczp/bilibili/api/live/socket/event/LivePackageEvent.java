package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.LiveEntity;

public class LivePackageEvent extends ReceiveRoomStatusPackageEvent<LiveEntity> {
    public LivePackageEvent(LiveClient source, LiveEntity entity) {
        super(source, entity);
    }
}
