package com.hiczp.bilibili.api.test;

import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.BilibiliSecurityHelper;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class SecurityHelperTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityHelperTest.class);
    private static final Config CONFIG = Config.getInstance();

    @Test
    public void normalLogin() throws Exception {
        LOGGER.info("Login attempt with username {}", CONFIG.getUsername());
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                new BilibiliAPI(),
                CONFIG.getUsername(),
                CONFIG.getPassword()
        );
        LOGGER.info("Login succeed with username {}", CONFIG.getUsername());
        BilibiliSecurityHelper.logout(new BilibiliAPI(), loginResponseEntity.getData().getAccessToken());
    }

    @Test
    public void loginWithWrongUsername() throws Exception {
        final String username = "bilibili_account";
        final String password = "bilibili_password";
        LOGGER.info("Login attempt with username {}, password {}", username, password);
        try {
            BilibiliSecurityHelper.login(
                    new BilibiliAPI(),
                    username,
                    password
            );
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void normalRefreshToken() throws Exception {
        LOGGER.info("Login attempt with username {}", CONFIG.getUsername());
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                new BilibiliAPI(),
                CONFIG.getUsername(),
                CONFIG.getPassword()
        );
        LOGGER.info("Login succeed with access token {}", loginResponseEntity.getData().getAccessToken());
        RefreshTokenResponseEntity refreshTokenResponseEntity = BilibiliSecurityHelper.refreshToken(
                new BilibiliAPI(),
                loginResponseEntity.getData().getAccessToken(),
                loginResponseEntity.getData().getRefreshToken()
        );
        LOGGER.info("Refresh token succeed with new access token {}", refreshTokenResponseEntity.getData().getAccessToken());
        BilibiliSecurityHelper.logout(new BilibiliAPI(), refreshTokenResponseEntity.getData().getAccessToken());
    }

    @Test
    public void refreshTokenWithWrongToken() throws Exception {
        try {
            RefreshTokenResponseEntity refreshTokenResponseEntity = BilibiliSecurityHelper.refreshToken(
                    new BilibiliAPI(),
                    "token",
                    "refreshToken"
            );
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void refreshTokenWithWrongRefreshToken() throws Exception {
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                new BilibiliAPI(),
                CONFIG.getUsername(),
                CONFIG.getPassword()
        );
        String accessToken = loginResponseEntity.getData().getAccessToken();
        LOGGER.info("Login succeed with access token {}", accessToken);
        try {
            RefreshTokenResponseEntity refreshTokenResponseEntity = BilibiliSecurityHelper.refreshToken(
                    new BilibiliAPI(),
                    accessToken,
                    "refreshToken"
            );
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
