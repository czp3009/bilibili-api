package com.hiczp.bilibili.api.main.model

import com.google.gson.annotations.SerializedName

data class CreateRelationTagResponse(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ttl")
        var ttl: Int // 1
) {
    @Suppress("SpellCheckingInspection")
    data class Data(
            @SerializedName("tagid")
            var tagid: Int // 110641
    )
}
