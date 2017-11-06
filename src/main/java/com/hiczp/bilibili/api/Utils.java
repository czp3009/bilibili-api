package com.hiczp.bilibili.api;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {
    private static final String APP_KEY = "1d8b6e7d45233436";
    private static final String APP_SECRET = "560c52ccd288fed045859ed18bffd973";
    private static final String HARDWARE_ID = "JxdyESFAJkcjEicQbBBsCTlbal5uX2Y";
    private static final String SCALE = "xxhdpi";
    private static final String VERSION = "5.15.0.515000";
    private static final String BUILD = VERSION.substring(VERSION.lastIndexOf(".") + 1);
    private static final String BUVID = "JxdyESFAJkcjEicQbBBsCTlbal5uX2Yinfoc";

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm000ss");

    //Display-ID 的值在未登录前为 Buvid-客户端启动时间, 在登录后为 mid-客户端启动时间
    public static String calculateDisplayId() {
        int mid = BilibiliRESTAPI.getMid();
        if (mid != 0) { //已登录
            return calculateDisplayId(mid);
        } else {    //未登录
            return String.format("%s-%d", BUVID, Instant.now().getEpochSecond());
        }
    }

    public static String calculateDisplayId(int mid) {
        return String.format("%d-%d", mid, Instant.now().getEpochSecond());
    }

    public static String calculateTraceId() {
        return simpleDateFormat.format(new Date());
    }

    //排序 params 并计算 sign
    //传入值为 name1=value1 形式
    public static String calculateSign(List<String> nameAndValues) {
        Collections.sort(nameAndValues);
        String encodedQuery = nameAndValues.stream().collect(Collectors.joining("&"));
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((encodedQuery + APP_SECRET).getBytes());
            String md5 = new BigInteger(1, messageDigest.digest()).toString(16);
            //md5 不满 32 位时左边加 0
            return ("00000000000000000000000000000000" + md5).substring(md5.length());
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
    }

    //加密密码
    public static String cipherPassword(String password, String hash, RSAPublicKey rsaPublicKey) throws InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
            return new String(
                    Base64.getEncoder().encode(
                            cipher.doFinal((hash + password).getBytes())
                    )
            );
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            throw new Error(e);
        }
    }

    public static String getAppKey() {
        return APP_KEY;
    }

    public static String getAppSecret() {
        return APP_SECRET;
    }

    public static String getHardwareId() {
        return HARDWARE_ID;
    }

    public static String getScale() {
        return SCALE;
    }

    public static String getVERSION() {
        return VERSION;
    }

    public static String getBUILD() {
        return BUILD;
    }

    public static String getBUVID() {
        return BUVID;
    }
}
