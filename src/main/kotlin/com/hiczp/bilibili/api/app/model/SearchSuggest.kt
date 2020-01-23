package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchSuggest(
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
            @SerializedName("list")
            var list: List<Suggest>,
            @SerializedName("trackid")
            var trackid: String // 8544564822819789247
    ) {
        data class Suggest(
                @SerializedName("from")
                var from: String, // search
                @SerializedName("keyword")
                var keyword: String, // 刀剑神域 ALICIZATION
                @SerializedName("position")
                var position: Int, // 10
                @SerializedName("sug_type")
                var sugType: String?, // 番剧
                @SerializedName("term_type")
                var termType: Int, // 8
                @SerializedName("title")
                var title: String // 刀剑神域 ALICIZATION
        )
    }
}
