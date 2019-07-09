package com.hiczp.bilibili.rest.service

interface Ok {
    fun ok(): Boolean
}

inline fun <T : Ok> T.orThrow(block: (T) -> Throwable) = if (ok()) this else throw block(this)
