package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class SearchArticleResult(
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
            var pages: Int, // 50
            @SerializedName("total")
            var total: Int, // 0
            @SerializedName("trackid")
            var trackid: String // 2251647613743955310
    ) {
        data class Item(
                @SerializedName("badge")
                var badge: String, // 专栏
                @SerializedName("desc")
                var desc: String, // 今天来和大家说下《刀剑神域3》第19集的先行图剧情，与其说是第19集，确切的讲应该是18.5集，根据先行图来看，这一集是前面的合集，主要讲的是桐人和尤吉欧的经历。在第18集结尾，桐人不小心说出了赛鲁卡的名字，导致爱丽丝记忆发生了错乱，隐约想起了自己的妹妹，而接下来就是桐人会和爱丽丝说关于她的事了，而所说的方式根据先行图来看事回忆杀方式。下面就简单和大家说下官方给出的先行图。先行图01：a姐植入记忆水晶桐人既然要告诉爱丽丝真相，也会给她说这一切的元凶就是最高祭师a姐，从上图先行图可以看出，这是a姐
                @SerializedName("goto")
                var goto: String, // article
                @SerializedName("id")
                var id: Long, // 2052980
                @SerializedName("image_urls")
                var imageUrls: List<String>,
                @SerializedName("like")
                var like: Int, // 116
                @SerializedName("mid")
                var mid: Int, // 12043763
                @SerializedName("name")
                var name: String, // 老白与动漫
                @SerializedName("param")
                var `param`: String, // 2052980
                @SerializedName("play")
                var play: Int, // 19101
                @SerializedName("reply")
                var reply: Int, // 82
                @SerializedName("template_id")
                var templateId: Int, // 3
                @SerializedName("title")
                var title: String, // <em class="keyword">刀剑神域</em>3第19集先行：桐人告诉爱丽丝真相，又是回忆杀剧情！
                @SerializedName("uri")
                var uri: String, // bilibili://article/2052980
                @SerializedName("view")
                var view: Int // 19101
        )
    }
}
