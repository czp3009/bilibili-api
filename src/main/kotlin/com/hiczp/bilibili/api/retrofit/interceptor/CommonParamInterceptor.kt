package com.hiczp.bilibili.api.retrofit.interceptor

import com.hiczp.bilibili.api.retrofit.Header
import com.hiczp.bilibili.api.retrofit.ParamType
import com.hiczp.bilibili.api.retrofit.addAllEncoded
import com.hiczp.bilibili.api.retrofit.forEachNonNull
import mu.KotlinLogging
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response

private val logger = KotlinLogging.logger {}

/**
 * 为请求添加公共参数
 *
 * @param paramType 参数类型, Query 或 FormUrlEncoded
 * @param additionParams ParamName to ParamValueExpression
 */
class CommonParamInterceptor(
        private var paramType: ParamType,
        private vararg val additionParams: Pair<String, () -> String?>
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var headers = request.headers()
        var httpUrl = request.url()
        var body = request.body()

        //是否强制加到 FormBody
        if (headers[Header.FORCE_FORM_BODY_NAME] != null) {
            paramType = ParamType.FORM_URL_ENCODED
            headers = headers.newBuilder().removeAll(Header.FORCE_FORM_BODY_NAME).build()
        }

        when {
            //如果欲添加参数的位置为 Query 则直接添加, paramType 为 FORM_URL_ENCODED 则继续下面的判断
            paramType == ParamType.QUERY -> {
                httpUrl = request.url().newBuilder().apply {
                    additionParams.forEachNonNull { name, value ->
                        addQueryParameter(name, value)
                    }
                }.build()
            }

            //BODY 不存在或者是空的
            body == null || body.contentLength() == 0L -> {
                body = FormBody.Builder().apply {
                    additionParams.forEachNonNull { name, value ->
                        add(name, value)
                    }
                }.build()
            }

            //只要 BODY 为 FormBody, 那么里面一定有内容
            body is FormBody -> {
                body = FormBody.Builder().addAllEncoded(body).apply {
                    additionParams.forEachNonNull { name, value ->
                        add(name, value)
                    }
                }.build()
            }

            else -> {
                logger.error {
                    "Cannot add params to request: ${request.method()} ${request.url()} ${body.javaClass.simpleName}"
                }
            }
        }

        return chain.proceed(
                request.newBuilder()
                        .headers(headers)
                        .url(httpUrl)
                        .method(request.method(), body)
                        .build()
        )
    }
}
