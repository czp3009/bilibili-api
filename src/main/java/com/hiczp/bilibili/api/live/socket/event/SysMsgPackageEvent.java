package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.SysMsgEntity;

import java.util.EventObject;

public class SysMsgPackageEvent extends EventObject {
    private SysMsgEntity sysMsgEntity;

    public SysMsgPackageEvent(Object source, SysMsgEntity sysMsgEntity) {
        super(source);
        this.sysMsgEntity = sysMsgEntity;
    }

    public SysMsgEntity getSysMsgEntity() {
        return sysMsgEntity;
    }
}
