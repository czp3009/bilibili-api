package com.hiczp.bilibili.api.interceptor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.ServerErrorCode;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.stream.IntStream;

//自动刷新 token
public class RefreshTokenInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshTokenInterceptor.class);

    private BilibiliAPI bilibiliAPI;
    private int[] codes;

    public RefreshTokenInterceptor(BilibiliAPI bilibiliAPI, int... codes) {
        this.bilibiliAPI = bilibiliAPI;
        this.codes = codes;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        JsonObject jsonObject = InterceptorHelper.getJsonInBody(response);
        JsonElement codeElement = jsonObject.get("code");
        if (codeElement == null) {
            return response;
        }
        int codeValue = codeElement.getAsInt();
        if (codeValue == ServerErrorCode.Common.OK) {
            return response;
        }

        if (IntStream.of(codes).noneMatch(code -> code == codeValue)) {
            return response;
        }

        if (bilibiliAPI.isCurrentTokenAndRefreshTokenInvalid()) {
            return response;
        }

        try {
            bilibiliAPI.refreshToken();
            response = chain.proceed(chain.request());
        } catch (Exception e) {
            LOGGER.error("refresh token failed: {}", e.getMessage());
        }

        return response;
    }
}
