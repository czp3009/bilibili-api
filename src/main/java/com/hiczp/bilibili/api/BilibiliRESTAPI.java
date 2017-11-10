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
                    .addInterceptor(ErrorResponseConverterInterceptor.getInstance())
                    .addInterceptor(BodyHttpLoggingInterceptor.getInstance())
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
                    .addInterceptor(ErrorResponseConverterInterceptor.getInstance())
                    .addInterceptor(BodyHttpLoggingInterceptor.getInstance())
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
        //服务器返回异常错误码
        if (keyEntity.getCode() != 0) {
            throw new IOException(keyEntity.getMessage());
        }
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
        int code = loginResponseEntity.getCode();
        switch (code) {
            case ServerErrorCode.Passport.BAD_REQUEST: {
                throw new IOException("request error");
            }
            case ServerErrorCode.Passport.USERNAME_OR_PASSWORD_INVALID: {
                throw new LoginException("username or password invalid");
            }
            case ServerErrorCode.Passport.CANT_DECRYPT_RSA_PASSWORD: {
                throw new LoginException("password error or hash expired");
            }
            default: {
                //其他错误码
                if (code != 0) {
                    throw new IOException(loginResponseEntity.getMessage());
                }
            }
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
        int code = infoEntity.getCode();
        switch (code) {
            case ServerErrorCode.Passport.NO_LOGIN: {
                throw new LoginException("please try after login");
            }
            default: {
                //其他错误码
                if (code != 0) {
                    throw new IOException(infoEntity.getMessage());
                }
            }
        }
        return infoEntity;
    }

    public static RefreshTokenResponseEntity refreshToken() throws IOException, LoginException {
        return refreshToken(accessToken, refreshToken);
    }

    public static RefreshTokenResponseEntity refreshToken(String accessToken, String refreshToken) throws IOException, LoginException {
        RefreshTokenResponseEntity refreshTokenResponseEntity = getPassportService().refreshToken(accessToken, refreshToken).execute().body();
        int code = refreshTokenResponseEntity.getCode();
        switch (code) {
            case ServerErrorCode.Passport.NO_LOGIN: {
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
                if (code != 0) {
                    throw new IOException(refreshTokenResponseEntity.getMessage());
                }
            }
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
        int code = logoutResponseEntity.getCode();
        switch (code) {
            case ServerErrorCode.Passport.NO_LOGIN: {
                throw new LoginException("access token can't be empty");
            }
            case ServerErrorCode.Passport.ACCESS_TOKEN_NOT_FOUND: {
                throw new LoginException("access token invalid");
            }
            default: {
                //其他错误码
                if (code != 0) {
                    throw new IOException(logoutResponseEntity.getMessage());
                }
            }
        }
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
