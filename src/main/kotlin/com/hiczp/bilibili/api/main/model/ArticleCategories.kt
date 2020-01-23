package com.hiczp.bilibili.api.main.model

import com.google.gson.annotations.SerializedName

data class ArticleCategories(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: List<Category>,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ttl")
        var ttl: Int // 1
) {
    data class Category(
            @SerializedName("children")
            var children: List<Category>,
            @SerializedName("id")
            var id: Int, // 17
            @SerializedName("name")
            var name: String, // 科技
            @SerializedName("parent_id")
            var parentId: Int // 0
    )
}
