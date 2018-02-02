package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.BilibiliClientProperties;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortParamsAndSignInterceptor implements Interceptor {
    private BilibiliClientProperties bilibiliClientDefinition;

    public SortParamsAndSignInterceptor(BilibiliClientProperties bilibiliClientDefinition) {
        this.bilibiliClientDefinition = bilibiliClientDefinition;
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
        Collections.sort(nameAndValues);
        nameAndValues.add(String.format("%s=%s", "sign", calculateSign(nameAndValues)));
        return chain.proceed(
                request.newBuilder()
                        .url(httpUrl.newBuilder()
                                .encodedQuery(generateQuery(nameAndValues))
                                .build()
                        ).build()
        );
    }

    private String generateQuery(List<String> nameAndValues) {
        return nameAndValues.stream().collect(Collectors.joining("&"));
    }

    //排序 params 并计算 sign
    //传入值为 name1=value1 形式
    private String calculateSign(List<String> nameAndValues) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((generateQuery(nameAndValues) + bilibiliClientDefinition.getAppSecret()).getBytes());
            String md5 = new BigInteger(1, messageDigest.digest()).toString(16);
            //md5 不满 32 位时左边加 0
            return ("00000000000000000000000000000000" + md5).substring(md5.length());
        } catch (NoSuchAlgorithmException e) {
            throw new Error(e);
        }
    }
}
