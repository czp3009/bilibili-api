package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.passport.entity.KeyEntity;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.LogoutResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;
import com.hiczp.bilibili.api.provider.BilibiliServiceProvider;

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
    /**
     * 加密一个明文密码
     *
     * @param bilibiliServiceProvider BilibiliServiceProvider 实例
     * @param password                明文密码
     * @return 密文密码
     * @throws IOException 网络错误
     */
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
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
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

    /**
     * 计算 sign
     *
     * @param nameAndValues 传入值为 name1=value1 形式, 传入值必须已经排序. value 必须已经经过 URLEncode
     * @param appSecret     APP 密钥
     * @return sign
     */
    public static String calculateSign(@Nonnull List<String> nameAndValues, @Nonnull String appSecret) {
        return calculateSign(nameAndValues.stream().collect(Collectors.joining("&")), appSecret);
    }

    /**
     * 计算 sign
     *
     * @param encodedQuery 已经经过 URLEncode 处理的 Query 参数字符串
     * @param appSecret    APP 密钥
     * @return sign
     */
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

    /**
     * 向一个 Query 参数字符串中添加 sign
     *
     * @param nameAndValues 传入值为 name1=value1 形式, 传入值必须已经排序. value 必须已经经过 URLEncode
     * @param appSecret     APP 密钥
     * @return 添加了 sign 的 Query 参数字符串
     */
    public static String addSignToQuery(@Nonnull List<String> nameAndValues, @Nonnull String appSecret) {
        return addSignToQuery(nameAndValues.stream().collect(Collectors.joining("&")), appSecret);
    }

    /**
     * 向一个 Query 参数字符串中添加 sign
     *
     * @param encodedQuery 已经经过 URLEncode 处理的 Query 参数字符串
     * @param appSecret    APP 密钥
     * @return 添加了 sign 的 Query 参数字符串
     */
    public static String addSignToQuery(@Nonnull String encodedQuery, @Nonnull String appSecret) {
        return encodedQuery + String.format("&%s=%s", "sign", calculateSign(encodedQuery, appSecret));
    }

    /**
     * 登录
     *
     * @param bilibiliServiceProvider BilibiliServiceProvider 实例
     * @param username                用户名
     * @param password                明文密码
     * @return 返回值包含有 token 与 refreshToken
     * @throws IOException 网络错误
     */
    public static LoginResponseEntity login(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                            @Nonnull String username,
                                            @Nonnull String password) throws IOException {
        return login(bilibiliServiceProvider, username, password, null, null);
    }

    /**
     * 带验证码的登录
     * 在一段时间内使用错误的密码尝试登录多次, 再次使用这个 IP 地址登录这个账号会被要求验证码
     *
     * @param bilibiliServiceProvider BilibiliServiceProvider 实例
     * @param username                用户名
     * @param password                明文密码
     * @param captcha                 验证码
     * @param cookie                  与验证码对应的 cookies
     * @return 返回值包含有 token 与 refreshToken
     * @throws IOException 网络错误
     * @see com.hiczp.bilibili.api.passport.CaptchaService
     */
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

    /**
     * 刷新 Token
     *
     * @param bilibiliServiceProvider BilibiliServiceProvider 实例
     * @param accessToken             token
     * @param refreshToken            refreshToken
     * @return 返回值包含一个新的 token 与 refreshToken
     * @throws IOException 网络错误
     */
    public static RefreshTokenResponseEntity refreshToken(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                                          @Nonnull String accessToken,
                                                          @Nonnull String refreshToken) throws IOException {
        return bilibiliServiceProvider.getPassportService().refreshToken(accessToken, refreshToken)
                .execute()
                .body();
    }

    /**
     * 注销
     *
     * @param bilibiliServiceProvider BilibiliServiceProvider 实例
     * @param accessToken             token
     * @return 返回 0 表示成功
     * @throws IOException 网络错误
     */
    public static LogoutResponseEntity logout(@Nonnull BilibiliServiceProvider bilibiliServiceProvider,
                                              @Nonnull String accessToken) throws IOException {
        return bilibiliServiceProvider.getPassportService().logout(accessToken)
                .execute()
                .body();
    }
}
