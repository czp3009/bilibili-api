package com.hiczp.bilibili.api.main.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class BangumiPage(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String, // success
        @SerializedName("result")
        var result: Result
) {
    data class Result(
            @SerializedName("modules")
            var modules: List<Module>,
            @SerializedName("regions")
            var regions: List<Region>
    ) {
        data class Module(
                @SerializedName("attr")
                var attr: Attr,
                @SerializedName("headers")
                var headers: List<JsonElement>,
                @SerializedName("items")
                var items: List<Item>,
                @SerializedName("module_id")
                var moduleId: Int, // 6
                @SerializedName("size")
                var size: Int, // 10
                @SerializedName("style")
                var style: String, // fall
                @SerializedName("title")
                var title: String, // 编辑推荐
                @SerializedName("wid")
                var wid: List<Int>
        ) {
            data class Item(
                    @SerializedName("badge")
                    var badge: String, // NEW
                    @SerializedName("badge_type")
                    var badgeType: Int, // 0
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/bangumi/57e00f9995459ab0cf40800358ee7f3b392b38a4.jpg
                    @SerializedName("cursor")
                    var cursor: String, // 1.55021040036E12
                    @SerializedName("desc")
                    var desc: String, // 明明是最差劲的相遇，但雏却不知何时开始无法停止心动。雏被初中时的学长·恋雪所吸引，决定和他进入同所高中而拼命学习。并且，和青梅竹马的虎太朗一同进入了樱丘高中。曾经单调乏味的恋雪，为了自己单相思的对象，而在假日结束后改换了形象，变得受欢迎起来。在这种状况下，雏决定要「告白」，但是——！？
                    @SerializedName("is_new")
                    var isNew: Int, // 0
                    @SerializedName("item_id")
                    var itemid: Long, // 34265
                    @SerializedName("link")
                    var link: String, // https://www.bilibili.com/blackboard/topic/activity-dm4qK4-BI.html
                    @SerializedName("title")
                    var title: String, // 【资讯档】2019年第7周
                    @SerializedName("wid")
                    var wid: Int // 78
            )

            data class Attr(
                    @SerializedName("follow")
                    var follow: Int, // 0
                    @SerializedName("header")
                    var header: Int, // 1
                    @SerializedName("random")
                    var random: Int // 0
            )
        }

        data class Region(
                @SerializedName("icon")
                var icon: String, // http://i0.hdslb.com/bfs/bangumi/3b66adc7339e62d469ea5b89a45c74e14e3ae831.png
                @SerializedName("title")
                var title: String, // 点评
                @SerializedName("url")
                var url: String // bilibili://pgc/review/index
        )
    }
}
