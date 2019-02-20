package com.hiczp.bilibili.api.message.model

import com.google.gson.annotations.SerializedName

data class NotifyCount(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String,
        @SerializedName("msg")
        var msg: String
) {
    data class Data(
            @SerializedName("_gt_")
            var gt: Int, // 0
            /**
             * \@我
             */
            @SerializedName("at_me")
            var atMe: Int, // 0
            @SerializedName("notify_me")
            var notifyMe: Int, // 9
            /**
             * 收到的赞
             */
            @SerializedName("praise_me")
            var praiseMe: Int, // 0
            /**
             * 回复我的
             */
            @SerializedName("reply_me")
            var replyMe: Int, // 0
            @SerializedName("up")
            var up: Int // 0
    )
}
