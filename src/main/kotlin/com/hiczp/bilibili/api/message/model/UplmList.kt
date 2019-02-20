package com.hiczp.bilibili.api.message.model

import com.google.gson.annotations.SerializedName

data class UplmList(
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
            @SerializedName("id")
            var id: Int, // 2429173
            @SerializedName("time")
            var time: String, // 2018-11-25 19:29:22
            @SerializedName("title")
            var title: String, // 叮！你有一份荣誉周报待查收！
            @SerializedName("unread")
            var unread: Int // 0
    )
}
