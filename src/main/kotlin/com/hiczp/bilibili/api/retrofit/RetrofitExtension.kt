package com.hiczp.bilibili.api.retrofit

import okhttp3.FormBody

inline fun FormBody.forEach(block: (String, String) -> Unit) {
    repeat(size()) {
        block(encodedName(it), encodedValue(it))
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

fun FormBody.containsEncodedName(name: String): Boolean {
    repeat(size()) {
        if (encodedName(it) == name) return true
    }
    return false
}

fun FormBody.Builder.addAllEncoded(formBody: FormBody): FormBody.Builder {
    with(formBody) {
        repeat(size()) {
            addEncoded(encodedName(it), encodedValue(it))
        }
    }
    return this
}

internal inline fun Array<out Pair<String, () -> String?>>.forEachNonNull(action: (String, String) -> Unit) {
    forEach { (name, valueExpression) ->
        val value = valueExpression()
        if (value != null) {
            action(name, value)
        }
    }
}
