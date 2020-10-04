package com.hiczp.bilibili.api.utils

import io.ktor.client.*
import io.ktor.client.features.logging.*
import org.slf4j.LoggerFactory

internal fun HttpClientConfig<*>.logging(func: () -> Unit) {
    install(Logging) {
        level = if (LoggerFactory.getLogger(func.javaClass).isDebugEnabled) {
            LogLevel.ALL
        } else {
            LogLevel.NONE
        }
    }
}
