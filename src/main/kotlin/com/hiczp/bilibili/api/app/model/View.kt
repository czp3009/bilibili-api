package com.hiczp.bilibili.api.app.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class View(
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
            @SerializedName("aid")
            var aid: Int, // 44172743
            @SerializedName("attribute")
            var attribute: Int, // 16512
            @SerializedName("cid")
            var cid: Int, // 77356986
            @SerializedName("cm_config")
            var cmConfig: CmConfig,
            @SerializedName("cms")
            var cms: List<Cm>,
            /**
             * copyright 为 1 时表示自制, 2 表示转载
             */
            @SerializedName("copyright")
            var copyright: Int, // 1
            @SerializedName("ctime")
            var ctime: Int, // 1550654012
            @SerializedName("desc")
            var desc: String,
            @SerializedName("dimension")
            var dimension: Dimension,
            @SerializedName("dislike_reasons")
            var dislikeReasons: List<DislikeReason>,
            @SerializedName("dm_seg")
            var dmSeg: Int, // 1
            @SerializedName("duration")
            var duration: Int, // 444
            @SerializedName("dynamic")
            var `dynamic`: String, // #流浪地球##木星##太阳#
            @SerializedName("elec")
            var elec: Elec,
            @SerializedName("owner")
            var owner: Owner,
            @SerializedName("owner_ext")
            var ownerExt: OwnerExt,
            @SerializedName("pages")
            var pages: List<Page>,
            @SerializedName("pic")
            var pic: String, // http://i0.hdslb.com/bfs/archive/783445f04541299ee84de21a2479cce88d8268ff.jpg
            @SerializedName("pubdate")
            var pubdate: Int, // 1550654012
            @SerializedName("relates")
            var relates: List<Relate>,
            @SerializedName("req_user")
            var reqUser: ReqUser,
            @SerializedName("rights")
            var rights: Rights,
            @SerializedName("staff")
            var staff: List<Staff>,
            @SerializedName("stat")
            var stat: Stat,
            @SerializedName("state")
            var state: Int, // 0
            @SerializedName("tag")
            var tag: List<Tag>,
            @SerializedName("tid")
            var tid: Int, // 96
            @SerializedName("title")
            var title: String, // 模拟流浪地球进入木星的洛希极限,太阳要膨胀吞没地球这事是真的吗？
            @SerializedName("tname")
            var tname: String, // 星海
            @SerializedName("videos")
            var videos: Int // 1
    ) {
        data class Cm(
                @SerializedName("ad_info")
                var adInfo: JsonElement, // {}
                @SerializedName("client_ip")
                var clientIp: String, // 218.205.81.101
                @SerializedName("index")
                var index: Int, // 1
                @SerializedName("is_ad_loc")
                var isAdLoc: Boolean, // true
                @SerializedName("request_id")
                var requestId: String, // 1550675871470q172a22a56a79q738
                @SerializedName("rsc_id")
                var rscId: Int, // 2337
                @SerializedName("src_id")
                var srcId: Int // 2338
        )

        data class Owner(
                @SerializedName("face")
                var face: String, // http://i1.hdslb.com/bfs/face/9a586d1ef659b322af150c925976a134ad046a74.jpg
                @SerializedName("mid")
                var mid: Long, // 393484294
                @SerializedName("name")
                var name: String // 娱乐酱鸭
        )

        data class Elec(
                @SerializedName("elec_set")
                var elecSet: ElecSet,
                @SerializedName("list")
                var list: List<JsonElement>,
                @SerializedName("show")
                var show: Boolean // true
        ) {
            data class ElecSet(
                    @SerializedName("elec_list")
                    var elecList: List<Elec>,
                    @SerializedName("elec_theme")
                    var elecTheme: Int, // 0
                    @SerializedName("integrity_rate")
                    var integrityRate: Double, // 10.0
                    @SerializedName("rmb_rate")
                    var rmbRate: Double, // 10.0
                    @SerializedName("round_mode")
                    var roundMode: Int // 0
            ) {
                data class Elec(
                        @SerializedName("elec_num")
                        var elecNum: Int, // 0
                        @SerializedName("is_customize")
                        var isCustomize: Int, // 1
                        @SerializedName("max_elec")
                        var maxElec: Int, // 99999
                        @SerializedName("min_elec")
                        var minElec: Int, // 20
                        @SerializedName("title")
                        var title: String // 自定义
                )
            }
        }

        data class ReqUser(
                @SerializedName("attention")
                var attention: Int, // -999
                @SerializedName("coin")
                var coin: Int, // 0
                @SerializedName("dislike")
                var dislike: Int, // 0
                @SerializedName("favorite")
                var favorite: Int, // 0
                @SerializedName("like")
                var like: Int // 0
        )

        data class Stat(
                @SerializedName("aid")
                var aid: Int, // 44172743
                @SerializedName("coin")
                var coin: Int, // 23
                @SerializedName("danmaku")
                var danmaku: Int, // 19
                @SerializedName("dislike")
                var dislike: Int, // 0
                @SerializedName("favorite")
                var favorite: Int, // 10
                @SerializedName("his_rank")
                var hisRank: Int, // 0
                @SerializedName("like")
                var like: Int, // 35
                @SerializedName("now_rank")
                var nowRank: Int, // 0
                @SerializedName("reply")
                var reply: Int, // 11
                @SerializedName("share")
                var share: Int, // 0
                @SerializedName("view")
                var view: Int // 1995
        )

        data class OwnerExt(
                @SerializedName("assists")
                var assists: JsonElement?, // null
                @SerializedName("fans")
                var fans: Int, // 275
                @SerializedName("official_verify")
                var officialVerify: OfficialVerify,
                @SerializedName("vip")
                var vip: Vip
        ) {
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

        data class Tag(
                @SerializedName("attribute")
                var attribute: Int, // 0
                @SerializedName("cover")
                var cover: String,
                @SerializedName("hated")
                var hated: Int, // 0
                @SerializedName("hates")
                var hates: Int, // 0
                @SerializedName("is_activity")
                var isActivity: Int, // 0
                @SerializedName("liked")
                var liked: Int, // 0
                @SerializedName("likes")
                var likes: Int, // 0
                @SerializedName("tag_id")
                var tagId: Int, // 7534
                @SerializedName("tag_name")
                var tagName: String // 未来
        )

        data class Staff(
                @SerializedName("attention")
                var attention: Int, // 0
                @SerializedName("face")
                var face: String, // http://i1.hdslb.com/bfs/face/9a586d1ef659b322af150c925976a134ad046a74.jpg
                @SerializedName("mid")
                var mid: Long, // 393484294
                @SerializedName("name")
                var name: String, // 娱乐酱鸭
                @SerializedName("official_verify")
                var officialVerify: OfficialVerify,
                @SerializedName("title")
                var title: String, // UP主
                @SerializedName("vip")
                var vip: Vip
        ) {
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

        data class DislikeReason(
                @SerializedName("reason_id")
                var reasonId: Int, // 8
                @SerializedName("reason_name")
                var reasonName: String // 营销广告
        )

        data class Relate(
                @SerializedName("ad_index")
                var adIndex: Int, // 2
                @SerializedName("aid")
                var aid: Int, // 38496110
                @SerializedName("card_index")
                var cardIndex: Int, // 3
                @SerializedName("cid")
                var cid: Int, // 67669037
                @SerializedName("client_ip")
                var clientIp: String, // 218.205.81.101
                @SerializedName("duration")
                var duration: Int, // 189
                @SerializedName("goto")
                var goto: String, // av
                @SerializedName("is_ad_loc")
                var isAdLoc: Boolean, // true
                @SerializedName("owner")
                var owner: Owner,
                @SerializedName("param")
                var `param`: String, // 38496110
                @SerializedName("pic")
                var pic: String, // http://i2.hdslb.com/bfs/archive/ca80fb7c554e083716feb910370b77caa5e124b3.jpg
                @SerializedName("request_id")
                var requestId: String, // 1550675871470q172a22a56a79q738
                @SerializedName("src_id")
                var srcId: Int, // 2334
                @SerializedName("stat")
                var stat: Stat,
                @SerializedName("title")
                var title: String, // 《流浪地球》发布创想特辑，从无到有呈现刘慈欣科幻想象
                @SerializedName("trackid")
                var trackid: String, // related_0.shylf-ai-recsys-87.1550675871470.909
                @SerializedName("uri")
                var uri: String // bilibili://video/38496110?player_width=1920&player_height=1080&player_rotate=0&trackid=related_0.shylf-ai-recsys-87.1550675871470.909
        ) {
            data class Owner(
                    @SerializedName("face")
                    var face: String, // http://static.hdslb.com/images/member/noface.gif
                    @SerializedName("mid")
                    var mid: Long, // 334512441
                    @SerializedName("name")
                    var name: String // 达岸电影2018
            )

            data class Stat(
                    @SerializedName("aid")
                    var aid: Int, // 38496110
                    @SerializedName("coin")
                    var coin: Int, // 130
                    @SerializedName("danmaku")
                    var danmaku: Int, // 152
                    @SerializedName("dislike")
                    var dislike: Int, // 0
                    @SerializedName("favorite")
                    var favorite: Int, // 194
                    @SerializedName("his_rank")
                    var hisRank: Int, // 0
                    @SerializedName("like")
                    var like: Int, // 341
                    @SerializedName("now_rank")
                    var nowRank: Int, // 0
                    @SerializedName("reply")
                    var reply: Int, // 264
                    @SerializedName("share")
                    var share: Int, // 278
                    @SerializedName("view")
                    var view: Int // 19397
            )
        }

        data class Page(
                @SerializedName("cid")
                var cid: Int, // 77356986
                @SerializedName("dimension")
                var dimension: Dimension,
                @SerializedName("dm")
                var dm: Dm,
                @SerializedName("dmlink")
                var dmlink: String, // http://comment.bilibili.com/77356986.xml
                @SerializedName("duration")
                var duration: Int, // 444
                @SerializedName("from")
                var from: String, // vupload
                @SerializedName("metas")
                var metas: List<Meta>,
                @SerializedName("page")
                var page: Int, // 1
                @SerializedName("part")
                var part: String, // 2.20.2
                @SerializedName("vid")
                var vid: String,
                @SerializedName("weblink")
                var weblink: String
        ) {
            data class Dm(
                    @SerializedName("closed")
                    var closed: Boolean, // false
                    @SerializedName("count")
                    var count: Int, // 19
                    @SerializedName("mask")
                    var mask: JsonElement, // {}
                    @SerializedName("real_name")
                    var realName: Boolean, // false
                    @SerializedName("subtitles")
                    var subtitles: JsonElement? // null
            )

            data class Dimension(
                    @SerializedName("height")
                    var height: Int, // 720
                    @SerializedName("rotate")
                    var rotate: Int, // 0
                    @SerializedName("width")
                    var width: Int // 1280
            )

            data class Meta(
                    @SerializedName("format")
                    var format: String,
                    @SerializedName("quality")
                    var quality: Int, // 48
                    @SerializedName("size")
                    var size: Int // 81074
            )
        }

        data class Rights(
                @SerializedName("autoplay")
                var autoplay: Int, // 1
                @SerializedName("bp")
                var bp: Int, // 0
                @SerializedName("download")
                var download: Int, // 1
                @SerializedName("elec")
                var elec: Int, // 1
                @SerializedName("hd5")
                var hd5: Int, // 0
                @SerializedName("is_cooperation")
                var isCooperation: Int, // 0
                @SerializedName("movie")
                var movie: Int, // 0
                @SerializedName("no_reprint")
                var noReprint: Int, // 1
                @SerializedName("pay")
                var pay: Int, // 0
                @SerializedName("ugc_pay")
                var ugcPay: Int // 0
        )

        data class Dimension(
                @SerializedName("height")
                var height: Int, // 720
                @SerializedName("rotate")
                var rotate: Int, // 0
                @SerializedName("width")
                var width: Int // 1280
        )

        data class CmConfig(
                @SerializedName("ads_control")
                var adsControl: AdsControl
        ) {
            data class AdsControl(
                    @SerializedName("has_danmu")
                    var hasDanmu: Int // 0
            )
        }
    }
}
