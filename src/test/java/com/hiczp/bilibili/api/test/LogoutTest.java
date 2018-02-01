package com.hiczp.bilibili.api.test;

import org.junit.Test;

public class LogoutTest {
    @Test
    public void logout() throws Exception {
        Config.getBilibiliAPI().logout();
    }
}
