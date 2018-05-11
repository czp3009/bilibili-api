package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.interceptor.*;
import com.hiczp.bilibili.api.live.LiveService;
import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.passport.CaptchaService;
import com.hiczp.bilibili.api.passport.PassportService;
import com.hiczp.bilibili.api.passport.SsoService;
import com.hiczp.bilibili.api.passport.entity.InfoEntity;
import com.hiczp.bilibili.api.passport.entity.LoginResponseEntity;
import com.hiczp.bilibili.api.passport.entity.LogoutResponseEntity;
import com.hiczp.bilibili.api.passport.entity.RefreshTokenResponseEntity;
import com.hiczp.bilibili.api.passport.exception.CaptchaMismatchException;
import com.hiczp.bilibili.api.provider.*;
import com.hiczp.bilibili.api.web.BilibiliWebAPI;
import com.hiczp.bilibili.api.web.BrowserProperties;
import com.hiczp.bilibili.api.web.cookie.SimpleCookieJar;
import io.netty.channel.EventLoopGroup;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class BilibiliAPI implements BilibiliServiceProvider, BilibiliCaptchaProvider, BilibiliSsoProvider, BilibiliWebAPIProvider, LiveClientProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(BilibiliAPI.class);

    private final Long apiInitTime = Instant.now().getEpochSecond();    //记录当前类被实例化的时间
    private final BilibiliClientProperties bilibiliClientProperties;
    private final BilibiliAccount bilibiliAccount;

    private Boolean autoRefreshToken = true;

    //用于阻止进行多次错误的 refreshToken 操作
    private String invalidToken;
    private String invalidRefreshToken;

    private PassportService passportService;
    private CaptchaService captchaService;
    private LiveService liveService;

    private BilibiliWebAPI bilibiliWebAPI;

    public BilibiliAPI() {
        this.bilibiliClientProperties = BilibiliClientProperties.defaultSetting();
        this.bilibiliAccount = BilibiliAccount.emptyInstance();
    }

    public BilibiliAPI(BilibiliClientProperties bilibiliClientProperties) {
        this.bilibiliClientProperties = bilibiliClientProperties;
        this.bilibiliAccount = BilibiliAccount.emptyInstance();
    }

    public BilibiliAPI(BilibiliSecurityContext bilibiliSecurityContext) {
        this.bilibiliClientProperties = BilibiliClientProperties.defaultSetting();
        this.bilibiliAccount = new BilibiliAccount(bilibiliSecurityContext);
    }

    public BilibiliAPI(BilibiliClientProperties bilibiliClientProperties, BilibiliSecurityContext bilibiliSecurityContext) {
        this.bilibiliClientProperties = bilibiliClientProperties;
        this.bilibiliAccount = new BilibiliAccount(bilibiliSecurityContext);
    }

    @Override
    public PassportService getPassportService() {
        if (passportService == null) {
            passportService = getPassportService(Collections.emptyList(), HttpLoggingInterceptor.Level.BASIC);
        }
        return passportService;
    }

    public PassportService getPassportService(@Nonnull List<Interceptor> interceptors, @Nonnull HttpLoggingInterceptor.Level logLevel) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        //TODO 不明确客户端访问 passport.bilibili.com 时使用的 UA
        okHttpClientBuilder
                .addInterceptor(new AddFixedHeadersInterceptor(
                        "Buvid", bilibiliClientProperties.getBuvId(),
                        "User-Agent", "bili-universal/6560 CFNetwork/894 Darwin/17.4.0" //这是 IOS 的 UA
                ))
                .addInterceptor(new AddDynamicHeadersInterceptor(
                        () -> "Display-ID", () -> String.format("%s-%d", bilibiliAccount.getUserId() == null ? bilibiliClientProperties.getBuvId() : bilibiliAccount.getUserId(), apiInitTime)
                ))
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
                .addInterceptor(new ErrorResponseConverterInterceptor());

        interceptors.forEach(okHttpClientBuilder::addInterceptor);

        okHttpClientBuilder
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
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder
                .addInterceptor(new AddFixedHeadersInterceptor(
                        "Buvid", bilibiliClientProperties.getBuvId(),
                        "User-Agent", String.format("Mozilla/5.0 BiliDroid/%s (bbcallen@gmail.com)", bilibiliClientProperties.getSimpleVersion()),
                        "Device-ID", bilibiliClientProperties.getHardwareId()
                ))
                .addInterceptor(new AddDynamicHeadersInterceptor(
                        //Display-ID 的值在未登录前为 Buvid-客户端启动时间, 在登录后为 mid-客户端启动时间
                        () -> "Display-ID", () -> String.format("%s-%d", bilibiliAccount.getUserId() == null ? bilibiliClientProperties.getBuvId() : bilibiliAccount.getUserId(), apiInitTime)
                ))
                .addInterceptor(new AddFixedParamsInterceptor(
                        "_device", "android",
                        "_hwid", bilibiliClientProperties.getHardwareId(),
                        "actionKey", "appkey",
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
                .addInterceptor(new AutoRefreshTokenInterceptor(
                        this,
                        ServerErrorCode.Common.UNAUTHORIZED,
                        ServerErrorCode.Live.USER_NO_LOGIN,
                        ServerErrorCode.Live.PLEASE_LOGIN,
                        ServerErrorCode.Live.PLEASE_LOGIN0,
                        ServerErrorCode.Live.NO_LOGIN
                ))
                .addInterceptor(new AddAccessKeyInterceptor(bilibiliAccount))
                .addInterceptor(new SortParamsAndSignInterceptor(bilibiliClientProperties))
                .addInterceptor(new ErrorResponseConverterInterceptor());

        interceptors.forEach(okHttpClientBuilder::addInterceptor);

        okHttpClientBuilder
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(logLevel));

        return new Retrofit.Builder()
                .baseUrl(BaseUrlDefinition.LIVE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()
                .create(LiveService.class);
    }

    @Override
    public CaptchaService getCaptchaService() {
        if (captchaService == null) {
            captchaService = getCaptchaService(Collections.emptyList(), HttpLoggingInterceptor.Level.BASIC);
        }
        return captchaService;
    }

    public CaptchaService getCaptchaService(@Nonnull List<Interceptor> interceptors, @Nonnull HttpLoggingInterceptor.Level logLevel) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        interceptors.forEach(okHttpClientBuilder::addInterceptor);
        okHttpClientBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(logLevel));

        return new Retrofit.Builder()
                .baseUrl(BaseUrlDefinition.PASSPORT)
                .client(okHttpClientBuilder.build())
                .build()
                .create(CaptchaService.class);
    }

    public SsoService getSsoService() {
        return getSsoService(new SimpleCookieJar());
    }

    //sso 需要保存 cookie, 不对 SsoService 进行缓存
    @Override
    public SsoService getSsoService(CookieJar cookieJar) {
        return getSsoService(cookieJar, Collections.emptyList(), HttpLoggingInterceptor.Level.BASIC);
    }

    public SsoService getSsoService(@Nonnull CookieJar cookieJar, @Nonnull List<Interceptor> interceptors, @Nonnull HttpLoggingInterceptor.Level logLevel) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder
                .cookieJar(cookieJar)
                .addInterceptor(new AddFixedParamsInterceptor(
                        "build", bilibiliClientProperties.getBuild(),
                        "mobi_app", "android",
                        "platform", "android"
                ))
                .addInterceptor(new AddDynamicParamsInterceptor(
                        () -> "ts", () -> Long.toString(Instant.now().getEpochSecond())
                ))
                .addInterceptor(new AddAccessKeyInterceptor(bilibiliAccount))
                .addInterceptor(new AddAppKeyInterceptor(bilibiliClientProperties))
                .addInterceptor(new SortParamsAndSignInterceptor(bilibiliClientProperties));

        interceptors.forEach(okHttpClientBuilder::addInterceptor);

        okHttpClientBuilder
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(logLevel));

        return new Retrofit.Builder()
                .baseUrl(BaseUrlDefinition.PASSPORT)
                .client(okHttpClientBuilder.build())
                .build()
                .create(SsoService.class);
    }

    @Override
    public HttpUrl getSsoUrl(@Nullable String goUrl) {
        CancelRequestInterceptor cancelRequestInterceptor = new CancelRequestInterceptor();
        try {
            getSsoService(new SimpleCookieJar(), Collections.singletonList(cancelRequestInterceptor), HttpLoggingInterceptor.Level.BASIC)
                    .sso(goUrl)
                    .execute();
        } catch (IOException ignored) {

        }
        return cancelRequestInterceptor.getRequest().url();
    }

    @Override
    public Map<String, List<Cookie>> toCookies() throws IOException {
        //用这个地址是因为这个地址一定不会改变(在 B站 未来的更新中)并且很省流量
        return toCookies(BaseUrlDefinition.PASSPORT + "api/oauth2/getKey");
    }

    public Map<String, List<Cookie>> toCookies(@Nullable String goUrl) throws IOException {
        SimpleCookieJar simpleCookieJar = new SimpleCookieJar();
        getSsoService(simpleCookieJar).sso(goUrl).execute();
        return simpleCookieJar.getCookiesMap();
    }

    @Override
    public BilibiliWebAPI getBilibiliWebAPI() throws IOException {
        return getBilibiliWebAPI(BrowserProperties.defaultSetting());
    }

    public BilibiliWebAPI getBilibiliWebAPI(BrowserProperties browserProperties) throws IOException {
        if (bilibiliWebAPI == null) {
            bilibiliWebAPI = new BilibiliWebAPI(browserProperties, toCookies());
        }
        return bilibiliWebAPI;
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
        bilibiliWebAPI = null;
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
        bilibiliWebAPI = null;
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

    /**
     * 2018-05-11 现在用假的房间 Id 也能正常连接弹幕推送服务器
     *
     * @param eventLoopGroup 用于连接弹幕推送服务器的 EventLoop
     * @param roomId         房间 ID, 可以是真 ID 也可以是假 ID
     * @param isRealRoomId   使用的 roomId 是否是真 ID
     * @return LiveClient 实例
     */
    @Override
    public LiveClient getLiveClient(EventLoopGroup eventLoopGroup, long roomId, boolean isRealRoomId) {
        return bilibiliAccount.getUserId() == null ?
                new LiveClient(this, eventLoopGroup, roomId, isRealRoomId) :
                new LiveClient(this, eventLoopGroup, roomId, isRealRoomId, bilibiliAccount.getUserId());
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

    public boolean isAutoRefreshToken() {
        return autoRefreshToken;
    }

    public BilibiliAPI setAutoRefreshToken(boolean autoRefreshToken) {
        this.autoRefreshToken = autoRefreshToken;
        return this;
    }
}
