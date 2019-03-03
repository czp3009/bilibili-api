package com.hiczp.bilibili.api.test

import com.hiczp.bilibili.api.danmaku.DanmakuParser
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class DanmakuTest {
    //6250 行弹幕的解析加用户 ID 反查在 4098ms 内完成(i7-8700)
    @Test
    fun fetchAndParseDanmaku() {
        runBlocking {
            //著名的炮姐视频 你指尖跃动的电光是我此生不变的信仰
            val responseBody = bilibiliClient.danmakuAPI.list(aid = 810872, oid = 1176840).await()
            timer {
                DanmakuParser.parse(responseBody.byteStream()).second.forEach {
                    println("[${it.time}] ${it.calculatePossibleUserIds()} ${it.content}")
                }
            }
        }
    }
}
