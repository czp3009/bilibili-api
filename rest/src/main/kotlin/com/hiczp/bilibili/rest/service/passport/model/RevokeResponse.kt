package com.hiczp.bilibili.rest.service.passport.model

import com.google.gson.annotations.SerializedName
import com.hiczp.bilibili.rest.service.Ok

data class RevokeResponse(
        @SerializedName("message")
        val message: String? = "", // user not login
        @SerializedName("ts")
        val ts: Long = 0, // 1562653921
        @SerializedName("code")
        val code: Int = 0 // -101
) : Ok {
    override fun ok() = code == 0
}
