package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class AnchorInRoom(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // success
        @SerializedName("msg")
        var msg: String // success
) {
    data class Data(
            @SerializedName("info")
            var info: Info,
            @SerializedName("level")
            var level: Level,
            @SerializedName("san")
            var san: Int // 12
    ) {
        data class Info(
                @SerializedName("face")
                var face: String, // https://i0.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg
                @SerializedName("gender")
                var gender: Int, // 0
                @SerializedName("identification")
                var identification: Int?, // 1
                @SerializedName("mobile_verify")
                var mobileVerify: Int, // 0
                @SerializedName("official_verify")
                var officialVerify: OfficialVerify,
                @SerializedName("platform_user_level")
                var platformUserLevel: Int, // 5
                @SerializedName("rank")
                var rank: String, // 10000
                @SerializedName("uid")
                var uid: Long, // 2866663
                @SerializedName("uname")
                var uname: String, // hyx5020
                @SerializedName("vip_type")
                var vipType: Int // 2
        ) {
            data class OfficialVerify(
                    @SerializedName("desc")
                    var desc: String,
                    @SerializedName("role")
                    var role: Int, // 0
                    @SerializedName("type")
                    var type: Int // -1
            )
        }

        data class Level(
                @SerializedName("anchor_score")
                var anchorScore: Int, // 36685
                @SerializedName("color")
                var color: Int, // 5805790
                @SerializedName("cost")
                var cost: Int, // 29431298
                @SerializedName("master_level")
                var masterLevel: MasterLevel,
                @SerializedName("rcost")
                var rcost: Long, // 3668592
                @SerializedName("svip")
                var svip: Int, // 0
                @SerializedName("svip_time")
                var svipTime: String, // 2019-02-09 11:03:54
                @SerializedName("uid")
                var uid: Int, // 2866663
                @SerializedName("update_time")
                var updateTime: String, // 2019-03-12 23:00:42
                @SerializedName("user_level")
                var userLevel: Int, // 22
                @SerializedName("user_score")
                var userScore: String, // 0
                @SerializedName("vip")
                var vip: Int, // 0
                @SerializedName("vip_time")
                var vipTime: String // 2019-02-09 11:03:54
        ) {
            data class MasterLevel(
                    @SerializedName("anchor_score")
                    var anchorScore: Int, // 36685
                    @SerializedName("color")
                    var color: Int, // 5805790
                    @SerializedName("current")
                    var current: List<Int>,
                    @SerializedName("level")
                    var level: Int, // 11
                    @SerializedName("master_level_color")
                    var masterLevelColor: Int, // 5805790
                    @SerializedName("next")
                    var next: List<Int>,
                    @SerializedName("sort")
                    var sort: String, // >10000
                    @SerializedName("upgrade_score")
                    var upgradeScore: Int // 2925
            )
        }
    }
}
