package com.hiczp.bilibili.api.interceptor;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.function.Supplier;

public class AddDynamicParamsInterceptor implements Interceptor {
    private Supplier<String>[] paramAndValues;

    @SafeVarargs
    public AddDynamicParamsInterceptor(Supplier<String>... paramAndValues) {
        if (paramAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Parameter must have value");
        }
        this.paramAndValues = paramAndValues;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();
        for (int i = 0; i < paramAndValues.length; i += 2) {
            httpUrlBuilder.addQueryParameter(paramAndValues[i].get(), paramAndValues[i + 1].get());
        }
        return chain.proceed(request.newBuilder().url(httpUrlBuilder.build()).build());
    }
}
