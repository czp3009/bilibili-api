package com.hiczp.bilibili.api.retrofit.interceptor

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

        if (paramType == ParamType.QUERY) {
            //这里认为 Query 一定不为 null
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
        } else if (paramType == ParamType.FORM_URL_ENCODED && request.body() is FormBody) {
            val sign = calculateSign((request.body() as FormBody).sortedRaw(), appSecret)
            val formBody = FormBody.Builder().apply {
                //添加原有的参数
                addAll(request.body() as FormBody)
                //添加 sign
                addEncoded("sign", sign)
            }.build()
            return chain.proceed(
                    request.newBuilder().post(formBody).build()
            )
        } else {
            //如果 body 不为 FormBody 将无法添加签名
            logger.error {
                "Impossible add sign to ${request.body()?.javaClass}. Request: " +
                        "${request.method()} ${request.url()}"
            }
        }

        return chain.proceed(request)
    }

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
