package com.hiczp.bilibili.rest.service.passport.model

import com.google.gson.annotations.SerializedName
import com.hiczp.bilibili.rest.service.Ok

data class GetKeyResponse(
        @SerializedName("message")
        val message: String? = null,
        @SerializedName("ts")
        val ts: Long = 0, // 1562229380
        @SerializedName("code")
        val code: Int = 0, // 0
        @SerializedName("data")
        val `data`: Data = Data()
) : Ok {
    data class Data(
            @SerializedName("hash")
            val hash: String = "", // a953480d976dd1ba
            @SerializedName("key")
            val key: String = "" // -----BEGIN PUBLIC KEY-----MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDjb4V7EidX/ym28t2ybo0U6t0n6p4ej8VjqKHg100va6jkNbNTrLQqMCQCAYtXMXXp2Fwkk6WR+12N9zknLjf+C9sx/+l48mjUU8RqahiFD1XT/u2e0m2EN029OhCgkHx3Fc/KlFSIbak93EH/XlYis0w+Xl69GV6klzgxW6d2xQIDAQAB-----END PUBLIC KEY-----
    )

    override fun ok() = code == 0

    val hash get() = data.hash
    val key get() = data.key
}
