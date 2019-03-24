package com.hiczp.bilibili.api.live.websocket

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.hiczp.bilibili.api.isEmpty

/**
 * 用于解析 DANMU_MSG 的工具类
 * 注意, 并非所有字段的含义都已明确. 例如 bubble, guardLevel, teamid
 *
 * @see com.hiczp.bilibili.api.live.model.RoomMessage
 */
@Suppress("MemberVisibilityCanBePrivate")
inline class DanmakuMessage(val data: JsonObject) {
    inline val info: JsonArray
        get() = data.get("info").array

    inline val basicInfo
        get() = info[0].array

    /**
     * 弹幕池
     */
    inline val pool
        get() = basicInfo[0].int

    /**
     * 弹幕类型, 可能和视频弹幕一致
     * (1从右至左滚动弹幕|6从左至右滚动弹幕|5顶端固定弹幕|4底端固定弹幕|7高级弹幕|8脚本弹幕)
     */
    inline val type
        get() = basicInfo[1].int

    /**
     * 弹幕字号
     */
    inline val fontSize
        get() = basicInfo[2].int

    /**
     * 弹幕颜色
     */
    inline val color
        get() = basicInfo[3].int

    /**
     * 弹幕发送时间
     */
    inline val timestamp
        get() = basicInfo[4].long

    /**
     * 发送此弹幕的客户端进入直播间的时间.
     * 注意, 如果弹幕来自一个 Android 客户端, 那么此字段是一个随机数(不包括符号位有9位或者10位), 可能为负数
     */
    inline val enterRoomTime
        get() = basicInfo[5].long

    /**
     * 用户 ID 的 CRC32 校验和
     * 注意, 不需要用此字段来得到用户 ID
     */
    inline val userIdCrc32
        get() = basicInfo[7].string

    /**
     * 弹幕的内容
     */
    inline val message
        get() = info[1].string

    inline val userInfo
        get() = info[2].array

    inline val userId
        get() = userInfo[0].long

    inline val nickname
        get() = userInfo[1].string

    inline val isAdmin
        get() = userInfo[2].int

    inline val isVip
        get() = userInfo[3].int

    inline val isSVip
        get() = userInfo[4].int

    /**
     * 粉丝勋章信息
     * 注意, 如果弹幕发送者没有佩戴勋章则该字段为一个空 JsonArray
     * 未佩戴粉丝勋章时, 下面几个字段都会返回 null
     */
    inline val fansMedalInfo
        get() = info[3].array

    inline val fansMedalLevel
        get() = if (fansMedalInfo.isEmpty()) null else fansMedalInfo[0].int

    inline val fansMedalName
        get() = if (fansMedalInfo.isEmpty()) null else fansMedalInfo[1].string

    /**
     * 粉丝勋章对应的主播的用户名
     */
    inline val fansMedalAnchorNickname
        get() = if (fansMedalInfo.isEmpty()) null else fansMedalInfo[2].string

    /**
     * 粉丝勋章对应的主播的直播间号码
     */
    inline val fansMedalAnchorRoomId
        get() = if (fansMedalInfo.isEmpty()) null else fansMedalInfo[3].long

    /**
     * 粉丝勋章的背景颜色
     */
    inline val fansMedalBackgroundColor
        get() = if (fansMedalInfo.isEmpty()) null else fansMedalInfo[4].int

    inline val userLevelInfo
        get() = info[4].array

    /**
     * UL, 发送者的用户等级, 非主播等级
     */
    inline val userLevel
        get() = userLevelInfo[0].int

    /**
     * 用户等级标识的边框的颜色, 通常为最后一个佩戴的粉丝勋章的颜色
     */
    inline val userLevelBorderColor
        get() = userLevelInfo[2].int

    /**
     * 用户排名, 可能为数字, 也可能是 ">50000"
     */
    inline val userRank
        get() = userLevelInfo[3].string

    /**
     * 用户头衔
     * 可能为空列表, 也可能是值为 "" 的列表
     * 可能有两项, 两项的值可能一样
     */
    inline val userTitles
        get() = info[5].array.map { it.string }

    /**
     * 校验信息
     * {
     *  "ts": 1553368447,
     *  "ct": "98688F2F"
     * }
     */
    inline val checkInfo
        get() = info[9].obj
}
