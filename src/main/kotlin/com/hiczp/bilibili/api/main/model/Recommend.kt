package com.hiczp.bilibili.api.main.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Recommend(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String, // success
        @SerializedName("result")
        var result: Result
) {
    data class Result(
            @SerializedName("card")
            var card: JsonElement,  // []
            @SerializedName("relates")
            var relates: List<Relate>,
            @SerializedName("season")
            var season: List<Season>
    ) {
        data class Season(
                @SerializedName("badge")
                var badge: String, // 会员抢先
                @SerializedName("badge_type")
                var badgeType: Int, // 0
                @SerializedName("cover")
                var cover: String, // http://i0.hdslb.com/bfs/bangumi/3fc16a667502cbff226e585eb660a96a20c7458c.png
                @SerializedName("from")
                var from: Int, // 0
                @SerializedName("new_ep")
                var newEp: NewEp,
                @SerializedName("rating")
                var rating: Rating,
                @SerializedName("season_id")
                var seasonId: Int, // 26146
                @SerializedName("season_type")
                var seasonType: Int, // 1
                @SerializedName("stat")
                var stat: Stat,
                @SerializedName("title")
                var title: String, // 多罗罗
                @SerializedName("url")
                var url: String // http://www.bilibili.com/bangumi/play/ss26146
        ) {
            data class NewEp(
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/archive/7dec9d820b82ee57ebde0ba5c186b63e1e728abd.jpg
                    @SerializedName("index_show")
                    var indexShow: String // 更新至第7话
            )

            data class Rating(
                    @SerializedName("count")
                    var count: Long, // 22916
                    @SerializedName("score")
                    var score: Double // 9.8
            )

            data class Stat(
                    @SerializedName("danmaku")
                    var danmaku: Int, // 435439
                    @SerializedName("follow")
                    var follow: Int, // 2073877
                    @SerializedName("view")
                    var view: Int // 24884016
            )
        }

        data class Relate(
                @SerializedName("desc1")
                var desc1: String, // 【萌羽Moeyu】魔法禁书目录御坂美琴易拉罐保温杯
                @SerializedName("desc2")
                var desc2: String, // 295
                @SerializedName("item_id")
                var itemid: Long, // 10005816
                @SerializedName("pic")
                var pic: String, // https://i0.hdslb.com/bfs/mall/mall/c3/f0/c3f029d8221c6ecc96bd1ab321034bc2.jpg
                @SerializedName("title")
                var title: String, // 【现货即发】魔法禁书目录正版授权，Moeyu出品。
                @SerializedName("type")
                var type: Int, // 1
                @SerializedName("type_name")
                var typeName: String, // 商品
                @SerializedName("url")
                var url: String // bilibili://mall/web?url=https%3A%2F%2Fmall.bilibili.com%2Fdetail.html%3FitemsId%3D10005816%26msource%3Dfanju_25617_10005816%26noTitleBar%3D1%26loadingShow%3D1
        )
    }
}
