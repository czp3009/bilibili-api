package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class MyInfo(
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
            @SerializedName("birthday")
            var birthday: String, // 1995-11-18
            @SerializedName("coins")
            var coins: Int, // 1025
            @SerializedName("email_status")
            var emailStatus: Int, // 0
            @SerializedName("face")
            var face: String, // http://i1.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg
            @SerializedName("identification")
            var identification: Int, // 1
            @SerializedName("level")
            var level: Int, // 4
            @SerializedName("mid")
            var mid: Int, // 20293030
            @SerializedName("name")
            var name: String, // czp3009
            @SerializedName("official")
            var official: Official,
            @SerializedName("rank")
            var rank: Int, // 10000
            @SerializedName("sex")
            var sex: Int, // 0
            @SerializedName("sign")
            var sign: String,
            @SerializedName("silence")
            var silence: Int, // 0
            @SerializedName("tel_status")
            var telStatus: Int, // 1
            @SerializedName("vip")
            var vip: Vip
    ) {
        data class Official(
                @SerializedName("desc")
                var desc: String,
                @SerializedName("role")
                var role: Int, // 0
                @SerializedName("title")
                var title: String
        )

        data class Vip(
                @SerializedName("due_date")
                var dueDate: Long, // 0
                @SerializedName("status")
                var status: Int, // 0
                @SerializedName("type")
                var type: Int, // 0
                @SerializedName("vip_pay_type")
                var vipPayType: Int // 0
        )
    }
}
