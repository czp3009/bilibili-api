package com.hiczp.bilibili.api.test

import com.github.salomonbrys.kotson.byString
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.hiczp.bilibili.api.BilibiliClient
import okhttp3.logging.HttpLoggingInterceptor

object Config {
    @Suppress("SpellCheckingInspection")
    private val gson = Gson()

    private val config = gson.fromJson<JsonObject>(
            Config::class.java.getResourceAsStream("/config.json").reader()
    )

    val username by config.byString

    val password by config.byString

    //登陆过的实例
    val bilibiliClient by lazy {
        BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY).apply {
            loginResponse = config["loginResponse"]?.let { gson.fromJson(it) }
        }
    }

    //未登录的实例
    val noLoginBilibiliClient = BilibiliClient(logLevel = HttpLoggingInterceptor.Level.BODY)
}
