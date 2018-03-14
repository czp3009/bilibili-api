package com.hiczp.bilibili.api.interceptor;

import com.hiczp.bilibili.api.exception.UserCancelRequestException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * 这个拦截器用于取消请求
 * 如果需要让数据经过其他拦截器处理, 但是不想发生真实的网络请求, 就可以使用这个
 *
 * @see UserCancelRequestException
 */
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
