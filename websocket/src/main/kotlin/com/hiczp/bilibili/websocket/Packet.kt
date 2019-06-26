package com.hiczp.bilibili.websocket

import com.github.salomonbrys.kotson.obj
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.WebSocketSession
import io.ktor.util.InternalAPI
import io.ktor.util.decodeString
import java.nio.ByteBuffer

/**
 * 数据包模型
 * 由于 Android APP 并未全线换成 wss, 以下用的是移动版网页的协议
 * 数据包头部结构  00 00 00 65  00 10 00 01  00 00 00 07  00 00 00 01
 *              |数据包总长度| |头长| |tag|  |数据包类型 |  |   tag   |
 *
 * @param shortTag 一种 tag, 如果是非 command 数据包则为 1, 否则为 0
 * @param packetType 数据包类型
 * @param tag 同 tagShort, 但是为 int 类型
 * @param content 正文内容
 */
@Suppress("MemberVisibilityCanBePrivate")
internal data class Packet(
        val shortTag: Short = 1,
        val packetType: PacketType,
        val tag: Int = shortTag.toInt(),
        val content: ByteBuffer
) {
    val totalLength
        get() = headerLength + content.limit()

    fun toFrame() = Frame.Binary(
            true,
            ByteBuffer.allocate(totalLength)
                    .putInt(totalLength)
                    .putShort(headerLength)
                    .putShort(shortTag)
                    .putInt(packetType.value)
                    .putInt(tag)
                    .put(content).apply {
                        flip()
                    }!!
    )

    companion object {
        const val headerLength: Short = 0x10
    }
}

sealed class ResolvedPacket<T> {
    abstract val packetType: PacketType
    abstract val content: T
}

data class PopularityPacket(override val content: Int) : ResolvedPacket<Int>() {
    constructor(content: ByteBuffer) : this(content.int)

    override val packetType = PacketType.POPULARITY
}

data class CommandPacket(override val content: Command) : ResolvedPacket<Command>() {
    @UseExperimental(InternalAPI::class)
    constructor(content: ByteBuffer) : this(jsonParser.parse(content.decodeString()).obj)

    override val packetType = PacketType.COMMAND

    inline val cmd
        get() = content.cmd

    companion object {
        private val jsonParser = JsonParser()
    }
}

/**
 * 一个 Message 中可能包含多个数据包
 */
internal fun Frame.toPackets(): Sequence<Packet> {
    val bufferLength = buffer.limit()
    return sequence {
        while (buffer.hasRemaining()) {
            val startPosition = buffer.position()
            val totalLength = buffer.int
            buffer.position(buffer.position() + 2)    //skip headerLength
            val shortTag = buffer.short
            val packetType = PacketType.getByValue(buffer.int)
            val tag = buffer.int
            buffer.limit(startPosition + totalLength)
            val content = buffer.slice()
            buffer.position(buffer.limit())
            buffer.limit(bufferLength)
            yield(Packet(shortTag, packetType, tag, content))
        }
    }
}

internal suspend inline fun WebSocketSession.send(packet: Packet) = send(packet.toFrame())

typealias Command = JsonObject

val Command.cmd
    get() = this["cmd"].asString!!
