package com.hiczp.bilibili.api.interceptor;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

//当返回的数据中的 code 表示未登录时, 将 response 的 HttpStatus 改为 401, 以供 authenticator 使用
//TODO 未实现
public class ErrorResponseStatusConverterInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        throw new UnsupportedOperationException();
    }
}
