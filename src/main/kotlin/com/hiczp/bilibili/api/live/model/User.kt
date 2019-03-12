package com.hiczp.bilibili.api.live.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // OK
        @SerializedName("msg")
        var msg: String // OK
) {
    data class Data(
            @SerializedName("gold")
            var gold: Int, // 0
            @SerializedName("isSign")
            var isSign: Int, // 0
            @SerializedName("medal")
            var medal: JsonElement?, // null
            @SerializedName("new")
            var new: Int, // 1
            @SerializedName("room_id")
            var roomId: Long, // 1110317
            @SerializedName("silver")
            var silver: Int, // 140258
            @SerializedName("svip")
            var svip: Int, // 0
            @SerializedName("svip_time")
            var svipTime: String, // 0000-00-00 00:00:00
            @SerializedName("use_count")
            var useCount: Int, // 0
            @SerializedName("user_level")
            var userLevel: Int, // 25
            @SerializedName("user_level_color")
            var userLevelColor: Int, // 5805790
            @SerializedName("vip")
            var vip: Int, // 0
            @SerializedName("vip_time")
            var vipTime: String, // 2018-05-15 12:00:50
            @SerializedName("vip_view_status")
            var vipViewStatus: Int, // 1
            @SerializedName("wearTitle")
            var wearTitle: WearTitle
    ) {
        data class WearTitle(
                @SerializedName("activity")
                var activity: String, // 0
                @SerializedName("title")
                var title: String // 0
        )
    }
}
