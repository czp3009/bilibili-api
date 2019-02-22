package com.hiczp.bilibili.api.retrofit

//该文件用于防止拼写错误

object Method {
    const val GET = "GET"
    const val POST = "POST"
    const val PATCH = "PATCH"
    const val PUT = "PUT"
    const val DELETE = "DELETE"
    const val OPTION = "OPTION"
}

object Header {
    const val JSON = "application/json"
    const val FORM_URLENCODED = "application/x-www-form-urlencoded; charset=utf-8"
    const val ZH_CN = "zh-CN,zh;q=0.8"
}

object Param {
    const val ACCESS_KEY = "access_key"
    @Suppress("SpellCheckingInspection")
    const val APP_KEY = "appkey"
    const val SIGN = "sign"
}
