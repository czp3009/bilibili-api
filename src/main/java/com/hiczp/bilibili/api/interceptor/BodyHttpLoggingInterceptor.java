package com.hiczp.bilibili.api.interceptor;

import okhttp3.logging.HttpLoggingInterceptor;

public class BodyHttpLoggingInterceptor {
    private static HttpLoggingInterceptor httpLoggingInterceptor;

    public static HttpLoggingInterceptor getInstance() {
        if (httpLoggingInterceptor == null) {
            httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        return httpLoggingInterceptor;
    }
}
