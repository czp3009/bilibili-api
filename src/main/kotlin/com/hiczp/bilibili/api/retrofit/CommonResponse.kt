package com.hiczp.bilibili.api.retrofit

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

/**
 * 通用实体, 可表示无 data 的响应 或 错误响应
 * code 为 0 表示正常响应, 此时 message 为 null
 * code 不为 0 表示错误响应, 此时 data 可能是各种类型
 * 一些 API 同时有 msg 和 message
 */
data class CommonResponse(
        @SerializedName("code")
        var code: Int, // 0

        @SerializedName("msg")
        var msg: String?,

        @SerializedName("message")
        var message: String?,

        @SerializedName("ts")
        var timestamp: Long, // 1550546539

        /**
         * data 可能是各种类型, 例如 array, object, string
         */
        @SerializedName("data")
        var data: JsonElement?
)
