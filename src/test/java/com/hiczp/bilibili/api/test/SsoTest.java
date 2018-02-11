package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliAPI;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SsoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoTest.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final BilibiliAPI BILIBILI_API = Config.getBilibiliAPI();

    @Ignore
    @Test
    public void test() throws Exception {
//        Object object = BILIBILI_API.getPassportService()
//                .sso(BILIBILI_API.getBilibiliAccount().getAccessToken(), null)
//                .execute()
//                .body();
//        LOGGER.info("{}", object.toString());
    }
}
