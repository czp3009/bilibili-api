package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.exception.UserCancelRequestException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CancelRequestInterceptor implements Interceptor {
    private Request request;

    @Override
    public Response intercept(Chain chain) throws IOException {
        request = chain.request();
        throw new UserCancelRequestException();
    }

    public Request getRequest() {
        return request;
    }
}
