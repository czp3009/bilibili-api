package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchMovieResult(
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
            var pages: Int, // 1
            @SerializedName("total")
            var total: Int, // 2
            @SerializedName("trackid")
            var trackid: String // 11415000413319714311
    ) {
        data class Item(
                @SerializedName("area")
                var area: String, // 日本
                @SerializedName("badge")
                var badge: String, // 电影
                /**
                 * badge 的特殊样式
                 */
                @SerializedName("badges")
                var badges: List<Map<String, String>>,
                @SerializedName("cover")
                var cover: String, // https://i0.hdslb.com/bfs/bangumi/aef914fac9edfa518c4df9a82d5d3d0cba08a451.jpg
                /**
                 * 类型为 纪录片 时没有 cv, 其他一些字段同理
                 */
                @SerializedName("cv")
                var cv: String?, // 曹旭鹏、阎萌萌、碧涓、惠霖、梦娇
                /**
                 * 有些纪录片有分集, 有些没有
                 */
                @SerializedName("episodes")
                var episodes: List<Episode>?,
                @SerializedName("goto")
                var goto: String, // movie
                /**
                 * 一些纪录片没有 label, 其他一些字段同理
                 */
                @SerializedName("label")
                var label: String?, // 演员：曹旭鹏、阎萌萌、碧涓、惠霖、梦娇
                /**
                 * 2 为剧场版动画, 3 为纪录片
                 */
                @SerializedName("media_type")
                var mediaType: Int, // 2
                @SerializedName("param")
                var `param`: String, // 115472
                @SerializedName("ptime")
                var ptime: Long, // 1505404800
                @SerializedName("rating")
                var rating: Double, // 5.8
                @SerializedName("season_id")
                var seasonId: Int, // 12767
                @SerializedName("season_type")
                var seasonType: Int, // 2
                @SerializedName("season_type_name")
                var seasonTypeName: String, // 电影
                @SerializedName("staff")
                var staff: String?, // 导演：伊藤智彦编剧：川原砾
                @SerializedName("style")
                var style: String, // 科幻/动画
                @SerializedName("title")
                var title: String, // 刀剑神域：序列之争（中文）
                @SerializedName("uri")
                var uri: String, // https://www.bilibili.com/bangumi/play/ss12767/
                @SerializedName("vote")
                var vote: Int? // 581
        ) {
            data class Episode(
                    @SerializedName("index")
                    var index: String, // 4
                    @SerializedName("param")
                    var `param`: String, // 250006
                    @SerializedName("uri")
                    var uri: String // https://www.bilibili.com/bangumi/play/ep250006
            )
        }
    }
}
