package com.hiczp.bilibili.api.live.socket;

import com.hiczp.bilibili.api.live.socket.entity.*;

public interface BulletScreenListener {
    void onConnect();

    void onDisconnect();

    void onViewerCountPackage(int viewerCount);

    void onDanMuMSGPackage(DanMuMSGEntity danMuMSGEntity);

    void onSendGiftPackage(SendGiftEntity sendGiftEntity);

    void onSysMSGPackage(SysMSGEntity sysMSGEntity);

    void onSysGiftPackage(SysGiftEntity sysGiftEntity);

    void onWelcomePackage(WelcomeEntity welcomeEntity);

    void onWelcomeGuardPackage(WelcomeGuardEntity welcomeGuardEntity);

    void onLivePackage(LiveEntity liveEntity);

    void onPreparingPackage(PreparingEntity preparingEntity);

    void onUnknownPackage(byte[] raw);
}
