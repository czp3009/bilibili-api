package com.hiczp.bilibili.api.main.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class DeleteLog(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ttl")
        var ttl: Int // 1
) {
    data class Data(
            @SerializedName("logs")
            var logs: JsonElement?, // null
            @SerializedName("page")
            var page: Page,
            @SerializedName("reply_count")
            var replyCount: Int, // 11
            @SerializedName("report_count")
            var reportCount: Int // 28
    ) {
        data class Page(
                @SerializedName("num")
                var num: Int, // 1
                @SerializedName("pages")
                var pages: Int, // 0
                @SerializedName("size")
                var size: Int, // 20
                @SerializedName("total")
                var total: Int // 0
        )
    }
}
