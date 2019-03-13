package com.hiczp.bilibili.api.app.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class SearchResult(
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
            @SerializedName("array")
            var array: Int, // 1
            @SerializedName("attribute")
            var attribute: Int, // 1
            @SerializedName("item")
            var item: List<Item>,
            @SerializedName("items")
            var items: JsonElement,
            @SerializedName("nav")
            var nav: List<Nav>,
            @SerializedName("page")
            var page: Int, // 1
            @SerializedName("trackid")
            var trackid: String // 9256129479667154639
    ) {
        data class Nav(
                @SerializedName("name")
                var name: String, // 专栏
                @SerializedName("pages")
                var pages: Int, // 50
                @SerializedName("total")
                var total: Int, // 1000
                @SerializedName("type")
                var type: Int // 6
        )

        data class Item(
                @SerializedName("area")
                var area: String, // 日本
                @SerializedName("author")
                var author: String, // 那位滑稽
                @SerializedName("badge")
                var badge: String, // 专栏
                @SerializedName("badges")
                var badges: List<Badge>,
                @SerializedName("cover")
                var cover: String, // https://i0.hdslb.com/bfs/archive/a4a58b6772d0de16df6e9a7d3e208fd52a552710.jpg
                @SerializedName("cv")
                var cv: String, // 曹旭鹏、阎萌萌、碧涓、惠霖、梦娇
                @SerializedName("danmaku")
                var danmaku: Int, // 196
                @SerializedName("desc")
                var desc: String, // 刀剑神域第一季作品以 2022 年为舞台，大厂牌电子机械制造商“ARGUS”开发出－“NERvGear”－能连结虚拟世界的机器。完全的虚拟实境终于能够实现。主角桐人使用 NERvGear 游玩 VR MMORPG《Sword Art Online》的玩家，幸运地参与过封测并买下正式版的桐人，和正式营运就马上“完全潜行”享受着正式版的 SAO 世界。就在游戏四小时多后，桐人发现到“登出”指令竟然消失。认为只是系统暂时出错的桐人和开始陷入混乱的所有玩家们一起被传送到开始地点广场，并传来游戏设计者的死亡游戏
                @SerializedName("duration")
                var duration: String, // 591:52
                @SerializedName("episodes")
                var episodes: List<Episode>,
                @SerializedName("face")
                var face: String, // http://i0.hdslb.com/bfs/face/d34c34fca6471f07e60db3a7007cc5c2eb6bd785.jpg
                @SerializedName("goto")
                var goto: String, // recommend_word
                @SerializedName("id")
                var id: Int, // 2227576
                @SerializedName("image_urls")
                var imageUrls: List<String>,
                @SerializedName("is_atten")
                var isAtten: Int, // 1
                @SerializedName("is_selection")
                var isSelection: Int, // 1
                @SerializedName("label")
                var label: String, // 演员：曹旭鹏、阎萌萌、碧涓、惠霖、梦娇
                @SerializedName("like")
                var like: Int, // 13
                @SerializedName("linktype")
                var linktype: String, // query_rec
                @SerializedName("list")
                var list: List<X>,
                @SerializedName("media_type")
                var mediaType: Int, // 2
                @SerializedName("mid")
                var mid: Long, // 382820503
                @SerializedName("new_rec_tags")
                var newRecTags: List<NewRecTag>,
                @SerializedName("param")
                var `param`: String, // 33673993
                @SerializedName("play")
                var play: Int, // 324938
                @SerializedName("position")
                var position: Int, // 21
                @SerializedName("ptime")
                var ptime: Long, // 1505404800
                @SerializedName("rating")
                var rating: Double, // 5.8
                @SerializedName("rec_tags")
                var recTags: List<String>,
                @SerializedName("reply")
                var reply: Int, // 4
                @SerializedName("season_id")
                var seasonId: Int, // 12767
                @SerializedName("season_type")
                var seasonType: Int, // 2
                @SerializedName("season_type_name")
                var seasonTypeName: String, // 电影
                @SerializedName("staff")
                var staff: String, // 导演：伊藤智彦编剧：川原砾
                @SerializedName("style")
                var style: String, // 科幻/动画
                @SerializedName("template_id")
                var templateId: Int, // 4
                @SerializedName("title")
                var title: String, // 相关推荐
                @SerializedName("trackid")
                var trackid: String, // 9256129479667154639
                @SerializedName("uri")
                var uri: String, // bilibili://video/33673993?player_width=352&player_height=288&player_rotate=0
                @SerializedName("view")
                var view: Int, // 2310
                @SerializedName("vote")
                var vote: Int // 581
        ) {
            data class NewRecTag(
                    @SerializedName("bg_color")
                    var bgColor: String, // #FAAB4B
                    @SerializedName("bg_color_night")
                    var bgColorNight: String, // #BA833F
                    @SerializedName("bg_style")
                    var bgStyle: Int, // 1
                    @SerializedName("border_color")
                    var borderColor: String, // #FAAB4B
                    @SerializedName("border_color_night")
                    var borderColorNight: String, // #BA833F
                    @SerializedName("text")
                    var text: String, // MINECRAFT
                    @SerializedName("text_color")
                    var textColor: String, // #FFFFFFFF
                    @SerializedName("text_color_night")
                    var textColorNight: String // #E5E5E5
            )

            data class Badge(
                    @SerializedName("bg_color")
                    var bgColor: String, // #FB7299
                    @SerializedName("bg_color_night")
                    var bgColorNight: String, // #BB5B76
                    @SerializedName("bg_style")
                    var bgStyle: Int, // 1
                    @SerializedName("border_color")
                    var borderColor: String, // #FB7299
                    @SerializedName("border_color_night")
                    var borderColorNight: String, // #BB5B76
                    @SerializedName("text")
                    var text: String, // 会员抢先
                    @SerializedName("text_color")
                    var textColor: String, // #FFFFFF
                    @SerializedName("text_color_night")
                    var textColorNight: String // #E5E5E5
            )

            data class X(
                    @SerializedName("from_source")
                    var fromSource: String, // query_rec_search
                    @SerializedName("param")
                    var `param`: String, // 7852399559249609627
                    @SerializedName("title")
                    var title: String, // FATE 刀剑神域
                    @SerializedName("type")
                    var type: String // query_rec
            )

            data class Episode(
                    @SerializedName("index")
                    var index: String, // 21
                    @SerializedName("param")
                    var `param`: String, // 250557
                    @SerializedName("uri")
                    var uri: String // https://www.bilibili.com/bangumi/play/ep250557
            )
        }
    }
}
