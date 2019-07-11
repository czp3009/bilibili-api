package com.hiczp.bilibili.rest.ktor

import io.ktor.util.AttributeKey

internal const val FORCE_QUERY_COMMON_PARAMS = "ForceQueryCommonParams"

internal val FORCE_QUERY_COMMON_PARAMS_ATTRIBUTE_KEY = AttributeKey<String>(FORCE_QUERY_COMMON_PARAMS)

internal const val APP_KEY = "AppKey"

internal val APP_KEY_ATTRIBUTE_KEY = AttributeKey<String>(APP_KEY)

internal const val APP_SECRET = "AppSecret"

internal val APP_SECRET_ATTRIBUTE_KEY = AttributeKey<String>(APP_SECRET)
