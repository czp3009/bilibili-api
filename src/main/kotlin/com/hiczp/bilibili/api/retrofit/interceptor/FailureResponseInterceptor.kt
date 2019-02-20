package com.hiczp.bilibili.api.retrofit.interceptor

import com.github.salomonbrys.kotson.fromJson
import com.github.salomonbrys.kotson.int
import com.github.salomonbrys.kotson.obj
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.hiczp.bilibili.api.retrofit.exception.BilibiliApiException
import okhttp3.Interceptor
import okhttp3.Response

/**
 * 如果服务器返回的 code 不为 0 则抛出异常
 */
object FailureResponseInterceptor : Interceptor {
    private val jsonParser = JsonParser()
    @Suppress("SpellCheckingInspection")
    private val gson = Gson()

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val body = response.body()
        if (!response.isSuccessful || body == null || body.contentLength() == 0L) return response

        //获取字符集
        val contentType = body.contentType()
        val charset = if (contentType == null) {
            Charsets.UTF_8
        } else {
            contentType.charset(Charsets.UTF_8)!!
        }

        //拷贝流并读取其内容
        val jsonObject = body.source().also {
            it.request(Long.MAX_VALUE)
        }.buffer.clone().inputStream().reader(charset).let {
            jsonParser.parse(it).obj
        }

        //判断 code 是否为 0
        if (jsonObject["code"].int != 0) {
            throw BilibiliApiException(gson.fromJson(jsonObject))
        }

        return response
    }
}
