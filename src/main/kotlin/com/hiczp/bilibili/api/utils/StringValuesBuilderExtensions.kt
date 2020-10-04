package com.hiczp.bilibili.api.utils

import io.ktor.http.*
import io.ktor.util.*

@OptIn(InternalAPI::class)
internal fun StringValuesBuilder.appendMissing(name: String, value: String) = appendMissing(name, listOf(value))

private const val SIGN = "sign"

@OptIn(InternalAPI::class)
internal fun StringValuesBuilder.sortAndSign(appSecret: String) {
    val sorted = entries().asSequence().filter { it.key != SIGN }.sortedBy { it.key }
    clear()
    sorted.forEach { (key, value) ->
        appendAll(key, value)
    }
    sorted.joinToString(separator = "&") { (key, value) ->
        value.joinToString(separator = "&") {
            "$key=${it.encodeURLParameter()}"
        }
    }.let {
        it + appSecret
    }.toMD5().let {
        append(SIGN, it)
    }
}
