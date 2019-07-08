package com.hiczp.bilibili.rest.ktor

import io.ktor.util.AttributeKey

internal const val FORCE_QUERY_COMMON_PARAMS = "ForceQueryCommonParams"

internal val FORCE_QUERY_COMMON_PARAMS_ATTRIBUTE_KEY = AttributeKey<String>(FORCE_QUERY_COMMON_PARAMS)
