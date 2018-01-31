package com.hiczp.bilibili.api.live.socket.event;

import com.hiczp.bilibili.api.live.socket.entity.SysGiftEntity;

import java.util.EventObject;

public class SysGiftPackageEvent extends EventObject {
    private SysGiftEntity sysGiftEntity;

    public SysGiftPackageEvent(Object source, SysGiftEntity sysGiftEntity) {
        super(source);
        this.sysGiftEntity = sysGiftEntity;
    }

    public SysGiftEntity getSysGiftEntity() {
        return sysGiftEntity;
    }
}
