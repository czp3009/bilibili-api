package com.hiczp.bilibili.api.test

import com.hiczp.bilibili.api.danmaku.DanmakuParser
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class DanmakuTest {
    //339.6kib 的弹幕文件在 0.5s 内解析完毕(i5-4200H), 通常视频的弹幕不会超过这个容量
    @Test
    fun fetchAndParseDanmaku() {
        runBlocking {
            //著名的炮姐视频 你指尖跃动的电光是我此生不变的信仰
            val responseBody = bilibiliClient.danmakuAPI.list(aid = 810872, oid = 1176840).await()
            timer {
                DanmakuParser.parse(responseBody.byteStream()).second.forEach {
                    println("[${it.time}] ${it.content}")
                }
            }
        }
    }
}
