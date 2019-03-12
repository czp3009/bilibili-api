package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class DanmakuConfig(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // ok
        @SerializedName("msg")
        var msg: String // ok
) {
    data class Data(
            @SerializedName("host")
            var host: String, // broadcastlv.chat.bilibili.com
            @SerializedName("host_server_list")
            var hostServerList: List<HostServer>,
            @SerializedName("max_delay")
            var maxDelay: Int, // 5000
            @SerializedName("port")
            var port: Int, // 2243
            @SerializedName("refresh_rate")
            var refreshRate: Int, // 100
            @SerializedName("refresh_row_factor")
            var refreshRowFactor: Double, // 0.125
            @SerializedName("server_list")
            var serverList: List<Server>
    ) {
        data class Server(
                @SerializedName("host")
                var host: String, // broadcastlv.chat.bilibili.com
                @SerializedName("port")
                var port: Int // 80
        )

        data class HostServer(
                @SerializedName("host")
                var host: String, // broadcastlv.chat.bilibili.com
                @SerializedName("port")
                var port: Int, // 2243
                @SerializedName("ws_port")
                var wsPort: Int, // 2244
                @SerializedName("wss_port")
                var wssPort: Int // 443
        )
    }
}
