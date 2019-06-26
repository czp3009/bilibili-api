package com.hiczp.bilibili.websocket

import com.github.salomonbrys.kotson.jsonObject
import java.nio.ByteBuffer

/**
 * 预设数据包
 */
internal object PresetPacket {
    /**
     * 进房数据包
     * {"uid":50333369,"roomid":14073662,"protover":1}
     *
     * @param anchorUserId 房间主的用户 ID
     * @param roomId 房间号
     */
    @Suppress("SpellCheckingInspection")
    fun enterRoom(anchorUserId: Long, roomId: Long) = Packet(
            packetType = PacketType.ENTER_ROOM,
            content = ByteBuffer.wrap(
                    jsonObject(
                            "uid" to anchorUserId,
                            "roomid" to roomId,
                            "protover" to 1 //该值总为 1
                    ).toString().toByteArray()
            )
    )

    /**
     * 心跳包
     * 心跳包的正文内容可能是故意的, 为固定值 "[object Object]"
     */
    fun heartbeat(content: ByteBuffer = ByteBuffer.wrap("[object Object]".toByteArray())) = Packet(
            packetType = PacketType.HEARTBEAT,
            content = content
    )
}
