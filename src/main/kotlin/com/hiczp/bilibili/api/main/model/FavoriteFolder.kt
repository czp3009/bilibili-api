package com.hiczp.bilibili.api.main.model

import com.google.gson.annotations.SerializedName

data class FavoriteFolder(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: List<Data>,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ttl")
        var ttl: Int // 1
) {
    data class Data(
            @SerializedName("atten_count")
            var attenCount: Int, // 0
            @SerializedName("cover")
            var cover: List<Cover>,
            @SerializedName("ctime")
            var ctime: Long, // 1451133174
            @SerializedName("cur_count")
            var curCount: Int, // 1
            @SerializedName("favoured")
            var favoured: Int, // 0
            @SerializedName("fid")
            var fid: Long, // 795158
            @SerializedName("max_count")
            var maxCount: Int, // 50000
            @SerializedName("media_id")
            var mediaId: Long, // 79515830
            @SerializedName("mid")
            var mid: Long, // 20293030
            @SerializedName("mtime")
            var mtime: Long, // 1544629663
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
