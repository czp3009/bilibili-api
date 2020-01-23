package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class MobileRoom(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // ok
        @SerializedName("msg")
        var msg: String // ok
) {
    data class Data(
            @SerializedName("encrypted")
            var encrypted: Boolean, // false
            @SerializedName("hidden_till")
            var hiddenTill: Int, // 0
            @SerializedName("is_hidden")
            var isHidden: Boolean, // false
            @SerializedName("is_locked")
            var isLocked: Boolean, // false
            @SerializedName("is_portrait")
            var isPortrait: Boolean, // false
            @SerializedName("is_sp")
            var isSp: Int, // 0
            @SerializedName("live_status")
            var liveStatus: Int, // 0
            @SerializedName("live_time")
            var liveTime: Long, // -62170012800
            @SerializedName("lock_till")
            var lockTill: Int, // 0
            @SerializedName("need_p2p")
            var needP2p: Int, // 0
            @SerializedName("pwd_verified")
            var pwdVerified: Boolean, // true
            /**
             * 实际房间号
             */
            @SerializedName("room_id")
            var roomId: Long, // 1110317
            /**
             * 如果房间有短号则 roomShield 为 1
             */
            @SerializedName("room_shield")
            var roomShield: Int, // 0
            /**
             * 短房间号
             */
            @SerializedName("short_id")
            var shortId: Int, // 0
            @SerializedName("special_type")
            var specialType: Int, // 0
            @SerializedName("uid")
            var uid: Long // 20293030
    )
}
