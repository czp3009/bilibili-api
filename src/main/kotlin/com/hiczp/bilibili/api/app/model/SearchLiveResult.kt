package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchLiveResult(
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
            @SerializedName("live_master")
            var liveMaster: LiveMaster,
            @SerializedName("live_room")
            var liveRoom: LiveRoom,
            @SerializedName("pages")
            var pages: Int, // 3
            @SerializedName("total")
            var total: Int, // 0
            @SerializedName("trackid")
            var trackid: String // 14587616663833842975
    ) {
        data class LiveRoom(
                @SerializedName("items")
                var items: List<Item>,
                @SerializedName("pages")
                var pages: Int, // 3
                @SerializedName("total")
                var total: Int, // 57
                @SerializedName("trackid")
                var trackid: String
        ) {
            data class Item(
                    @SerializedName("area_v2_name")
                    var areaV2Name: String, // 300英雄
                    @SerializedName("attentions")
                    var attentions: Int, // 2
                    @SerializedName("badge")
                    var badge: String, // 直播
                    @SerializedName("cover")
                    var cover: String, // https://i0.hdslb.com/bfs/live/16181996f2260024f861db58d0d3dea2dd390930.jpg
                    @SerializedName("goto")
                    var goto: String, // live
                    @SerializedName("live_status")
                    var liveStatus: Int, // 2
                    @SerializedName("mid")
                    var mid: Long, // 82542745
                    @SerializedName("name")
                    var name: String, // SAO刀剑神域丶
                    @SerializedName("online")
                    var online: Int, // 7
                    @SerializedName("param")
                    var `param`: String, // 3387258
                    @SerializedName("region")
                    var region: Int, // 4
                    @SerializedName("roomid")
                    var roomid: Long, // 3387258
                    @SerializedName("tags")
                    var tags: String, // 点点关注
                    @SerializedName("title")
                    var title: String, // SAO刀剑神域丶的直播间
                    @SerializedName("type")
                    var type: String, // live_room
                    @SerializedName("uri")
                    var uri: String // bilibili://live/3387258?broadcast_type=0
            )
        }

        data class LiveMaster(
                @SerializedName("pages")
                var pages: Int, // 0
                @SerializedName("total")
                var total: Int, // 0
                @SerializedName("trackid")
                var trackid: String
        )
    }
}
