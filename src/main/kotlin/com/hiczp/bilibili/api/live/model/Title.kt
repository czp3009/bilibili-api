package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class Title(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: List<Title>,
        @SerializedName("message")
        var message: String, // success
        @SerializedName("msg")
        var msg: String // success
) {
    data class Title(
            @SerializedName("colorful")
            var colorful: Int, // 0
            @SerializedName("height")
            var height: Int, // 20
            @SerializedName("id")
            var id: String, // cake-flour
            @SerializedName("img")
            var img: String, // https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/cake-flour.png?20180726173300
            @SerializedName("is_lihui")
            var isLihui: Int, // 0
            @SerializedName("lihui_height")
            var lihuiHeight: Int, // 0
            @SerializedName("lihui_img")
            var lihuiImg: String,
            @SerializedName("lihui_width")
            var lihuiWidth: Int, // 0
            @SerializedName("title")
            var title: String, // 2016 新春活动
            @SerializedName("width")
            var width: Int // 68
    )
}
