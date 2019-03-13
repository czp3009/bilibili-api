package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchUserResult(
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
            @SerializedName("items")
            var items: List<Item>,
            @SerializedName("pages")
            var pages: Int, // 2
            @SerializedName("total")
            var total: Int, // 0
            @SerializedName("trackid")
            var trackid: String // 15623048138266462990
    ) {
        data class Item(
                @SerializedName("archives")
                var archives: Int, // 1
                @SerializedName("av_items")
                var avItems: List<AvItem>,
                @SerializedName("cover")
                var cover: String, // https://i0.hdslb.com/bfs/face/c3200c52ae76004fbbab44010990431d0604aee5.jpg
                @SerializedName("fans")
                var fans: Int, // 3
                @SerializedName("goto")
                var goto: String, // author
                @SerializedName("is_up")
                var isUp: Boolean, // true
                @SerializedName("level")
                var level: Int, // 3
                @SerializedName("live_status")
                var liveStatus: Int, // 1
                @SerializedName("live_uri")
                var liveUri: String, // bilibili://live/3234638?broadcast_type=0
                @SerializedName("mid")
                var mid: Long, // 32557668
                @SerializedName("official_verify")
                var officialVerify: OfficialVerify,
                @SerializedName("param")
                var `param`: String, // 32557668
                @SerializedName("roomid")
                var roomid: Long, // 3234638
                @SerializedName("sign")
                var sign: String, // 担心额刚好阿西
                @SerializedName("title")
                var title: String, // 刀剑神域小漠
                @SerializedName("uri")
                var uri: String // bilibili://author/32557668
        ) {
            data class OfficialVerify(
                    @SerializedName("type")
                    var type: Int // 127
            )

            data class AvItem(
                    @SerializedName("cover")
                    var cover: String, // https://i0.hdslb.com/bfs/archive/95be7c1a940dda2bbf4c33213df94eb650e44d10.jpg
                    @SerializedName("ctime")
                    var ctime: Int, // 1535755416
                    @SerializedName("danmaku")
                    var danmaku: Int, // 1
                    @SerializedName("duration")
                    var duration: String, // 3:1
                    @SerializedName("goto")
                    var goto: String, // av
                    @SerializedName("param")
                    var `param`: String, // 30843572
                    @SerializedName("play")
                    var play: Int, // 15
                    @SerializedName("title")
                    var title: String, // 官方认证：非洲正品大酋长
                    @SerializedName("uri")
                    var uri: String // bilibili://video/30843572?player_width=1920&player_height=1080&player_rotate=0
            )
        }
    }
}
