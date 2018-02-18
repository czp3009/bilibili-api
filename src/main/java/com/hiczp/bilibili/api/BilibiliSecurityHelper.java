package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.passport.entity.KeyEntity;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.LogoutResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class BilibiliSecurityHelper {
    private static String cipherPassword(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                         @Nonnull String password) throws IOException {
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

    //计算 sign
    //传入值为 name1=value1 形式
    //传入值必须已经排序
    //value 必须已经 URLEncode
    public static String calculateSign(@Nonnull List<String> nameAndValues, @Nonnull String appSecret) {
        return calculateSign(nameAndValues.stream().collect(Collectors.joining("&")), appSecret);
    }

    public static String calculateSign(@Nonnull String encodedQuery, @Nonnull String appSecret) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((encodedQuery + appSecret).getBytes());
            String md5 = new BigInteger(1, messageDigest.digest()).toString(16);
            //md5 不满 32 位时左边加 0
            return ("00000000000000000000000000000000" + md5).substring(md5.length());
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
    }

    //直接生成添加了 sign 的 query
    //传入值为 name1=value1 形式
    //传入值必须已经排序
    //value 必须已经 URLEncode
    public static String addSignToQuery(@Nonnull List<String> nameAndValues, @Nonnull String appSecret) {
        return addSignToQuery(nameAndValues.stream().collect(Collectors.joining("&")), appSecret);
    }

    public static String addSignToQuery(@Nonnull String encodedQuery, @Nonnull String appSecret) {
        return encodedQuery + String.format("&%s=%s", "sign", calculateSign(encodedQuery, appSecret));
    }

    public static LoginResponseEntity login(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                            @Nonnull String username,
                                            @Nonnull String password) throws IOException {
        return login(bilibiliServiceProvider, username, password, null, null);
    }

    public static LoginResponseEntity login(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                            @Nonnull String username,
                                            @Nonnull String password,
                                            @Nullable String captcha,
                                            @Nullable String cookie) throws IOException {
        return bilibiliServiceProvider.getPassportService()
                .login(
                        username,
                        cipherPassword(bilibiliServiceProvider, password),
                        captcha,
                        cookie
                ).execute()
                .body();
    }

    public static RefreshTokenResponseEntity refreshToken(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                                          @Nonnull String accessToken,
                                                          @Nonnull String refreshToken) throws IOException {
        return bilibiliServiceProvider.getPassportService().refreshToken(accessToken, refreshToken)
                .execute()
                .body();
    }

    public static LogoutResponseEntity logout(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                              @Nonnull String accessToken) throws IOException {
        return bilibiliServiceProvider.getPassportService().logout(accessToken)
                .execute()
                .body();
    }
}
