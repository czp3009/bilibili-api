package com.hiczp.bilibili.api.interceptor;

import okhttp3.logging.HttpLoggingInterceptor;

public class BasicHttpLoggingInterceptor {
    private static HttpLoggingInterceptor httpLoggingInterceptor;

    public static HttpLoggingInterceptor getInstance() {
        if (httpLoggingInterceptor == null) {
            httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        return httpLoggingInterceptor;
    }
}
