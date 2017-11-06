package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliRESTAPI;
import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutTest.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void logout() throws Exception {
        LOGGER.info("Logout");
        GSON.toJson(
                BilibiliRESTAPI.logout(),
                System.out
        );
    }

    @After
    public void endLine() {
        System.out.println();
    }
}
