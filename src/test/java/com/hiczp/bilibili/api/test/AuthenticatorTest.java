package com.hiczp.bilibili.api.test;

import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.BilibiliAccount;
import org.junit.Test;

public class AuthenticatorTest {
    @Test
    public void test() throws Exception {
        BilibiliAPI bilibiliAPI = new BilibiliAPI(
                new BilibiliAccount(
                        "123",
                        "123",
                        null,
                        null,
                        null
                )
        );
        bilibiliAPI.getLiveService()
                .getPlayerBag()
                .execute();
        bilibiliAPI.getLiveService()
                .getPlayerBag()
                .execute();
    }
}
