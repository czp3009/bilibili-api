package com.hiczp.bilibili.api.app.model

import com.google.gson.annotations.SerializedName

data class FavoriteArticle(
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
            @SerializedName("count")
            var count: Int, // 1
            @SerializedName("items")
            var items: List<Item>
    ) {
        data class Item(
                @SerializedName("banner_url")
                var bannerUrl: String, // https://i0.hdslb.com/bfs/article/97cddc6d048297aedcc5cc498cbfb090358567eb.jpg
                @SerializedName("favorite_time")
                var favoriteTime: Int, // 1551348963
                @SerializedName("goto")
                var goto: String, // article
                @SerializedName("id")
                var id: Long, // 2165049
                @SerializedName("image_urls")
                var imageUrls: List<String>,
                @SerializedName("name")
                var name: String, // 京八贱
                @SerializedName("param")
                var `param`: String, // 2165049
                @SerializedName("summary")
                var summary: String, // 相信不少玩家在完破了《荒野大镖客：救赎2》的单人剧情模式后，就开始了线上模式。近期官方推出的更新给大家带来了不少新内容，比如新的对决模式、竞速、衣物和表情动作等等，还强化了游戏内的通缉和小地图等系统，尝试给予玩家更加多样的体验。不过更新上线后所带来的改变反而激起了玩家的怒火，首当其冲的便是打猎相关的更动，在游戏中玩家可把肢解完毕的猎物尸体卖给肉贩，而经历了这次的更新后，多人线上模式这项打猎物品的价格直接被砍半，玩家也发现不少猎物的掉落物数量有减少的迹象，让不少喜爱悠闲打猎生活的玩家大感不满。猎人
                @SerializedName("template_id")
                var templateId: Int, // 4
                @SerializedName("title")
                var title: String, // 《荒野大镖客2》线上模式的近期更新引起玩家强烈不满，引发争议
                @SerializedName("uri")
                var uri: String // bilibili://article/2165049
        )
    }
}
