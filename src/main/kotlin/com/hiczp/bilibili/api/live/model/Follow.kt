package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class Follow(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // success
        @SerializedName("msg")
        var msg: String // success
) {
    data class Data(
            @SerializedName("follow")
            var follow: Int // 0
    )
}
