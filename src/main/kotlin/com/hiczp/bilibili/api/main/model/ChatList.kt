package com.hiczp.bilibili.api.main.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class ChatList(
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
            @SerializedName("config")
            var config: Config,
            @SerializedName("cursor")
            var cursor: Cursor,
            @SerializedName("dialog")
            var dialog: Dialog,
            @SerializedName("replies")
            var replies: List<Reply>
    ) {
        data class Reply(
                @SerializedName("action")
                var action: Int, // 0
                @SerializedName("assist")
                var assist: Int, // 0
                @SerializedName("attr")
                var attr: Int, // 8
                @SerializedName("content")
                var content: Content,
                @SerializedName("count")
                var count: Int, // 0
                @SerializedName("ctime")
                var ctime: Int, // 1541824116
                @SerializedName("dialog")
                var dialog: Long, // 1136351035
                @SerializedName("dialog_str")
                var dialogStr: String,
                @SerializedName("fansgrade")
                var fansgrade: Int, // 0
                @SerializedName("floor")
                var floor: Int, // 172
                @SerializedName("folder")
                var folder: Folder,
                @SerializedName("like")
                var like: Int, // 0
                @SerializedName("member")
                var member: Member,
                @SerializedName("mid")
                var mid: Long, // 161745277
                @SerializedName("oid")
                var oid: Long, // 34175504
                @SerializedName("parent")
                var parent: Int, // 1136656601
                @SerializedName("parent_str")
                var parentStr: String, // 1136656601
                @SerializedName("rcount")
                var rcount: Int, // 0
                @SerializedName("replies")
                var replies: JsonElement?, // null
                @SerializedName("root")
                var root: Long, // 1136310360
                @SerializedName("root_str")
                var rootStr: String, // 1136310360
                @SerializedName("rpid")
                var rpid: Long, // 1175989845
                @SerializedName("rpid_str")
                var rpidStr: String, // 1175989845
                @SerializedName("state")
                var state: Int, // 2
                @SerializedName("type")
                var type: Int, // 1
                @SerializedName("up_action")
                var upAction: UpAction
        ) {
            data class UpAction(
                    @SerializedName("like")
                    var like: Boolean, // false
                    @SerializedName("reply")
                    var reply: Boolean // false
            )

            data class Member(
                    @SerializedName("DisplayRank")
                    var displayRank: String, // 0
                    @SerializedName("avatar")
                    var avatar: String, // http://static.hdslb.com/images/member/noface.gif
                    @SerializedName("fans_detail")
                    var fansDetail: JsonElement?, // null
                    @SerializedName("following")
                    var following: Int, // 0
                    @SerializedName("level_info")
                    var levelInfo: LevelInfo,
                    @SerializedName("mid")
                    var mid: String, // 161745277
                    @SerializedName("nameplate")
                    var nameplate: Nameplate,
                    @SerializedName("official_verify")
                    var officialVerify: OfficialVerify,
                    @SerializedName("pendant")
                    var pendant: Pendant,
                    @SerializedName("rank")
                    var rank: String, // 10000
                    @SerializedName("sex")
                    var sex: String, // 保密
                    @SerializedName("sign")
                    var sign: String,
                    @SerializedName("uname")
                    var uname: String, // vo6869
                    @SerializedName("vip")
                    var vip: Vip
            ) {
                data class Pendant(
                        @SerializedName("expire")
                        var expire: Long, // 0
                        @SerializedName("image")
                        var image: String,
                        @SerializedName("name")
                        var name: String,
                        @SerializedName("pid")
                        var pid: Int // 0
                )

                data class Nameplate(
                        @SerializedName("condition")
                        var condition: String,
                        @SerializedName("image")
                        var image: String,
                        @SerializedName("image_small")
                        var imageSmall: String,
                        @SerializedName("level")
                        var level: String,
                        @SerializedName("name")
                        var name: String,
                        @SerializedName("nid")
                        var nid: Int // 0
                )

                data class OfficialVerify(
                        @SerializedName("desc")
                        var desc: String,
                        @SerializedName("type")
                        var type: Int // -1
                )

                data class Vip(
                        @SerializedName("accessStatus")
                        var accessStatus: Int, // 0
                        @SerializedName("dueRemark")
                        var dueRemark: String,
                        @SerializedName("vipDueDate")
                        var vipDueDate: Long, // 1544371200000
                        @SerializedName("vipStatus")
                        var vipStatus: Int, // 0
                        @SerializedName("vipStatusWarn")
                        var vipStatusWarn: String,
                        @SerializedName("vipType")
                        var vipType: Int // 1
                )

                data class LevelInfo(
                        @SerializedName("current_exp")
                        var currentExp: Int, // 0
                        @SerializedName("current_level")
                        var currentLevel: Int, // 2
                        @SerializedName("current_min")
                        var currentMin: Int, // 0
                        @SerializedName("next_exp")
                        var nextExp: Int // 0
                )
            }

            data class Content(
                    @SerializedName("device")
                    var device: String, // phone
                    @SerializedName("members")
                    var members: List<JsonElement>,
                    @SerializedName("message")
                    var message: String, // 回复 @***全副武装 :耶酥是佛教徒
                    @SerializedName("plat")
                    var plat: Int // 3
            )

            data class Folder(
                    @SerializedName("has_folded")
                    var hasFolded: Boolean, // false
                    @SerializedName("is_folded")
                    var isFolded: Boolean, // false
                    @SerializedName("rule")
                    var rule: String
            )
        }

        data class Cursor(
                @SerializedName("max_floor")
                var maxFloor: Int, // 172
                @SerializedName("min_floor")
                var minFloor: Int, // 8
                @SerializedName("size")
                var size: Int // 11
        )

        data class Config(
                @SerializedName("show_up_flag")
                var showUpFlag: Boolean, // true
                @SerializedName("showadmin")
                var showadmin: Int, // 0
                @SerializedName("showentry")
                var showentry: Int, // 0
                @SerializedName("showfloor")
                var showfloor: Int, // 1
                @SerializedName("showtopic")
                var showtopic: Int // 1
        )

        data class Dialog(
                @SerializedName("max_floor")
                var maxFloor: Int, // 172
                @SerializedName("min_floor")
                var minFloor: Int // 8
        )
    }
}
