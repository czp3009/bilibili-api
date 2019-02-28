package com.hiczp.bilibili.api.main.model

import com.google.gson.annotations.SerializedName

data class RelationTags(
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
            /**
             * all 不是指全部, 而是指 公开关注
             */
            @SerializedName("all")
            var all: List<Tag>,
            @SerializedName("default")
            var default: List<Tag>,
            @SerializedName("list")
            var list: List<Tag>,
            @SerializedName("special")
            var special: List<Tag>
    ) {
        @Suppress("SpellCheckingInspection")
        data class Tag(
                @SerializedName("count")
                var count: Int, // 28
                @SerializedName("name")
                var name: String, // 公开关注
                @SerializedName("tagid")
                var tagid: Int // -1
        )
    }
}
