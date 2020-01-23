package com.hiczp.bilibili.api.vc.model

import com.google.gson.annotations.SerializedName

data class DynamicNumber(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String,
        @SerializedName("msg")
        var msg: String
) {
    data class Data(
            @SerializedName("_gt_")
            var gt: Int, // 0
            @SerializedName("exist_gap")
            var existGap: Int, // 1
            @SerializedName("new_num")
            var newNum: Int, // 30
            @SerializedName("update_num")
            var updateNum: Int // 100
    )
}
