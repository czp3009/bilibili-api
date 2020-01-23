package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class GiftConfig(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: List<Data>,
        @SerializedName("message")
        var message: String, // success
        @SerializedName("msg")
        var msg: String // success
) {
    data class Data(
            @SerializedName("animation_frame_num")
            var animationFrameNum: Int, // 12
            @SerializedName("bag_gift")
            var bagGift: Int, // 0
            @SerializedName("broadcast")
            var broadcast: Int, // 0
            @SerializedName("bullet_head")
            var bulletHead: String,
            @SerializedName("bullet_tail")
            var bulletTail: String,
            @SerializedName("coin_type")
            var coinType: String, // gold
            @SerializedName("corner_background")
            var cornerBackground: String,
            @SerializedName("corner_mark")
            var cornerMark: String, // 祈愿
            @SerializedName("count_map")
            var countMap: List<CountMap>,
            @SerializedName("desc")
            var desc: String, // 祥瑞御免，家宅平安。
            @SerializedName("draw")
            var draw: Int, // 0
            @SerializedName("effect")
            var effect: Int, // 0
            @SerializedName("frame_animation")
            var frameAnimation: String, // https://i0.hdslb.com/bfs/live/4e19f947d0bd346d38fe4838d7ab431d003f9d7f.png
            @SerializedName("full_sc_horizontal")
            var fullScHorizontal: String,
            @SerializedName("full_sc_horizontal_svga")
            var fullScHorizontalSvga: String,
            @SerializedName("full_sc_vertical")
            var fullScVertical: String,
            @SerializedName("full_sc_vertical_svga")
            var fullScVerticalSvga: String,
            @SerializedName("full_sc_web")
            var fullScWeb: String,
            @SerializedName("gif")
            var gif: String, // https://i0.hdslb.com/bfs/live/a90ff57209661b309f121116682bdee1f3937a98.gif
            @SerializedName("gift_type")
            var giftType: Int, // 1
            @SerializedName("id")
            var id: Int, // 30136
            @SerializedName("img_basic")
            var imgBasic: String, // https://s1.hdslb.com/bfs/live/a7c750335ed42ae4dfeb70570804326d3ecaf61c.png
            @SerializedName("img_dynamic")
            var imgDynamic: String, // https://i0.hdslb.com/bfs/live/f6f314227e7ed8065c4f7266ada913289971f806.png
            @SerializedName("limit_interval")
            var limitInterval: Int, // 0
            @SerializedName("name")
            var name: String, // 御守
            @SerializedName("price")
            var price: Int, // 1000
            @SerializedName("privilege_required")
            var privilegeRequired: Int, // 0
            @SerializedName("rights")
            var rights: String, // 当前主播亲密度+10 经验值+1000
            @SerializedName("rule")
            var rule: String, // 赠送御守即可参与“敬祈照准”活动。
            @SerializedName("stay_time")
            var stayTime: Int, // 3
            @SerializedName("type")
            var type: Int, // 0
            @SerializedName("webp")
            var webp: String // https://i0.hdslb.com/bfs/live/6d8a7907cf89556d074b8ce220e7dd56ccaf5160.webp
    ) {
        data class CountMap(
                @SerializedName("num")
                var num: Int, // 2333
                @SerializedName("text")
                var text: String
        )
    }
}
