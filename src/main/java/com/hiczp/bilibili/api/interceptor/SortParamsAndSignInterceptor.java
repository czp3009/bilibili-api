package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.Utils;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortParamsAndSignInterceptor implements Interceptor {
    private static SortParamsAndSignInterceptor sortParamsAndSignInterceptor;

    public static SortParamsAndSignInterceptor getInstance() {
        if (sortParamsAndSignInterceptor == null) {
            sortParamsAndSignInterceptor = new SortParamsAndSignInterceptor();
        }
        return sortParamsAndSignInterceptor;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrl = request.url();
        List<String> nameAndValues = new ArrayList<>(httpUrl.querySize() + 1);
        httpUrl.queryParameterNames().forEach(name ->
                httpUrl.queryParameterValues(name).forEach(value -> {
                            try {
                                nameAndValues.add(String.format("%s=%s", name, URLEncoder.encode(value, StandardCharsets.UTF_8.toString())));
                            } catch (UnsupportedEncodingException e) {
                                throw new Error(e);
                            }
                        }
                )
        );
        nameAndValues.add(String.format("%s=%s", "sign", Utils.calculateSign(nameAndValues)));
        return chain.proceed(
                request.newBuilder()
                        .url(httpUrl.newBuilder().encodedQuery(nameAndValues.stream().collect(Collectors.joining("&"))).build())
                        .build()
        );
    }
}
