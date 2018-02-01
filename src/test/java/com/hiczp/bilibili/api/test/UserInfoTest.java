package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.ServerErrorCode;
import com.hiczp.bilibili.api.passport.entity.InfoEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.AuthenticationException;

public class UserInfoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoTest.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final BilibiliAPI BILIBILI_API = Config.getBilibiliAPI();

    @Test
    public void getUserInfo() throws Exception {
        InfoEntity infoEntity = BILIBILI_API.getPassportService()
                .getInfo(BILIBILI_API.getBilibiliAccount().getAccessToken())
                .execute()
                .body();
        if (infoEntity.getCode() == ServerErrorCode.Common.OK) {
            LOGGER.info("UserInfo below: \n{}", GSON.toJson(infoEntity));
        } else {
            throw new AuthenticationException(infoEntity.getMessage());
        }
    }
}
