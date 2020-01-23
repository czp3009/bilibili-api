package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class RoomMessage(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String,
        @SerializedName("msg")
        var msg: String
) {
    data class Data(
            @SerializedName("admin")
            var admin: List<Admin>,
            @SerializedName("room")
            var room: List<Message>
    ) {
        data class Message(
                @SerializedName("bubble")
                var bubble: Int, // 0
                @SerializedName("check_info")
                var checkInfo: CheckInfo,
                @SerializedName("guard_level")
                var guardLevel: Int, // 0
                @SerializedName("isadmin")
                var isadmin: Int, // 0
                @SerializedName("medal")
                var medal: List<String>,   //[ 17, "毛菇","猫菇椰汁",923614,16752445,""]
                @SerializedName("nickname")
                var nickname: String, // 柠檬味狗凉゜
                @SerializedName("rank")
                var rank: Int, // 10000
                @SerializedName("rnd")
                var rnd: String, // 1552452731
                @SerializedName("svip")
                var svip: Int, // 1
                @SerializedName("teamid")
                var teamid: Int, // 0
                @SerializedName("text")
                var text: String, // 当前有效总督房:14979272;146
                @SerializedName("timeline")
                var timeline: String, // 2019-03-13 12:52:09
                @SerializedName("title")
                var title: List<String>,
                @SerializedName("uid")
                var uid: Int, // 1615204
                @SerializedName("uname_color")
                var unameColor: String,
                /**
                 * 有可能是 >50000 这样的东西, 下同
                 */
                @SerializedName("user_level")
                var userLevel: List<String>,
                @SerializedName("user_title")
                var userTitle: String,
                @SerializedName("vip")
                var vip: Int // 1
        ) {
            data class CheckInfo(
                    @SerializedName("ct")
                    var ct: String, // 4B9A2E41
                    @SerializedName("ts")
                    var ts: Int // 1552452729
            )
        }

        data class Admin(
                @SerializedName("bubble")
                var bubble: Int, // 2
                @SerializedName("check_info")
                var checkInfo: CheckInfo,
                @SerializedName("guard_level")
                var guardLevel: Int, // 2
                @SerializedName("isadmin")
                var isadmin: Int, // 1
                @SerializedName("medal")
                var medal: List<String>,
                @SerializedName("nickname")
                var nickname: String, // 沧澜ベ
                @SerializedName("rank")
                var rank: Int, // 10000
                @SerializedName("rnd")
                var rnd: String, // 350761541
                @SerializedName("svip")
                var svip: Int, // 1
                @SerializedName("teamid")
                var teamid: Int, // 0
                @SerializedName("text")
                var text: String, // 下个号见
                @SerializedName("timeline")
                var timeline: String, // 2019-03-13 12:54:42
                @SerializedName("title")
                var title: List<String>,
                @SerializedName("uid")
                var uid: Long, // 11626554
                @SerializedName("uname_color")
                var unameColor: String, // #e91e63
                @SerializedName("user_level")
                var userLevel: List<String>,
                @SerializedName("user_title")
                var userTitle: String, // title-181-1
                @SerializedName("vip")
                var vip: Int // 1
        ) {
            data class CheckInfo(
                    @SerializedName("ct")
                    var ct: String, // D1012BA7
                    @SerializedName("ts")
                    var ts: Long // 1552452882
            )
        }
    }
}
