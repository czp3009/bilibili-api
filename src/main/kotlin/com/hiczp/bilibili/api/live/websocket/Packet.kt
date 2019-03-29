package com.hiczp.bilibili.api.live.websocket

import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.WebSocketSession
import java.nio.ByteBuffer

/**
 * 数据包模型
 * 由于 Android APP 并未全线换成 wss, 以下用的是移动版网页的协议
 * 数据包头部结构  00 00 00 65  00 10 00 01  00 00 00 07  00 00 00 01
 *              |数据包总长度| |头长| |tag|  |数据包类型 |  |  tag  |
 *
 * @param shortTag 一种 tag, 如果是非 command 数据包则为 1, 否则为 0, short 类型
 * @param packetType 数据包类型
 * @param tag 同 tagShort, 但是为 int 类型
 * @param content 正文内容
 */
@Suppress("MemberVisibilityCanBePrivate")
data class Packet(
        val shortTag: Short = 1,
        val packetType: PacketType,
        val tag: Int = 1,
        val content: ByteBuffer
) {
    val totalLength
        get() = headerLength + content.limit()

    val headerLength: Short = 0x10

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
}

/**
 * 一个 Message 中可能包含多个数据包
 */
internal fun Frame.toPackets(): List<Packet> {
    val bufferLength = buffer.limit()
    val list = ArrayList<Packet>()
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
        list.add(Packet(shortTag, packetType, tag, content))
    }
    return list
}

internal suspend inline fun WebSocketSession.send(packet: Packet) = send(packet.toFrame())
