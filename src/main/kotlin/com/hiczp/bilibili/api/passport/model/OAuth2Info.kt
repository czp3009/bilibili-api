package com.hiczp.bilibili.api.passport.model

import com.google.gson.annotations.SerializedName

data class OAuth2Info(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("ts")
        var ts: Long // 1551865482
) {
    data class Data(
            @SerializedName("access_token")
            var accessToken: String, // 813b20ea7f229795eba7bd31608e3621
            @SerializedName("expires_in")
            var expiresIn: Long, // 1797151
            @SerializedName("mid")
            var mid: Long // 20293030
    )
}
