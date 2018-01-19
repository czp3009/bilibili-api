package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.passport.PassportService;
import com.hiczp.bilibili.api.passport.entity.KeyEntity;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.LogoutResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.rsa.RSAPublicKeyImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class BilibiliSecurityHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(BilibiliSecurityHelper.class);

    public static LoginResponseEntity login(BilibiliServiceProvider bilibiliServiceProvider,
                                            String username,
                                            String password) throws IOException, LoginException {
        PassportService passportService = bilibiliServiceProvider.getPassportService();
        KeyEntity keyEntity = passportService.getKey().execute().body();
        //服务器返回异常错误码
        if (keyEntity.getCode() != 0) {
            throw new IOException(keyEntity.getMessage());
        }
        //解析 RSA 公钥
        RSAPublicKey rsaPublicKey;
        try {
            rsaPublicKey = new RSAPublicKeyImpl(
                    Base64.getDecoder().decode(
                            keyEntity.getData().getKey()
                                    .replace("-----BEGIN PUBLIC KEY-----", "")
                                    .replace("-----END PUBLIC KEY-----", "")
                                    .replaceAll("\n", "")
                                    .getBytes()
                    )
            );
        } catch (InvalidKeyException e) {
            throw new IOException("get broken RSA public key");
        }
        //加密密码
        String cipheredPassword;
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            cipheredPassword = new String(
                    Base64.getEncoder().encode(
                            cipher.doFinal((keyEntity.getData().getHash() + password).getBytes())
                    )
            );
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            throw new Error(e);
        } catch (InvalidKeyException e) {
            throw new IOException("get broken RSA public key");
        }
        //发起登录请求
        LoginResponseEntity loginResponseEntity = passportService.login(
                username, cipheredPassword
        ).execute().body();
        //判断返回值
        switch (loginResponseEntity.getCode()) {
            case ServerErrorCode.Common.OK: {
                LOGGER.info("Login succeed with username '{}', userId: {}", username, loginResponseEntity.getData().getMid());
                return loginResponseEntity;
            }
            case ServerErrorCode.Passport.USERNAME_OR_PASSWORD_INVALID: {
                throw new LoginException("username or password invalid");
            }
            case ServerErrorCode.Passport.CANT_DECRYPT_RSA_PASSWORD: {
                throw new LoginException("password error or hash expired");
            }
            default: {
                //其他错误码
                throw new IOException(loginResponseEntity.getMessage());
            }
        }
    }

    public static RefreshTokenResponseEntity refreshToken(BilibiliServiceProvider bilibiliServiceProvider,
                                                          String accessToken,
                                                          String refreshToken) throws IOException, LoginException {
        RefreshTokenResponseEntity refreshTokenResponseEntity = bilibiliServiceProvider.getPassportService()
                .refreshToken(
                        accessToken,
                        refreshToken
                ).execute()
                .body();
        switch (refreshTokenResponseEntity.getCode()) {
            case ServerErrorCode.Common.OK: {
                LOGGER.info("Access token refreshed, Expires in {} seconds later", refreshTokenResponseEntity.getData().getExpiresIn());
                return refreshTokenResponseEntity;
            }
            case ServerErrorCode.Common.NO_LOGIN: {
                throw new LoginException("access token can't be empty");
            }
            case ServerErrorCode.Passport.ACCESS_TOKEN_NOT_FOUND: {
                throw new LoginException("access token invalid");
            }
            case ServerErrorCode.Passport.REFRESH_TOKEN_NOT_MATCH: {
                throw new LoginException("access token and refresh token mismatch");
            }
            default: {
                //其他错误码
                throw new IOException(refreshTokenResponseEntity.getMessage());
            }
        }
    }

    public static LogoutResponseEntity logout(BilibiliServiceProvider bilibiliServiceProvider,
                                              String accessToken) throws IOException, LoginException {
        LogoutResponseEntity logoutResponseEntity = bilibiliServiceProvider.getPassportService().logout(accessToken).execute().body();
        switch (logoutResponseEntity.getCode()) {
            case ServerErrorCode.Common.OK: {
                return logoutResponseEntity;
            }
            case ServerErrorCode.Common.NO_LOGIN: {
                throw new LoginException("access token can't be empty or invalid");
            }
            case ServerErrorCode.Passport.ACCESS_TOKEN_NOT_FOUND: {
                throw new LoginException("access token invalid");
            }
            default: {
                //其他错误码
                throw new IOException(logoutResponseEntity.getMessage());
            }
        }
    }
}
