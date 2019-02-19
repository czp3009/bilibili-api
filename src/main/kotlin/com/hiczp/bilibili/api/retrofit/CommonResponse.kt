package com.hiczp.bilibili.api.retrofit

import com.google.gson.annotations.SerializedName

data class CommonResponse(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String?,
        @SerializedName("ts")
        var ts: Int // 1550546539
)
