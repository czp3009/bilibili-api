package com.hiczp.bilibili.api.main.model

import com.google.gson.annotations.SerializedName

data class ChildReply(
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
            @SerializedName("assist")
            var assist: Int, // 0
            @SerializedName("blacklist")
            var blacklist: Int, // 0
            @SerializedName("config")
            var config: Config,
            @SerializedName("cursor")
            var cursor: Cursor,
            @SerializedName("root")
            var root: Root,
            @SerializedName("upper")
            var upper: Upper
    ) {
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

        data class Upper(
                @SerializedName("mid")
                var mid: Long // 7584632
        )

        data class Cursor(
                @SerializedName("all_count")
                var allCount: Int, // 2
                @SerializedName("max_id")
                var maxId: Int, // 2
                @SerializedName("min_id")
                var minId: Int, // 1
                @SerializedName("size")
                var size: Int // 2
        )

        data class Root(
                @SerializedName("action")
                var action: Int, // 0
                @SerializedName("assist")
                var assist: Int, // 0
                @SerializedName("attr")
                var attr: Int, // 0
                @SerializedName("content")
                var content: Content,
                @SerializedName("count")
                var count: Int, // 2
                @SerializedName("ctime")
                var ctime: Int, // 1550681500
                @SerializedName("dialog")
                var dialog: Int, // 0
                @SerializedName("dialog_str")
                var dialogStr: String,
                @SerializedName("fansgrade")
                var fansgrade: Int, // 0
                @SerializedName("floor")
                var floor: Int, // 1348
                @SerializedName("folder")
                var folder: Folder,
                @SerializedName("like")
                var like: Int, // 1
                @SerializedName("member")
                var member: Member,
                @SerializedName("mid")
                var mid: Int, // 14363383
                @SerializedName("oid")
                var oid: Int, // 16622855
                @SerializedName("parent")
                var parent: Int, // 0
                @SerializedName("parent_str")
                var parentStr: String, // 0
                @SerializedName("rcount")
                var rcount: Int, // 2
                @SerializedName("replies")
                var replies: List<Reply>,
                @SerializedName("root")
                var root: Int, // 0
                @SerializedName("root_str")
                var rootStr: String, // 0
                @SerializedName("rpid")
                var rpid: Long, // 1405602348
                @SerializedName("rpid_str")
                var rpidStr: String, // 1405602348
                @SerializedName("state")
                var state: Int, // 0
                @SerializedName("type")
                var type: Int, // 1
                @SerializedName("up_action")
                var upAction: UpAction
        ) {
            data class Folder(
                    @SerializedName("has_folded")
                    var hasFolded: Boolean, // false
                    @SerializedName("is_folded")
                    var isFolded: Boolean, // false
                    @SerializedName("rule")
                    var rule: String // https://www.bilibili.com/blackboard/foldingreply.html
            )

            data class Reply(
                    @SerializedName("action")
                    var action: Int, // 0
                    @SerializedName("assist")
                    var assist: Int, // 0
                    @SerializedName("attr")
                    var attr: Int, // 0
                    @SerializedName("content")
                    var content: Content,
                    @SerializedName("count")
                    var count: Int, // 0
                    @SerializedName("ctime")
                    var ctime: Int, // 1550682402
                    @SerializedName("dialog")
                    var dialog: Int, // 1405625526
                    @SerializedName("dialog_str")
                    var dialogStr: String,
                    @SerializedName("fansgrade")
                    var fansgrade: Int, // 0
                    @SerializedName("floor")
                    var floor: Int, // 2
                    @SerializedName("folder")
                    var folder: Folder,
                    @SerializedName("like")
                    var like: Int, // 1
                    @SerializedName("member")
                    var member: Member,
                    @SerializedName("mid")
                    var mid: Int, // 14363383
                    @SerializedName("oid")
                    var oid: Int, // 16622855
                    @SerializedName("parent")
                    var parent: Int, // 1405602348
                    @SerializedName("parent_str")
                    var parentStr: String, // 1405602348
                    @SerializedName("rcount")
                    var rcount: Int, // 0
                    @SerializedName("replies")
                    var replies: List<Any>,
                    @SerializedName("root")
                    var root: Int, // 1405602348
                    @SerializedName("root_str")
                    var rootStr: String, // 1405602348
                    @SerializedName("rpid")
                    var rpid: Long, // 1405625526
                    @SerializedName("rpid_str")
                    var rpidStr: String, // 1405625526
                    @SerializedName("state")
                    var state: Int, // 0
                    @SerializedName("type")
                    var type: Int, // 1
                    @SerializedName("up_action")
                    var upAction: UpAction
            ) {
                data class Content(
                        @SerializedName("device")
                        var device: String,
                        @SerializedName("members")
                        var members: List<Any>,
                        @SerializedName("message")
                        var message: String, // 导演:你认为是否有人了解你？像你自己一样了解你？老佛爷:这个问题我很难回答，别人对我的想法已根深蒂固，所以我认为几乎是不可能，我想是如此，即使是我深爱的人。我不想在别人生活中显得真实，我想成为幽灵，现身，然后消失，我也不想面对任何人的真实，因为我不想面对真实的自己，那是我的秘密。别跟我说那些关于孤独的陈词滥调，之于我这种人，孤独是一种胜利，这是场人生战役。像我一样从事创意工作的人，必须独处，让自己重新充电，整日生活在聚光灯前是无法创作的。我还要做许多事，例如阅读，身边有人就无法去做。平时几乎已没时间，但我随时都会想阅读，所以我赞成每人都要该独立生活。将别人当成依靠，对于我这样的人来说很危险，我必须时时刻刻如履薄冰，并在它破裂之前跨出下一步。
                        @SerializedName("plat")
                        var plat: Int // 2
                )

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
                        var avatar: String, // http://i2.hdslb.com/bfs/face/63f5da7bda813e470cefd465767035efccff747d.jpg
                        @SerializedName("fans_detail")
                        var fansDetail: Any?, // null
                        @SerializedName("following")
                        var following: Int, // 0
                        @SerializedName("level_info")
                        var levelInfo: LevelInfo,
                        @SerializedName("mid")
                        var mid: String, // 14363383
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
                        var sign: String, // - 故事何必听的真切，自在之人掀雨踏天阙。
                        @SerializedName("uname")
                        var uname: String, // 浮生不思量
                        @SerializedName("vip")
                        var vip: Vip
                ) {
                    data class Pendant(
                            @SerializedName("expire")
                            var expire: Int, // 0
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
                            var vipDueDate: Long, // 1515686400000
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
                            var currentLevel: Int, // 5
                            @SerializedName("current_min")
                            var currentMin: Int, // 0
                            @SerializedName("next_exp")
                            var nextExp: Int // 0
                    )
                }

                data class Folder(
                        @SerializedName("has_folded")
                        var hasFolded: Boolean, // false
                        @SerializedName("is_folded")
                        var isFolded: Boolean, // false
                        @SerializedName("rule")
                        var rule: String
                )
            }

            data class Content(
                    @SerializedName("device")
                    var device: String,
                    @SerializedName("members")
                    var members: List<Any>,
                    @SerializedName("message")
                    var message: String, // 唉有点不敢相信…R.I.P……走好走好
                    @SerializedName("plat")
                    var plat: Int // 2
            )

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
                    var avatar: String, // http://i2.hdslb.com/bfs/face/63f5da7bda813e470cefd465767035efccff747d.jpg
                    @SerializedName("fans_detail")
                    var fansDetail: Any?, // null
                    @SerializedName("following")
                    var following: Int, // 0
                    @SerializedName("level_info")
                    var levelInfo: LevelInfo,
                    @SerializedName("mid")
                    var mid: String, // 14363383
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
                    var sign: String, // - 故事何必听的真切，自在之人掀雨踏天阙。
                    @SerializedName("uname")
                    var uname: String, // 浮生不思量
                    @SerializedName("vip")
                    var vip: Vip
            ) {
                data class Pendant(
                        @SerializedName("expire")
                        var expire: Int, // 0
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
                        var vipDueDate: Long, // 1515686400000
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
                        var currentLevel: Int, // 5
                        @SerializedName("current_min")
                        var currentMin: Int, // 0
                        @SerializedName("next_exp")
                        var nextExp: Int // 0
                )
            }
        }
    }
}
