package com.hiczp.bilibili.rest.service.passport.model

import com.google.gson.annotations.SerializedName
import com.hiczp.bilibili.rest.service.Ok

data class OAuth2Info(
        @SerializedName("message")
        val message: String? = null,
        @SerializedName("ts")
        val ts: Long = 0, // 1562505063
        @SerializedName("code")
        val code: Int = 0, // 0
        @SerializedName("data")
        val `data`: Data = Data()
) : Ok {
    data class Data(
            @SerializedName("mid")
            val mid: Long = 0, // 20293030
            @SerializedName("access_token")
            val accessToken: String = "", // eb371c8f089f33da2fc65e5607269d71
            @SerializedName("expires_in")
            val expiresIn: Long = 0 // 2591950
    )

    override fun ok() = code == 0

    val mid get() = data.mid
    val accessToken get() = data.accessToken
    val expiresIn get() = data.expiresIn
}
