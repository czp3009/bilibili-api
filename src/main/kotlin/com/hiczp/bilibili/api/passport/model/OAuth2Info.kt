package com.hiczp.bilibili.api.passport.model

import com.google.gson.annotations.SerializedName

//{
//	"ts": 1584209074,
//	"code": 0,
//	"data": {
//		"mid": 20293030,
//		"access_token": "53802794ed685411e30b320614261031",
//		"expires_in": 2591992
//	}
//}
data class OAuth2Info(
    val message: String?,
    val ts: Long, // 1562505063
    val code: Int, // 0
    val `data`: Data
) {
    data class Data(
        val mid: Long, // 20293030
        @SerializedName("access_token")
        val accessToken: String, // eb371c8f089f33da2fc65e5607269d71
        @SerializedName("expires_in")
        val expiresIn: Long  // 2591950
    )

    val mid get() = data.mid
    val accessToken get() = data.accessToken
    val expiresIn get() = data.expiresIn
}
