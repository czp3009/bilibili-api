package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.passport.entity.KeyEntity;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.LogoutResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;

public class BilibiliSecurityHelper {
    private static String cipherPassword(BilibiliServiceProvider bilibiliServiceProvider,
                                         String password) throws IOException {
        KeyEntity keyEntity = bilibiliServiceProvider.getPassportService().getKey().execute().body();
        //服务器返回异常错误码
        if (keyEntity.getCode() != 0) {
            throw new IOException(keyEntity.getMessage());
        }
        //构造无备注的 RSA 公钥字符串
        String rsaPublicKeyString = Arrays.stream(keyEntity.getData().getKey().split("\n"))
                .filter(string -> !string.startsWith("-"))
                .collect(Collectors.joining());
        //解析 RSA 公钥
        PublicKey publicKey;
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(rsaPublicKeyString.getBytes()));
            publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        } catch (InvalidKeySpecException e) {
            throw new IOException("get broken RSA public key");
        }
        //加密密码
        String cipheredPassword;
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
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
        return cipheredPassword;
    }

    public static LoginResponseEntity login(BilibiliServiceProvider bilibiliServiceProvider,
                                            String username,
                                            String password) throws IOException {
        return login(bilibiliServiceProvider, username, password, null, null);
    }

    public static LoginResponseEntity login(BilibiliServiceProvider bilibiliServiceProvider,
                                            String username,
                                            String password,
                                            String captcha,
                                            String cookie) throws IOException {
        return bilibiliServiceProvider.getPassportService()
                .login(
                        username,
                        cipherPassword(bilibiliServiceProvider, password),
                        captcha,
                        cookie
                ).execute()
                .body();
    }

    public static RefreshTokenResponseEntity refreshToken(BilibiliServiceProvider bilibiliServiceProvider,
                                                          String accessToken,
                                                          String refreshToken) throws IOException {
        return bilibiliServiceProvider.getPassportService().refreshToken(accessToken, refreshToken)
                .execute()
                .body();
    }

    public static LogoutResponseEntity logout(BilibiliServiceProvider bilibiliServiceProvider,
                                              String accessToken) throws IOException {
        return bilibiliServiceProvider.getPassportService().logout(accessToken)
                .execute()
                .body();
    }
}
