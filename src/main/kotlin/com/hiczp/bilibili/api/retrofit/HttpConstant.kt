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
    const val DISPLAY_ID = "Display-ID"
    @Suppress("SpellCheckingInspection")
    const val BUILD_VERSION_ID = "Buvid"
    const val DEVICE_ID = "Device-ID"
    const val USER_AGENT = "User-Agent"
    const val ACCEPT = "Accept"
    const val ACCEPT_LANGUAGE = "Accept-Language"
    const val ACCEPT_ENCODING = "Accept-Encoding"

    //强制公共参数添加位置
    const val FORCE_PARAM = "Retrofit-Force-Param"
    const val FORCE_PARAM_QUERY = "query"
    const val FORCE_PARAM_FORMBODY = "formBody"
    const val FORCE_QUERY = "$FORCE_PARAM: $FORCE_PARAM_QUERY"
    const val FORCE_FORMBODY = "$FORCE_PARAM: $FORCE_PARAM_FORMBODY"
}

object Param {
    const val ACCESS_KEY = "access_key"
    @Suppress("SpellCheckingInspection")
    const val APP_KEY = "appkey"
    const val ACTION_KEY = "actionKey"
    const val BUILD = "build"
    @Suppress("SpellCheckingInspection")
    const val BUILD_VERSION_ID = "buvid"
    const val CHANNEL = "channel"
    @Suppress("ObjectPropertyName")
    const val _DEVICE = "_device"
    const val DEVICE = "device"
    @Suppress("ObjectPropertyName", "SpellCheckingInspection")
    const val _HARDWARE_ID = "_hwid"
    const val SOURCE = "src"
    const val TRACE_ID = "trace_id"
    const val USER_ID = "uid"
    const val VERSION = "version"
    @Suppress("SpellCheckingInspection")
    const val MOBILE_APP = "mobi_app"
    const val PLATFORM = "platform"
    const val TIMESTAMP = "ts"
    const val EXPIRE = "expire"
    const val MID = "mid"
    const val SIGN = "sign"
}

internal object Charsets {
    const val UTF_8 = "UTF-8"
}
