package com.hiczp.bilibili.api.player.model

import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.Nullable

data class VideoPlayUrl(
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
            @SerializedName("accept_description")
            var acceptDescription: List<String>,
            @SerializedName("accept_format")
            var acceptFormat: String, // flv_p60,flv720_p60,flv,flv720,flv480,flv360
            @SerializedName("accept_quality")
            var acceptQuality: List<Int>,
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
            @SerializedName("quality")
            var quality: Int, // 32
            @SerializedName("result")
            var result: String, // suee
            @SerializedName("seek_param")
            var seekParam: String, // start
            @SerializedName("seek_type")
            var seekType: String, // offset
            @SerializedName("timelength")
            var timelength: Long, // 196367
            @SerializedName("video_codecid")
            var videoCodecid: Int, // 7
            @SerializedName("video_project")
            var videoProject: Boolean, // true
            @SerializedName("durl")
            var durl: List<Durl>
    ) {
        data class Dash(
                @SerializedName("audio")
                var audio: List<Audio>,
                @SerializedName("video")
                var video: List<Video>
        ) {
            data class Audio(
                    @SerializedName("backup_url")
                    var backupUrl: List<String>,
                    @SerializedName("bandwidth")
                    var bandwidth: Int, // 191246
                    @SerializedName("base_url")
                    var baseUrl: String, // http://101.75.242.10/upgcxcode/41/36/72913641/72913641-1-30280.m4s?expires=1550754000&platform=android&ssig=2eirz02lIhKUw--w26lpqQ&oi=1699214834&trid=e0d3ad6245d8432887eb12b71f29bb3e&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                    @SerializedName("codecid")
                    var codecid: Int, // 0
                    @SerializedName("id")
                    var id: Int // 30280
            )

            data class Video(
                    @SerializedName("backup_url")
                    var backupUrl: List<String>,
                    @SerializedName("bandwidth")
                    var bandwidth: Int, // 288340
                    @SerializedName("base_url")
                    var baseUrl: String, // http://60.12.119.68/upgcxcode/41/36/72913641/72913641-1-30011.m4s?expires=1550754000&platform=android&ssig=Ven-c2XaxfkQIoMkzuq7MQ&oi=1699214834&trid=e0d3ad6245d8432887eb12b71f29bb3e&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                    @SerializedName("codecid")
                    var codecid: Int, // 12
                    @SerializedName("id")
                    var id: Int // 16
            )
        }

        data class Durl(
                @SerializedName("order")
                var order: Int,
                @SerializedName("length")
                var length: Long,
                @SerializedName("size")
                var size: Long,
                @SerializedName("url")
                var url: String,
                @SerializedName("backup_url")
                var backupUrl: List<String>
        )
    }
}
