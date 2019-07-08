package com.hiczp.bilibili.rest.service

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonElement
import com.google.gson.JsonObject

typealias Response = JsonObject

/**
 * code 为 0 表示请求正确返回
 */
val Response.code
    get() = this["code"].int

val Response.msg
    get() = this["msg"]?.string

val Response.message
    get() = this["message"]?.string

val Response.data: JsonElement?
    get() = this["data"]

val Response.dataAsObj
    get() = this["data"].obj

val Response.dataAsArray
    get() = this["data"].array

val Response.dataAsString
    get() = this["data"].string

val Response.timestamp
    get() = this["ts"]?.long

fun Response.ok() = code == 0
