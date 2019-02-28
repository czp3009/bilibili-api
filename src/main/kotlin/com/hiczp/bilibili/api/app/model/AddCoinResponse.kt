package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class AddCoinResponse(
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
            @SerializedName("like")
            var like: Boolean, // false
            @SerializedName("prompt")
            var prompt: Boolean? // true
    )
}
