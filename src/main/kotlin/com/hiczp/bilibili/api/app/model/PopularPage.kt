package com.hiczp.bilibili.api.app.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class PopularPage(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("config")
        var config: Config,
        @SerializedName("data")
        var `data`: List<Data>,
        @SerializedName("message")
        var message: String, // 0
        @SerializedName("ver")
        var ver: String // 1550674482
) {
    data class Data(
            @SerializedName("args")
            var args: JsonElement,  // {}
            @SerializedName("card_goto")
            var cardGoto: String, // av
            @SerializedName("card_type")
            var cardType: String, // small_cover_v5
            @SerializedName("cover")
            var cover: String, // http://i1.hdslb.com/bfs/archive/92c41f8fd16ccc7c9fb8ff4c302c8cd28f98500c.jpg
            @SerializedName("cover_right_text_1")
            var coverRightText1: String, // 2:22:47
            @SerializedName("from_type")
            var fromType: String, // recommend
            @SerializedName("goto")
            var goto: String, // av
            @SerializedName("idx")
            var idx: Int, // 10
            @SerializedName("param")
            var `param`: String, // 44139240
            @SerializedName("rcmd_reason_style")
            var rcmdReasonStyle: RcmdReasonStyle,
            @SerializedName("right_desc_1")
            var rightDesc1: String, // Alessa0
            @SerializedName("right_desc_2")
            var rightDesc2: String, // 17.5万观看 · 11小时前
            @SerializedName("three_point")
            var threePoint: ThreePoint,
            @SerializedName("three_point_v2")
            var threePointV2: List<ThreePointV2>,
            @SerializedName("title")
            var title: String, // 【莫璃】还愿-Devotion 实况解说
            @SerializedName("uri")
            var uri: String // bilibili://video/44139240?page=1&player_preload=%7B%22cid%22%3A77299630%2C%22expire_time%22%3A1550678082%2C%22file_info%22%3A%7B%22116%22%3A%5B%7B%22timelength%22%3A1650317%2C%22filesize%22%3A1203029539%7D%5D%2C%2216%22%3A%5B%7B%22timelength%22%3A1650264%2C%22filesize%22%3A59700129%7D%5D%2C%2232%22%3A%5B%7B%22timelength%22%3A1650264%2C%22filesize%22%3A133510883%7D%5D%2C%2264%22%3A%5B%7B%22timelength%22%3A1650264%2C%22filesize%22%3A295466703%7D%5D%2C%2274%22%3A%5B%7B%22timelength%22%3A1650317%2C%22filesize%22%3A601916177%7D%5D%2C%2280%22%3A%5B%7B%22timelength%22%3A1650264%2C%22filesize%22%3A442710018%7D%5D%7D%2C%22support_quality%22%3A%5B116%2C74%2C80%2C64%2C32%2C16%5D%2C%22support_formats%22%3A%5B%22flv_p60%22%2C%22flv720_p60%22%2C%22flv%22%2C%22flv720%22%2C%22flv480%22%2C%22flv360%22%5D%2C%22support_description%22%3A%5B%22%E9%AB%98%E6%B8%85%201080P60%22%2C%22%E9%AB%98%E6%B8%85%20720P60%22%2C%22%E9%AB%98%E6%B8%85%201080P%22%2C%22%E9%AB%98%E6%B8%85%20720P%22%2C%22%E6%B8%85%E6%99%B0%20480P%22%2C%22%E6%B5%81%E7%95%85%20360P%22%5D%2C%22quality%22%3A32%2C%22video_codecid%22%3A7%2C%22video_project%22%3Atrue%2C%22fnver%22%3A0%2C%22fnval%22%3A16%2C%22dash%22%3A%7B%22video%22%3A%5B%7B%22id%22%3A16%2C%22base_url%22%3A%22http%3A%2F%2F112.13.92.201%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30015.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DpB2mBK-uUt8J2FR7gpRkMw%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A380120%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A32%2C%22base_url%22%3A%22http%3A%2F%2F112.16.2.199%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30032.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DQnAj8uehkASEqd0d4x2qng%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A722044%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A64%2C%22base_url%22%3A%22http%3A%2F%2F112.16.2.200%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30064.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DQrLc5Upez1bBgiBKy18EAA%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A967572%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A80%2C%22base_url%22%3A%22http%3A%2F%2F112.13.92.209%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30080.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3D_mTir3zLWUP6l1IkebdNxA%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A1901584%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A16%2C%22base_url%22%3A%22http%3A%2F%2F112.16.2.195%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30011.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DC0KJJqQGAv_ZnGPvLFCxKA%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A289408%2C%22codecid%22%3A12%7D%2C%7B%22id%22%3A32%2C%22base_url%22%3A%22http%3A%2F%2F112.16.2.197%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30033.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3D7qlxqk9UW65zMM87EROiTQ%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A647221%2C%22codecid%22%3A12%7D%2C%7B%22id%22%3A64%2C%22base_url%22%3A%22http%3A%2F%2F112.16.2.195%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30066.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DESc65T0K8um6aFJwFT0ATg%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A1432336%2C%22codecid%22%3A12%7D%2C%7B%22id%22%3A80%2C%22base_url%22%3A%22http%3A%2F%2F112.16.2.196%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30077.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DmxkPp_P0Z4p665jFbM6Yeg%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A2146129%2C%22codecid%22%3A12%7D%5D%2C%22audio%22%3A%5B%7B%22id%22%3A30280%2C%22base_url%22%3A%22http%3A%2F%2F112.16.2.202%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30280.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DFSfFHiKsuIi26dSiVD1R1A%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A258739%2C%22codecid%22%3A0%7D%2C%7B%22id%22%3A30216%2C%22base_url%22%3A%22http%3A%2F%2F117.149.37.134%2Fupgcxcode%2F30%2F96%2F77299630%2F77299630-1-30216.m4s%3Fexpires%3D1550681400%5Cu0026platform%3Dandroid%5Cu0026ssig%3DMkkmNF2KLHxp826xbglC7w%5Cu0026oi%3D3670888805%5Cu0026hfa%3D2120131681%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Ddfa70793caa4422581b4291f4a4f9a0d%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A67093%2C%22codecid%22%3A0%7D%5D%7D%7D&player_width=1920&player_height=1080&player_rotate=0
    ) {
        data class ThreePoint(
                @SerializedName("watch_later")
                var watchLater: Int // 1
        )

        data class ThreePointV2(
                @SerializedName("title")
                var title: String, // 添加至稍后再看
                @SerializedName("type")
                var type: String // watch_later
        )

        data class RcmdReasonStyle(
                @SerializedName("bg_color")
                var bgColor: String, // #FFFB9E60
                @SerializedName("bg_style")
                var bgStyle: Int, // 1
                @SerializedName("border_color")
                var borderColor: String, // #FFFB9E60
                @SerializedName("text")
                var text: String, // 新
                @SerializedName("text_color")
                var textColor: String // #FFFFFFFF
        )
    }

    data class Config(
            @SerializedName("bottom_text")
            var bottomText: String, // 已经到达热门的尽头惹，<em class="keyword">关于热门</em>
            @SerializedName("bottom_text_cover")
            var bottomTextCover: String, // http://i0.hdslb.com/bfs/archive/10814950191d33ba6eb6f29439e27399c3eeee37.png
            @SerializedName("bottom_text_url")
            var bottomTextUrl: String, // https://www.bilibili.com/blackboard/activity-RKWxGjjMb.html
            @SerializedName("item_title")
            var itemTitle: String // 当前热门
    )
}
