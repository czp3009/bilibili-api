package com.hiczp.bilibili.api.danmaku

import com.google.gson.stream.JsonReader
import com.hiczp.bilibili.api.bounded
import com.hiczp.bilibili.api.readUInt
import java.io.InputStream
import java.util.*
import java.util.zip.GZIPInputStream
import javax.xml.namespace.QName
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamConstants

/**
 * 弹幕文件解析器.
 * 弹幕文件(list.so)有三个部分
 * 第一个部分为一个 Int, 表示第二部分的长度
 * 第二部分为一个 Json, 标识各个弹幕的等级(用于屏蔽设置)
 * 第三部分为一个 gzip 压缩过的 xml
 *
 * Web 端的弹幕是一个明文 xml, 与 APP 的接口是不一样的.
 *
 * json 部分形如 {"dmflags":[{"dmid":12551893546958848,"flag":10}],"rec_flag":1,"rec_text":"开启后，全站视频将按等级等优化弹幕","rec_switch":1}
 * xml 部分形如 <d p="12509048833835076,0,117373,5,25,16777215,1551001292,0,d2c5fc5">硬核劈柴</d>
 *
 * @see com.hiczp.bilibili.api.danmaku.DanmakuAPI.list
 */
@Suppress("SpellCheckingInspection")
object DanmakuParser {
    /**
     * 解析弹幕文件
     *
     * @param inputStream 输入流, 可以指向任何位置
     *
     * @return 返回 flags map 与 弹幕序列. 注意, 原始的弹幕顺序是按发送时间来排的, 而非播放器时间.
     */
    fun parse(inputStream: InputStream): Pair<Map<Long, Int>, Sequence<Danmaku>> {
        //Json 的长度
        val jsonLength = inputStream.readUInt()

        //弹幕ID-Flag
        val danmakuFlags = HashMap<Long, Int>()
        //gson 会从 reader 中自行缓冲 1024 个字符, 这会导致额外的字符被消费. 因此要限制其读取数量
        //流式解析 Json
        with(JsonReader(inputStream.bounded(jsonLength).reader())) {
            beginObject()
            while (hasNext()) {
                when (nextName()) {
                    "dmflags" -> {
                        beginArray()
                        while (hasNext()) {
                            var danmakuId = 0L
                            var flag = 0
                            beginObject()
                            while (hasNext()) {
                                when (nextName()) {
                                    "dmid" -> danmakuId = nextLong()
                                    "flag" -> flag = nextInt()
                                    else -> skipValue()
                                }
                            }
                            endObject()
                            danmakuFlags[danmakuId] = flag
                        }
                        endArray()
                    }
                    else -> skipValue()
                }
            }
            endObject()
        }

        //json 解析完毕后, 剩下的内容是一个 gzip 压缩过的 xml
        val reader = GZIPInputStream(inputStream).reader()
        //流式解析 xml
        val xmlEventReader = XMLInputFactory.newInstance().createXMLEventReader(reader)
        //lazy sequence
        val danmakus = sequence {
            var startD = false  //之前解析到的 element 是否是 d
            var p: String? = null   //之前解析到的 p 的值
            while (xmlEventReader.hasNext()) {
                val event = xmlEventReader.nextEvent()
                when (event.eventType) {
                    XMLStreamConstants.START_ELEMENT -> {
                        with(event.asStartElement()) {
                            startD = name.localPart == "d"
                            if (startD) {
                                p = getAttributeByName(P).value
                            }
                        }
                    }
                    XMLStreamConstants.CHARACTERS -> {
                        //如果前一个解析到的是 d 标签, 那么此处得到的一定是 d 标签的 body
                        if (startD) {
                            val danmaku = with(StringTokenizer(p, ",")) {
                                Danmaku(
                                        nextToken().toLong(),
                                        nextToken(),
                                        nextToken().toLong(),
                                        nextToken().toInt(),
                                        nextToken().toInt(),
                                        nextToken().toInt(),
                                        nextToken().toLong(),
                                        nextToken(),
                                        nextToken(),
                                        event.asCharacters().data
                                )
                            }
                            yield(danmaku)
                        }
                    }
                }
            }
        }

        return danmakuFlags to danmakus
    }

    //常量, 用于加快速度
    private val P = QName("p")
}
