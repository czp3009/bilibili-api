package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class Sidebar(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: List<SidebarElement>,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ttl")
        var ttl: Int // 1
) {
    data class SidebarElement(
            @SerializedName("id")
            var id: Int, // 13
            @SerializedName("logo")
            var logo: String, // http://i0.hdslb.com/bfs/archive/91f7ba40e54502f7479c8d355e4298989bb8ebce.png
            @SerializedName("module")
            var module: Int, // 1
            @SerializedName("name")
            var name: String, // 会员购中心
            @SerializedName("online_time")
            var onlineTime: Int, // 0
            @SerializedName("param")
            var `param`: String, // bilibili://mall/mine?msource=mine
            @SerializedName("rank")
            var rank: Int, // 300
            @SerializedName("tip")
            var tip: Int // 1
    )
}
