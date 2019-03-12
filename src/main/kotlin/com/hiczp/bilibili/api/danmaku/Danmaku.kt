package com.hiczp.bilibili.api.danmaku

import com.hiczp.crc32crack.Crc32Cracker

data class Danmaku(
        /**
         * 弹幕 id
         */
        val id: Long,

        /**
         * TODO 下标 1, 不明属性
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
         * TODO 下标 7, 不明属性
         */
        val unknownAttribute7: String,

        /**
         * 弹幕发送者的 hash(用户 id 的 CRC32 校验和)
         */
        val user: String,

        /**
         * 弹幕的内容
         * 注意, 不一定是一个自然语言字符串, 可能是以 [ 开头的具有语义的文本, 如下所示
         * [0,0,"1-1",4.5,"天下第一电击公主，贯穿天地的惊艳落雷！我炮傲娇永世长存！",0,0,0,0.99,500,0,1,"SimHei",true]
         * 这可能表示某种特殊的输出格式
         */
        val content: String
) {
        /**
         * 计算弹幕发送者 ID(可能有多个)
         * 第一次调用 Crc32Cracker 将花费大约 300ms 来生成反查表
         * hash 反查通常不超过 1ms
         */
        fun calculatePossibleUserIds() = Crc32Cracker.crack(user)
}
