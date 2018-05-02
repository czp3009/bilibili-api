package com.hiczp.bilibili.api.live.bulletScreen;

import com.hiczp.bilibili.api.live.entity.BulletScreenEntity;
import com.hiczp.bilibili.api.provider.BilibiliServiceProvider;

public class BulletScreenSendingTask {
    private BilibiliServiceProvider bilibiliServiceProvider;
    private BulletScreenEntity bulletScreenEntity;
    private BulletScreenSendingCallback bulletScreenSendingCallback;

    public BulletScreenSendingTask(BilibiliServiceProvider bilibiliServiceProvider, BulletScreenEntity bulletScreenEntity, BulletScreenSendingCallback bulletScreenSendingCallback) {
        this.bilibiliServiceProvider = bilibiliServiceProvider;
        this.bulletScreenEntity = bulletScreenEntity;
        this.bulletScreenSendingCallback = bulletScreenSendingCallback;
    }

    public BilibiliServiceProvider getBilibiliServiceProvider() {
        return bilibiliServiceProvider;
    }

    public BulletScreenEntity getBulletScreenEntity() {
        return bulletScreenEntity;
    }

    public BulletScreenSendingCallback getBulletScreenSendingCallback() {
        return bulletScreenSendingCallback;
    }
}
