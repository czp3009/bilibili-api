package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchHot(
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
            var list: List<Hot>,
            @SerializedName("trackid")
            var trackid: String // 3482080616107297898
    ) {
        data class Hot(
                @SerializedName("keyword")
                var keyword: String, // 凹凸世界
                @SerializedName("name_type")
                var nameType: String,
                @SerializedName("status")
                var status: String
        )
    }
}
