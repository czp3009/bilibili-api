package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class FavoriteVideo(
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
            @SerializedName("count")
            var count: Int, // 1
            @SerializedName("items")
            var items: List<Item>
    ) {
        data class Item(
                @SerializedName("aid")
                var aid: Int, // 30702
                @SerializedName("danmaku")
                var danmaku: Int, // 19363
                @SerializedName("goto")
                var goto: String, // av
                @SerializedName("name")
                var name: String, // ⑨搬运君
                @SerializedName("param")
                var `param`: String, // 30702
                @SerializedName("pic")
                var pic: String, // http://i1.hdslb.com/bfs/archive/76a045020b6aaa830121132d4a6536d6b82660f4.jpg
                @SerializedName("play_num")
                var playNum: Long, // 371718
                @SerializedName("title")
                var title: String, // 【整理发布】妄想学生会
                @SerializedName("ugc_pay")
                var ugcPay: Long, // 0
                @SerializedName("uri")
                var uri: String // bilibili://video/30702
        )
    }
}
