package com.hiczp.bilibili.api.passport.model

//{
//	"code": 0,
//	"message": "0",
//	"ttl": 1
//}
data class RevokeResponse(
    val message: String?, // user not login
    val ts: Long?, // 1562653921
    val code: Int,  // -101
    val ttl: Int? // 1
)
