package com.hiczp.bilibili.api.retrofit.interceptor

import com.hiczp.bilibili.api.retrofit.ParamExpression
import com.hiczp.bilibili.api.retrofit.forEachNonNull
import okhttp3.Interceptor
import okhttp3.Response

/**
 * 为请求添加公共 Header
 *
 * @param additionHeaders HeaderName to HeaderValueExpression
 */
class CommonHeaderInterceptor(private vararg val additionHeaders: ParamExpression) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            additionHeaders.forEachNonNull { name, value ->
                addHeader(name, value)
            }
        }.build()
        return chain.proceed(request)
    }
}
