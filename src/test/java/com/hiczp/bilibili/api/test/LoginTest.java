package com.hiczp.bilibili.api.test;

import org.junit.Test;

public class LoginTest {
    private static final Config CONFIG = Config.getInstance();

    @Test
    public void login() throws Exception {
        Config.getBilibiliAPI().login(CONFIG.getUsername(), CONFIG.getPassword());
    }
}
