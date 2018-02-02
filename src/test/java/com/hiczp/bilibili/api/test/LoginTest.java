package com.hiczp.bilibili.api.test;

import com.hiczp.bilibili.api.passport.exception.CaptchaMismatchException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class LoginTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);
    private static final Config CONFIG = Config.getInstance();

    @Test
    public void login() throws Exception {
        try {
            Config.getBilibiliAPI().login(CONFIG.getUsername(), CONFIG.getPassword());
        } catch (CaptchaMismatchException e) {
            LOGGER.info("Need captcha");
            if (GraphicsEnvironment.isHeadless()) {
                LOGGER.error("Need graphics support to display captcha, login failed");
                throw new UnsupportedOperationException(e);
            } else {
                CaptchaInputDialog captchaInputDialog = CaptchaInputDialog.create();
                Config.getBilibiliAPI().login(
                        CONFIG.getUsername(),
                        CONFIG.getPassword(),
                        captchaInputDialog.getCaptcha(),
                        captchaInputDialog.getCookie()
                );
            }
        }
    }
}
