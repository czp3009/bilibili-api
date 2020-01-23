package com.hiczp.bilibili.api.main.model

import com.google.gson.annotations.SerializedName

data class SendReplyResponse(
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
            @SerializedName("dialog")
            var dialog: Long, // 0
            @SerializedName("dialog_str")
            var dialogStr: String, // 0
            @SerializedName("parent")
            var parent: Long, // 0
            @SerializedName("parent_str")
            var parentStr: String, // 0
            @SerializedName("root")
            var root: Long, // 0
            @SerializedName("root_str")
            var rootStr: String, // 0
            @SerializedName("rpid")
            var rpid: Long, // 1422858564
            @SerializedName("rpid_str")
            var rpidStr: String // 1422858564
    )
}
