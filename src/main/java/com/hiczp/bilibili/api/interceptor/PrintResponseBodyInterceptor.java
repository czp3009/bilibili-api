package com.hiczp.bilibili.api.interceptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PrintResponseBodyInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintResponseBodyInterceptor.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        JsonObject jsonObject = InterceptorHelper.getJsonInBody(response);
        LOGGER.info(GSON.toJson(jsonObject));

        return response;
    }
}
