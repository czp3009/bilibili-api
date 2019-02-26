package com.hiczp.bilibili.api.main.model

import com.google.gson.annotations.SerializedName

data class BangumiMore(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String, // success
        @SerializedName("result")
        var result: List<Result>
) {
    data class Result(
            @SerializedName("cover")
            var cover: String, // http://i0.hdslb.com/bfs/bangumi/5bac9515a50c880e55a772c194241ff9943e0004.png
            /**
             * cursor 的值有可能是科学计数法, 例如 1.550210400638E12
             * 如果不是最后一个 item 将没有这个字段
             */
            @SerializedName("cursor")
            var cursor: String?, // 1548172800112.0
            @SerializedName("desc")
            var desc: String, // 正在就读白凰女学院3年级的加藤茉莉香，是个拥有“私掠船免状”的合法宇宙海贼。她不仅是学生、宇宙艇部的部长、咖啡馆的服务员，还是宇宙海贼船·弁天丸的船长，每天都过着繁忙而充实的生活。某天，正在豪华客船上开展工作的茉莉香，在乘客名单中发现了拥有银河通行证的少年·无限彼方的名字……。少年与海贼的亚空冒险就此展开！
            @SerializedName("id")
            var id: Int, // 33409
            @SerializedName("is_new")
            var isNew: Int, // 0
            @SerializedName("link")
            var link: String, // https://www.bilibili.com/read/cv1831506
            @SerializedName("link_type")
            var linkType: Int, // 4
            @SerializedName("link_value")
            var linkValue: Int, // 0
            @SerializedName("pub_time")
            var pubTime: String, // 2019-01-23 00:00:00
            @SerializedName("simg")
            var simg: String,
            @SerializedName("title")
            var title: String, // 化身为刃，除魔四方——《多罗罗》
            @SerializedName("wid")
            var wid: Int // 81
    )
}
