package com.hiczp.bilibili.api.retrofit.interceptor

import com.hiczp.bilibili.api.retrofit.Method
import com.hiczp.bilibili.api.retrofit.ParamType
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

        //如果欲添加的参数类型为 Query 则直接添加
        if (paramType == ParamType.QUERY) {
            val httpUrl = request.url().newBuilder().apply {
                additionParams.forEach { (paramName, paramValueExpression) ->
                    addQueryParameter(paramName, paramValueExpression())
                }
            }.build()
            return chain.proceed(
                    request.newBuilder().url(httpUrl).build()
            )
        }

        //如果请求方式为 POST(只要方式为 POST, body 就一定不为 null)
        if (request.method() == Method.POST) {
            val body = request.body()!!
            val newFormBody = {
                FormBody.Builder().apply {
                    additionParams.forEach { (paramName, paramValueExpression) ->
                        add(paramName, paramValueExpression())
                    }
                }
            }
            if (body.contentType() == null) {   //如果 body 为空
                return chain.proceed(
                        request.newBuilder().post(newFormBody().build()).build()
                )
            } else if (body is FormBody) {  //如果 body 为 FormBody
                return chain.proceed(
                        request.newBuilder().post(newFormBody().addAll(body).build()).build()
                )
            }
        }

        //其他情况, 例如请求方式为 GET 或 Body 为 Json
        logger.error {
            "Impossible add FormUrlEncoded params to ${request.body()?.javaClass?.simpleName ?: "<NullBody>"}. " +
                    "Request: ${request.method()} ${request.url()}"
        }
        return chain.proceed(request)
    }
}
