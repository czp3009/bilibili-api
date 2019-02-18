package com.hiczp.bilibili.api.test

import com.google.gson.Gson
import com.google.gson.JsonObject

object Config {
    private val config = Gson().fromJson(
            Config::class.java.getResourceAsStream("/config.json").reader(),
            JsonObject::class.java
    )

    val username = config["username"].asString!!

    val password = config["password"].asString!!
}
