package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliRESTAPI;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void _0login() throws Exception {
        LOGGER.info("Start login test");
        Config config = Config.getInstance();
        GSON.toJson(
                BilibiliRESTAPI.login(config.getUsername(), config.getPassword()),
                System.out
        );
    }

    @Test
    public void _1info() throws Exception {
        LOGGER.info("Getting user info");
        GSON.toJson(
                BilibiliRESTAPI.getAccountInfo(),
                System.out
        );
    }

    @Test
    public void _2refreshToken() throws Exception {
        LOGGER.info("Refreshing token");
        GSON.toJson(
                BilibiliRESTAPI.refreshToken(),
                System.out
        );
    }

    @After
    public void endLine() {
        System.out.println();
    }
}
