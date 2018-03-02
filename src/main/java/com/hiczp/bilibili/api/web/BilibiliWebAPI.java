package com.hiczp.bilibili.api.web;

import com.hiczp.bilibili.api.BaseUrlDefinition;
import com.hiczp.bilibili.api.interceptor.AddFixedHeadersInterceptor;
import com.hiczp.bilibili.api.web.cookie.SimpleCookieJar;
import com.hiczp.bilibili.api.web.live.LiveService;
import okhttp3.Cookie;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BilibiliWebAPI {
    private final BrowserProperties browserProperties;
    private final SimpleCookieJar cookieJar;

    private LiveService liveService;

    public BilibiliWebAPI(BrowserProperties browserProperties, SimpleCookieJar cookieJar) {
        this.browserProperties = browserProperties;
        this.cookieJar = cookieJar;
    }

    public BilibiliWebAPI(SimpleCookieJar cookieJar) {
        this(BrowserProperties.defaultSetting(), cookieJar);
    }

    public BilibiliWebAPI(BrowserProperties browserProperties, Map<String, List<Cookie>> cookiesMap) {
        this(browserProperties, new SimpleCookieJar(cookiesMap));
    }

    public BilibiliWebAPI(Map<String, List<Cookie>> cookiesMap) {
        this(BrowserProperties.defaultSetting(), new SimpleCookieJar(cookiesMap));
    }

    public LiveService getLiveService() {
        if (liveService == null) {
            liveService = getLiveService(Collections.emptyList(), HttpLoggingInterceptor.Level.BASIC);
        }
        return liveService;
    }

    public LiveService getLiveService(@Nonnull List<Interceptor> interceptors, @Nonnull HttpLoggingInterceptor.Level logLevel) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder
                .cookieJar(cookieJar)
                .addInterceptor(new AddFixedHeadersInterceptor(
                        "User-Agent", browserProperties.getUserAgent()
                ));

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

    public SimpleCookieJar getCookieJar() {
        return cookieJar;
    }
}
