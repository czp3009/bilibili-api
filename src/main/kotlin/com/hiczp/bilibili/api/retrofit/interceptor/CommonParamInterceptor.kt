package com.hiczp.bilibili.api.retrofit.interceptor

import com.hiczp.bilibili.api.retrofit.HttpMethod
import com.hiczp.bilibili.api.retrofit.addAll
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
        private vararg val additionParams: Pair<String, () -> String>
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (paramType == ParamType.QUERY) {
            val httpUrl = request.url().newBuilder().apply {
                additionParams.forEach { (paramName, paramValueExpression) ->
                    addQueryParameter(paramName, paramValueExpression())
                }
            }.build()
            return chain.proceed(
                    request.newBuilder().url(httpUrl).build()
            )
        } else if (paramType == ParamType.FORM_URL_ENCODED && request.body() is FormBody ||
                paramType == ParamType.FORM_URL_ENCODED && request.method() == HttpMethod.POST.toString() && request.body()?.contentType() == null
        ) {
            //TODO 原有的 Body 为空的情况
            val formBody = FormBody.Builder().apply {
                //添加原有的参数
                addAll(request.body() as FormBody)
                //添加公共参数
                additionParams.forEach { (paramName, paramValueExpression) ->
                    add(paramName, paramValueExpression())
                }
            }.build()
            return chain.proceed(
                    request.newBuilder().post(formBody).build()
            )
        } else {
            //如果 body 不为 FormBody 将无法添加 FormUrlEncoded 参数
            logger.error {
                "Impossible add FormUrlEncoded params to ${request.body()?.javaClass}. Request: " +
                        "${request.method()} ${request.url()}"
            }
        }

        return chain.proceed(request)
    }
}
