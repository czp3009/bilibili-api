package com.hiczp.bilibili.api.test

import com.github.salomonbrys.kotson.byString
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.JsonObject
import com.hiczp.bilibili.api.BilibiliClient
import com.hiczp.bilibili.api.gson
import okhttp3.logging.HttpLoggingInterceptor

//配置文件
private val config = gson.fromJson<JsonObject>(
        Config::class.java.getResourceAsStream("/config.json").reader()
)

//未登录的实例
val noLoginBilibiliClient = BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY)

//登陆过的实例
val bilibiliClient by lazy {
    BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY).apply {
        loginResponse = config["loginResponse"]?.let { gson.fromJson(it) }
    }
}

object Config {
    val username by config.byString

    val password by config.byString
}
