package com.hiczp.bilibili.rest.ktor

import io.ktor.http.encodeURLParameter
import io.ktor.util.InternalAPI
import io.ktor.util.StringValuesBuilder

@UseExperimental(InternalAPI::class)
internal fun StringValuesBuilder.sortAndSign(appSecret: String) {
    val sorted = entries().sortedBy { it.key }
    clear()
    sorted.forEach { (key, value) ->
        appendAll(key, value)
    }
    if (!contains("sign")) {
        sorted.joinToString(separator = "&") { (key, value) ->
            value.joinToString(separator = "&") {
                "$key=${it.encodeURLParameter()}"
            }
        }.let {
            it + appSecret
        }.md5().let {
            append("sign", it)
        }
    }
}
