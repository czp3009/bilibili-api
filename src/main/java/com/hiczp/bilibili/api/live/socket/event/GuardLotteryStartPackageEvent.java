package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.GuardLotteryStartEntity;

public class GuardLotteryStartPackageEvent extends ReceiveDataPackageEvent<GuardLotteryStartEntity> {
    public GuardLotteryStartPackageEvent(LiveClient source, GuardLotteryStartEntity entity) {
        super(source, entity);
    }
}
