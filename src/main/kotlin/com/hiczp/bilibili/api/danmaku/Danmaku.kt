package com.hiczp.bilibili.api.danmaku

data class Danmaku(
        /**
         * 弹幕 id
         */
        val id: Long,

        /**
         * 下标 1, 不明属性
         */
        val unknownAttribute1: String,

        /**
         * 弹幕出现时间(播放器时间)(ms)
         */
        val time: Long,

        /**
         * 弹幕类型
         * (1从右至左滚动弹幕|6从左至右滚动弹幕|5顶端固定弹幕|4底端固定弹幕|7高级弹幕|8脚本弹幕)
         */
        val type: Int,

        /**
         * 字号
         */
        val fontSize: Int,

        /**
         * 颜色
         */
        val color: Int,

        /**
         * 弹幕的发送时间(时间戳)(s)
         */
        val timestamp: Long,

        /**
         * 下标 7, 不明属性
         */
        val unknownAttribute7: String,

        /**
         * 弹幕发送者的 hash(用户 id 的 CRC32 校验和)
         */
        val user: String,

        /**
         * 弹幕的内容
         */
        val content: String
)
