package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class LikeResponse(
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
            /**
             * 取消点赞时 toast 为 ""
             */
            @SerializedName("toast")
            var toast: String // 点赞收到！视频可能推荐哦
    )
}
