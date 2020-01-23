package com.hiczp.bilibili.api.player.model

import com.google.gson.annotations.SerializedName

data class BangumiPlayUrl(
        @SerializedName("accept_description")
        var acceptDescription: List<String>,
        @SerializedName("accept_format")
        var acceptFormat: String, // hdflv2,flv,flv720,flv480,mp4
        @SerializedName("accept_quality")
        var acceptQuality: List<Int>,
        @SerializedName("bp")
        var bp: Int, // 0
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("dash")
        var dash: Dash,
        @SerializedName("fnval")
        var fnval: Int, // 16
        @SerializedName("fnver")
        var fnver: Int, // 0
        @SerializedName("format")
        var format: String, // flv480
        @SerializedName("from")
        var from: String, // local
        @SerializedName("has_paid")
        var hasPaid: Boolean, // false
        @SerializedName("is_preview")
        var isPreview: Int, // 0
        @SerializedName("quality")
        var quality: Int, // 32
        @SerializedName("result")
        var result: String, // suee
        @SerializedName("seek_param")
        var seekParam: String, // start
        @SerializedName("seek_type")
        var seekType: String, // offset
        @SerializedName("status")
        var status: Int, // 2
        @SerializedName("timelength")
        var timelength: Long, // 1420201
        @SerializedName("video_codecid")
        var videoCodecid: Int, // 7
        @SerializedName("video_project")
        var videoProject: Boolean, // true
        @SerializedName("vip_status")
        var vipStatus: Int, // 0
        @SerializedName("vip_type")
        var vipType: Int // 0
) {
    data class Dash(
            @SerializedName("audio")
            var audio: List<Audio>,
            @SerializedName("video")
            var video: List<Video>
    ) {
        data class Video(
                @SerializedName("backupUrl")
                var backupUrl: List<String>,
                @SerializedName("backup_url")
                var backup_url: List<String>,
                @SerializedName("bandwidth")
                var bandwidth: Int, // 379067
                @SerializedName("baseUrl")
                var baseUrl: String, // http://60.12.119.70/upgcxcode/28/12/74921228/74921228-1-30016.m4s?expires=1550754300&platform=android&ssig=rJUT9lWneFYshCT4p_3YuA&oi=1699214834&trid=83334c4981ed460ea2444f6aab79d1b6&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                @SerializedName("base_url")
                var base_url: String, // http://60.12.119.70/upgcxcode/28/12/74921228/74921228-1-30016.m4s?expires=1550754300&platform=android&ssig=rJUT9lWneFYshCT4p_3YuA&oi=1699214834&trid=83334c4981ed460ea2444f6aab79d1b6&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                @SerializedName("codecid")
                var codecid: Int, // 7
                @SerializedName("id")
                var id: Int // 16
        )

        data class Audio(
                @SerializedName("backupUrl")
                var backupUrl: List<String>,
                @SerializedName("backup_url")
                var backup_url: List<String>,
                @SerializedName("bandwidth")
                var bandwidth: Int, // 193680
                @SerializedName("baseUrl")
                var baseUrl: String, // http://60.12.119.68/upgcxcode/28/12/74921228/74921228-1-30280.m4s?expires=1550754300&platform=android&ssig=1-JiBSZvopajZNgVZ3HRdA&oi=1699214834&trid=83334c4981ed460ea2444f6aab79d1b6&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                @SerializedName("base_url")
                var base_url: String, // http://60.12.119.68/upgcxcode/28/12/74921228/74921228-1-30280.m4s?expires=1550754300&platform=android&ssig=1-JiBSZvopajZNgVZ3HRdA&oi=1699214834&trid=83334c4981ed460ea2444f6aab79d1b6&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                @SerializedName("id")
                var id: Int // 30280
        )
    }
}
