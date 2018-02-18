package com.hiczp.bilibili.api.test;

import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManualLoginTool {
    private static final Logger LOGGER = LoggerFactory.getLogger(ManualLoginTool.class);

    public static void main(String[] args) throws Exception {
        RuleSuite.init();
        Config config = Config.getInstance();
        LoginResponseEntity loginResponseEntity = new BilibiliAPI()
                .login(config.getUsername(), config.getPassword());
        LOGGER.info(new GsonBuilder().setPrettyPrinting().create().toJson(loginResponseEntity));
    }
}
