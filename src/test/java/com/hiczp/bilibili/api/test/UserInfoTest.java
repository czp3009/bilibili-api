package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.passport.entity.InfoEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInfoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoTest.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private final BilibiliAPI bilibiliAPI = Config.getBilibiliAPI();

    @Test
    public void getUserInfo() throws Exception {
        InfoEntity infoEntity = bilibiliAPI.getPassportService()
                .getInfo(bilibiliAPI.getBilibiliAccount().getAccessToken())
                .execute()
                .body();
        LOGGER.debug("UserInfo below: \n{}", GSON.toJson(infoEntity));
    }
}
