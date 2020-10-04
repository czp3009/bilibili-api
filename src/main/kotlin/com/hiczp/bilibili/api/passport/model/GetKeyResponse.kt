package com.hiczp.bilibili.api.passport.model

import com.hiczp.bilibili.api.utils.PEM

//{
//	"ts": 1584208643,
//	"code": 0,
//	"data": {
//		"hash": "2e5f153071bede36",
//		"key": "-----BEGIN PUBLIC KEY-----\nMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjb4V7EidX/ym28t2ybo0U6t0n\n6p4ej8VjqKHg100va6jkNbNTrLQqMCQCAYtXMXXp2Fwkk6WR+12N9zknLjf+C9sx\n/+l48mjUU8RqahiFD1XT/u2e0m2EN029OhCgkHx3Fc/KlFSIbak93EH/XlYis0w+\nXl69GV6klzgxW6d2xQIDAQAB\n-----END PUBLIC KEY-----\n"
//	}
//}
data class GetKeyResponse(
    val message: String?,
    val ts: Long, // 1562229380
    val code: Int, // 0
    val `data`: Data
) {
    data class Data(
        val hash: String, // a953480d976dd1ba
        val key: PEM  // -----BEGIN PUBLIC KEY-----MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjb4V7EidX/ym28t2ybo0U6t0n6p4ej8VjqKHg100va6jkNbNTrLQqMCQCAYtXMXXp2Fwkk6WR+12N9zknLjf+C9sx/+l48mjUU8RqahiFD1XT/u2e0m2EN029OhCgkHx3Fc/KlFSIbak93EH/XlYis0w+Xl69GV6klzgxW6d2xQIDAQAB-----END PUBLIC KEY-----
    )

    val hash get() = data.hash
    val key get() = data.key
}
