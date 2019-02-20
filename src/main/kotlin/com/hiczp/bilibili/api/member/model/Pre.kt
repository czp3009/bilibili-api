package com.hiczp.bilibili.api.member.model

import com.google.gson.annotations.SerializedName

data class Pre(
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
            @SerializedName("academy")
            var academy: Academy,
            @SerializedName("act")
            var act: Act,
            @SerializedName("creative")
            var creative: Creative,
            @SerializedName("entrance")
            var entrance: Entrance
    ) {
        data class Entrance(
                @SerializedName("guidance")
                var guidance: String, // 投稿
                @SerializedName("show")
                var show: Int // 1
        )

        data class Creative(
                @SerializedName("portal_list")
                var portalList: List<Portal>,
                @SerializedName("show")
                var show: Int // 1
        ) {
            data class Portal(
                    @SerializedName("icon")
                    var icon: String, // http://i0.hdslb.com/bfs/archive/31f485451e415bbbc59407f1fddce8f317db6287.png
                    @SerializedName("id")
                    var id: Int, // 0
                    @SerializedName("more")
                    var more: Int, // 0
                    @SerializedName("mtime")
                    var mtime: Int, // 1547466050
                    @SerializedName("new")
                    var new: Int, // 1
                    @SerializedName("position")
                    var position: Int, // 8
                    @SerializedName("subtitle")
                    var subtitle: String,
                    @SerializedName("title")
                    var title: String, // 更多功能
                    @SerializedName("url")
                    var url: String // activity://uper/user_center/more_portal
            )
        }

        data class Act(
                @SerializedName("show")
                var show: Int, // 1
                @SerializedName("title")
                var title: String, // 热门活动
                @SerializedName("url")
                var url: String // https://www.bilibili.com/blackboard/x/activity-tougao-h5/all
        )

        data class Academy(
                @SerializedName("show")
                var show: Int, // 0
                @SerializedName("title")
                var title: String,
                @SerializedName("url")
                var url: String
        )
    }
}
