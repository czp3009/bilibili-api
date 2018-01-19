package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.BilibiliClientProperties;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AddAppKeyInterceptor implements Interceptor {
    private BilibiliClientProperties bilibiliClientDefinition;

    public AddAppKeyInterceptor(BilibiliClientProperties bilibiliClientDefinition) {
        this.bilibiliClientDefinition = bilibiliClientDefinition;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request.newBuilder().url(
                request.url().newBuilder()
                        .addQueryParameter("appkey", bilibiliClientDefinition.getAppKey())
                        .build()
        ).build());
    }
}
