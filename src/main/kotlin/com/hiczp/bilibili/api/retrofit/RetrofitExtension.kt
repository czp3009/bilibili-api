package com.hiczp.bilibili.api.retrofit

import okhttp3.FormBody

inline fun FormBody.forEach(block: (Pair<String, String>) -> Unit) {
    for (i in 0..size()) {
        block(encodedName(i) to encodedValue(i))
    }
}

fun FormBody.raw() =
        StringBuilder().apply {
            repeat(size()) {
                if (it != 0) append('&')
                append(encodedName(it))
                append('=')
                append(encodedValue(it))
            }
        }.toString()

fun FormBody.sortedRaw(): String {
    val nameAndValue = ArrayList<String>()
    repeat(size()) {
        nameAndValue.add("${encodedName(it)}=${encodedValue(it)}")
    }
    return nameAndValue.sorted().joinToString(separator = "&")
}

fun FormBody.Builder.addAll(formBody: FormBody): FormBody.Builder {
    formBody.forEach { (encodedName, encodedValue) ->
        addEncoded(encodedName, encodedValue)
    }
    return this
}
