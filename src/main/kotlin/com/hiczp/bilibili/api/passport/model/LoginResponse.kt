package com.hiczp.bilibili.api.passport.model

import com.google.gson.annotations.SerializedName

//{
//	"ts": 1584208643,
//	"code": 0,
//	"data": {
//		"status": 0,
//		"token_info": {
//			"mid": 20293030,
//			"access_token": "4dcbc20bf766938a3501a64e61e8ca31",
//			"refresh_token": "e61048dbc3f9added8527ac025352731",
//			"expires_in": 2592000
//		},
//		"cookie_info": {
//			"cookies": [{
//				"name": "bili_jct",
//				"value": "43afa5cec21c54207185d44795dc7d09",
//				"http_only": 0,
//				"expires": 1586800643
//			}, {
//				"name": "DedeUserID",
//				"value": "20293030",
//				"http_only": 0,
//				"expires": 1586800643
//			}, {
//				"name": "DedeUserID__ckMd5",
//				"value": "cdff5c8e58b793cc",
//				"http_only": 0,
//				"expires": 1586800643
//			}, {
//				"name": "sid",
//				"value": "ai99lik7",
//				"http_only": 0,
//				"expires": 1586800643
//			}, {
//				"name": "SESSDATA",
//				"value": "7a6de960%2C1586800643%2Ce06aee31",
//				"http_only": 1,
//				"expires": 1586800643
//			}],
//			"domains": [".bilibili.com", ".biligame.com", ".im9.com", ".bigfunapp.cn"]
//		},
//		"sso": ["https://passport.bilibili.com/api/v2/sso", "https://passport.biligame.com/api/v2/sso", "https://passport.im9.com/api/v2/sso", "https://passport.bigfunapp.cn/api/v2/sso"]
//	}
//}
data class LoginResponse(
    val message: String?, // "验证码错误"
    val ts: Long, // 1562229381
    val code: Int, // 0
    /**
     * 密码错误时, 可能没有 data 字段
     */
    val `data`: Data
) {
    /**
     * 如果登陆失败, 例如需要验证手机号, 需要极验等, 此时会有 url 字段并且其他字段可能不存在(包括 status 也可能不存在)
     */
    data class Data(
        val url: String?,
        val status: Int, // 0
        @SerializedName("token_info")
        val tokenInfo: TokenInfo,
        @SerializedName("cookie_info")
        val cookieInfo: CookieInfo,
        val sso: List<String>
    ) {
        data class CookieInfo(
            val cookies: List<Cookie>,
            val domains: List<String>
        ) {
            data class Cookie(
                val name: String, // SESSDATA
                val value: String, // 824135b9%2C1564821381%2C7aa53171
                @SerializedName("http_only")
                val httpOnly: Int, // 1
                /**
                 * 时间戳
                 */
                val expires: Long // 1564821381
            )
        }

        data class TokenInfo(
            /**
             * 用户 ID
             */
            val mid: Long, // 20293030
            @SerializedName("access_token")
            val accessToken: String, // 4c50c1a6f82c76f32beebe646c1cc771
            @SerializedName("refresh_token")
            val refreshToken: String, // c8bbbaa1ba576d672fffb36f03b11971
            /**
             * 单位为秒, 每个 token 的有效期为一个月
             */
            @SerializedName("expires_in")
            val expiresIn: Long  // 2592000
        )
    }

    val mid get() = data.tokenInfo.mid
    val accessToken get() = data.tokenInfo.accessToken
    val refreshToken get() = data.tokenInfo.refreshToken
    val expiresIn get() = data.tokenInfo.expiresIn
}
