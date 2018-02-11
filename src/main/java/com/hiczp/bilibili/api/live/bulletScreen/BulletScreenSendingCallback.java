package com.hiczp.bilibili.api.live.bulletScreen;

import com.hiczp.bilibili.api.live.entity.BulletScreenEntity;
import com.hiczp.bilibili.api.live.entity.SendBulletScreenResponseEntity;

public interface BulletScreenSendingCallback {
    void onResponse(BulletScreenEntity bulletScreenEntity, SendBulletScreenResponseEntity sendBulletScreenResponseEntity);

    void onFailure(BulletScreenEntity bulletScreenEntity, Throwable throwable);
}
