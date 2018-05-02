package com.hiczp.bilibili.api.interceptor;

import com.google.gson.*;
import com.hiczp.bilibili.api.ServerErrorCode;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 错误返回码内容转换拦截器
 * 由于服务器返回错误时的 data 字段类型不固定, 会导致 json 反序列化出错.
 * 该拦截器将在返回的 code 不为 0 时, 将 response 转换为包含一个空 data 的 json 字符串.
 */
public class ErrorResponseConverterInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorResponseConverterInterceptor.class);
    private static final Gson GSON = new Gson();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        ResponseBody responseBody = response.body();

        JsonObject jsonObject = InterceptorHelper.getJsonInBody(response);
        JsonElement code = jsonObject.get("code");
        //code 字段不存在
        if (code == null || code.isJsonNull()) {
            return response;
        }
        //code 为 0
        try {
            if (code.getAsInt() == ServerErrorCode.Common.OK) {
                return response;
            }
        } catch (NumberFormatException e) {    //如果 code 不是数字的话直接返回
            return response;
        }

        //打印 body
        LOGGER.error("Get error response below: \n{}",
                new GsonBuilder()
                        .setPrettyPrinting()
                        .create()
                        .toJson(jsonObject)
        );
        //data 字段不存在
        if (jsonObject.get("data") == null) {
            return response;
        }
        jsonObject.add("data", JsonNull.INSTANCE);
        return response.newBuilder()
                .body(ResponseBody.create(
                        responseBody.contentType(),
                        GSON.toJson(jsonObject))
                ).build();
    }
}
