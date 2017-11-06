package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.Utils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AddAppKeyInterceptor implements Interceptor {
    private static AddAppKeyInterceptor addAppKeyInterceptor;

    public static AddAppKeyInterceptor getInstance() {
        if (addAppKeyInterceptor == null) {
            addAppKeyInterceptor = new AddAppKeyInterceptor();
        }
        return addAppKeyInterceptor;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        return chain.proceed(request.newBuilder().url(
                request.url().newBuilder()
                        .addQueryParameter("appkey", Utils.getAppKey())
                        .build()
        ).build());
    }
}
