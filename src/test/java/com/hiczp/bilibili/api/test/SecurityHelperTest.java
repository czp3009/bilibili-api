package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.BilibiliSecurityHelper;
import com.hiczp.bilibili.api.ServerErrorCode;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityHelperTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityHelperTest.class);
    private static final Config CONFIG = Config.getInstance();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void normalLogin() throws Exception {
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                new BilibiliAPI(),
                CONFIG.getUsername(),
                CONFIG.getPassword()
        );
        if (loginResponseEntity.getCode() == ServerErrorCode.Passport.CAPTCHA_NOT_MATCH) {
            LOGGER.error("This account need captcha to login, ignore test");
            return;
        }
        LOGGER.info("{}", GSON.toJson(loginResponseEntity));
        BilibiliSecurityHelper.logout(new BilibiliAPI(), loginResponseEntity.getData().getAccessToken());
    }

    @Ignore
    @Test
    public void loginWithWrongUsername() throws Exception {
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                new BilibiliAPI(),
                "bilibili_account",
                "bilibili_password"
        );
        LOGGER.info("{}", loginResponseEntity.getMessage());
    }

    @Test
    public void normalRefreshToken() throws Exception {
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                new BilibiliAPI(),
                CONFIG.getUsername(),
                CONFIG.getPassword()
        );
        if (loginResponseEntity.getCode() == ServerErrorCode.Passport.CAPTCHA_NOT_MATCH) {
            LOGGER.error("This account need captcha to login, ignore test");
            return;
        }
        RefreshTokenResponseEntity refreshTokenResponseEntity = BilibiliSecurityHelper.refreshToken(
                new BilibiliAPI(),
                loginResponseEntity.getData().getAccessToken(),
                loginResponseEntity.getData().getRefreshToken()
        );
        LOGGER.info("{}", GSON.toJson(refreshTokenResponseEntity));
        BilibiliSecurityHelper.logout(new BilibiliAPI(), refreshTokenResponseEntity.getData().getAccessToken());
    }

    @Test
    public void refreshTokenWithWrongToken() throws Exception {
        RefreshTokenResponseEntity refreshTokenResponseEntity = BilibiliSecurityHelper.refreshToken(
                new BilibiliAPI(),
                "token",
                "refreshToken"
        );
        LOGGER.info("{}", refreshTokenResponseEntity.getMessage());
    }

    @Test
    public void refreshTokenWithWrongRefreshToken() throws Exception {
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                new BilibiliAPI(),
                CONFIG.getUsername(),
                CONFIG.getPassword()
        );
        if (loginResponseEntity.getCode() == ServerErrorCode.Passport.CAPTCHA_NOT_MATCH) {
            LOGGER.error("This account need captcha to login, ignore test");
            return;
        }
        String accessToken = loginResponseEntity.getData().getAccessToken();
        RefreshTokenResponseEntity refreshTokenResponseEntity = BilibiliSecurityHelper.refreshToken(
                new BilibiliAPI(),
                accessToken,
                "refreshToken"
        );
        LOGGER.info("{}", refreshTokenResponseEntity.getMessage());
    }
}
