package com.hiczp.bilibili.api.retrofit.interceptor

import com.hiczp.bilibili.api.retrofit.Method
import com.hiczp.bilibili.api.retrofit.ParamType
import com.hiczp.bilibili.api.retrofit.addAll
import com.hiczp.bilibili.api.retrofit.sortedRaw
import mu.KotlinLogging
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import java.security.MessageDigest

private val logger = KotlinLogging.logger {}

/**
 * 排序参数并添加签名
 */
class SortAndSignInterceptor(private val paramType: ParamType, private val appSecret: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        //如果欲签名的参数类型为 Query
        if (paramType == ParamType.QUERY) {
            //如果代码是正确的, 那么传到这里的 Query 参数一定包含了公共参数
            val sortedEncodedQuery = request.url().encodedQuery()!!
                    .split('&')
                    .sorted()
                    .joinToString(separator = "&")
            val sign = calculateSign(sortedEncodedQuery, appSecret)
            return chain.proceed(
                    request.newBuilder()
                            .url(request.url().newBuilder()
                                    .encodedQuery("$sortedEncodedQuery&sign=$sign")
                                    .build()
                            )
                            .build()
            )
        }

        val body = request.body()
        if (request.method() == Method.POST && body is FormBody) {
            val sign = calculateSign(body.sortedRaw(), appSecret)
            val newFormBody = FormBody.Builder().apply {
                addAll(body)
                addEncoded("sign", sign)
            }.build()
            return chain.proceed(request.newBuilder().post(newFormBody).build())
        }

        //其他情况, 例如请求方式为 GET 或 Body 为 Json
        logger.error {
            "Impossible add sign to ${request.body()?.javaClass?.simpleName ?: "<NullBody>"}. " +
                    "Request: ${request.method()} ${request.url()}"
        }
        return chain.proceed(request)
    }

    companion object {
        /**
         * 签名算法为 "$排序后的参数字符串$appSecret".md5()
         */
        private fun calculateSign(string: String, appSecret: String) =
                MessageDigest.getInstance("MD5")
                        .digest((string + appSecret).toByteArray())
                        .joinToString(separator = "") {
                            String.format("%02x", it)
                        }
    }
}
