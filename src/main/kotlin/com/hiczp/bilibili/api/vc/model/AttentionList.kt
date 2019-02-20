package com.hiczp.bilibili.api.vc.model

import com.google.gson.annotations.SerializedName

data class AttentionList(
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
            @SerializedName("list")
            var list: List<String>
    )
}
