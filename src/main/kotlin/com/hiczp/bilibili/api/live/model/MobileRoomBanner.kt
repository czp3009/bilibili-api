package com.hiczp.bilibili.api.live.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class MobileRoomBanner(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // OK
        @SerializedName("msg")
        var msg: String // OK
) {
    data class Data(
            @SerializedName("bottom")
            var bottom: List<JsonElement>,
            @SerializedName("gift")
            var gift: JsonElement?, // null
            @SerializedName("gift_banner")
            var giftBanner: JsonElement?, // null
            @SerializedName("inputBanner")
            var inputBanner: List<JsonElement>,
            @SerializedName("lol_activity")
            var lolActivity: LolActivity,
            @SerializedName("superBanner")
            var superBanner: JsonElement?, // null
            @SerializedName("top")
            var top: List<Top>
    ) {
        data class Top(
                @SerializedName("activity_title")
                var activityTitle: String, // 周星
                @SerializedName("color")
                var color: String,
                @SerializedName("cover")
                var cover: String, // https://i0.hdslb.com/bfs/vc/5cfb2a7dc2a25db580f130a55f475f74e2bd3202.png
                @SerializedName("expire_hour")
                var expireHour: Int, // 24
                @SerializedName("gift_img")
                var giftImg: String, // https://s1.hdslb.com/bfs/vc/39aee4bf13b170f22f19ef1c278cebf3a6e40332.png
                @SerializedName("id")
                var id: Int, // 199
                @SerializedName("is_close")
                var isClose: Int, // 0
                @SerializedName("jump_url")
                var jumpUrl: String, // https://live.bilibili.com/p/html/live-app-weekstar/index.html?is_live_half_webview=1&hybrid_biz=live-app-weekStar&hybrid_rotate_d=1&hybrid_half_ui=1,3,100p,70p,300e51,0,30,100;2,2,375,100p,300e51,0,30,100;3,3,100p,70p,300e51,0,30,100;4,2,375,100p,300e51,0,30,100;5,3,100p,70p,300e51,0,30,100;6,3,100p,70p,300e51,0,30,100;7,3,100p,70p,300e51,0,30,100&room_id=29434
                @SerializedName("rank")
                var rank: String, // 999+
                @SerializedName("rank_name")
                var rankName: String, // 打榜
                @SerializedName("title")
                var title: String, // 排名
                @SerializedName("type")
                var type: Int, // 1
                @SerializedName("week_gift_color")
                var weekGiftColor: String, // #ffffff
                @SerializedName("week_rank_color")
                var weekRankColor: String, // #ffffff
                @SerializedName("week_text_color")
                var weekTextColor: String // #ffffff
        )

        data class LolActivity(
                @SerializedName("guess_cover")
                var guessCover: String, // https://i0.hdslb.com/bfs/live/61d1c4bcce470080a5408d6c03b7b48e0a0fa8d7.png
                @SerializedName("status")
                var status: Int, // 0
                @SerializedName("vote_cover")
                var voteCover: String // https://i0.hdslb.com/bfs/live/6030cb2847f4d197caacb12fbe12f2656b999bcf.png
        )
    }
}
