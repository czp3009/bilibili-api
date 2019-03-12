package com.hiczp.bilibili.api.live.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class UserInfoInRoom(
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
            @SerializedName("entry_effect")
            var entryEffect: EntryEffect,
            @SerializedName("gift")
            var gift: Gift,
            @SerializedName("info")
            var info: Info,
            @SerializedName("level")
            var level: Level,
            @SerializedName("new")
            var new: Int, // 1
            @SerializedName("privilege")
            var privilege: Privilege,
            @SerializedName("role")
            var role: Role,
            @SerializedName("room_admin")
            var roomAdmin: RoomAdmin,
            @SerializedName("wallet")
            var wallet: Wallet
    ) {
        data class Wallet(
                @SerializedName("gold")
                var gold: String, // 0
                @SerializedName("silver")
                var silver: String // 140258
        )

        data class Info(
                @SerializedName("bili_vip")
                var biliVip: Int, // 0
                @SerializedName("face")
                var face: String, // https://i1.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg
                @SerializedName("gender")
                var gender: Int, // 0
                @SerializedName("identification")
                var identification: Int, // 1
                @SerializedName("mobile_verify")
                var mobileVerify: Int, // 1
                @SerializedName("mobile_virtual")
                var mobileVirtual: Int, // 0
                @SerializedName("official_verify")
                var officialVerify: OfficialVerify,
                @SerializedName("platform_user_level")
                var platformUserLevel: Int, // 4
                @SerializedName("rank")
                var rank: String, // 10000
                @SerializedName("uid")
                var uid: Long, // 20293030
                @SerializedName("uname")
                var uname: String, // czp3009
                @SerializedName("vip_type")
                var vipType: Int // 0
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
                @SerializedName("color")
                var color: Int, // 5805790
                @SerializedName("cost")
                var cost: Int, // 52187800
                @SerializedName("is_show_vip_broadcast")
                var isShowVipBroadcast: Int, // 0
                @SerializedName("master_level")
                var masterLevel: MasterLevel,
                @SerializedName("rcost")
                var rcost: Int, // 2737665
                @SerializedName("svip")
                var svip: Int, // 0
                @SerializedName("svip_time")
                var svipTime: String, // 0000-00-00 00:00:00
                @SerializedName("uid")
                var uid: Int, // 20293030
                @SerializedName("update_time")
                var updateTime: String, // 0000-00-00 00:00:00
                @SerializedName("user_level")
                var userLevel: Int, // 25
                @SerializedName("user_level_rank")
                var userLevelRank: String, // >50000
                @SerializedName("user_score")
                var userScore: String, // 0
                @SerializedName("vip")
                var vip: Int, // 0
                @SerializedName("vip_time")
                var vipTime: String // 2018-05-15 12:00:50
        ) {
            data class MasterLevel(
                    @SerializedName("color")
                    var color: Int, // 5805790
                    @SerializedName("current")
                    var current: List<Int>,
                    @SerializedName("level")
                    var level: Int, // 11
                    @SerializedName("next")
                    var next: List<Int>
            )
        }

        data class RoomAdmin(
                @SerializedName("is_admin")
                var isAdmin: Int // 0
        )

        data class Role(
                @SerializedName("info")
                var info: Info,
                @SerializedName("role_id")
                var roleId: Int, // 2
                @SerializedName("role_name")
                var roleName: String // 播主
        ) {
            data class Info(
                    @SerializedName("roomid")
                    var roomid: Long // 1110317
            )
        }

        data class EntryEffect(
                @SerializedName("basemap_url")
                var basemapUrl: String,
                @SerializedName("copy_writing")
                var copyWriting: String,
                @SerializedName("effective_time")
                var effectiveTime: Int, // 0
                @SerializedName("face")
                var face: String, // https://i1.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg
                @SerializedName("highlight_color")
                var highlightColor: String,
                @SerializedName("id")
                var id: Int, // 0
                @SerializedName("mock_effect")
                var mockEffect: Int, // 0
                @SerializedName("priority")
                var priority: Int, // 0
                @SerializedName("privilege_type")
                var privilegeType: Int, // 0
                @SerializedName("show_avatar")
                var showAvatar: Int, // 0
                @SerializedName("target_id")
                var targetId: Long, // 2866663
                @SerializedName("uid")
                var uid: Long // 20293030
        )

        data class Privilege(
                @SerializedName("broadcast")
                var broadcast: JsonElement?, // null
                @SerializedName("notice_status")
                var noticeStatus: Int // 1
        )

        data class Gift(
                @SerializedName("is_show")
                var isShow: String, // 1
                @SerializedName("uid")
                var uid: Long // 20293030
        )
    }
}
