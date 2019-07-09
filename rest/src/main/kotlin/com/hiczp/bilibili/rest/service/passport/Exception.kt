@file:Suppress("CanBeParameter", "MemberVisibilityCanBePrivate")

package com.hiczp.bilibili.rest.service.passport

import com.hiczp.bilibili.rest.service.passport.model.LoginResponse
import com.hiczp.bilibili.rest.service.passport.model.RevokeResponse

class LoginException internal constructor(val loginResponse: LoginResponse) : IllegalStateException(loginResponse.message)

class RevokeException internal constructor(val revokeResponse: RevokeResponse) : IllegalStateException(revokeResponse.message)
