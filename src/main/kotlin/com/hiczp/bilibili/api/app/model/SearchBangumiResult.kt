package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchBangumiResult(
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
            @SerializedName("items")
            var items: List<Item>,
            @SerializedName("pages")
            var pages: Int, // 1
            @SerializedName("total")
            var total: Int, // 1
            @SerializedName("trackid")
            var trackid: String // 1357843021891149439
    ) {
        data class Item(
                @SerializedName("area")
                var area: String, // 日本
                @SerializedName("badge")
                var badge: String, // 番剧
                @SerializedName("badges")
                var badges: List<Badge>,
                @SerializedName("cover")
                var cover: String, // https://i0.hdslb.com/bfs/bangumi/4d9f43eb3dba572797f8915f8f28efce9e58d756.jpg
                @SerializedName("cv")
                var cv: String, // 桐人（桐谷和人）：松冈祯丞亚丝娜（结城明日奈）：户松遥爱丽丝：茅野爱衣尤吉欧：岛崎信长赛鲁卡：前田佳织里罗妮耶·亚拉贝尔：近藤玲奈蒂洁·修特利尼：石原夏织神代凛子：小林沙苗菊冈诚二郎：森川智之莱欧斯·安提诺斯：岩濑周平温贝尔·吉泽克：木岛隆一索尔狄丽娜·塞路尔特：潘惠美沃罗·利凡玎：村田太志诗乃（朝田诗乃）：泽城美雪 强尼·布莱克（金本敦）：逢坂良太 西莉卡（绫野珪子）：日高里菜 莉兹贝特（筱崎里香）：高垣彩阳
                @SerializedName("episodes")
                var episodes: List<Episode>,
                @SerializedName("goto")
                var goto: String, // bangumi
                @SerializedName("is_atten")
                var isAtten: Int, // 1
                @SerializedName("is_selection")
                var isSelection: Int, // 1
                @SerializedName("label")
                var label: String, // 小说改/热血/奇幻/战斗/励志
                @SerializedName("media_type")
                var mediaType: Int, // 1
                @SerializedName("param")
                var `param`: String, // 130412
                @SerializedName("ptime")
                var ptime: Int, // 1538841600
                @SerializedName("rating")
                var rating: Double, // 9.2
                @SerializedName("season_id")
                var seasonId: Int, // 25510
                @SerializedName("season_type")
                var seasonType: Int, // 1
                @SerializedName("season_type_name")
                var seasonTypeName: String, // 番剧
                @SerializedName("staff")
                var staff: String, // 原作：川原砾原作插画 / 角色设计草案：abec导演：小野学助理导演：佐久间贵史角色设计：足立慎吾、铃木豪、西口智也总作画监督：铃木豪、西口智也动作作画监督：菅野芳弘、竹内哲也美术导演：小川友佳子、渡边佳人美术设定：森冈贤一、谷内优穗色彩设计：中野尚美CG导演：云藤隆太音响导演：岩浪美和效果：小山恭正音响制作：ソニルード音乐：梶浦由记制片：EGG FIRM、Straight Edge制作：A-1 Pictures
                @SerializedName("style")
                var style: String, // 小说改/热血/奇幻/战斗/励志
                @SerializedName("title")
                var title: String, // 刀剑神域 Alicization
                @SerializedName("uri")
                var uri: String, // https://www.bilibili.com/bangumi/play/ss25510/
                @SerializedName("vote")
                var vote: Int // 48497
        ) {
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
