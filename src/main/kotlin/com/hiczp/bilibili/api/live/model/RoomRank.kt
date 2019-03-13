package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class RoomRank(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // OK
        @SerializedName("msg")
        var msg: String // OK
) {
    data class Data(
            @SerializedName("color")
            var color: String, // #FB7299
            @SerializedName("h5_url")
            var h5Url: String, // https://live.bilibili.com/p/html/live-app-rankcurrent/index.html?is_live_half_webview=1&hybrid_half_ui=1,5,85p,70p,FFE293,0,30,100,10;2,2,320,100p,FFE293,0,30,100,0;4,2,320,100p,FFE293,0,30,100,0;6,5,65p,60p,FFE293,0,30,100,10;5,5,55p,60p,FFE293,0,30,100,10;3,5,85p,70p,FFE293,0,30,100,10;7,5,65p,60p,FFE293,0,30,100,10;&anchor_uid=2866663&rank_type=master_realtime_hour_room&area_hour=1&area_v2_id=145&area_v2_parent_id=1
            @SerializedName("rank_desc")
            var rankDesc: String, // 小时总榜
            @SerializedName("roomid")
            var roomid: Long, // 29434
            @SerializedName("timestamp")
            var timestamp: Long, // 1552451099
            @SerializedName("web_url")
            var webUrl: String // https://live.bilibili.com/blackboard/room-current-rank.html?rank_type=master_realtime_hour_room&area_hour=1&area_v2_id=145&area_v2_parent_id=1
    )
}
