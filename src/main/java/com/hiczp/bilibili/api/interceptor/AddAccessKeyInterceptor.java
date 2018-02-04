package com.hiczp.bilibili.api.interceptor;

import com.google.common.base.Strings;
import com.hiczp.bilibili.api.BilibiliSecurityContext;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AddAccessKeyInterceptor implements Interceptor {
    private BilibiliSecurityContext bilibiliSecurityContext;

    public AddAccessKeyInterceptor(BilibiliSecurityContext bilibiliSecurityContext) {
        this.bilibiliSecurityContext = bilibiliSecurityContext;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();
        String accessKey = bilibiliSecurityContext.getAccessToken();
        if (!Strings.isNullOrEmpty(accessKey)) {
            httpUrlBuilder.removeAllQueryParameters("access_key")
                    .addQueryParameter("access_key", accessKey);
        }
        return chain.proceed(request.newBuilder().url(httpUrlBuilder.build()).build());
    }
}
