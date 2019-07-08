package com.hiczp.bilibili.rest.service.passport.model

import com.google.gson.annotations.SerializedName
import com.hiczp.bilibili.rest.service.Ok

data class LoginResponse(
        @SerializedName("message")
        val message: String? = null,
        @SerializedName("ts")
        val ts: Long = 0, // 1562229381
        @SerializedName("code")
        val code: Int = 0, // 0
        @SerializedName("data")
        val `data`: Data = Data()
) : Ok {
    data class Data(
            @SerializedName("url")
            val url: String? = null,
            @SerializedName("status")
            val status: Int = 0, // 0
            @SerializedName("token_info")
            val tokenInfo: TokenInfo = TokenInfo(),
            @SerializedName("cookie_info")
            val cookieInfo: CookieInfo = CookieInfo(),
            @SerializedName("sso")
            val sso: List<String> = listOf()
    ) {
        data class CookieInfo(
                @SerializedName("cookies")
                val cookies: List<Cookie> = listOf(),
                @SerializedName("domains")
                val domains: List<String> = listOf()
        ) {
            data class Cookie(
                    @SerializedName("name")
                    val name: String = "", // SESSDATA
                    @SerializedName("value")
                    val value: String = "", // 824135b9%2C1564821381%2C7aa53171
                    @SerializedName("http_only")
                    val httpOnly: Int = 0, // 1
                    @SerializedName("expires")
                    val expires: Long = 0 // 1564821381
            )
        }

        data class TokenInfo(
                @SerializedName("mid")
                val mid: Long = 0, // 20293030
                @SerializedName("access_token")
                val accessToken: String = "", // 4c50c1a6f82c76f32beebe646c1cc771
                @SerializedName("refresh_token")
                val refreshToken: String = "", // c8bbbaa1ba576d672fffb36f03b11971
                @SerializedName("expires_in")
                val expiresIn: Long = 0 // 2592000
        )
    }

    override fun ok() = code == 0

    val mid get() = data.tokenInfo.mid
    val accessToken get() = data.tokenInfo.accessToken
    val refreshToken get() = data.tokenInfo.refreshToken
    val expiresIn get() = data.tokenInfo.expiresIn
}
