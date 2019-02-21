package com.hiczp.bilibili.api.main.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Reply(
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
            @SerializedName("folder")
            var folder: Folder,
            @SerializedName("hots")
            var hots: List<Hot>,
            @SerializedName("notice")
            var notice: JsonElement?, // null
            @SerializedName("replies")
            var replies: List<Reply>,
            @SerializedName("top")
            var top: Top?,
            @SerializedName("upper")
            var upper: Upper,
            @SerializedName("vote")
            var vote: Int // 0
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
                var count: Int, // 1
                @SerializedName("ctime")
                var ctime: Int, // 1550677636
                @SerializedName("dialog")
                var dialog: Int, // 0
                @SerializedName("dialog_str")
                var dialogStr: String,
                @SerializedName("fansgrade")
                var fansgrade: Int, // 0
                @SerializedName("floor")
                var floor: Int, // 295
                @SerializedName("folder")
                var folder: Folder,
                @SerializedName("like")
                var like: Int, // 0
                @SerializedName("member")
                var member: Member,
                @SerializedName("mid")
                var mid: Int, // 14028833
                @SerializedName("oid")
                var oid: Int, // 44012857
                @SerializedName("parent")
                var parent: Int, // 0
                @SerializedName("parent_str")
                var parentStr: String, // 0
                @SerializedName("rcount")
                var rcount: Int, // 1
                @SerializedName("replies")
                var replies: List<Reply>,
                @SerializedName("root")
                var root: Int, // 0
                @SerializedName("root_str")
                var rootStr: String, // 0
                @SerializedName("rpid")
                var rpid: Long, // 1405424731
                @SerializedName("rpid_str")
                var rpidStr: String, // 1405424731
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

            data class UpAction(
                    @SerializedName("like")
                    var like: Boolean, // false
                    @SerializedName("reply")
                    var reply: Boolean // false
            )

            data class Content(
                    @SerializedName("device")
                    var device: String, // pad
                    @SerializedName("members")
                    var members: List<JsonElement>,
                    @SerializedName("message")
                    var message: String, // 高速公路有盈利吗
                    @SerializedName("plat")
                    var plat: Int // 3
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
                    var ctime: Int, // 1550677973
                    @SerializedName("dialog")
                    var dialog: Int, // 1405471211
                    @SerializedName("dialog_str")
                    var dialogStr: String,
                    @SerializedName("fansgrade")
                    var fansgrade: Int, // 0
                    @SerializedName("floor")
                    var floor: Int, // 1
                    @SerializedName("folder")
                    var folder: Folder,
                    @SerializedName("like")
                    var like: Int, // 0
                    @SerializedName("member")
                    var member: Member,
                    @SerializedName("mid")
                    var mid: Int, // 14674816
                    @SerializedName("oid")
                    var oid: Int, // 44012857
                    @SerializedName("parent")
                    var parent: Int, // 1405424731
                    @SerializedName("parent_str")
                    var parentStr: String, // 1405424731
                    @SerializedName("rcount")
                    var rcount: Int, // 0
                    @SerializedName("replies")
                    var replies: List<JsonElement>,
                    @SerializedName("root")
                    var root: Int, // 1405424731
                    @SerializedName("root_str")
                    var rootStr: String, // 1405424731
                    @SerializedName("rpid")
                    var rpid: Long, // 1405471211
                    @SerializedName("rpid_str")
                    var rpidStr: String, // 1405471211
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
                        var members: List<JsonElement>,
                        @SerializedName("message")
                        var message: String, // 有收费站[小电视_笑]
                        @SerializedName("plat")
                        var plat: Int // 2
                )

                data class UpAction(
                        @SerializedName("like")
                        var like: Boolean, // false
                        @SerializedName("reply")
                        var reply: Boolean // false
                )

                data class Folder(
                        @SerializedName("has_folded")
                        var hasFolded: Boolean, // false
                        @SerializedName("is_folded")
                        var isFolded: Boolean, // false
                        @SerializedName("rule")
                        var rule: String
                )

                data class Member(
                        @SerializedName("DisplayRank")
                        var displayRank: String, // 0
                        @SerializedName("avatar")
                        var avatar: String, // http://i0.hdslb.com/bfs/face/3cb6b6aeea49fa7fd49b198e4e536a8ce4ede4fe.jpg
                        @SerializedName("fans_detail")
                        var fansDetail: JsonElement?, // null
                        @SerializedName("following")
                        var following: Int, // 0
                        @SerializedName("level_info")
                        var levelInfo: LevelInfo,
                        @SerializedName("mid")
                        var mid: String, // 14674816
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
                        var sign: String, // 没错，就是我
                        @SerializedName("uname")
                        var uname: String, // XIzkaZero
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

                    data class Vip(
                            @SerializedName("accessStatus")
                            var accessStatus: Int, // 0
                            @SerializedName("dueRemark")
                            var dueRemark: String,
                            @SerializedName("vipDueDate")
                            var vipDueDate: Long, // 1653408000000
                            @SerializedName("vipStatus")
                            var vipStatus: Int, // 1
                            @SerializedName("vipStatusWarn")
                            var vipStatusWarn: String,
                            @SerializedName("vipType")
                            var vipType: Int // 2
                    )
                }
            }

            data class Member(
                    @SerializedName("DisplayRank")
                    var displayRank: String, // 0
                    @SerializedName("avatar")
                    var avatar: String, // http://i0.hdslb.com/bfs/face/275a86b1609f55ec2ea759e4a0ef03d9423961dd.jpg
                    @SerializedName("fans_detail")
                    var fansDetail: JsonElement?, // null
                    @SerializedName("following")
                    var following: Int, // 0
                    @SerializedName("level_info")
                    var levelInfo: LevelInfo,
                    @SerializedName("mid")
                    var mid: String, // 14028833
                    @SerializedName("nameplate")
                    var nameplate: Nameplate,
                    @SerializedName("official_verify")
                    var officialVerify: OfficialVerify,
                    @SerializedName("pendant")
                    var pendant: Pendant,
                    @SerializedName("rank")
                    var rank: String, // 10000
                    @SerializedName("sex")
                    var sex: String, // 男
                    @SerializedName("sign")
                    var sign: String, // 时差党，海贼王，游戏狂，懒人。。。。
                    @SerializedName("uname")
                    var uname: String, // 陆个钢镚儿
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

                data class LevelInfo(
                        @SerializedName("current_exp")
                        var currentExp: Int, // 0
                        @SerializedName("current_level")
                        var currentLevel: Int, // 4
                        @SerializedName("current_min")
                        var currentMin: Int, // 0
                        @SerializedName("next_exp")
                        var nextExp: Int // 0
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
                        var vipDueDate: Long, // 0
                        @SerializedName("vipStatus")
                        var vipStatus: Int, // 0
                        @SerializedName("vipStatusWarn")
                        var vipStatusWarn: String,
                        @SerializedName("vipType")
                        var vipType: Int // 0
                )
            }
        }

        data class Upper(
                @SerializedName("mid")
                var mid: Int // 11248627
        )

        data class Config(
                @SerializedName("show_up_flag")
                var showUpFlag: Boolean, // true
                @SerializedName("showadmin")
                var showadmin: Int, // 1
                @SerializedName("showentry")
                var showentry: Int, // 1
                @SerializedName("showfloor")
                var showfloor: Int, // 1
                @SerializedName("showtopic")
                var showtopic: Int // 1
        )

        data class Cursor(
                @SerializedName("all_count")
                var allCount: Int, // 904
                @SerializedName("is_begin")
                var isBegin: Boolean, // true
                @SerializedName("is_end")
                var isEnd: Boolean, // false
                @SerializedName("mode")
                var mode: Int, // 1
                @SerializedName("next")
                var next: Int, // 295
                @SerializedName("prev")
                var prev: Int, // 314
                @SerializedName("support_mode")
                var supportMode: List<Int>
        )

        data class Hot(
                @SerializedName("action")
                var action: Int, // 0
                @SerializedName("assist")
                var assist: Int, // 0
                @SerializedName("attr")
                var attr: Int, // 256
                @SerializedName("content")
                var content: Content,
                @SerializedName("count")
                var count: Int, // 3
                @SerializedName("ctime")
                var ctime: Int, // 1550507590
                @SerializedName("dialog")
                var dialog: Int, // 0
                @SerializedName("dialog_str")
                var dialogStr: String,
                @SerializedName("fansgrade")
                var fansgrade: Int, // 1
                @SerializedName("floor")
                var floor: Int, // 4
                @SerializedName("folder")
                var folder: Folder,
                @SerializedName("like")
                var like: Int, // 124
                @SerializedName("member")
                var member: Member,
                @SerializedName("mid")
                var mid: Int, // 7937795
                @SerializedName("oid")
                var oid: Int, // 44012857
                @SerializedName("parent")
                var parent: Int, // 0
                @SerializedName("parent_str")
                var parentStr: String, // 0
                @SerializedName("rcount")
                var rcount: Int, // 3
                @SerializedName("replies")
                var replies: List<Reply>,
                @SerializedName("root")
                var root: Int, // 0
                @SerializedName("root_str")
                var rootStr: String, // 0
                @SerializedName("rpid")
                var rpid: Long, // 1400028639
                @SerializedName("rpid_str")
                var rpidStr: String, // 1400028639
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

            data class Content(
                    @SerializedName("device")
                    var device: String,
                    @SerializedName("members")
                    var members: List<JsonElement>,
                    @SerializedName("message")
                    var message: String, // 最后一个笑出了声[蛆音娘_大笑]
                    @SerializedName("plat")
                    var plat: Int // 1
            )

            data class Member(
                    @SerializedName("DisplayRank")
                    var displayRank: String, // 0
                    @SerializedName("avatar")
                    var avatar: String, // http://i2.hdslb.com/bfs/face/bc5ee06d9df30057064e3450b572da6f793fbd2a.jpg
                    @SerializedName("fans_detail")
                    var fansDetail: FansDetail,
                    @SerializedName("following")
                    var following: Int, // 0
                    @SerializedName("level_info")
                    var levelInfo: LevelInfo,
                    @SerializedName("mid")
                    var mid: String, // 7937795
                    @SerializedName("nameplate")
                    var nameplate: Nameplate,
                    @SerializedName("official_verify")
                    var officialVerify: OfficialVerify,
                    @SerializedName("pendant")
                    var pendant: Pendant,
                    @SerializedName("rank")
                    var rank: String, // 10000
                    @SerializedName("sex")
                    var sex: String, // 男
                    @SerializedName("sign")
                    var sign: String, // 你是什么样的人，取决于你选择成为什么样的人。
                    @SerializedName("uname")
                    var uname: String, // 会飞的果酱
                    @SerializedName("vip")
                    var vip: Vip
            ) {
                data class Pendant(
                        @SerializedName("expire")
                        var expire: Int, // 1565150481
                        @SerializedName("image")
                        var image: String, // http://i2.hdslb.com/bfs/face/5ac24fa22208f48126bfacb42901e932946f6aa3.png
                        @SerializedName("name")
                        var name: String, // 2019拜年祭·典藏
                        @SerializedName("pid")
                        var pid: Int // 267
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

                data class Vip(
                        @SerializedName("accessStatus")
                        var accessStatus: Int, // 0
                        @SerializedName("dueRemark")
                        var dueRemark: String,
                        @SerializedName("vipDueDate")
                        var vipDueDate: Long, // 1570809600000
                        @SerializedName("vipStatus")
                        var vipStatus: Int, // 1
                        @SerializedName("vipStatusWarn")
                        var vipStatusWarn: String,
                        @SerializedName("vipType")
                        var vipType: Int // 2
                )

                data class OfficialVerify(
                        @SerializedName("desc")
                        var desc: String,
                        @SerializedName("type")
                        var type: Int // -1
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

                data class FansDetail(
                        @SerializedName("intimacy")
                        var intimacy: Int, // 0
                        @SerializedName("is_receive")
                        var isReceive: Int, // 1
                        @SerializedName("level")
                        var level: Int, // 1
                        @SerializedName("master_status")
                        var masterStatus: Int, // 1
                        @SerializedName("medal_id")
                        var medalId: Int, // 143626
                        @SerializedName("medal_name")
                        var medalName: String, // 名禄
                        @SerializedName("score")
                        var score: Int, // 0
                        @SerializedName("uid")
                        var uid: Int // 7937795
                )
            }

            data class UpAction(
                    @SerializedName("like")
                    var like: Boolean, // true
                    @SerializedName("reply")
                    var reply: Boolean // false
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
                    var ctime: Int, // 1550670930
                    @SerializedName("dialog")
                    var dialog: Int, // 1405107877
                    @SerializedName("dialog_str")
                    var dialogStr: String,
                    @SerializedName("fansgrade")
                    var fansgrade: Int, // 0
                    @SerializedName("floor")
                    var floor: Int, // 3
                    @SerializedName("folder")
                    var folder: Folder,
                    @SerializedName("like")
                    var like: Int, // 0
                    @SerializedName("member")
                    var member: Member,
                    @SerializedName("mid")
                    var mid: Int, // 27407505
                    @SerializedName("oid")
                    var oid: Int, // 44012857
                    @SerializedName("parent")
                    var parent: Int, // 1400028639
                    @SerializedName("parent_str")
                    var parentStr: String, // 1400028639
                    @SerializedName("rcount")
                    var rcount: Int, // 0
                    @SerializedName("replies")
                    var replies: List<JsonElement>,
                    @SerializedName("root")
                    var root: Int, // 1400028639
                    @SerializedName("root_str")
                    var rootStr: String, // 1400028639
                    @SerializedName("rpid")
                    var rpid: Long, // 1405107877
                    @SerializedName("rpid_str")
                    var rpidStr: String, // 1405107877
                    @SerializedName("state")
                    var state: Int, // 0
                    @SerializedName("type")
                    var type: Int, // 1
                    @SerializedName("up_action")
                    var upAction: UpAction
            ) {
                data class Member(
                        @SerializedName("DisplayRank")
                        var displayRank: String, // 0
                        @SerializedName("avatar")
                        var avatar: String, // http://i1.hdslb.com/bfs/face/84aacbd97393f61d84a03cc5500df17ff2f289bf.jpg
                        @SerializedName("fans_detail")
                        var fansDetail: JsonElement?, // null
                        @SerializedName("following")
                        var following: Int, // 0
                        @SerializedName("level_info")
                        var levelInfo: LevelInfo,
                        @SerializedName("mid")
                        var mid: String, // 27407505
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
                        var sign: String, // 欢迎加入小天使动漫交流群，群聊号码Q：953511423
                        @SerializedName("uname")
                        var uname: String, // 小天使de日常
                        @SerializedName("vip")
                        var vip: Vip
                ) {
                    data class Vip(
                            @SerializedName("accessStatus")
                            var accessStatus: Int, // 0
                            @SerializedName("dueRemark")
                            var dueRemark: String,
                            @SerializedName("vipDueDate")
                            var vipDueDate: Long, // 1543420800000
                            @SerializedName("vipStatus")
                            var vipStatus: Int, // 0
                            @SerializedName("vipStatusWarn")
                            var vipStatusWarn: String,
                            @SerializedName("vipType")
                            var vipType: Int // 1
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

                    data class Pendant(
                            @SerializedName("expire")
                            var expire: Int, // 1551514981
                            @SerializedName("image")
                            var image: String, // http://i0.hdslb.com/bfs/face/ec152705d82f96381f1150058d55e057396f0576.png
                            @SerializedName("name")
                            var name: String, // 2019拜年祭·纪念
                            @SerializedName("pid")
                            var pid: Int // 266
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

                data class Content(
                        @SerializedName("device")
                        var device: String,
                        @SerializedName("members")
                        var members: List<JsonElement>,
                        @SerializedName("message")
                        var message: String, // 迷之自信╮(￣▽￣)╭
                        @SerializedName("plat")
                        var plat: Int // 2
                )

                data class UpAction(
                        @SerializedName("like")
                        var like: Boolean, // false
                        @SerializedName("reply")
                        var reply: Boolean // false
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
        }

        data class Top(
                @SerializedName("admin")
                var admin: JsonElement?, // null
                @SerializedName("upper")
                var upper: Upper,
                @SerializedName("vote")
                var vote: JsonElement? // null
        ) {
            data class Upper(
                    @SerializedName("action")
                    var action: Int, // 0
                    @SerializedName("assist")
                    var assist: Int, // 0
                    @SerializedName("attr")
                    var attr: Int, // 2
                    @SerializedName("content")
                    var content: Content,
                    @SerializedName("count")
                    var count: Int, // 5
                    @SerializedName("ctime")
                    var ctime: Int, // 1550553976
                    @SerializedName("dialog")
                    var dialog: Int, // 0
                    @SerializedName("dialog_str")
                    var dialogStr: String,
                    @SerializedName("fansgrade")
                    var fansgrade: Int, // 0
                    @SerializedName("floor")
                    var floor: Int, // 82
                    @SerializedName("folder")
                    var folder: Folder,
                    @SerializedName("like")
                    var like: Int, // 129
                    @SerializedName("member")
                    var member: Member,
                    @SerializedName("mid")
                    var mid: Int, // 11248627
                    @SerializedName("oid")
                    var oid: Int, // 44012857
                    @SerializedName("parent")
                    var parent: Int, // 0
                    @SerializedName("parent_str")
                    var parentStr: String, // 0
                    @SerializedName("rcount")
                    var rcount: Int, // 5
                    @SerializedName("replies")
                    var replies: List<Reply>,
                    @SerializedName("root")
                    var root: Int, // 0
                    @SerializedName("root_str")
                    var rootStr: String, // 0
                    @SerializedName("rpid")
                    var rpid: Long, // 1401074923
                    @SerializedName("rpid_str")
                    var rpidStr: String, // 1401074923
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
                        var ctime: Int, // 1550572214
                        @SerializedName("dialog")
                        var dialog: Int, // 1401606362
                        @SerializedName("dialog_str")
                        var dialogStr: String,
                        @SerializedName("fansgrade")
                        var fansgrade: Int, // 0
                        @SerializedName("floor")
                        var floor: Int, // 5
                        @SerializedName("folder")
                        var folder: Folder,
                        @SerializedName("like")
                        var like: Int, // 0
                        @SerializedName("member")
                        var member: Member,
                        @SerializedName("mid")
                        var mid: Int, // 85049857
                        @SerializedName("oid")
                        var oid: Int, // 44012857
                        @SerializedName("parent")
                        var parent: Int, // 1401606362
                        @SerializedName("parent_str")
                        var parentStr: String, // 1401606362
                        @SerializedName("rcount")
                        var rcount: Int, // 0
                        @SerializedName("replies")
                        var replies: List<JsonElement>,
                        @SerializedName("root")
                        var root: Int, // 1401074923
                        @SerializedName("root_str")
                        var rootStr: String, // 1401074923
                        @SerializedName("rpid")
                        var rpid: Long, // 1401835347
                        @SerializedName("rpid_str")
                        var rpidStr: String, // 1401835347
                        @SerializedName("state")
                        var state: Int, // 0
                        @SerializedName("type")
                        var type: Int, // 1
                        @SerializedName("up_action")
                        var upAction: UpAction
                ) {
                    data class Member(
                            @SerializedName("DisplayRank")
                            var displayRank: String, // 0
                            @SerializedName("avatar")
                            var avatar: String, // http://i0.hdslb.com/bfs/face/09b0ac305a942fc99391acd6164d3fbad9ee9dfb.jpg
                            @SerializedName("fans_detail")
                            var fansDetail: JsonElement?, // null
                            @SerializedName("following")
                            var following: Int, // 0
                            @SerializedName("level_info")
                            var levelInfo: LevelInfo,
                            @SerializedName("mid")
                            var mid: String, // 85049857
                            @SerializedName("nameplate")
                            var nameplate: Nameplate,
                            @SerializedName("official_verify")
                            var officialVerify: OfficialVerify,
                            @SerializedName("pendant")
                            var pendant: Pendant,
                            @SerializedName("rank")
                            var rank: String, // 10000
                            @SerializedName("sex")
                            var sex: String, // 男
                            @SerializedName("sign")
                            var sign: String, // 车痴
                            @SerializedName("uname")
                            var uname: String, // 没皮没脸的孩纸666
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

                        data class LevelInfo(
                                @SerializedName("current_exp")
                                var currentExp: Int, // 0
                                @SerializedName("current_level")
                                var currentLevel: Int, // 3
                                @SerializedName("current_min")
                                var currentMin: Int, // 0
                                @SerializedName("next_exp")
                                var nextExp: Int // 0
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
                                var vipDueDate: Long, // 0
                                @SerializedName("vipStatus")
                                var vipStatus: Int, // 0
                                @SerializedName("vipStatusWarn")
                                var vipStatusWarn: String,
                                @SerializedName("vipType")
                                var vipType: Int // 0
                        )
                    }

                    data class UpAction(
                            @SerializedName("like")
                            var like: Boolean, // false
                            @SerializedName("reply")
                            var reply: Boolean // false
                    )

                    data class Content(
                            @SerializedName("device")
                            var device: String,
                            @SerializedName("members")
                            var members: List<Member>,
                            @SerializedName("message")
                            var message: String, // 回复 @搞事的boy111 :tg现在换人了还在B站有合作
                            @SerializedName("plat")
                            var plat: Int // 2
                    ) {
                        data class Member(
                                @SerializedName("DisplayRank")
                                var displayRank: String, // 0
                                @SerializedName("avatar")
                                var avatar: String, // http://static.hdslb.com/images/member/noface.gif
                                @SerializedName("level_info")
                                var levelInfo: LevelInfo,
                                @SerializedName("mid")
                                var mid: String, // 26318345
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
                                var uname: String, // 搞事的boy111
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

                            data class LevelInfo(
                                    @SerializedName("current_exp")
                                    var currentExp: Int, // 0
                                    @SerializedName("current_level")
                                    var currentLevel: Int, // 4
                                    @SerializedName("current_min")
                                    var currentMin: Int, // 0
                                    @SerializedName("next_exp")
                                    var nextExp: Int // 0
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
                                    var vipDueDate: Long, // 0
                                    @SerializedName("vipStatus")
                                    var vipStatus: Int, // 0
                                    @SerializedName("vipStatusWarn")
                                    var vipStatusWarn: String,
                                    @SerializedName("vipType")
                                    var vipType: Int // 0
                            )
                        }
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

                data class UpAction(
                        @SerializedName("like")
                        var like: Boolean, // false
                        @SerializedName("reply")
                        var reply: Boolean // false
                )

                data class Content(
                        @SerializedName("device")
                        var device: String,
                        @SerializedName("members")
                        var members: List<JsonElement>,
                        @SerializedName("message")
                        var message: String, // 点赞、投币和关注UP哦(〜￣△￣)〜这视频来自TGT最新的一集
                        @SerializedName("plat")
                        var plat: Int // 1
                )

                data class Member(
                        @SerializedName("DisplayRank")
                        var displayRank: String, // 0
                        @SerializedName("avatar")
                        var avatar: String, // http://i0.hdslb.com/bfs/face/2232c221a7f60312c3d63f2b601e0b2c7d8fda51.jpg
                        @SerializedName("fans_detail")
                        var fansDetail: JsonElement?, // null
                        @SerializedName("following")
                        var following: Int, // 0
                        @SerializedName("level_info")
                        var levelInfo: LevelInfo,
                        @SerializedName("mid")
                        var mid: String, // 11248627
                        @SerializedName("nameplate")
                        var nameplate: Nameplate,
                        @SerializedName("official_verify")
                        var officialVerify: OfficialVerify,
                        @SerializedName("pendant")
                        var pendant: Pendant,
                        @SerializedName("rank")
                        var rank: String, // 10000
                        @SerializedName("sex")
                        var sex: String, // 女
                        @SerializedName("sign")
                        var sign: String, // 以古为镜，可以知兴替；以人为镜，可以明得失。对于祖国，勿吹捧入天，亦莫踩入地 (￣︶￣)
                        @SerializedName("uname")
                        var uname: String, // 阿煌看世界
                        @SerializedName("vip")
                        var vip: Vip
                ) {
                    data class Nameplate(
                            @SerializedName("condition")
                            var condition: String, // 所有自制视频总播放数>=50万
                            @SerializedName("image")
                            var image: String, // http://i0.hdslb.com/bfs/face/3f2d64f048b39fb6c26f3db39df47e6080ec0f9c.png
                            @SerializedName("image_small")
                            var imageSmall: String, // http://i1.hdslb.com/bfs/face/90c35d41d8a19b19474d6bac672394c17b444ce8.png
                            @SerializedName("level")
                            var level: String, // 高级勋章
                            @SerializedName("name")
                            var name: String, // 出道偶像
                            @SerializedName("nid")
                            var nid: Int // 9
                    )

                    data class OfficialVerify(
                            @SerializedName("desc")
                            var desc: String,
                            @SerializedName("type")
                            var type: Int // -1
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

                    data class Pendant(
                            @SerializedName("expire")
                            var expire: Int, // 1570032000
                            @SerializedName("image")
                            var image: String, // http://i1.hdslb.com/bfs/face/14738b92760b90675d4bf35dd059b0a666113bae.png
                            @SerializedName("name")
                            var name: String, // 春原庄的管理人小姐
                            @SerializedName("pid")
                            var pid: Int // 190
                    )

                    data class Vip(
                            @SerializedName("accessStatus")
                            var accessStatus: Int, // 0
                            @SerializedName("dueRemark")
                            var dueRemark: String,
                            @SerializedName("vipDueDate")
                            var vipDueDate: Long, // 1570032000000
                            @SerializedName("vipStatus")
                            var vipStatus: Int, // 1
                            @SerializedName("vipStatusWarn")
                            var vipStatusWarn: String,
                            @SerializedName("vipType")
                            var vipType: Int // 2
                    )
                }
            }
        }
    }
}
