package com.hiczp.bilibili.api.retrofit.interceptor

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
        private val paramType: ParamType,
        private vararg val additionParams: Pair<String, () -> String?>
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val body = request.body()

        request = when {
            //如果欲添加参数的位置为 Query 则直接添加, paramType 为 FORM_URL_ENCODED 则继续下面的判断
            paramType == ParamType.QUERY -> {
                val httpUrl = request.url().newBuilder().apply {
                    additionParams.forEachNonNull { name, value ->
                        addQueryParameter(name, value)
                    }
                }.build()
                request.newBuilder().url(httpUrl).build()
            }

            //BODY 不存在或者是空的
            body == null || body.contentLength() == 0L -> {
                val formBody = FormBody.Builder().apply {
                    additionParams.forEachNonNull { name, value ->
                        add(name, value)
                    }
                }.build()
                request.newBuilder().method(request.method(), formBody).build()
            }

            //只要 BODY 为 FormBody, 那么里面一定有内容
            body is FormBody -> {
                val formBody = FormBody.Builder().apply {
                    addAllEncoded(body)
                    additionParams.forEachNonNull { name, value ->
                        add(name, value)
                    }
                }.build()
                request.newBuilder().method(request.method(), formBody).build()
            }

            else -> {
                logger.error {
                    "Cannot add params to request: ${request.method()} ${request.url()} ${body.javaClass.simpleName}"
                }
                request
            }
        }

        return chain.proceed(request)
    }
}
