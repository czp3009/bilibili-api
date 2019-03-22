package com.hiczp.bilibili.api.live.websocket

import com.github.salomonbrys.kotson.jsonObject
import com.google.gson.JsonElement
import com.hiczp.bilibili.api.jsonParser
import com.hiczp.bilibili.api.toPrettyPrintString
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.WebSocketSession
import io.ktor.http.cio.websocket.readBytes
import io.ktor.util.InternalAPI
import io.ktor.util.moveToByteArray
import java.nio.ByteBuffer

/**
 * 数据包模型
 * 由于 Android APP 并未全线换成 wss, 以下用的是移动版网页的协议
 *
 * @param packetType 数据包类型
 * @param content 正文内容
 * @param protocolVersion 协议版本
 * @param sequence 序列号, 似乎总为 1
 */
@Suppress("MemberVisibilityCanBePrivate")
class Packet(
        val packetType: PacketType,
        val content: ByteArray,
        val protocolVersion: Short = 1,
        val sequence: Int = 1
) {
    constructor(
            packetType: PacketType,
            content: JsonElement,
            protocolVersion: Short = 1,
            sequence: Int = 1
    ) : this(packetType, content.toString().toByteArray(), protocolVersion, sequence)

    val totalLength: Int
        get() = headerLength + content.size

    val headerLength: Short = 16

    fun getJsonContent() = jsonParser.parse(content.toString(Charsets.UTF_8))!!

    fun toFrame() = Frame.Binary(
            true,
            ByteBuffer.allocate(totalLength)
                    .putInt(totalLength)
                    .putShort(headerLength)
                    .putShort(protocolVersion)
                    .putInt(packetType.value)
                    .putInt(sequence)
                    .put(content)
                    .flip()
    )

    override fun toString() = toFrame().readBytes().toPrettyPrintString()

    companion object {
        @UseExperimental(InternalAPI::class)
        fun fromFrame(frame: Frame) =
                with(frame.buffer) {
                    int
                    short
                    val protocolVersion = short
                    val packetType = PacketType.getByValue(int)
                    val sequence = int
                    val content = moveToByteArray()
                    Packet(packetType, content, protocolVersion, sequence)
                }
    }
}

enum class PacketType(val value: Int) {
    //impossible
    UNKNOWN(0),

    HEARTBEAT(2),

    POPULARITY(3),

    COMMAND(5),

    ENTER_ROOM(7),

    ENTER_ROOM_RESPONSE(8);

    companion object {
        fun getByValue(value: Int) = values().firstOrNull { it.value == value } ?: UNKNOWN
    }
}

/**
 * 预设数据包
 */
object PresetPacket {
    /**
     * 进房数据包
     * {"uid":50333369,"roomid":14073662,"protover":0}
     *
     * @param anchorUserId 房间主的用户 ID
     * @param roomId 房间号
     */
    @Suppress("SpellCheckingInspection")
    fun enterRoomPacket(anchorUserId: Long, roomId: Long) = Packet(
            PacketType.ENTER_ROOM,
            jsonObject(
                    "uid" to anchorUserId,
                    "roomid" to roomId,
                    "protover" to 0 //该值总为 0
            )
    )

    /**
     * 心跳包
     * 心跳包的正文内容可能是故意的, 为固定值 [object Object]
     */
    fun heartbeatPacket(content: ByteArray = "[object Object]".toByteArray()) = Packet(
            PacketType.HEARTBEAT,
            content
    )
}

internal fun Frame.toPacket() = Packet.fromFrame(this)

internal suspend inline fun WebSocketSession.send(packet: Packet) = send(packet.toFrame())
