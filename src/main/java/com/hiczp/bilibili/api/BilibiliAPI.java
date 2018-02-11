package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.interceptor.*;
import com.hiczp.bilibili.api.live.LiveService;
import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.passport.PassportService;
import com.hiczp.bilibili.api.passport.entity.InfoEntity;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.LogoutResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;
import com.hiczp.bilibili.api.passport.exception.CaptchaMismatchException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BilibiliAPI implements BilibiliServiceProvider, LiveClientProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(BilibiliAPI.class);

    private final Long apiInitTime = Instant.now().getEpochSecond();    //记录当前类被实例化的时间
    private final BilibiliClientProperties bilibiliClientProperties;
    private final BilibiliAccount bilibiliAccount;

    //用于阻止进行多次错误的 refreshToken 操作
    private String invalidToken;
    private String invalidRefreshToken;

    private PassportService passportService;
    private LiveService liveService;

    public BilibiliAPI() {
        this.bilibiliClientProperties = BilibiliClientProperties.defaultSetting();
        this.bilibiliAccount = BilibiliAccount.emptyInstance();
    }

    public BilibiliAPI(BilibiliClientProperties bilibiliClientProperties) {
        this.bilibiliClientProperties = bilibiliClientProperties;
        this.bilibiliAccount = BilibiliAccount.emptyInstance();
    }

    public BilibiliAPI(BilibiliAccount bilibiliAccount) {
        this.bilibiliClientProperties = BilibiliClientProperties.defaultSetting();
        this.bilibiliAccount = new BilibiliAccount(bilibiliAccount);
    }

    public BilibiliAPI(BilibiliClientProperties bilibiliClientProperties, BilibiliAccount bilibiliAccount) {
        this.bilibiliClientProperties = bilibiliClientProperties;
        this.bilibiliAccount = new BilibiliAccount(bilibiliAccount);
    }

    //TODO 不明确客户端访问 passport.bilibili.com 时使用的 UA
    @Override
    public PassportService getPassportService() {
        if (passportService == null) {
            passportService = getPassportService(Collections.emptyList(), HttpLoggingInterceptor.Level.BASIC);
        }
        return passportService;
    }

    public PassportService getPassportService(@Nonnull List<Interceptor> interceptors, @Nonnull HttpLoggingInterceptor.Level logLevel) {
        Objects.requireNonNull(interceptors);
        Objects.requireNonNull(logLevel);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        interceptors.forEach(okHttpClientBuilder::addInterceptor);

        okHttpClientBuilder
                .addInterceptor(new AddFixedParamsInterceptor(
                        "build", bilibiliClientProperties.getBuild(),
                        "mobi_app", "android",
                        "platform", "android"
                ))
                .addInterceptor(new AddDynamicParamsInterceptor(
                        () -> "ts", () -> Long.toString(Instant.now().getEpochSecond())
                ))
                .addInterceptor(new AddAppKeyInterceptor(bilibiliClientProperties))
                .addInterceptor(new SortParamsAndSignInterceptor(bilibiliClientProperties))
                .addInterceptor(new ErrorResponseConverterInterceptor())
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(logLevel));

        return new Retrofit.Builder()
                .baseUrl(BaseUrlDefinition.PASSPORT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
                .create(PassportService.class);
    }

    @Override
    public LiveService getLiveService() {
        if (liveService == null) {
            liveService = getLiveService(Collections.emptyList(), HttpLoggingInterceptor.Level.BASIC);
        }
        return liveService;
    }

    public LiveService getLiveService(@Nonnull List<Interceptor> interceptors, @Nonnull HttpLoggingInterceptor.Level logLevel) {
        Objects.requireNonNull(interceptors);
        Objects.requireNonNull(logLevel);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        interceptors.forEach(okHttpClientBuilder::addInterceptor);

        okHttpClientBuilder
                .addInterceptor(new AddFixedHeadersInterceptor(
                        "Buvid", bilibiliClientProperties.getBuvId(),
                        "User-Agent", "Mozilla/5.0 BiliDroid/5.15.0 (bbcallen@gmail.com)",
                        "Device-ID", bilibiliClientProperties.getHardwareId()
                ))
                .addInterceptor(new AddDynamicHeadersInterceptor(
                        //Display-ID 的值在未登录前为 Buvid-客户端启动时间, 在登录后为 mid-客户端启动时间
                        () -> "Display-ID", () -> String.format("%s-%d", bilibiliAccount.getUserId() == null ? bilibiliClientProperties.getBuvId() : bilibiliAccount.getUserId(), apiInitTime)
                ))
                .addInterceptor(new AddFixedParamsInterceptor(
                        "_device", "android",
                        "_hwid", bilibiliClientProperties.getHardwareId(),
                        "build", bilibiliClientProperties.getBuild(),
                        "mobi_app", "android",
                        "platform", "android",
                        "scale", bilibiliClientProperties.getScale(),
                        "src", "google",
                        "version", bilibiliClientProperties.getVersion()
                ))
                .addInterceptor(new AddDynamicParamsInterceptor(
                        () -> "ts", () -> Long.toString(Instant.now().getEpochSecond()),
                        () -> "trace_id", () -> new SimpleDateFormat("yyyyMMddHHmm000ss").format(new Date())
                ))
                .addInterceptor(new AddAppKeyInterceptor(bilibiliClientProperties))
                .addInterceptor(new RefreshTokenInterceptor(
                        this,
                        ServerErrorCode.Common.UNAUTHORIZED,
                        ServerErrorCode.Live.USER_NO_LOGIN,
                        ServerErrorCode.Live.PLEASE_LOGIN,
                        ServerErrorCode.Live.NO_LOGIN
                ))
                .addInterceptor(new AddAccessKeyInterceptor(bilibiliAccount))
                .addInterceptor(new SortParamsAndSignInterceptor(bilibiliClientProperties))
                .addInterceptor(new ErrorResponseConverterInterceptor())
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(logLevel));

        return new Retrofit.Builder()
                .baseUrl(BaseUrlDefinition.LIVE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
                .create(LiveService.class);
    }

    public LoginResponseEntity login(@Nonnull String username, @Nonnull String password) throws IOException, LoginException, CaptchaMismatchException {
        return login(username, password, null, null);
    }

    public synchronized LoginResponseEntity login(@Nonnull String username,
                                                  @Nonnull String password,
                                                  String captcha,
                                                  String cookie) throws IOException, LoginException, CaptchaMismatchException {
        LOGGER.info("Login attempting with username '{}'", username);
        LoginResponseEntity loginResponseEntity = BilibiliSecurityHelper.login(
                this,
                username,
                password,
                captcha,
                cookie
        );
        //判断返回值
        switch (loginResponseEntity.getCode()) {
            case ServerErrorCode.Common.OK: {

            }
            break;
            case ServerErrorCode.Passport.USERNAME_OR_PASSWORD_INVALID: {
                throw new LoginException("username or password invalid");
            }
            case ServerErrorCode.Passport.CANT_DECRYPT_RSA_PASSWORD: {
                throw new LoginException("password error or hash expired");
            }
            case ServerErrorCode.Passport.CAPTCHA_NOT_MATCH: {
                throw new CaptchaMismatchException("captcha mismatch");
            }
            default: {
                throw new IOException(loginResponseEntity.getMessage());
            }
        }
        bilibiliAccount.copyFrom(loginResponseEntity.toBilibiliAccount());
        LOGGER.info("Login succeed with username: {}", username);
        return loginResponseEntity;
    }

    public synchronized RefreshTokenResponseEntity refreshToken() throws IOException, LoginException {
        if (isCurrentTokenAndRefreshTokenInvalid()) {
            throw new LoginException("access token or refresh token not been set yet or invalid");
        }

        LOGGER.info("RefreshToken attempting with userId '{}'", bilibiliAccount.getUserId());
        RefreshTokenResponseEntity refreshTokenResponseEntity = BilibiliSecurityHelper.refreshToken(
                this,
                bilibiliAccount.getAccessToken(),
                bilibiliAccount.getRefreshToken()
        );
        switch (refreshTokenResponseEntity.getCode()) {
            case ServerErrorCode.Common.OK: {

            }
            break;
            case ServerErrorCode.Passport.NO_LOGIN: {
                markCurrentTokenAndRefreshTokenInvalid();
                throw new LoginException("access token invalid");
            }
            case ServerErrorCode.Passport.REFRESH_TOKEN_NOT_MATCH: {
                markCurrentTokenAndRefreshTokenInvalid();
                throw new LoginException("access token and refresh token mismatch");
            }
            default: {
                throw new IOException(refreshTokenResponseEntity.getMessage());
            }
        }
        bilibiliAccount.copyFrom(refreshTokenResponseEntity.toBilibiliAccount());
        LOGGER.info("RefreshToken succeed with userId: {}", bilibiliAccount.getUserId());
        return refreshTokenResponseEntity;
    }

    public synchronized LogoutResponseEntity logout() throws IOException, LoginException {
        LOGGER.info("Logout attempting with userId '{}'", bilibiliAccount.getUserId());
        Long userId = bilibiliAccount.getUserId();
        LogoutResponseEntity logoutResponseEntity = BilibiliSecurityHelper.logout(this, bilibiliAccount.getAccessToken());
        switch (logoutResponseEntity.getCode()) {
            case ServerErrorCode.Common.OK: {

            }
            break;
            case ServerErrorCode.Passport.NO_LOGIN: {
                throw new LoginException("access token invalid");
            }
            default: {
                throw new IOException(logoutResponseEntity.getMessage());
            }
        }
        bilibiliAccount.reset();
        LOGGER.info("Logout succeed with userId: {}", userId);
        return logoutResponseEntity;
    }

    public InfoEntity getAccountInfo() throws IOException, LoginException {
        InfoEntity infoEntity = getPassportService()
                .getInfo(bilibiliAccount.getAccessToken())
                .execute()
                .body();
        switch (infoEntity.getCode()) {
            case ServerErrorCode.Common.OK: {

            }
            break;
            case ServerErrorCode.Passport.NO_LOGIN: {
                throw new LoginException("no login");
            }
            default: {
                throw new IOException(infoEntity.getMessage());
            }
        }

        return infoEntity;
    }

    @Override
    public LiveClient getLiveClient(long showRoomId) {
        return bilibiliAccount.getUserId() == null ?
                new LiveClient(this, showRoomId) :
                new LiveClient(this, showRoomId, bilibiliAccount.getUserId());
    }

    private void markCurrentTokenAndRefreshTokenInvalid() {
        invalidToken = bilibiliAccount.getAccessToken();
        invalidRefreshToken = bilibiliAccount.getRefreshToken();
    }

    public boolean isCurrentTokenAndRefreshTokenInvalid() {
        //如果 accessToken 或 refreshToken 没有被设置或者已经尝试过并明确他们是无效的
        return bilibiliAccount.getAccessToken() == null ||
                bilibiliAccount.getRefreshToken() == null ||
                (bilibiliAccount.getAccessToken().equals(invalidToken) && bilibiliAccount.getRefreshToken().equals(invalidRefreshToken));
    }

    public BilibiliClientProperties getBilibiliClientProperties() {
        return bilibiliClientProperties;
    }

    public BilibiliAccount getBilibiliAccount() {
        return bilibiliAccount;
    }
}
