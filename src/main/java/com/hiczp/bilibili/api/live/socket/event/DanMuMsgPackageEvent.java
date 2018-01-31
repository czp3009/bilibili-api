package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.DanMuMsgEntity;

import java.util.EventObject;

public class DanMuMsgPackageEvent extends EventObject {
    private DanMuMsgEntity danMuMsgEntity;

    public DanMuMsgPackageEvent(Object source, DanMuMsgEntity danMuMsgEntity) {
        super(source);
        this.danMuMsgEntity = danMuMsgEntity;
    }

    public DanMuMsgEntity getDanMuMsgEntity() {
        return danMuMsgEntity;
    }
}
