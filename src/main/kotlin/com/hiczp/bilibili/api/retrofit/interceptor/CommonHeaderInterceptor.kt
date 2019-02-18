package com.hiczp.bilibili.api.retrofit.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 为请求添加公共 Header
 *
 * @param additionHeaders HeaderName to HeaderValueExpression
 */
class CommonHeaderInterceptor(private vararg val additionHeaders: Pair<String, () -> String>) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            additionHeaders.forEach { (headerName, headerValueExpression) ->
                addHeader(headerName, headerValueExpression())
            }
        }.build()
        return chain.proceed(request)
    }
}
