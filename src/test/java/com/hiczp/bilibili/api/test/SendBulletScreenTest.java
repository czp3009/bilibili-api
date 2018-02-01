package com.hiczp.bilibili.api.test;

import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.live.entity.BulletScreenEntity;
import org.junit.Test;

public class SendBulletScreenTest {
    private static final long ROOM_ID = 29434;
    private static final BilibiliAPI BILIBILI_API = Config.getBilibiliAPI();

    @Test
    public void sendBulletScreen() throws Exception {
        BILIBILI_API.getLiveService()
                .sendBulletScreen(
                        new BulletScreenEntity(
                                ROOM_ID,
                                BILIBILI_API.getBilibiliAccount().getUserId(),
                                "这是自动发送的弹幕"
                        )
                ).execute();
    }
}
