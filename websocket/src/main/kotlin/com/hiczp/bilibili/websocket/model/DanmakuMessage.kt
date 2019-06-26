package com.hiczp.bilibili.websocket.model

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonArray
import com.hiczp.bilibili.websocket.Command
import com.hiczp.bilibili.websocket.cmd

@Suppress("MemberVisibilityCanBePrivate")
inline class DanmakuMessage(val data: Command) {
    val info: JsonArray
        get() = data.get("info").array

    val basicInfo
        get() = info[0].array

    /**
     * 弹幕池
     */
    val pool
        get() = basicInfo[0].int

    /**
     * 弹幕模式, 可能和视频弹幕一致
     * (1从右至左滚动弹幕|6从左至右滚动弹幕|5顶端固定弹幕|4底端固定弹幕|7高级弹幕|8脚本弹幕)
     */
    val mode
        get() = basicInfo[1].int

    /**
     * 弹幕字号
     */
    val fontSize
        get() = basicInfo[2].int

    /**
     * 弹幕颜色
     */
    val color
        get() = basicInfo[3].int

    /**
     * 弹幕发送时间
     */
    val timestamp
        get() = basicInfo[4].long

    /**
     * 发送此弹幕的客户端进入直播间的时间.
     * 注意, 如果弹幕来自一个 Android 客户端, 那么此字段是一个随机数(不包括符号位有9位或者10位), 可能为负数
     */
    val enterRoomTime
        get() = basicInfo[5].long

    /**
     * 用户 ID 的 CRC32 校验和
     * 注意, 不需要用此字段来得到用户 ID
     */
    val userIdCrc32
        get() = basicInfo[7].string

    /**
     * 弹幕的内容
     */
    val message
        get() = info[1].string

    val userInfo
        get() = info[2].array

    val userId
        get() = userInfo[0].long

    val nickname
        get() = userInfo[1].string

    val isAdmin
        get() = userInfo[2].int

    val isVip
        get() = userInfo[3].int

    val isSVip
        get() = userInfo[4].int

    /**
     * 粉丝勋章信息
     * 注意, 如果弹幕发送者没有佩戴勋章则该字段为一个空 JsonArray
     * 未佩戴粉丝勋章时, 下面几个字段都会返回 null
     */
    val fansMedalInfo
        get() = info[3].array

    val fansMedalLevel
        get() = fansMedalInfo[0]?.int

    val fansMedalName
        get() = fansMedalInfo[1]?.string

    /**
     * 粉丝勋章对应的主播的用户名
     */
    val fansMedalAnchorNickname
        get() = fansMedalInfo[2]?.string

    /**
     * 粉丝勋章对应的主播的直播间号码
     */
    val fansMedalAnchorRoomId
        get() = fansMedalInfo[3]?.long

    /**
     * 粉丝勋章的背景颜色
     */
    val fansMedalBackgroundColor
        get() = fansMedalInfo[4]?.int

    val userLevelInfo
        get() = info[4].array

    /**
     * UL, 发送者的用户等级, 非主播等级
     */
    val userLevel
        get() = userLevelInfo[0].int

    /**
     * 用户等级标识的边框的颜色, 通常为最后一个佩戴的粉丝勋章的颜色
     */
    val userLevelBorderColor
        get() = userLevelInfo[2].int

    /**
     * 用户排名, 可能为数字, 也可能是 ">50000"
     */
    val userRank
        get() = userLevelInfo[3].string

    /**
     * 用户头衔
     * 可能为空列表, 也可能是值为 String 类型的列表
     * 可能有两项, 两项的值可能一样
     */
    val userTitles
        get() = info[5].array.map { it.string }

    /**
     * 校验信息
     * {
     *  "ts": 1553368447,
     *  "ct": "98688F2F"
     * }
     */
    val checkInfo
        get() = info[9].obj
}

private const val danmakuMessage = "DANMU_MSG"

fun Command.asDanmakuMessage() =
        if (cmd == danmakuMessage) {
            DanmakuMessage(this)
        } else {
            throw IllegalStateException("Cannot convert $cmd to $danmakuMessage")
        }
