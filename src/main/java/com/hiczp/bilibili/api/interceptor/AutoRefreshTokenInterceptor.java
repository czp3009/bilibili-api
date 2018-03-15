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

/**
 * 自动刷新 token
 * 如果一次请求的返回值表示鉴权失败, 会尝试刷新一次 token 然后自动重放请求
 * 刷新 token 的行为将只发生一次, 如果刷新 token 失败, 下次请求的时候不会再次执行刷新 token 操作而会直接返回原本的返回内容
 */
public class AutoRefreshTokenInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoRefreshTokenInterceptor.class);

    private BilibiliAPI bilibiliAPI;
    private int[] codes;

    public AutoRefreshTokenInterceptor(BilibiliAPI bilibiliAPI, int... codes) {
        this.bilibiliAPI = bilibiliAPI;
        this.codes = codes;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!bilibiliAPI.isAutoRefreshToken()) {
            return response;
        }

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
