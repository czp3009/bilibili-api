package com.hiczp.bilibili.api.live.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class HomePage(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: Data,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ttl")
        var ttl: Int // 1
) {
    data class Data(
            @SerializedName("activity_card")
            var activityCard: List<JsonElement>,
            @SerializedName("area_entrance")
            var areaEntrance: List<AreaEntrance>,
            @SerializedName("area_entrance_v2")
            var areaEntranceV2: List<JsonElement>,
            @SerializedName("banner")
            var banner: List<Banner>,
            @SerializedName("hour_rank")
            var hourRank: List<HourRank>,
            @SerializedName("interval")
            var interval: Int, // 10
            @SerializedName("is_sky_horse_gray")
            var isSkyHorseGray: Int, // 0
            @SerializedName("my_idol")
            var myIdol: List<MyIdol>,
            @SerializedName("my_tag")
            var myTag: List<MyTag>,
            @SerializedName("room_list")
            var roomList: List<Room>,
            @SerializedName("sea_patrol")
            var seaPatrol: List<JsonElement>
    ) {
        data class MyTag(
                @SerializedName("extra_info")
                var extraInfo: ExtraInfo,
                @SerializedName("list")
                var list: List<X>,
                @SerializedName("module_info")
                var moduleInfo: ModuleInfo
        ) {
            data class X(
                    @SerializedName("area_v2_id")
                    var areaV2Id: Int, // 0
                    @SerializedName("area_v2_name")
                    var areaV2Name: String, // 全部标签
                    @SerializedName("area_v2_parent_id")
                    var areaV2ParentId: Int, // 0
                    @SerializedName("area_v2_parent_name")
                    var areaV2ParentName: String,
                    @SerializedName("is_advice")
                    var isAdvice: Int, // 1
                    @SerializedName("link")
                    var link: String, // http://live.bilibili.com/app/mytag/
                    @SerializedName("pic")
                    var pic: String // http://i0.hdslb.com/bfs/vc/ff03528785fc8c91491d79e440398484811d6d87.png
            )

            data class ModuleInfo(
                    @SerializedName("count")
                    var count: Int, // 0
                    @SerializedName("id")
                    var id: Int, // 28
                    @SerializedName("link")
                    var link: String,
                    @SerializedName("pic")
                    var pic: String,
                    @SerializedName("sort")
                    var sort: Int, // 1
                    @SerializedName("title")
                    var title: String, // 常用标签
                    @SerializedName("type")
                    var type: Int // 12
            )

            data class ExtraInfo(
                    @SerializedName("is_gray")
                    var isGray: Int, // 0
                    @SerializedName("offline")
                    var offline: List<JsonElement>
            )
        }

        data class Room(
                @SerializedName("list")
                var list: List<X>,
                @SerializedName("module_info")
                var moduleInfo: ModuleInfo
        ) {
            data class X(
                    @SerializedName("accept_quality")
                    var acceptQuality: List<Int>,
                    @SerializedName("area_v2_id")
                    var areaV2Id: Int, // 96
                    @SerializedName("area_v2_name")
                    var areaV2Name: String, // 其他绘画
                    @SerializedName("area_v2_parent_id")
                    var areaV2ParentId: Int, // 4
                    @SerializedName("area_v2_parent_name")
                    var areaV2ParentName: String, // 绘画
                    @SerializedName("broadcast_type")
                    var broadcastType: Int, // 0
                    @SerializedName("click_callback")
                    var clickCallback: String,
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/live/room_cover/6ef5b522bdf4de9fe2535b6031ae9b32c405cea0.jpg
                    @SerializedName("current_quality")
                    var currentQuality: Int, // 4
                    @SerializedName("face")
                    var face: String, // http://i0.hdslb.com/bfs/face/c165088330c1bd7f671b427b610379603aa002ae.jpg
                    @SerializedName("group_id")
                    var groupId: Int, // 0
                    @SerializedName("link")
                    var link: String,
                    @SerializedName("online")
                    var online: Int, // 5584
                    @SerializedName("pendent_ru")
                    var pendentRu: String,
                    @SerializedName("pendent_ru_color")
                    var pendentRuColor: String,
                    @SerializedName("pendent_ru_pic")
                    var pendentRuPic: String,
                    @SerializedName("pk_id")
                    var pkId: Int, // 0
                    @SerializedName("play_url")
                    var playUrl: String, // http://ws.live-play.acgvideo.com/live-ws/403834/live_397298321_43558493.flv?wsSecret=9dc8725a77c8ef5c68545e436f53b917&wsTime=1552470101&trid=9179fec58e79438aab34a9bbe5087e33&sig=no
                    @SerializedName("play_url_h265")
                    var playUrlH265: String,
                    @SerializedName("rec_type")
                    var recType: Int, // 0
                    @SerializedName("roomid")
                    var roomid: Long, // 21218600
                    @SerializedName("session_id")
                    var sessionId: String, // 456BB3BF-16D6-4BD3-9B4E-4570C274CEE5
                    @SerializedName("show_callback")
                    var showCallback: String,
                    @SerializedName("title")
                    var title: String, // 学员答疑13：00~21：00
                    @SerializedName("uname")
                    var uname: String // 轻微课魔鬼绘画特训班
            )

            data class ModuleInfo(
                    @SerializedName("count")
                    var count: Int, // 0
                    @SerializedName("id")
                    var id: Int, // 8
                    @SerializedName("link")
                    var link: String, // http://live.bilibili.com/app/area?parent_area_id=4&parent_area_name=绘画&area_id=&area_name=
                    @SerializedName("pic")
                    var pic: String, // http://i0.hdslb.com/bfs/live/7c54d7cc64e022845fccd63221de069b71eb6f67.png
                    @SerializedName("sort")
                    var sort: Int, // 25
                    @SerializedName("title")
                    var title: String, // 绘画
                    @SerializedName("type")
                    var type: Int // 9
            )
        }

        data class AreaEntrance(
                @SerializedName("list")
                var list: List<X>,
                @SerializedName("module_info")
                var moduleInfo: ModuleInfo
        ) {
            data class ModuleInfo(
                    @SerializedName("count")
                    var count: Int, // 0
                    @SerializedName("id")
                    var id: Int, // 2
                    @SerializedName("link")
                    var link: String,
                    @SerializedName("pic")
                    var pic: String,
                    @SerializedName("sort")
                    var sort: Int, // 2
                    @SerializedName("title")
                    var title: String, // 分区入口
                    @SerializedName("type")
                    var type: Int // 2
            )

            data class X(
                    @SerializedName("content")
                    var content: String,
                    @SerializedName("id")
                    var id: Int, // 45
                    @SerializedName("link")
                    var link: String, // http://live.bilibili.com/app/area?parent_area_id=1&parent_area_name=娱乐&area_id=199&area_name=虚拟主播
                    @SerializedName("pic")
                    var pic: String, // http://i0.hdslb.com/bfs/vc/7725a45469b776ee91f2d42afca1e5711f84ac51.png
                    @SerializedName("title")
                    var title: String // 虚拟主播
            )
        }

        data class Banner(
                @SerializedName("list")
                var list: List<X>,
                @SerializedName("module_info")
                var moduleInfo: ModuleInfo
        ) {
            data class X(
                    @SerializedName("content")
                    var content: String,
                    @SerializedName("id")
                    var id: Int, // 1117
                    @SerializedName("link")
                    var link: String, // https://www.bilibili.com/blackboard/live/activity-flower-girl2-h5.html
                    @SerializedName("pic")
                    var pic: String, // http://i0.hdslb.com/bfs/vc/523a719b51a647eeb969956865a20781d7e6d994.jpg
                    @SerializedName("title")
                    var title: String // 花之初少女
            )

            data class ModuleInfo(
                    @SerializedName("count")
                    var count: Int, // 0
                    @SerializedName("id")
                    var id: Int, // 1
                    @SerializedName("link")
                    var link: String,
                    @SerializedName("pic")
                    var pic: String,
                    @SerializedName("sort")
                    var sort: Int, // 0
                    @SerializedName("title")
                    var title: String, // banner位
                    @SerializedName("type")
                    var type: Int // 1
            )
        }

        data class MyIdol(
                @SerializedName("extra_info")
                var extraInfo: ExtraInfo,
                @SerializedName("list")
                var list: List<X>,
                @SerializedName("module_info")
                var moduleInfo: ModuleInfo
        ) {
            data class ExtraInfo(
                    @SerializedName("card_type")
                    var cardType: Int, // 1
                    @SerializedName("relation_page")
                    var relationPage: Int, // 1
                    @SerializedName("tags_desc")
                    var tagsDesc: String,
                    @SerializedName("time_desc")
                    var timeDesc: String,
                    @SerializedName("total_count")
                    var totalCount: Int, // 1
                    @SerializedName("uname_desc")
                    var unameDesc: String
            )

            data class ModuleInfo(
                    @SerializedName("count")
                    var count: Int, // 0
                    @SerializedName("id")
                    var id: Int, // 13
                    @SerializedName("link")
                    var link: String, // http://live.bilibili.com/app/myfollow/
                    @SerializedName("pic")
                    var pic: String, // http://i0.hdslb.com/bfs/live/484abcd8940ee43ec8b4409cbfe0c1e52f09a338.png
                    @SerializedName("sort")
                    var sort: Int, // 4
                    @SerializedName("title")
                    var title: String, // 我的关注
                    @SerializedName("type")
                    var type: Int // 8
            )

            data class X(
                    @SerializedName("accept_quality")
                    var acceptQuality: List<Int>,
                    @SerializedName("area")
                    var area: Int, // 7
                    @SerializedName("area_name")
                    var areaName: String, // 放映厅
                    @SerializedName("area_v2_id")
                    var areaV2Id: Int, // 34
                    @SerializedName("area_v2_name")
                    var areaV2Name: String, // 音乐台
                    @SerializedName("area_v2_parent_id")
                    var areaV2ParentId: Int, // 1
                    @SerializedName("area_v2_parent_name")
                    var areaV2ParentName: String, // 娱乐
                    @SerializedName("broadcast_type")
                    var broadcastType: Int, // 0
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg
                    @SerializedName("current_quality")
                    var currentQuality: Int, // 4
                    @SerializedName("face")
                    var face: String, // http://i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
                    @SerializedName("link")
                    var link: String, // http://live.bilibili.com/23058?broadcast_type=0
                    @SerializedName("live_tag_name")
                    var liveTagName: String, // 音乐台
                    @SerializedName("live_time")
                    var liveTime: Int, // 1552406400
                    @SerializedName("official_verify")
                    var officialVerify: Int, // 1
                    @SerializedName("online")
                    var online: Int, // 9961
                    @SerializedName("pendent_ru")
                    var pendentRu: String,
                    @SerializedName("pendent_ru_color")
                    var pendentRuColor: String,
                    @SerializedName("pendent_ru_pic")
                    var pendentRuPic: String,
                    @SerializedName("pk_id")
                    var pkId: Int, // 0
                    @SerializedName("play_url")
                    var playUrl: String, // http://ws.live-play.acgvideo.com/live-ws/637609/live_11153765_9369560.flv?wsSecret=49e118106b827b5008e10b0c74fa1a5a&wsTime=1552470101&trid=fe3b3a0b017a439c86d792ab5dd6fcd5&sig=no
                    @SerializedName("play_url_h265")
                    var playUrlH265: String,
                    @SerializedName("roomid")
                    var roomid: Long, // 23058
                    @SerializedName("special_attention")
                    var specialAttention: Int, // 0
                    @SerializedName("title")
                    var title: String, // 哔哩哔哩音悦台
                    @SerializedName("uid")
                    var uid: Long, // 11153765
                    @SerializedName("uname")
                    var uname: String // 3号直播间
            )
        }

        data class HourRank(
                @SerializedName("extra_info")
                var extraInfo: ExtraInfo,
                @SerializedName("list")
                var list: List<X>,
                @SerializedName("module_info")
                var moduleInfo: ModuleInfo
        ) {
            data class ModuleInfo(
                    @SerializedName("count")
                    var count: Int, // 0
                    @SerializedName("id")
                    var id: Int, // 4
                    @SerializedName("link")
                    var link: String, // https://live.bilibili.com/p/html/live-app-rank/index.html?is_live_webview=1&nav=hour
                    @SerializedName("pic")
                    var pic: String, // http://i0.hdslb.com/bfs/live/39cd413f6bc72fb9da8c10ff2686b537477294ab.png
                    @SerializedName("sort")
                    var sort: Int, // 11
                    @SerializedName("title")
                    var title: String, // 小时榜
                    @SerializedName("type")
                    var type: Int // 5
            )

            data class X(
                    @SerializedName("area_v2_id")
                    var areaV2Id: Int, // 145
                    @SerializedName("area_v2_name")
                    var areaV2Name: String, // 视频聊天
                    @SerializedName("area_v2_parent_id")
                    var areaV2ParentId: Int, // 1
                    @SerializedName("area_v2_parent_name")
                    var areaV2ParentName: String, // 娱乐
                    @SerializedName("face")
                    var face: String, // http://i2.hdslb.com/bfs/face/cdc9866d09ed82e6fae610f5ba4b8706db509802.jpg
                    @SerializedName("live_status")
                    var liveStatus: Int, // 1
                    @SerializedName("rank")
                    var rank: Int, // 3
                    @SerializedName("roomid")
                    var roomid: Long, // 274926
                    @SerializedName("uid")
                    var uid: Long, // 24601383
                    @SerializedName("uname")
                    var uname: String // 蛋黄姬GAT-X105
            )

            data class ExtraInfo(
                    @SerializedName("sub_title")
                    var subTitle: String // 15:00-16:00 总榜排名
            )
        }
    }
}
