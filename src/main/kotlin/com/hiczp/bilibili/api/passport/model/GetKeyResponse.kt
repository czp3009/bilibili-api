package com.hiczp.bilibili.api.passport.model

import com.google.gson.annotations.SerializedName

data class GetKeyResponse(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String?,
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("ts")
        var ts: Int // 1550219688
) {
    data class Data(
            @SerializedName("hash")
            var hash: String, // 93ac6f60b4789952
            @SerializedName("key")
            var key: String // -----BEGIN PUBLIC KEY-----MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdScM09sZJqFPX7bvmB2y6i08JbHsa0v4THafPbJN9NoaZ9Djz1LmeLkVlmWx1DwgHVW+K7LVWT5FV3johacVRuV9837+RNntEK6SE82MPcl7fA++dmW2cLlAjsIIkrX+aIvvSGCuUfcWpWFy3YVDqhuHrNDjdNcaefJIQHMW+sQIDAQAB-----END PUBLIC KEY-----
    )
}
