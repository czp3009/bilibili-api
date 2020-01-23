package com.hiczp.bilibili.api.main.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Season(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String, // success
        @SerializedName("result")
        var result: Result
) {
    data class Result(
            @SerializedName("cover")
            var cover: String, // http://i0.hdslb.com/bfs/bangumi/a92892921f3209f7784a954c37467c9869a1d4c1.png
            @SerializedName("episodes")
            var episodes: List<Episode>,
            @SerializedName("evaluate")
            var evaluate: String, // 位于东京西部的巨大“学园都市”，实施着超能力开发的特殊课程。学生们的能力被给予从“无能力Level 0”到“超能力Level 5”的六阶段评价。高中生上条当麻，由于寄宿在右手中的力量——只要是异能之力...
            @SerializedName("link")
            var link: String, // http://www.bilibili.com/bangumi/media/md134912/
            @SerializedName("media_id")
            var mimediaId: Long, // 134912
            @SerializedName("mode")
            var mode: Int, // 2
            @SerializedName("new_ep")
            var newEp: NewEp,
            @SerializedName("paster")
            var paster: Paster,
            @SerializedName("payment")
            var payment: Payment,
            @SerializedName("publish")
            var publish: Publish,
            @SerializedName("rating")
            var rating: Rating,
            @SerializedName("record")
            var record: String,
            @SerializedName("rights")
            var rights: Rights,
            @SerializedName("season_id")
            var seasonId: Long, // 25617
            @SerializedName("season_title")
            var seasonTitle: String, // 魔法禁书目录 第三季
            @SerializedName("seasons")
            var seasons: List<Season>,
            @SerializedName("section")
            var section: List<JsonElement>,
            @SerializedName("series")
            var series: Series,
            @SerializedName("share_url")
            var shareUrl: String, // http://m.bilibili.com/bangumi/play/ss25617
            @SerializedName("square_cover")
            var squareCover: String, // http://i0.hdslb.com/bfs/bangumi/91b29251445f9b808e9c30f34019d3ba4f128d6d.jpg
            @SerializedName("stat")
            var stat: Stat,
            @SerializedName("status")
            var status: Int, // 13
            @SerializedName("title")
            var title: String, // 魔法禁书目录 第三季
            @SerializedName("total")
            var total: Int, // 0
            @SerializedName("type")
            var type: Int, // 1
            @SerializedName("user_status")
            var userStatus: UserStatus
    ) {
        data class Series(
                @SerializedName("series_id")
                var seriesId: Int, // 621
                @SerializedName("series_title")
                var seriesTitle: String // 魔法禁书目录
        )

        data class UserStatus(
                @SerializedName("follow")
                var follow: Int, // 1
                @SerializedName("pay")
                var pay: Int, // 0
                @SerializedName("progress")
                var progress: Progress,
                @SerializedName("review")
                var review: Review,
                @SerializedName("sponsor")
                var sponsor: Int, // 0
                @SerializedName("vip")
                var vip: Int, // 0
                @SerializedName("vip_frozen")
                var vipFrozen: Int // 0
        ) {
            data class Progress(
                    @SerializedName("last_ep_id")
                    var lastEpId: Int, // 250436
                    @SerializedName("last_ep_index")
                    var lastEpIndex: String, // 3
                    @SerializedName("last_time")
                    var lastTime: Int // 1405
            )

            data class Review(
                    @SerializedName("is_open")
                    var isOpen: Int // 0
            )
        }

        data class Season(
                @SerializedName("is_new")
                var isNew: Int, // 1
                @SerializedName("season_id")
                var seasonId: Long, // 25617
                @SerializedName("season_title")
                var seasonTitle: String // 第三季
        )

        data class Episode(
                @SerializedName("aid")
                var aid: Int, // 44389470
                @SerializedName("badge")
                var badge: String, // 会员
                @SerializedName("badge_type")
                var badgeType: Int, // 0
                @SerializedName("cid")
                var cid: Int, // 77725026
                @SerializedName("cover")
                var cover: String, // http://i0.hdslb.com/bfs/archive/c83ef2a961d8b53d6a30f03e8fb631ea4248fede.jpg
                @SerializedName("dimension")
                var dimension: Dimension,
                @SerializedName("from")
                var from: String, // bangumi
                @SerializedName("id")
                var id: Int, // 250453
                @SerializedName("long_title")
                var longTitle: String, // 守护的理由
                @SerializedName("share_url")
                var shareUrl: String, // https://m.bilibili.com/bangumi/play/ep250453
                @SerializedName("status")
                var status: Int, // 13
                @SerializedName("title")
                var title: String, // 20
                @SerializedName("vid")
                var vid: String
        ) {
            data class Dimension(
                    @SerializedName("height")
                    var height: Int, // 1080
                    @SerializedName("rotate")
                    var rotate: Int, // 0
                    @SerializedName("width")
                    var width: Int // 1920
            )
        }

        data class Rating(
                @SerializedName("count")
                var count: Int, // 32318
                @SerializedName("score")
                var score: Double // 7.8
        )

        data class Rights(
                @SerializedName("allow_bp")
                var allowBp: Int, // 0
                @SerializedName("allow_download")
                var allowDownload: Int, // 0
                @SerializedName("allow_review")
                var allowReview: Int, // 1
                @SerializedName("area_limit")
                var areaLimit: Int, // 0
                @SerializedName("ban_area_show")
                var banAreaShow: Int, // 1
                @SerializedName("copyright")
                var copyright: String, // bilibili
                @SerializedName("is_preview")
                var isPreview: Int, // 1
                @SerializedName("watch_platform")
                var watchPlatform: Int // 0
        )

        data class NewEp(
                @SerializedName("desc")
                var desc: String, // 连载中, 每周五22:30更新
                @SerializedName("id")
                var id: Int, // 250453
                @SerializedName("is_new")
                var isNew: Int, // 1
                @SerializedName("title")
                var title: String // 20
        )

        data class Payment(
                @SerializedName("dialog")
                var dialog: Dialog,
                @SerializedName("pay_tip")
                var payTip: PayTip,
                @SerializedName("pay_type")
                var payType: PayType,
                @SerializedName("price")
                var price: String, // 0.0
                @SerializedName("vip_promotion")
                var vipPromotion: String
        ) {
            data class Dialog(
                    @SerializedName("btn_right")
                    var btnRight: BtnRight,
                    @SerializedName("desc")
                    var desc: String,
                    @SerializedName("title")
                    var title: String // 开通大会员抢先看
            ) {
                data class BtnRight(
                        @SerializedName("title")
                        var title: String, // 成为大会员
                        @SerializedName("type")
                        var type: String // vip
                )
            }

            data class PayType(
                    @SerializedName("allow_ticket")
                    var allowTicket: Int // 0
            )

            data class PayTip(
                    @SerializedName("primary")
                    var primary: Primary
            ) {
                data class Primary(
                        @SerializedName("sub_title")
                        var subTitle: String,
                        @SerializedName("title")
                        var title: String, // 开通大会员抢先看
                        @SerializedName("type")
                        var type: Int, // 1
                        @SerializedName("url")
                        var url: String
                )
            }
        }

        data class Stat(
                @SerializedName("coins")
                var coins: Long, // 333230
                @SerializedName("danmakus")
                var danmakus: Int, // 729836
                @SerializedName("favorites")
                var favorites: Int, // 2300833
                @SerializedName("reply")
                var reply: Int, // 324057
                @SerializedName("share")
                var share: Int, // 18362
                @SerializedName("views")
                var views: Int // 41392306
        )

        data class Publish(
                @SerializedName("is_finish")
                var isFinish: Int, // 0
                @SerializedName("is_started")
                var isStarted: Int, // 1
                @SerializedName("pub_time")
                var pubTime: String, // 2018-10-05 22:30:00
                @SerializedName("pub_time_show")
                var pubTimeShow: String, // 10月05日22:30
                @SerializedName("weekday")
                var weekday: Int // 0
        )

        data class Paster(
                @SerializedName("aid")
                var aid: Long, // 0
                @SerializedName("allow_jump")
                var allowJump: Int, // 0
                @SerializedName("cid")
                var cid: Long, // 0
                @SerializedName("duration")
                var duration: Int, // 0
                @SerializedName("type")
                var type: Int, // 0
                @SerializedName("url")
                var url: String
        )
    }
}
