package com.hiczp.bilibili.api.main.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class MyBangumiNews(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("message")
        var message: String, // success
        @SerializedName("result")
        var result: Result
) {
    data class Result(
            @SerializedName("delay")
            var delay: List<JsonElement>,
            @SerializedName("follow")
            var follow: Int, // 34
            @SerializedName("follows")
            var follows: List<Follow>,
            @SerializedName("follows_type")
            var followsType: Int, // 1
            @SerializedName("update")
            var update: Int // 1
    ) {
        data class Follow(
                @SerializedName("badge")
                var badge: String, // 会员抢先
                @SerializedName("badge_type")
                var badgeType: Int, // 0
                @SerializedName("cover")
                var cover: String, // http://i0.hdslb.com/bfs/bangumi/f34ff3975c39913af936c133ae60a5891babba08.png
                @SerializedName("is_finish")
                var isFinish: Int, // 0
                @SerializedName("is_started")
                var isStarted: Int, // 1
                @SerializedName("new_ep")
                var newEp: NewEp,
                /**
                 * 如果 progress 为 null 说明尚未观看
                 */
                @SerializedName("progress")
                var progress: Progress?,
                @SerializedName("season_id")
                var seasonId: Int, // 25681
                @SerializedName("title")
                var title: String, // JOJO的奇妙冒险 黄金之风
                @SerializedName("total_count")
                var totalCount: Int, // 39
                @SerializedName("url")
                var url: String // https://www.bilibili.com/bangumi/play/ss25681
        ) {
            data class NewEp(
                    @SerializedName("cover")
                    var cover: String, // http://i0.hdslb.com/bfs/archive/c3af18bf85040dfacb081db46e033f056318a8f0.jpg
                    @SerializedName("id")
                    var id: Int, // 250631
                    @SerializedName("index_show")
                    var indexShow: String // 更新至第20话
            )

            data class Progress(
                    @SerializedName("last_ep_desc")
                    var lastEpDesc: String, // 看到第2话
                    @SerializedName("last_ep_id")
                    var lastEpId: Int, // 250837
                    @SerializedName("last_ep_index")
                    var lastEpIndex: String, // 2
                    @SerializedName("last_time")
                    var lastTime: Int // 1377
            )
        }
    }
}
