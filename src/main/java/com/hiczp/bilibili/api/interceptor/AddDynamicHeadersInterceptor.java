package com.hiczp.bilibili.api.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.function.Supplier;

public class AddDynamicHeadersInterceptor implements Interceptor {
    private Supplier<String>[] headerAndValues;

    @SafeVarargs
    public AddDynamicHeadersInterceptor(Supplier<String>... headerAndValues) {
        if (headerAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Header must have value");
        }
        this.headerAndValues = headerAndValues;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();
        for (int i = 0; i < headerAndValues.length; i += 2) {
            requestBuilder.addHeader(headerAndValues[i].get(), headerAndValues[i + 1].get());
        }
        return chain.proceed(requestBuilder.build());
    }
}
