package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class FavoritePage(
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
            @SerializedName("favorite")
            var favorite: Favorite,
            @SerializedName("tab")
            var tab: Tab
    ) {
        data class Favorite(
                @SerializedName("count")
                var count: Int, // 1
                @SerializedName("items")
                var items: List<Item>
        ) {
            data class Item(
                    /**
                     * 如果该收藏夹最后一个视频被删除了, 那么将没有封面
                     */
                    @SerializedName("cover")
                    var cover: List<Cover>?, // null
                    @SerializedName("cur_count")
                    var curCount: Int, // 1
                    @SerializedName("fid")
                    var fid: Long, // 795158
                    @SerializedName("media_id")
                    var mediaId: Long, // 79515830
                    @SerializedName("mid")
                    var mid: Long, // 20293030
                    @SerializedName("name")
                    var name: String, // 默认收藏夹
                    @SerializedName("state")
                    var state: Int // 0
            ) {
                data class Cover(
                        @SerializedName("aid")
                        var aid: Long, // 9498716
                        @SerializedName("pic")
                        var pic: String, // http://i2.hdslb.com/bfs/archive/3536b8de71da4dd7bf01200db1e6c710b5f4aa0e.png
                        @SerializedName("type")
                        var type: Int // 2
                )
            }
        }

        data class Tab(
                @SerializedName("albums")
                var albums: Boolean, // false
                @SerializedName("article")
                var article: Boolean, // true
                @SerializedName("audios")
                var audios: Boolean, // false
                @SerializedName("cinema")
                var cinema: Boolean, // true
                @SerializedName("clips")
                var clips: Boolean, // false
                @SerializedName("favorite")
                var favorite: Boolean, // true
                @SerializedName("menu")
                var menu: Boolean, // false
                @SerializedName("pgc_menu")
                var pgcMenu: Boolean, // false
                @SerializedName("product")
                var product: Boolean, // false
                @SerializedName("specil")
                var specil: Boolean, // false
                @SerializedName("ticket")
                var ticket: Boolean, // false
                @SerializedName("topic")
                var topic: Boolean // false
        )
    }
}
