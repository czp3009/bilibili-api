package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class Tab(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Map<String, List<UIElement>>,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ver")
        var ver: String // 5720051238481856755
) {
    data class UIElement(
            @SerializedName("default_selected")
            var defaultSelected: Int, // 1
            @SerializedName("id")
            var id: Int, // 30
            @SerializedName("name")
            var name: String, // 追番
            @SerializedName("pos")
            var pos: Int, // 4
            @SerializedName("tab_id")
            var tabId: String, // 追番Tab
            @SerializedName("uri")
            var uri: String // bilibili://pgc/home
    )
}
