package com.hiczp.bilibili.api.live.model

import com.google.gson.annotations.SerializedName

data class AreaList(
        @SerializedName("code")
        var code: Int, // 0
        @SerializedName("data")
        var `data`: List<Data>,
        @SerializedName("message")
        var message: String, // success
        @SerializedName("msg")
        var msg: String // success
) {
    data class Data(
            @SerializedName("act_id")
            var actId: String, // 0
            @SerializedName("area_type")
            var areaType: Int, // 0
            @SerializedName("hot_status")
            var hotStatus: Int, // 0
            @SerializedName("id")
            var id: String, // 34
            @SerializedName("lock_status")
            var lockStatus: String, // 0
            @SerializedName("name")
            var name: String, // 音乐台
            @SerializedName("old_area_id")
            var oldAreaId: String, // 7
            @SerializedName("parent_id")
            var parentId: String, // 1
            @SerializedName("parent_name")
            var parentName: String, // 娱乐
            @SerializedName("pic")
            var pic: String, // https://i0.hdslb.com/bfs/vc/8537694f4fe68ab0798dd5d493d3ca5deb908088.png
            @SerializedName("pk_status")
            var pkStatus: String // 0
    )
}
