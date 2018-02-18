package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.BilibiliClientProperties;
import com.hiczp.bilibili.api.BilibiliSecurityHelper;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortParamsAndSignInterceptor implements Interceptor {
    private BilibiliClientProperties bilibiliClientProperties;

    public SortParamsAndSignInterceptor(BilibiliClientProperties bilibiliClientProperties) {
        this.bilibiliClientProperties = bilibiliClientProperties;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrl = request.url();
        List<String> nameAndValues = new ArrayList<>(httpUrl.querySize() + 1);
        httpUrl.queryParameterNames().stream()
                .filter(parameterName -> !parameterName.equals("sign"))
                .forEach(name ->
                        httpUrl.queryParameterValues(name).forEach(value -> {
                                    try {
                                        nameAndValues.add(String.format("%s=%s", name, URLEncoder.encode(value, StandardCharsets.UTF_8.toString())));
                                    } catch (UnsupportedEncodingException e) {
                                        throw new Error(e);
                                    }
                                }
                        )
                );
        Collections.sort(nameAndValues);
        return chain.proceed(
                request.newBuilder()
                        .url(httpUrl.newBuilder()
                                .encodedQuery(BilibiliSecurityHelper.addSignToQuery(nameAndValues, bilibiliClientProperties.getAppSecret()))
                                .build()
                        ).build()
        );
    }
}
