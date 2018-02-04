package com.hiczp.bilibili.api.interceptor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

class InterceptorHelper {
    private static final JsonParser JSON_PARSER = new JsonParser();

    static JsonObject getJsonInBody(Response response) throws IOException {
        ResponseBody responseBody = response.body();
        BufferedSource bufferedSource = responseBody.source();
        bufferedSource.request(Long.MAX_VALUE);
        Buffer buffer = bufferedSource.buffer();
        return JSON_PARSER.parse(
                //必须要 clone 一次, 否则将导致流关闭
                buffer.clone().readString(StandardCharsets.UTF_8)
        ).getAsJsonObject();
    }
}
