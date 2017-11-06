package com.hiczp.bilibili.api.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AddFixedHeadersInterceptor implements Interceptor {
    private String[] headerAndValues;

    public AddFixedHeadersInterceptor(String... headerAndValues) {
        if (headerAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("header must have value");
        }
        this.headerAndValues = headerAndValues;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();
        for (int i = 0; i < headerAndValues.length; i += 2) {
            requestBuilder.addHeader(headerAndValues[i], headerAndValues[i + 1]);
        }
        return chain.proceed(requestBuilder.build());
    }
}
