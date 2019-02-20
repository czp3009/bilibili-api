package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class Mine(
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
            @SerializedName("audio_type")
            var audioType: Int, // 0
            @SerializedName("bcoin")
            var bcoin: Int, // 5
            @SerializedName("coin")
            var coin: Double, // 892.7
            @SerializedName("dynamic")
            var `dynamic`: Int, // 8
            @SerializedName("face")
            var face: String, // http://i0.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg
            @SerializedName("follower")
            var follower: Int, // 512
            @SerializedName("following")
            var following: Int, // 106
            @SerializedName("level")
            var level: Int, // 5
            @SerializedName("mid")
            var mid: Int, // 2866663
            @SerializedName("name")
            var name: String, // hyx5020
            @SerializedName("new_followers")
            var newFollowers: Int, // 0
            @SerializedName("official_verify")
            var officialVerify: OfficialVerify,
            @SerializedName("rank")
            var rank: Int, // 10000
            @SerializedName("sex")
            var sex: Int, // 0
            @SerializedName("show_creative")
            var showCreative: Int, // 1
            @SerializedName("show_videoup")
            var showVideoup: Int, // 1
            @SerializedName("silence")
            var silence: Int, // 0
            @SerializedName("vip_type")
            var vipType: Int // 2
    ) {
        data class OfficialVerify(
                @SerializedName("desc")
                var desc: String,
                @SerializedName("type")
                var type: Int // -1
        )
    }
}
