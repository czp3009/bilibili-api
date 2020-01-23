package com.hiczp.bilibili.api.live.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class RoomList(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // success
        @SerializedName("msg")
        var msg: String // success
) {
    data class Data(
            @SerializedName("banner")
            var banner: List<Banner>,
            @SerializedName("count")
            var count: Int, // 5116
            @SerializedName("list")
            var list: List<X>,
            @SerializedName("tags")
            var tags: List<Tag>
    ) {
        data class Banner(
                @SerializedName("id")
                var id: String, // 1117
                @SerializedName("link")
                var link: String, // https://www.bilibili.com/blackboard/live/activity-flower-girl2-h5.html
                @SerializedName("pic")
                var pic: String, // https://i0.hdslb.com/bfs/vc/523a719b51a647eeb969956865a20781d7e6d994.jpg
                @SerializedName("position")
                var position: String, // 5
                @SerializedName("sort_num")
                var sortNum: String, // 1
                @SerializedName("title")
                var title: String // 花之初少女
        )

        data class X(
                @SerializedName("accept_quality")
                var acceptQuality: String, // 4
                @SerializedName("accept_quality_v2")
                var acceptQualityV2: List<JsonElement>,
                @SerializedName("area_id")
                var areaId: Int, // 107
                @SerializedName("area_name")
                var areaName: String, // 其他游戏
                @SerializedName("area_v2_id")
                var areaV2Id: Int, // 107
                @SerializedName("area_v2_name")
                var areaV2Name: String, // 其他游戏
                @SerializedName("area_v2_parent_id")
                var areaV2ParentId: Int, // 2
                @SerializedName("area_v2_parent_name")
                var areaV2ParentName: String, // 网游
                @SerializedName("broadcast_type")
                var broadcastType: Int, // 0
                @SerializedName("corner")
                var corner: String,
                @SerializedName("cover_size")
                var coverSize: CoverSize,
                @SerializedName("current_quality")
                var currentQuality: Int, // 4
                @SerializedName("face")
                var face: String, // https://i0.hdslb.com/bfs/face/9c9ad7d21784e70dfa57cdae40cfdca1b58424c4.jpg
                @SerializedName("game_live_num")
                var gameLiveNum: Int, // 30
                @SerializedName("group_id")
                var groupId: Int, // 0
                @SerializedName("is_tv")
                var isTv: Int, // 0
                @SerializedName("link")
                var link: String, // /21142258
                @SerializedName("online")
                var online: Int, // 0
                @SerializedName("parent_id")
                var parentId: Int, // 2
                @SerializedName("parent_name")
                var parentName: String, // 网游
                @SerializedName("pendent")
                var pendent: String,
                @SerializedName("pendent_ld")
                var pendentLd: String,
                @SerializedName("pendent_ld_color")
                var pendentLdColor: String,
                @SerializedName("pendent_ru")
                var pendentRu: String,
                @SerializedName("pendent_ru_color")
                var pendentRuColor: String,
                @SerializedName("pendent_ru_pic")
                var pendentRuPic: String,
                @SerializedName("pk_id")
                var pkId: Int, // 0
                @SerializedName("play_url")
                var playUrl: String,
                @SerializedName("roomid")
                var roomid: Long, // 21142258
                @SerializedName("session_id")
                var sessionId: String, // E9168524-EA1A-9F86-7A88-E33B58B9C8A8
                @SerializedName("show_cover")
                var showCover: String,
                @SerializedName("system_cover")
                var systemCover: String, // https://i0.hdslb.com/bfs/live/21142258.jpg?03131614
                @SerializedName("title")
                var title: String, // DNF除了肝啥都没
                @SerializedName("uid")
                var uid: Long, // 278287794
                @SerializedName("uname")
                var uname: String, // wz85699909
                @SerializedName("user_cover")
                var userCover: String, // https://i0.hdslb.com/bfs/live/room_cover/dbfd1bbb5f936620a7bccac4b5e51b54342284d1.jpg
                @SerializedName("user_cover_flag")
                var userCoverFlag: Int, // 1
                @SerializedName("web_pendent")
                var webPendent: String
        ) {
            data class CoverSize(
                    @SerializedName("height")
                    var height: Int, // 180
                    @SerializedName("width")
                    var width: Int // 320
            )
        }

        data class Tag(
                @SerializedName("id")
                var id: Int, // -2
                @SerializedName("name")
                var name: String, // 最新
                @SerializedName("sort_type")
                var sortType: String // live_time
        )
    }
}
