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
            /**
             * 推荐服务器
             */
            @SerializedName("host")
            var host: String, // broadcastlv.chat.bilibili.com
            /**
             * 服务器列表
             */
            @SerializedName("host_server_list")
            var hostServerList: List<HostServer>,
            @SerializedName("max_delay")
            var maxDelay: Int, // 5000
            /**
             * 这里的端口是非 TSL 的 websocket 端口, 需要到 host_server_list 中寻找推荐服务器对应的 websocket TSL 端口(通常是 443)
             */
            @SerializedName("port")
            var port: Int, // 2243
            @SerializedName("refresh_rate")
            var refreshRate: Int, // 100
            @SerializedName("refresh_row_factor")
            var refreshRowFactor: Double, // 0.125
            /**
             * 如果 DNS 失效可以使用该列表中的 IP
             */
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
                /**
                 * websocket 端口
                 */
                @SerializedName("ws_port")
                var wsPort: Int, // 2244
                /**
                 * websocket TSL 端口
                 */
                @SerializedName("wss_port")
                var wssPort: Int // 443
        )
    }
}
