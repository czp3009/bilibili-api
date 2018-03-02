package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.web.BilibiliWebAPI;
import com.hiczp.bilibili.api.web.live.entity.UserInfoEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WebAPITest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebAPITest.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private BilibiliWebAPI bilibiliWebAPI;

    public WebAPITest() {
        try {
            this.bilibiliWebAPI = Config.getBilibiliAPI().getBilibiliWebAPI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserInfo() throws IOException {
        UserInfoEntity userInfoEntity = bilibiliWebAPI.getLiveService().getUserInfo()
                .execute()
                .body();
        LOGGER.info("User info below: \n{}", GSON.toJson(userInfoEntity));
    }
}
