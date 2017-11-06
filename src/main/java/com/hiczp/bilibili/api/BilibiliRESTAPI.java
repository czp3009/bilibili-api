package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.interceptor.*;
import com.hiczp.bilibili.api.live.LiveService;
import com.hiczp.bilibili.api.passport.PassportService;
import com.hiczp.bilibili.api.passport.entity.*;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sun.security.rsa.RSAPublicKeyImpl;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.Base64;

public class BilibiliRESTAPI {
    private static final Logger LOGGER = LoggerFactory.getLogger(BilibiliRESTAPI.class);
    private static String accessToken;
    private static String refreshToken;
    private static int mid;

    private static LiveService liveService;
    private static PassportService passportService;

    //TODO 尚未实现 未登录, 服务器繁忙 等情况下的统一错误处理拦截器
    public static LiveService getLiveService() {
        if (liveService == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new AddFixedHeadersInterceptor(
                            "Display-ID", Utils.calculateDisplayId(),
                            "Buvid", Utils.getBUVID(),
                            "User-Agent", "Mozilla/5.0 BiliDroid/5.15.0 (bbcallen@gmail.com)",
                            "Device-ID", Utils.getHardwareId()
                    )).addInterceptor(new AddFixedParamsInterceptor(
                            "_device", "android",
                            "_hwid", Utils.getHardwareId(),
                            "build", Utils.getBUILD(),
                            "mobi_app", "android",
                            "platform", "android",
                            "scale", Utils.getScale(),
                            "src", "google",
                            "trace_id", Utils.calculateTraceId(),
                            "ts", Long.toString(Instant.now().getEpochSecond()),
                            "version", Utils.getVERSION()
                    )).addInterceptor(AddAccessKeyInterceptor.getInstance())
                    .addInterceptor(AddAppKeyInterceptor.getInstance())
                    .addInterceptor(SortParamsAndSignInterceptor.getInstance())
                    .addInterceptor(BasicHttpLoggingInterceptor.getInstance())
                    .build();

            liveService = new Retrofit.Builder()
                    .baseUrl("http://api.live.bilibili.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(LiveService.class);
        }
        return liveService;
    }

    public static PassportService getPassportService() {
        if (passportService == null) {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(AddAppKeyInterceptor.getInstance())
                    .addInterceptor(SortParamsAndSignInterceptor.getInstance())
                    .addInterceptor(BasicHttpLoggingInterceptor.getInstance())
                    .build();

            passportService = new Retrofit.Builder()
                    .baseUrl("https://passport.bilibili.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                    .create(PassportService.class);
        }
        return passportService;
    }

    public static LoginResponseEntity login(String username, String password) throws IOException, LoginException {
        LOGGER.debug("Login attempt with username '{}'", username);
        PassportService passportService = getPassportService();
        KeyEntity keyEntity = passportService.getKey().execute().body();
        if (keyEntity.getCode() != 0) {
            throw new RuntimeException(keyEntity.getMessage());
        }
        RSAPublicKey rsaPublicKey;
        try {
            rsaPublicKey = new RSAPublicKeyImpl(
                    Base64.getDecoder().decode(
                            keyEntity.getData().getKey()
                                    .replace("-----BEGIN PUBLIC KEY-----", "")
                                    .replace("-----END PUBLIC KEY-----", "")
                                    .replace("\n", "")
                                    .getBytes()
                    )
            );
        } catch (InvalidKeyException e) {
            throw new IOException("get broken RSA public key");
        }
        String cipheredPassword;
        try {
            cipheredPassword = Utils.cipherPassword(
                    password,
                    keyEntity.getData().getHash(),
                    rsaPublicKey
            );
        } catch (InvalidKeyException e) {
            throw new IOException("get broken RSA public key");
        }
        LoginResponseEntity loginResponseEntity = passportService.login(
                username, cipheredPassword
        ).execute().body();
        //TODO 不明确用户名和密码不匹配时返回的错误码
        if (loginResponseEntity.getCode() != 0) {
            throw new LoginException("username or password invalid");
        }
        BilibiliRESTAPI.accessToken = loginResponseEntity.getData().getAccessToken();
        BilibiliRESTAPI.refreshToken = loginResponseEntity.getData().getRefreshToken();
        BilibiliRESTAPI.mid = loginResponseEntity.getData().getMid();
        LOGGER.info("Login success with username '{}'", username);
        LOGGER.debug("mid: " + BilibiliRESTAPI.mid);
        return loginResponseEntity;
    }

    public static InfoEntity getAccountInfo() throws IOException, LoginException {
        InfoEntity infoEntity = getPassportService().getInfo(accessToken).execute().body();
        //TODO 不明确未登录时获取用户信息的错误码
        if (infoEntity.getCode() != 0) {
            throw new LoginException("please try after login");
        }
        return infoEntity;
    }

    public static RefreshTokenResponseEntity refreshToken() throws IOException, LoginException {
        return refreshToken(accessToken, refreshToken);
    }

    public static RefreshTokenResponseEntity refreshToken(String accessToken, String refreshToken) throws IOException, LoginException {
        RefreshTokenResponseEntity refreshTokenResponseEntity = getPassportService().refreshToken(accessToken, refreshToken).execute().body();
        //TODO 不明确 access token 和 refresh token 不匹配时的错误码
        if (refreshTokenResponseEntity.getCode() != 0) {
            throw new LoginException("access token and refresh token mismatch");
        }
        BilibiliRESTAPI.accessToken = refreshTokenResponseEntity.getData().getAccessToken();
        BilibiliRESTAPI.refreshToken = refreshTokenResponseEntity.getData().getRefreshToken();
        BilibiliRESTAPI.mid = refreshTokenResponseEntity.getData().getMid();
        LOGGER.info("Access token refreshed");
        LOGGER.debug("Expires in {} seconds later", refreshTokenResponseEntity.getData().getExpiresIn());
        return refreshTokenResponseEntity;
    }

    public static LogoutResponseEntity logout() throws IOException, LoginException {
        return logout(accessToken);
    }

    public static LogoutResponseEntity logout(String accessToken) throws IOException, LoginException {
        LogoutResponseEntity logoutResponseEntity = getPassportService().logout(accessToken).execute().body();
        //TODO 不明确使用无效的 access token 登出时的错误码
        if (logoutResponseEntity.getCode() != 0) {
            throw new LoginException("access token invalid");
        }
        BilibiliRESTAPI.accessToken = null;
        BilibiliRESTAPI.refreshToken = null;
        BilibiliRESTAPI.mid = 0;
        LOGGER.info("Logout success");
        return logoutResponseEntity;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        BilibiliRESTAPI.accessToken = accessToken;
    }

    public static String getRefreshToken() {
        return refreshToken;
    }

    public static void setRefreshToken(String refreshToken) {
        BilibiliRESTAPI.refreshToken = refreshToken;
    }

    public static int getMid() {
        return mid;
    }

    public static void setMid(int mid) {
        BilibiliRESTAPI.mid = mid;
    }
}
