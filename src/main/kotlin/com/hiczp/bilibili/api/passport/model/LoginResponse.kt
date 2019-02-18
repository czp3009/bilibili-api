package com.hiczp.bilibili.api.passport.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String?,
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("ts")
        var ts: Int // 1550219689
) {
    data class Data(
            @SerializedName("cookie_info")
            var cookieInfo: CookieInfo,
            @SerializedName("sso")
            var sso: List<String>,
            @SerializedName("status")
            var status: Int, // 0
            @SerializedName("token_info")
            var tokenInfo: TokenInfo
    ) {
        data class CookieInfo(
                @SerializedName("cookies")
                var cookies: List<Cookie>,
                @SerializedName("domains")
                var domains: List<String>
        ) {
            data class Cookie(
                    @SerializedName("expires")
                    var expires: Int, // 1552811689
                    @SerializedName("http_only")
                    var httpOnly: Boolean, // 1
                    @SerializedName("name")
                    var name: String, // SESSDATA
                    @SerializedName("value")
                    var value: String // 5ff9ba24%2C1552811689%2C04ae9421
            )
        }

        data class TokenInfo(
                @SerializedName("access_token")
                var accessToken: String, // fd0303ff75a6ec6b452c28f4d8621021
                @SerializedName("expires_in")
                var expiresIn: Int, // 2592000
                @SerializedName("mid")
                var mid: Int, // 20293030
                @SerializedName("refresh_token")
                var refreshToken: String // 6a333ebded3c3dbdde65d136b3190d21
        )
    }
}
