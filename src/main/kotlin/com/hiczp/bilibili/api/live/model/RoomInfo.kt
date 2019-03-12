package com.hiczp.bilibili.api.live.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class RoomInfo(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // ok
        @SerializedName("msg")
        var msg: String // ok
) {
    data class Data(
            @SerializedName("allow_change_area_time")
            var allowChangeAreaTime: Int, // 0
            @SerializedName("allow_upload_cover_time")
            var allowUploadCoverTime: Int, // 0
            @SerializedName("area_id")
            var areaId: Int, // 107
            @SerializedName("area_name")
            var areaName: String, // 其他游戏
            @SerializedName("area_pendants")
            var areaPendants: String,
            @SerializedName("attention")
            var attention: Int, // 62
            @SerializedName("background")
            var background: String,
            @SerializedName("description")
            var description: String, // <p>立即安装Jetbrains, 享受精彩人生!</p>
            @SerializedName("hot_words")
            var hotWords: List<String>,
            @SerializedName("hot_words_status")
            var hotWordsStatus: Int, // 0
            @SerializedName("is_anchor")
            var isAnchor: Int, // 1
            @SerializedName("is_portrait")
            var isPortrait: Boolean, // false
            @SerializedName("is_strict_room")
            var isStrictRoom: Boolean, // false
            @SerializedName("keyframe")
            var keyframe: String, // https://i0.hdslb.com/bfs/live/1110317.jpg?03092037
            @SerializedName("live_status")
            var liveStatus: Int, // 0
            @SerializedName("live_time")
            var liveTime: String, // 0000-00-00 00:00:00
            @SerializedName("new_pendants")
            var newPendants: NewPendants,
            @SerializedName("old_area_id")
            var oldAreaId: Int, // 1
            @SerializedName("online")
            var online: Int, // 18
            @SerializedName("parent_area_id")
            var parentAreaId: Int, // 2
            @SerializedName("parent_area_name")
            var parentAreaName: String, // 网游
            @SerializedName("pendants")
            var pendants: String,
            @SerializedName("pk_id")
            var pkId: Int, // 0
            @SerializedName("pk_status")
            var pkStatus: Int, // 0
            @SerializedName("room_id")
            var roomId: Long, // 1110317
            @SerializedName("room_silent_level")
            var roomSilentLevel: Int, // 0
            @SerializedName("room_silent_second")
            var roomSilentSecond: Int, // 0
            @SerializedName("room_silent_type")
            var roomSilentType: String,
            @SerializedName("short_id")
            var shortId: Int, // 0
            @SerializedName("tags")
            var tags: String, // 编程
            @SerializedName("title")
            var title: String, // 太空程序员
            @SerializedName("uid")
            var uid: Long, // 20293030
            @SerializedName("up_session")
            var upSession: String,
            @SerializedName("user_cover")
            var userCover: String, // https://i0.hdslb.com/bfs/live/b4d4dbf35f7a30fb6b0a2ea4077514235262797e.jpg
            @SerializedName("verify")
            var verify: String
    ) {
        data class NewPendants(
                @SerializedName("badge")
                var badge: JsonElement?, // null
                @SerializedName("frame")
                var frame: JsonElement?, // null
                @SerializedName("mobile_badge")
                var mobileBadge: JsonElement?, // null
                @SerializedName("mobile_frame")
                var mobileFrame: JsonElement? // null
        )
    }
}
