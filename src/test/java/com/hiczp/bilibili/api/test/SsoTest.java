package com.hiczp.bilibili.api.test;

import com.hiczp.bilibili.api.BilibiliAPI;
import okhttp3.Cookie;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class SsoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SsoTest.class);
    private static final BilibiliAPI BILIBILI_API = Config.getBilibiliAPI();

    @Test
    public void getSsoUrlTest() {
        LOGGER.info("SSO Url: {}", BILIBILI_API.getSsoUrl("https://account.bilibili.com/account/home"));
    }

    @Test
    public void toCookiesTest() throws Exception {
        Map<String, List<Cookie>> cookiesMap = BILIBILI_API.toCookies();
        StringBuilder stringBuilder = new StringBuilder();
        cookiesMap.forEach((domain, cookies) -> {
            stringBuilder.append("domain: ").append(domain).append("\n");
            cookies.forEach(cookie ->
                    stringBuilder.append("\t").append(cookie.name()).append("=").append(cookie.value()).append("\n")
            );
        });
        LOGGER.info("Cookies below: \n{}", stringBuilder.toString());
    }
}
