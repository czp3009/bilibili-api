package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class MobileTab(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: List<Tab>,
        @SerializedName("message")
        var message: String,
        @SerializedName("msg")
        var msg: String
) {
    data class Tab(
            /**
             * 如果是非顶层 Tab 则 default 为 null
             */
            @SerializedName("default")
            var default: Int? = null, // 0
            @SerializedName("default_sub_tab")
            var defaultSubTab: String,
            @SerializedName("desc")
            var desc: String, // 友爱社
            @SerializedName("order")
            var order: Int, // 600
            @SerializedName("status")
            var status: Int, // 0
            @SerializedName("sub_tab")
            var subTab: List<Tab>,
            @SerializedName("type")
            var type: String, // love-club
            @SerializedName("url")
            var url: String
    )
}
