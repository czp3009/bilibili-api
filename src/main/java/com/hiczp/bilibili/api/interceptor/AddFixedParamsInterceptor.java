package com.hiczp.bilibili.api.interceptor;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AddFixedParamsInterceptor implements Interceptor {
    private String[] paramAndValues;

    public AddFixedParamsInterceptor(String... paramAndValues) {
        if (paramAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("param must have value");
        }
        this.paramAndValues = paramAndValues;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();
        for (int i = 0; i < paramAndValues.length; i += 2) {
            httpUrlBuilder.addQueryParameter(paramAndValues[i], paramAndValues[i + 1]);
        }
        return chain.proceed(request.newBuilder().url(httpUrlBuilder.build()).build());
    }
}
