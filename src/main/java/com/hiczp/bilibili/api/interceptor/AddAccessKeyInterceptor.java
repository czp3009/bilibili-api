package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.BilibiliRESTAPI;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AddAccessKeyInterceptor implements Interceptor {
    private static AddAccessKeyInterceptor addAccessKeyInterceptor;

    public static AddAccessKeyInterceptor getInstance() {
        if (addAccessKeyInterceptor == null) {
            addAccessKeyInterceptor = new AddAccessKeyInterceptor();
        }
        return addAccessKeyInterceptor;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();
        String accessKey = BilibiliRESTAPI.getAccessToken();
        if (accessKey != null && accessKey.length() != 0) {
            httpUrlBuilder.addQueryParameter("access_key", accessKey);
        }
        return chain.proceed(request.newBuilder().url(httpUrlBuilder.build()).build());
    }
}
