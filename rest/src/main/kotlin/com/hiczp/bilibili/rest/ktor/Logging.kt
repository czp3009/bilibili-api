package com.hiczp.bilibili.rest.ktor

import io.ktor.client.HttpClientConfig
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import org.slf4j.LoggerFactory

fun HttpClientConfig<*>.logging(func: () -> Unit) {
    install(Logging) {
        level = if (LoggerFactory.getLogger(func.javaClass).isDebugEnabled) {
            LogLevel.ALL
        } else {
            LogLevel.NONE
        }
    }
}
