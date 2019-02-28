package com.hiczp.bilibili.api.app.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class Space(
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
            @SerializedName("album")
            var album: Album,
            /**
             * 投稿
             */
            @SerializedName("archive")
            var archive: Archive,
            @SerializedName("article")
            var article: Article,
            @SerializedName("audios")
            var audios: Audios,
            @SerializedName("card")
            var card: Card,
            @SerializedName("clip")
            var clip: Clip,
            /**
             * 最近投币
             */
            @SerializedName("coin_archive")
            var coinArchive: CoinArchive,
            @SerializedName("elec")
            var elec: Elec,
            @SerializedName("favourite")
            var favourite: Favourite,
            @SerializedName("images")
            var images: Images,
            /**
             * Ta推荐的视频
             */
            @SerializedName("like_archive")
            var likeArchive: LikeArchive,
            @SerializedName("live")
            var live: Live,
            @SerializedName("medal")
            var medal: Int, // 1
            @SerializedName("relation")
            var relation: Int, // 1
            @SerializedName("season")
            var season: Season,
            @SerializedName("setting")
            var setting: Setting,
            @SerializedName("tab")
            var tab: Tab
    ) {
        data class Archive(
                @SerializedName("count")
                var count: Int, // 8
                @SerializedName("item")
                var item: List<Item>
        ) {
            data class Item(
                    @SerializedName("author")
                    var author: String, // hyx5020
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/archive/603e9b0d67400ce05199e0c8ff14cc4204c7e4e5.jpg
                    @SerializedName("ctime")
                    var ctime: Int, // 1475686898
                    @SerializedName("danmaku")
                    var danmaku: Int, // 2
                    @SerializedName("duration")
                    var duration: Int, // 3720
                    @SerializedName("goto")
                    var goto: String, // av
                    @SerializedName("length")
                    var length: String,
                    @SerializedName("param")
                    var `param`: String, // 6557595
                    @SerializedName("play")
                    var play: Int, // 246
                    @SerializedName("title")
                    var title: String, // 蓝色起源 New Shepard In-flight Escape Test
                    @SerializedName("tname")
                    var tname: String, // 趣味科普人文
                    @SerializedName("ugc_pay")
                    var ugcPay: Int, // 0
                    @SerializedName("uri")
                    var uri: String // bilibili://video/6557595
            )
        }

        data class Favourite(
                @SerializedName("count")
                var count: Int, // 0
                @SerializedName("item")
                var item: List<Item>
        ) {
            data class Item(
                    @SerializedName("atten_count")
                    var attenCount: Int, // 0
                    @SerializedName("ctime")
                    var ctime: Long, // 1451133174
                    @SerializedName("cur_count")
                    var curCount: Int, // 1
                    @SerializedName("fid")
                    var fid: Long, // 795158
                    @SerializedName("max_count")
                    var maxCount: Int, // 50000
                    @SerializedName("media_id")
                    var mediaId: Long, // 79515830
                    @SerializedName("mid")
                    var mid: Long, // 20293030
                    @SerializedName("mtime")
                    var mtime: Int, // 1544629663
                    @SerializedName("name")
                    var name: String, // 默认收藏夹
                    @SerializedName("state")
                    var state: Int // 0
            )
        }

        data class Images(
                @SerializedName("imgUrl")
                var imgUrl: String
        )

        data class Season(
                @SerializedName("count")
                var count: Int, // 0
                @SerializedName("item")
                var item: List<Item>
        ) {
            data class Item(
                    @SerializedName("attention")
                    var attention: String, // 0
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/bangumi/de944b7c9306932d8dd3dcaeaf2eeec8670deec5.png
                    @SerializedName("finish")
                    var finish: Int, // 0
                    @SerializedName("goto")
                    var goto: String, // bangumi
                    @SerializedName("index")
                    var index: String,
                    @SerializedName("is_finish")
                    var isFinish: String,
                    @SerializedName("is_started")
                    var isStarted: Int, // 1
                    @SerializedName("mtime")
                    var mtime: Int, // 0
                    @SerializedName("newest_ep_id")
                    var newestEpId: String,
                    @SerializedName("newest_ep_index")
                    var newestEpIndex: String, // 8
                    @SerializedName("param")
                    var `param`: String, // 26284
                    @SerializedName("title")
                    var title: String, // 盾之勇者成名录
                    @SerializedName("total_count")
                    var totalCount: String, // 25
                    @SerializedName("uri")
                    var uri: String // http://bangumi.bilibili.com/anime/26284
            )
        }

        data class Article(
                @SerializedName("count")
                var count: Int, // 0
                @SerializedName("item")
                var item: List<JsonElement>,
                @SerializedName("lists")
                var lists: List<JsonElement>,
                @SerializedName("lists_count")
                var listsCount: Int // 0
        )

        data class Album(
                @SerializedName("count")
                var count: Int, // 0
                @SerializedName("has_more")
                var hasMore: Int, // 0
                @SerializedName("item")
                var item: List<JsonElement>,
                @SerializedName("next_offset")
                var nextOffset: Int // 0
        )

        data class CoinArchive(
                @SerializedName("count")
                var count: Int, // 1
                @SerializedName("item")
                var item: List<Item>
        ) {
            data class Item(
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/archive/0b49549eeefd58441ad88613fe460630182d1afe.jpg
                    @SerializedName("ctime")
                    var ctime: Int, // 1548875105
                    @SerializedName("danmaku")
                    var danmaku: Int, // 2
                    @SerializedName("duration")
                    var duration: Int, // 169
                    @SerializedName("goto")
                    var goto: String, // av
                    @SerializedName("length")
                    var length: String,
                    @SerializedName("param")
                    var `param`: String, // 42179433
                    @SerializedName("play")
                    var play: Int, // 3373
                    @SerializedName("title")
                    var title: String, // 《吹响吧！上低音号！》Dream Solister 上低音号四重奏
                    @SerializedName("tname")
                    var tname: String,
                    @SerializedName("ugc_pay")
                    var ugcPay: Int, // 0
                    @SerializedName("uri")
                    var uri: String // bilibili://video/42179433
            )
        }

        data class Elec(
                @SerializedName("elec_num")
                var elecNum: Int, // 0
                @SerializedName("elec_set")
                var elecSet: ElecSet,
                @SerializedName("list")
                var list: List<JsonElement>,
                @SerializedName("show")
                var show: Boolean // true
        ) {
            data class ElecSet(
                    @SerializedName("elec_list")
                    var elecList: List<Elec>,
                    @SerializedName("elec_theme")
                    var elecTheme: Int, // 0
                    @SerializedName("integrity_rate")
                    var integrityRate: Double, // 10.0
                    @SerializedName("rmb_rate")
                    var rmbRate: Double, // 10.0
                    @SerializedName("round_mode")
                    var roundMode: Int // 0
            ) {
                data class Elec(
                        @SerializedName("elec_num")
                        var elecNum: Int, // 0
                        @SerializedName("is_customize")
                        var isCustomize: Int, // 1
                        @SerializedName("max_elec")
                        var maxElec: Int, // 99999
                        @SerializedName("min_elec")
                        var minElec: Int, // 20
                        @SerializedName("title")
                        var title: String // 自定义
                )
            }
        }

        data class Setting(
                @SerializedName("bangumi")
                var bangumi: Int, // 0
                @SerializedName("channel")
                var channel: Int, // 1
                @SerializedName("coins_video")
                var coinsVideo: Int, // 1
                @SerializedName("fav_video")
                var favVideo: Int, // 0
                @SerializedName("groups")
                var groups: Int, // 0
                @SerializedName("likes_video")
                var likesVideo: Int, // 1
                @SerializedName("played_game")
                var playedGame: Int // 0
        )

        data class Card(
                @SerializedName("DisplayRank")
                var displayRank: String,
                @SerializedName("approve")
                var approve: Boolean, // false
                @SerializedName("article")
                var article: Int, // 0
                @SerializedName("attention")
                var attention: Int, // 113
                @SerializedName("attentions")
                var attentions: JsonElement?, // null
                @SerializedName("birthday")
                var birthday: String,
                @SerializedName("description")
                var description: String,
                @SerializedName("end_time")
                var endTime: Int, // 0
                @SerializedName("face")
                var face: String, // http://i0.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg
                @SerializedName("fans")
                var fans: Int, // 539
                @SerializedName("friend")
                var friend: Int, // 0
                @SerializedName("level_info")
                var levelInfo: LevelInfo,
                @SerializedName("mid")
                var mid: String, // 2866663
                @SerializedName("name")
                var name: String, // hyx5020
                @SerializedName("nameplate")
                var nameplate: Nameplate,
                @SerializedName("official_verify")
                var officialVerify: OfficialVerify,
                @SerializedName("pendant")
                var pendant: Pendant,
                @SerializedName("place")
                var place: String,
                @SerializedName("rank")
                var rank: String,
                @SerializedName("regtime")
                var regtime: Int, // 0
                @SerializedName("sex")
                var sex: String, // 保密
                @SerializedName("sign")
                var sign: String, // 简介？不存在的
                @SerializedName("silence")
                var silence: Int, // 0
                @SerializedName("silence_url")
                var silenceUrl: String,
                @SerializedName("spacesta")
                var spacesta: Int, // 0
                @SerializedName("vip")
                var vip: Vip
        ) {
            data class Vip(
                    @SerializedName("accessStatus")
                    var accessStatus: Int, // 0
                    @SerializedName("dueRemark")
                    var dueRemark: String,
                    @SerializedName("vipDueDate")
                    var vipDueDate: Long, // 1623081600000
                    @SerializedName("vipStatus")
                    var vipStatus: Int, // 1
                    @SerializedName("vipStatusWarn")
                    var vipStatusWarn: String,
                    @SerializedName("vipType")
                    var vipType: Int // 2
            )

            data class OfficialVerify(
                    @SerializedName("desc")
                    var desc: String,
                    @SerializedName("role")
                    var role: Int, // 0
                    @SerializedName("title")
                    var title: String,
                    @SerializedName("type")
                    var type: Int // -1
            )

            data class Pendant(
                    @SerializedName("expire")
                    var expire: Int, // 0
                    @SerializedName("image")
                    var image: String,
                    @SerializedName("name")
                    var name: String,
                    @SerializedName("pid")
                    var pid: Int // 0
            )

            data class Nameplate(
                    @SerializedName("condition")
                    var condition: String,
                    @SerializedName("image")
                    var image: String,
                    @SerializedName("image_small")
                    var imageSmall: String,
                    @SerializedName("level")
                    var level: String,
                    @SerializedName("name")
                    var name: String,
                    @SerializedName("nid")
                    var nid: Int // 0
            )

            data class LevelInfo(
                    @SerializedName("current_exp")
                    var currentExp: Int, // 11224
                    @SerializedName("current_level")
                    var currentLevel: Int, // 5
                    @SerializedName("current_min")
                    var currentMin: Int, // 10800
                    @SerializedName("next_exp")
                    var nextExp: Int // 28800
            )
        }

        data class Tab(
                @SerializedName("album")
                var album: Boolean, // false
                @SerializedName("archive")
                var archive: Boolean, // true
                @SerializedName("article")
                var article: Boolean, // false
                @SerializedName("audios")
                var audios: Boolean, // false
                @SerializedName("bangumi")
                var bangumi: Boolean, // false
                @SerializedName("clip")
                var clip: Boolean, // false
                @SerializedName("coin")
                var coin: Boolean, // true
                @SerializedName("community")
                var community: Boolean, // false
                @SerializedName("dynamic")
                var `dynamic`: Boolean, // true
                @SerializedName("favorite")
                var favorite: Boolean, // false
                @SerializedName("like")
                var like: Boolean, // true
                @SerializedName("mall")
                var mall: Boolean, // false
                @SerializedName("shop")
                var shop: Boolean // false
        )

        data class Audios(
                @SerializedName("count")
                var count: Int, // 0
                @SerializedName("item")
                var item: List<JsonElement>
        )

        data class LikeArchive(
                @SerializedName("count")
                var count: Int, // 7
                @SerializedName("item")
                var item: List<Item>
        ) {
            data class Item(
                    @SerializedName("cover")
                    var cover: String, // http://i1.hdslb.com/bfs/archive/6e246c830b26591924984f0f9275eede61621d80.jpg
                    @SerializedName("ctime")
                    var ctime: Int, // 1527760833
                    @SerializedName("danmaku")
                    var danmaku: Int, // 11309
                    @SerializedName("duration")
                    var duration: Int, // 215
                    @SerializedName("goto")
                    var goto: String, // av
                    @SerializedName("length")
                    var length: String,
                    @SerializedName("param")
                    var `param`: String, // 24180113
                    @SerializedName("play")
                    var play: Int, // 1325557
                    @SerializedName("title")
                    var title: String, // 【洛天依/言和原创曲】反派死于话多 (真实童话 Act.3)【PV付】
                    @SerializedName("tname")
                    var tname: String,
                    @SerializedName("ugc_pay")
                    var ugcPay: Int, // 0
                    @SerializedName("uri")
                    var uri: String // bilibili://video/24180113
            )
        }

        data class Live(
                @SerializedName("broadcast_type")
                var broadcastType: Int, // 0
                @SerializedName("cover")
                var cover: String, // http://i0.hdslb.com/bfs/live/af5786fa6d011c143fde5275c7af011f2c54a619.jpg
                @SerializedName("liveStatus")
                var liveStatus: Int, // 0
                @SerializedName("online")
                var online: Int, // 103
                @SerializedName("roomStatus")
                var roomStatus: Int, // 1
                @SerializedName("roomid")
                var roomid: Long, // 29434
                @SerializedName("roundStatus")
                var roundStatus: Int, // 0
                @SerializedName("title")
                var title: String, // 直播
                @SerializedName("url")
                var url: String // http://live.bilibili.com/29434
        )

        data class Clip(
                @SerializedName("count")
                var count: Int, // 0
                @SerializedName("has_more")
                var hasMore: Int, // 0
                @SerializedName("item")
                var item: List<JsonElement>,
                @SerializedName("next_offset")
                var nextOffset: Int // 0
        )
    }
}
