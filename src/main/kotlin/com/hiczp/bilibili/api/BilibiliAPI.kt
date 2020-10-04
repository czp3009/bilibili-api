package com.hiczp.bilibili.api

import com.hiczp.bilibili.api.utils.logging
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import java.time.Instant

class BilibiliAPI(
    httpClientEngine: HttpClientEngine,
    bilibiliClientProperties: BilibiliClientProperties = BilibiliClientProperties.DEFAULT
) {
    val initTimestamp = Instant.now().epochSecond

    val passport = HttpClient(httpClientEngine) {
        install(UserAgent) {
            agent = bilibiliClientProperties.userAgent
        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        logging { }

        defaultRequest {
            println()
        }
    }
}
