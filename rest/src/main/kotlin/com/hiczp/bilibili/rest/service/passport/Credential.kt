package com.hiczp.bilibili.rest.service.passport

import com.hiczp.bilibili.rest.service.passport.model.LoginResponse
import io.ktor.http.Cookie
import io.ktor.util.date.GMTDate
import java.io.Serializable

data class Credential(
        val userId: Long,
        val accessToken: String,
        val refreshToken: String,
        val expiresIn: Long,
        val cookies: List<Cookie> = emptyList()
) : Serializable

fun Credential.cookieMap() = cookies.associate { it.name to it.value }

fun LoginResponse.toCredential() = Credential(
        mid, accessToken, refreshToken, expiresIn,
        data.cookieInfo.cookies.map {
            Cookie(name = it.name, value = it.value, httpOnly = it.httpOnly == 1, expires = GMTDate(it.expires))
        }
)
