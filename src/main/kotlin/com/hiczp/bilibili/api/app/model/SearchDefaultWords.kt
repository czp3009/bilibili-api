package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchDefaultWords(
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
            @SerializedName("param")
            var `param`: String, // 5157193909505109430
            @SerializedName("show")
            var show: String, // 如果绝地求生也能滑铲
            @SerializedName("trackid")
            var trackid: String, // 14016083035920227490
            @SerializedName("word")
            var word: String // av46169875
    )
}
