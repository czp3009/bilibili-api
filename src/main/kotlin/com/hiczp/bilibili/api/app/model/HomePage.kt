package com.hiczp.bilibili.api.app.model

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
            @SerializedName("config")
            var config: Config,
            @SerializedName("items")
            var items: List<Item>
    ) {
        data class Item(
                @SerializedName("ad_info")
                var adInfo: AdInfo,
                @SerializedName("args")
                var args: Args,
                @SerializedName("badge")
                var badge: String, // 直播
                @SerializedName("banner_item")
                var bannerItem: List<BannerItem>,
                @SerializedName("can_play")
                var canPlay: Int, // 1
                @SerializedName("card_goto")
                var cardGoto: String, // av
                @SerializedName("card_type")
                var cardType: String, // small_cover_v2
                @SerializedName("cover")
                var cover: String, // http://i0.hdslb.com/bfs/archive/884e982379b32ef1dc3281e0da1864e62cf74cc3.jpg
                @SerializedName("cover_left_icon_1")
                var coverLeftIcon1: Int, // 1
                @SerializedName("cover_left_icon_2")
                var coverLeftIcon2: Int, // 3
                @SerializedName("cover_left_text_1")
                var coverLeftText1: String, // 2.9万
                @SerializedName("cover_left_text_2")
                var coverLeftText2: String, // 471
                @SerializedName("cover_right_text")
                var coverRightText: String, // 33:33
                @SerializedName("desc")
                var desc: String, // 少年歌行11
                @SerializedName("desc_button")
                var descButton: DescButton,
                @SerializedName("goto")
                var goto: String, // av
                @SerializedName("hash")
                var hash: String, // 674069931701357536
                @SerializedName("idx")
                var idx: Int, // 1550559507
                @SerializedName("official_icon")
                var officialIcon: Int, // 17
                @SerializedName("param")
                var `param`: String, // 43804922
                @SerializedName("player_args")
                var playerArgs: PlayerArgs,
                @SerializedName("rcmd_reason")
                var rcmdReason: String, // 已关注
                @SerializedName("rcmd_reason_style")
                var rcmdReasonStyle: RcmdReasonStyle,
                @SerializedName("three_point")
                var threePoint: ThreePoint,
                @SerializedName("three_point_v2")
                var threePointV2: List<ThreePointV2>,
                @SerializedName("title")
                var title: String, // 宇宙沙盘2娱乐，给地球加1000个月亮，先要准备好灭火器
                @SerializedName("title_right_pic")
                var titleRightPic: Int, // 14
                @SerializedName("title_right_text")
                var titleRightText: String, // 1
                @SerializedName("uri")
                var uri: String // bilibili://video/43804922?page=1&player_preload=%7B%22cid%22%3A76731390%2C%22expire_time%22%3A1550649542%2C%22file_info%22%3A%7B%22112%22%3A%5B%7B%22timelength%22%3A2012565%2C%22filesize%22%3A1416010611%7D%5D%2C%2216%22%3A%5B%7B%22timelength%22%3A2012565%2C%22filesize%22%3A72842412%7D%5D%2C%2232%22%3A%5B%7B%22timelength%22%3A2012565%2C%22filesize%22%3A163018544%7D%5D%2C%2264%22%3A%5B%7B%22timelength%22%3A2012565%2C%22filesize%22%3A360516756%7D%5D%2C%2280%22%3A%5B%7B%22timelength%22%3A2012565%2C%22filesize%22%3A540132030%7D%5D%7D%2C%22support_quality%22%3A%5B112%2C80%2C64%2C32%2C16%5D%2C%22support_formats%22%3A%5B%22hdflv2%22%2C%22flv%22%2C%22flv720%22%2C%22flv480%22%2C%22flv360%22%5D%2C%22support_description%22%3A%5B%22%E9%AB%98%E6%B8%85%201080P%2B%22%2C%22%E9%AB%98%E6%B8%85%201080P%22%2C%22%E9%AB%98%E6%B8%85%20720P%22%2C%22%E6%B8%85%E6%99%B0%20480P%22%2C%22%E6%B5%81%E7%95%85%20360P%22%5D%2C%22quality%22%3A32%2C%22video_codecid%22%3A7%2C%22video_project%22%3Atrue%2C%22fnver%22%3A0%2C%22fnval%22%3A16%2C%22dash%22%3A%7B%22video%22%3A%5B%7B%22id%22%3A16%2C%22base_url%22%3A%22http%3A%2F%2F58.243.177.135%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30015.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3D42OA30l6zhf_btPLBI8CGw%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A391965%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A32%2C%22base_url%22%3A%22http%3A%2F%2F60.12.119.69%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30032.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3Dx1acEg918HekzZ7feezBAA%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A878269%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A64%2C%22base_url%22%3A%22http%3A%2F%2F58.243.177.134%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30064.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3Dg2Ryt0_xwF-bQop6Bers1g%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A1947512%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A80%2C%22base_url%22%3A%22http%3A%2F%2F58.243.177.135%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30080.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3DCe4MJYd4Q8tb1zDiPZ2NPw%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A2920113%2C%22codecid%22%3A7%7D%2C%7B%22id%22%3A16%2C%22base_url%22%3A%22http%3A%2F%2F60.12.119.71%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30011.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3DtVLJ9Xy56D8zBIHQpeHnOA%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A289550%2C%22codecid%22%3A12%7D%2C%7B%22id%22%3A32%2C%22base_url%22%3A%22http%3A%2F%2F60.12.119.68%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30033.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3DU3bKyOYXHxJDPDsFyTSYRw%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A648003%2C%22codecid%22%3A12%7D%2C%7B%22id%22%3A64%2C%22base_url%22%3A%22http%3A%2F%2F60.12.119.69%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30066.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3DQmia_xv_261EEanMCMDLBg%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A1433063%2C%22codecid%22%3A12%7D%2C%7B%22id%22%3A80%2C%22base_url%22%3A%22http%3A%2F%2F60.12.119.70%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30077.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3D7KKLcfPoYOtggLt2B8OpSw%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A2147039%2C%22codecid%22%3A12%7D%2C%7B%22id%22%3A112%2C%22base_url%22%3A%22http%3A%2F%2Fupos-hz-mirrorwcsu.acgvideo.com%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30112.m4s%3Fe%3Dig8euxZM2rNcNbdlhoNvNC8BqJIzNbfqXBvEuENvNC8aNEVEtEvE9IMvXBvE2ENvNCImNEVEIj0Y2J_aug859r1qXg8xNEVE5XREto8GuFGv2U7SuxI72X6fTr859IB_%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026oi%3D1699214834%5Cu0026platform%3Dandroid%5Cu0026gen%3Dplayurl%5Cu0026uipk%3D5%5Cu0026os%3Dwcsu%5Cu0026nbs%3D1%5Cu0026deadline%3D1550653142%5Cu0026upsig%3Db1a2c5c4587c9d62c62328fd5fbf5e5d%22%2C%22bandwidth%22%3A5628680%2C%22codecid%22%3A7%7D%5D%2C%22audio%22%3A%5B%7B%22id%22%3A30280%2C%22base_url%22%3A%22http%3A%2F%2F58.243.177.131%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30280.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3DfoKPdZpezm90iRFrxXyj5A%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A167107%2C%22codecid%22%3A0%7D%2C%7B%22id%22%3A30216%2C%22base_url%22%3A%22http%3A%2F%2F222.161.224.6%2Fupgcxcode%2F90%2F13%2F76731390%2F76731390-1-30216.m4s%3Fexpires%3D1550652900%5Cu0026platform%3Dandroid%5Cu0026ssig%3Dfd9cXg9GDLF8Ci-EvSTuXQ%5Cu0026oi%3D1699214834%5Cu0026hfa%3D2120103141%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3D8fae8885111d4e9bacbcdf70a3021572%5Cu0026nfc%3D1%22%2C%22bandwidth%22%3A67216%2C%22codecid%22%3A0%7D%5D%7D%7D&player_width=1920&player_height=1080&player_rotate=0&trackid=all_3.shylf-ai-recsys-120.1550645942519.77
        ) {
            data class ThreePoint(
                    @SerializedName("dislike_reasons")
                    var dislikeReasons: List<DislikeReason>,
                    @SerializedName("feedbacks")
                    var feedbacks: List<Feedback>,
                    @SerializedName("watch_later")
                    var watchLater: Int // 1
            ) {
                data class DislikeReason(
                        @SerializedName("id")
                        var id: Int, // 1
                        @SerializedName("name")
                        var name: String // 不感兴趣
                )

                data class Feedback(
                        @SerializedName("id")
                        var id: Int, // 4
                        @SerializedName("name")
                        var name: String // 标题党/封面党
                )
            }

            data class PlayerArgs(
                    @SerializedName("aid")
                    var aid: Int, // 43804922
                    @SerializedName("cid")
                    var cid: Int // 76731390
            )

            data class Args(
                    @SerializedName("rid")
                    var rid: Int, // 17
                    @SerializedName("rname")
                    var rname: String, // 单机游戏
                    @SerializedName("tid")
                    var tid: Int, // 9264
                    @SerializedName("tname")
                    var tname: String, // 宇宙
                    @SerializedName("up_id")
                    var upId: Int, // 131565338
                    @SerializedName("up_name")
                    var upName: String // 的夏游戏模拟
            )

            data class AdInfo(
                    @SerializedName("ad_cb")
                    var adCb: String, // CMyzBBDInQwYl7+RAyAeKAEw6Ro46w5CHzE1NTA2NDU5NDI1MTlxMTcyYTIzYTU2YTE0NXE1NjFI97HNzZAtUgbmna3lt55aBua1meaxn2IG5Lit5Zu9aAFwAHiAgICA4ASAAQOIAQCSAQ4xMDEuNzEuMjQ1LjI0MpoBiwNhbGw6Y3BjX2Nyb3dkX3RhcmdldCxlY3BtOmRlZmF1bHQsY3BjVGFnRmlsdGVyOnVuZGVmaW5lZCxlbmhhbmNlQ3RyUUZhY3RvcjpkZWZhdWx0LGFkTWVjaGFuaXNtTW9uaXRvcjpvdGhlcixwbGF5cGFnZWN0cjpkaXNhYmxlLHVwX3JlY19mbG93X2NvbnRyb2w6dW5kZWZpbmVkLGJydXNoX2R1cGxpY2F0ZTpkZWZhdWx0LHBjdHJfY3BtOmNwbSxkZnhfc3BlY2lmaWNfcmF0aW86dW5kZWZpbmVkLHBjdHJfdjI6a2Fma2EsZHluYW1pY19mbG93X2NvbnRyb2w6c3BsaXQgdGhlIGZsb3cgYnkgbWlkLHBjdnI6ZGxkLGZyZXFMaW1pdDpkZWZhdWx0LHNtYWxsQ29uc3VtZVVuaXQ6ZnJlcUxpbWl0TG9vc2Usb3V0ZXJCZWF0SW5uZXI6ZW5hYmxlLG91dGVyUXVpdDpkZWZhdWx0LGZkc19ydHQ6ZGVmYXVsdKABHqgB4QSyASBXbHnmbpOszwTXdVHn7Ki/qhzsnkZKkYFNZgfpS815cLoBLmh0dHBzOi8vbS53ZWliby5jbi82MTkyODc3MjQyLzQzMzM1NDIxMjI4NzM3MTLCAYUBMzA3Ml8xNDI3Xzg0Nl83MjRfNDU3XzQ1MV80MzRfMzg1XzE3NF8xNTBfMTQ4XzE0OF8xNDhfMTQ4XzE0OF8xNDdfMTQ3XzE0N18xNDdfMTQ3XzE0N18xNDdfMTM5XzEzOV8xMzlfMTM5XzEzOV8xMzlfMTM5XzEzOV8xMzlfMTM5XzEzOMoBANIBANgBJuABgIyNngLoAYCMjZ4C8AEA+AEegAICiAIAkgLlAjE4MDIyNl8xNTUwNTM0OTIxLDE5NjEzNV8xNTUwNTM0OTMxLDc3NzA3XzE1NTA1MzQ5MzgsMjAwMzkyXzE1NTA1MzUxNDUsMTc2NzgwXzE1NTA1MzUxNTMsMTgwMjI1XzE1NTA1MzUxNjYsMjA0MDMzXzE1NTA1MzUyMzMsMjAyNDQ5XzE1NTA1MzUyMzMsNzc3MjNfMTU1MDUzNTIzNywyMDA0MTNfMTU1MDUzNTI0MywxMDE3MDNfMTU1MDUzNTczOCwyMDAxNDFfMTU1MDU5MTE1MSwxOTU3MzlfMTU1MDU5MTE1NywxNzY3NDhfMTU1MDYwMTU5OSwyMDA0MTFfMTU1MDYwMTYwMCwxNTE2NTJfMTU1MDYwMTYxMCwxNTE2NTBfMTU1MDYwMTczNiwyMDI0NDVfMTU1MDYwMTc1MCwyMDUyNjBfMTU1MDYxOTAyNiwyMDUyNjNfMTU1MDYxOTAyN5gCrqCjBqAC8qUHqALu/gSwAp8EuAIAwAIAyAIA0AIA2AIA4gISLCzmna3lt54t5LiK5Z+O5Yy6
                    @SerializedName("card_index")
                    var cardIndex: Int, // 5
                    @SerializedName("card_type")
                    var cardType: Int, // 3
                    @SerializedName("client_ip")
                    var clientIp: String, // 101.71.245.242
                    @SerializedName("cm_mark")
                    var cmMark: Int, // 1
                    @SerializedName("creative_content")
                    var creativeContent: CreativeContent,
                    @SerializedName("creative_id")
                    var creativeId: Int, // 6578071
                    @SerializedName("creative_type")
                    var creativeType: Int, // 2
                    @SerializedName("extra")
                    var extra: Extra,
                    @SerializedName("index")
                    var index: Int, // 2
                    @SerializedName("is_ad")
                    var isAd: Boolean, // true
                    @SerializedName("is_ad_loc")
                    var isAdLoc: Boolean, // true
                    @SerializedName("request_id")
                    var requestId: String, // 1550645942519q172a23a56a145q561
                    @SerializedName("resource")
                    var resource: Int, // 1897
                    @SerializedName("source")
                    var source: Int // 1899
            ) {
                data class CreativeContent(
                        @SerializedName("description")
                        var description: String, // 恶搞·剪辑
                        @SerializedName("image_md5")
                        var imageMd5: String, // 23f4d623b4348e86890411f29688fb58
                        @SerializedName("image_url")
                        var imageUrl: String, // https://i0.hdslb.com/bfs/sycp/creative_img/201902/9097a17ff77a3dc03ea4b8841f46078f.jpg_640x400.jpg
                        @SerializedName("title")
                        var title: String, // 往老鼠洞里打氢气和氧气，场面瞬间失控
                        @SerializedName("url")
                        var url: String // https://cm.bilibili.com/cm/api/fees/wise/redirect?ad_cb=CMyzBBDInQwYl7%2BRAyAeKAEw6Ro46w5CHzE1NTA2NDU5NDI1MTlxMTcyYTIzYTU2YTE0NXE1NjFI97HNzZAtUgbmna3lt55aBua1meaxn2IG5Lit5Zu9aAFwAHiAgICA4ASAAQOIAQCSAQ4xMDEuNzEuMjQ1LjI0MpoBiwNhbGw6Y3BjX2Nyb3dkX3RhcmdldCxlY3BtOmRlZmF1bHQsY3BjVGFnRmlsdGVyOnVuZGVmaW5lZCxlbmhhbmNlQ3RyUUZhY3RvcjpkZWZhdWx0LGFkTWVjaGFuaXNtTW9uaXRvcjpvdGhlcixwbGF5cGFnZWN0cjpkaXNhYmxlLHVwX3JlY19mbG93X2NvbnRyb2w6dW5kZWZpbmVkLGJydXNoX2R1cGxpY2F0ZTpkZWZhdWx0LHBjdHJfY3BtOmNwbSxkZnhfc3BlY2lmaWNfcmF0aW86dW5kZWZpbmVkLHBjdHJfdjI6a2Fma2EsZHluYW1pY19mbG93X2NvbnRyb2w6c3BsaXQgdGhlIGZsb3cgYnkgbWlkLHBjdnI6ZGxkLGZyZXFMaW1pdDpkZWZhdWx0LHNtYWxsQ29uc3VtZVVuaXQ6ZnJlcUxpbWl0TG9vc2Usb3V0ZXJCZWF0SW5uZXI6ZW5hYmxlLG91dGVyUXVpdDpkZWZhdWx0LGZkc19ydHQ6ZGVmYXVsdKABHqgB4QSyASBXbHnmbpOszwTXdVHn7Ki%2FqhzsnkZKkYFNZgfpS815cLoBLmh0dHBzOi8vbS53ZWliby5jbi82MTkyODc3MjQyLzQzMzM1NDIxMjI4NzM3MTLCAYUBMzA3Ml8xNDI3Xzg0Nl83MjRfNDU3XzQ1MV80MzRfMzg1XzE3NF8xNTBfMTQ4XzE0OF8xNDhfMTQ4XzE0OF8xNDdfMTQ3XzE0N18xNDdfMTQ3XzE0N18xNDdfMTM5XzEzOV8xMzlfMTM5XzEzOV8xMzlfMTM5XzEzOV8xMzlfMTM5XzEzOMoBANIBANgBJuABgIyNngLoAYCMjZ4C8AEA%2BAEegAICiAIAkgLlAjE4MDIyNl8xNTUwNTM0OTIxLDE5NjEzNV8xNTUwNTM0OTMxLDc3NzA3XzE1NTA1MzQ5MzgsMjAwMzkyXzE1NTA1MzUxNDUsMTc2NzgwXzE1NTA1MzUxNTMsMTgwMjI1XzE1NTA1MzUxNjYsMjA0MDMzXzE1NTA1MzUyMzMsMjAyNDQ5XzE1NTA1MzUyMzMsNzc3MjNfMTU1MDUzNTIzNywyMDA0MTNfMTU1MDUzNTI0MywxMDE3MDNfMTU1MDUzNTczOCwyMDAxNDFfMTU1MDU5MTE1MSwxOTU3MzlfMTU1MDU5MTE1NywxNzY3NDhfMTU1MDYwMTU5OSwyMDA0MTFfMTU1MDYwMTYwMCwxNTE2NTJfMTU1MDYwMTYxMCwxNTE2NTBfMTU1MDYwMTczNiwyMDI0NDVfMTU1MDYwMTc1MCwyMDUyNjBfMTU1MDYxOTAyNiwyMDUyNjNfMTU1MDYxOTAyN5gCrqCjBqAC8qUHqALu%2FgSwAp8EuAIAwAIAyAIA0AIA2AIA4gISLCzmna3lt54t5LiK5Z%2BO5Yy6
                )

                data class Extra(
                        @SerializedName("card")
                        var card: Card,
                        @SerializedName("click_urls")
                        var clickUrls: List<Any>,
                        @SerializedName("download_whitelist")
                        var downloadWhitelist: List<Any>,
                        @SerializedName("open_whitelist")
                        var openWhitelist: List<String>,
                        @SerializedName("preload_landingpage")
                        var preloadLandingpage: Int, // 0
                        @SerializedName("report_time")
                        var reportTime: Int, // 2000
                        @SerializedName("sales_type")
                        var salesType: Int, // 12
                        @SerializedName("show_urls")
                        var showUrls: List<Any>,
                        @SerializedName("special_industry")
                        var specialIndustry: Boolean, // false
                        @SerializedName("special_industry_tips")
                        var specialIndustryTips: String,
                        @SerializedName("use_ad_web_v2")
                        var useAdWebV2: Boolean // true
                ) {
                    data class Card(
                            @SerializedName("ad_tag")
                            var adTag: String,
                            @SerializedName("callup_url")
                            var callupUrl: String, // sinaweibo://cardlist?containerid=102803&luicode=10000404&lfid=jixinshengbo_9999_001
                            @SerializedName("card_type")
                            var cardType: Int, // 3
                            @SerializedName("covers")
                            var covers: List<Cover>,
                            @SerializedName("desc")
                            var desc: String, // 恶搞·剪辑
                            @SerializedName("jump_url")
                            var jumpUrl: String, // https://cm.bilibili.com/cm/api/fees/wise/redirect?ad_cb=CMyzBBDInQwYl7%2BRAyAeKAEw6Ro46w5CHzE1NTA2NDU5NDI1MTlxMTcyYTIzYTU2YTE0NXE1NjFI97HNzZAtUgbmna3lt55aBua1meaxn2IG5Lit5Zu9aAFwAHiAgICA4ASAAQOIAQCSAQ4xMDEuNzEuMjQ1LjI0MpoBiwNhbGw6Y3BjX2Nyb3dkX3RhcmdldCxlY3BtOmRlZmF1bHQsY3BjVGFnRmlsdGVyOnVuZGVmaW5lZCxlbmhhbmNlQ3RyUUZhY3RvcjpkZWZhdWx0LGFkTWVjaGFuaXNtTW9uaXRvcjpvdGhlcixwbGF5cGFnZWN0cjpkaXNhYmxlLHVwX3JlY19mbG93X2NvbnRyb2w6dW5kZWZpbmVkLGJydXNoX2R1cGxpY2F0ZTpkZWZhdWx0LHBjdHJfY3BtOmNwbSxkZnhfc3BlY2lmaWNfcmF0aW86dW5kZWZpbmVkLHBjdHJfdjI6a2Fma2EsZHluYW1pY19mbG93X2NvbnRyb2w6c3BsaXQgdGhlIGZsb3cgYnkgbWlkLHBjdnI6ZGxkLGZyZXFMaW1pdDpkZWZhdWx0LHNtYWxsQ29uc3VtZVVuaXQ6ZnJlcUxpbWl0TG9vc2Usb3V0ZXJCZWF0SW5uZXI6ZW5hYmxlLG91dGVyUXVpdDpkZWZhdWx0LGZkc19ydHQ6ZGVmYXVsdKABHqgB4QSyASBXbHnmbpOszwTXdVHn7Ki%2FqhzsnkZKkYFNZgfpS815cLoBLmh0dHBzOi8vbS53ZWliby5jbi82MTkyODc3MjQyLzQzMzM1NDIxMjI4NzM3MTLCAYUBMzA3Ml8xNDI3Xzg0Nl83MjRfNDU3XzQ1MV80MzRfMzg1XzE3NF8xNTBfMTQ4XzE0OF8xNDhfMTQ4XzE0OF8xNDdfMTQ3XzE0N18xNDdfMTQ3XzE0N18xNDdfMTM5XzEzOV8xMzlfMTM5XzEzOV8xMzlfMTM5XzEzOV8xMzlfMTM5XzEzOMoBANIBANgBJuABgIyNngLoAYCMjZ4C8AEA%2BAEegAICiAIAkgLlAjE4MDIyNl8xNTUwNTM0OTIxLDE5NjEzNV8xNTUwNTM0OTMxLDc3NzA3XzE1NTA1MzQ5MzgsMjAwMzkyXzE1NTA1MzUxNDUsMTc2NzgwXzE1NTA1MzUxNTMsMTgwMjI1XzE1NTA1MzUxNjYsMjA0MDMzXzE1NTA1MzUyMzMsMjAyNDQ5XzE1NTA1MzUyMzMsNzc3MjNfMTU1MDUzNTIzNywyMDA0MTNfMTU1MDUzNTI0MywxMDE3MDNfMTU1MDUzNTczOCwyMDAxNDFfMTU1MDU5MTE1MSwxOTU3MzlfMTU1MDU5MTE1NywxNzY3NDhfMTU1MDYwMTU5OSwyMDA0MTFfMTU1MDYwMTYwMCwxNTE2NTJfMTU1MDYwMTYxMCwxNTE2NTBfMTU1MDYwMTczNiwyMDI0NDVfMTU1MDYwMTc1MCwyMDUyNjBfMTU1MDYxOTAyNiwyMDUyNjNfMTU1MDYxOTAyN5gCrqCjBqAC8qUHqALu%2FgSwAp8EuAIAwAIAyAIA0AIA2AIA4gISLCzmna3lt54t5LiK5Z%2BO5Yy6
                            @SerializedName("long_desc")
                            var longDesc: String,
                            @SerializedName("title")
                            var title: String // 往老鼠洞里打氢气和氧气，场面瞬间失控
                    ) {
                        data class Cover(
                                @SerializedName("url")
                                var url: String // https://i0.hdslb.com/bfs/sycp/creative_img/201902/9097a17ff77a3dc03ea4b8841f46078f.jpg_640x400.jpg
                        )
                    }
                }
            }

            data class ThreePointV2(
                    @SerializedName("reasons")
                    var reasons: List<Reason>,
                    @SerializedName("subtitle")
                    var subtitle: String, // (选择后将减少相似内容推荐)
                    @SerializedName("title")
                    var title: String, // 不感兴趣
                    @SerializedName("type")
                    var type: String // dislike
            ) {
                data class Reason(
                        @SerializedName("id")
                        var id: Int, // 1
                        @SerializedName("name")
                        var name: String // 不感兴趣
                )
            }

            data class BannerItem(
                    @SerializedName("ad_cb")
                    var adCb: String, // CMDeARAAGOChASAAKAAwAzjABUIfMTU1MDY0NTk0MjUxNHExNzJhMjJhNTZhMTU5cTcxNkjysc3NkC1SBuadreW3nloG5rWZ5rGfYgbkuK3lm71oAXAAeICAgIAQgAEAiAGCJJIBDjEwMS43MS4yNDUuMjQymgGKA2FsbDpjcGNfY3Jvd2RfdGFyZ2V0LGVjcG06ZGVmYXVsdCxjcGNUYWdGaWx0ZXI6dW5kZWZpbmVkLGVuaGFuY2VDdHJRRmFjdG9yOmRlZmF1bHQsYWRNZWNoYW5pc21Nb25pdG9yOm90aGVyLHBsYXlwYWdlY3RyOmRpc2FibGUsdXBfcmVjX2Zsb3dfY29udHJvbDp1bmRlZmluZWQsYnJ1c2hfZHVwbGljYXRlOmRlZmF1bHQscGN0cl9jcG06Y3BtLGRmeF9zcGVjaWZpY19yYXRpbzp1bmRlZmluZWQscGN0cl92MjpkZnQsZHluYW1pY19mbG93X2NvbnRyb2w6c3BsaXQgdGhlIGZsb3cgYnkgbWlkLHBjdnI6ZGxkLGZyZXFMaW1pdDpkZWZhdWx0LHNtYWxsQ29uc3VtZVVuaXQ6ZnJlcUxpbWl0TG9vc2Usb3V0ZXJCZWF0SW5uZXI6ZGVmYXVsdCxvdXRlclF1aXQ6ZGVmYXVsdCxmZHNfcnR0OmRlZmF1bHSgAQCoAQCyASBzEMEnoPF8mLhSbbL8kmKEYNtD/f3W63yJX7yJ/ZmpN7oBQ2JpbGliaWxpOi8vZ2FtZV9jZW50ZXIvZGV0YWlsP2lkPTgwJnNvdXJjZUZyb209NzgyJnNvdXJjZVR5cGU9YWRQdXTCAQDKAQDSAQDYAQHgAQDoAQDwAQD4AQCAAgCIAgC4AgDAAqCsT8gCANACANgCAOICEiws5p2t5beeLeS4iuWfjuWMug==
                    @SerializedName("click_url")
                    var clickUrl: String, // https://ad-bili-data.biligame.com/api/mobile/clickBili?ad_plan_id=1670&mid=__MID__&os=0&idfa=__IDFA__&buvid=__BUVID__&android_id=43d7a1ebb6669597650e3ee417d9e7f5&imei=__IMEI__&mac=1035d532877200d6598f96118c2821e8&duid=__DUID__&ip=101.71.245.242&request_id=1550645942514q172a22a56a159q716&ts=__TS__&ua=Dalvik%252F2.1.0%2B%2528Linux%253B%2BU%253B%2BAndroid%2B6.0%253B%2BAndroid%2BSDK%2Bbuilt%2Bfor%2Bx86%2BBuild%252FMASTER%2529
                    @SerializedName("client_ip")
                    var clientIp: String, // 101.71.245.242
                    @SerializedName("cm_mark")
                    var cmMark: Int, // 0
                    @SerializedName("creative_id")
                    var creativeId: Int, // 20704
                    @SerializedName("extra")
                    var extra: Extra,
                    @SerializedName("hash")
                    var hash: String, // 036073dcc265f595ce2a0d331fe404c0
                    @SerializedName("id")
                    var id: Int, // 229421
                    @SerializedName("image")
                    var image: String, // http://i0.hdslb.com/bfs/archive/91318bfd6076f4c5fd59b945120f346eda43cc59.jpg
                    @SerializedName("index")
                    var index: Int, // 5
                    @SerializedName("is_ad")
                    var isAd: Boolean, // true
                    @SerializedName("is_ad_loc")
                    var isAdLoc: Boolean, // true
                    @SerializedName("request_id")
                    var requestId: String, // 1550645942462
                    @SerializedName("resource_id")
                    var resourceId: Int, // 631
                    @SerializedName("server_type")
                    var serverType: Int, // 0
                    @SerializedName("src_id")
                    var srcId: Int, // 704
                    @SerializedName("title")
                    var title: String, // 还有哪些特别的过年习俗呢？
                    @SerializedName("uri")
                    var uri: String // https://www.bilibili.com/blackboard/topic/activity-Dp6imaUka.html
            ) {
                data class Extra(
                        @SerializedName("card")
                        var card: Card,
                        @SerializedName("click_urls")
                        var clickUrls: List<String>,
                        @SerializedName("open_whitelist")
                        var openWhitelist: List<String>,
                        @SerializedName("preload_landingpage")
                        var preloadLandingpage: Int, // 0
                        @SerializedName("report_time")
                        var reportTime: Int, // 2000
                        @SerializedName("sales_type")
                        var salesType: Int, // 31
                        @SerializedName("show_urls")
                        var showUrls: List<Any>,
                        @SerializedName("special_industry")
                        var specialIndustry: Boolean, // false
                        @SerializedName("special_industry_tips")
                        var specialIndustryTips: String,
                        @SerializedName("use_ad_web_v2")
                        var useAdWebV2: Boolean // false
                ) {
                    data class Card(
                            @SerializedName("ad_tag")
                            var adTag: String,
                            @SerializedName("button")
                            var button: Button,
                            @SerializedName("callup_url")
                            var callupUrl: String,
                            @SerializedName("card_type")
                            var cardType: Int, // 0
                            @SerializedName("covers")
                            var covers: List<Cover>,
                            @SerializedName("desc")
                            var desc: String,
                            @SerializedName("jump_url")
                            var jumpUrl: String, // bilibili://game_center/detail?id=80&sourceFrom=782&sourceType=adPut
                            @SerializedName("long_desc")
                            var longDesc: String,
                            @SerializedName("title")
                            var title: String
                    ) {
                        data class Cover(
                                @SerializedName("url")
                                var url: String // https://i0.hdslb.com/bfs/sycp/creative_img/201902/abd37b988b7f043a8aba3f173ef5c220.jpg
                        )

                        data class Button(
                                @SerializedName("dlsuc_callup_url")
                                var dlsucCallupUrl: String,
                                @SerializedName("jump_url")
                                var jumpUrl: String, // bilibili://game_center/detail?id=80&sourceFrom=782&sourceType=adPut
                                @SerializedName("report_urls")
                                var reportUrls: List<Any>,
                                @SerializedName("text")
                                var text: String,
                                @SerializedName("type")
                                var type: Int // 1
                        )
                    }
                }
            }

            data class RcmdReasonStyle(
                    @SerializedName("bg_color")
                    var bgColor: String, // #FFFB9E60
                    @SerializedName("bg_style")
                    var bgStyle: Int, // 1
                    @SerializedName("border_color")
                    var borderColor: String, // #FFFB9E60
                    @SerializedName("text")
                    var text: String, // 已关注
                    @SerializedName("text_color")
                    var textColor: String // #FFFFFFFF
            )

            data class DescButton(
                    @SerializedName("event")
                    var event: String, // channel_click
                    @SerializedName("text")
                    var text: String, // 单机游戏 · 宇宙
                    @SerializedName("type")
                    var type: Int, // 1
                    @SerializedName("uri")
                    var uri: String // bilibili://pegasus/channel/9264
            )
        }

        data class Config(
                @SerializedName("autoplay_card")
                var autoplayCard: Int, // 2
                @SerializedName("column")
                var column: Int, // 2
                @SerializedName("feed_clean_abtest")
                var feedCleanAbtest: Int // 0
        )
    }
}
