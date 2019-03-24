package com.hiczp.bilibili.api.live.websocket

import com.github.salomonbrys.kotson.jsonObject
import java.nio.ByteBuffer

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
            packetType = PacketType.ENTER_ROOM,
            content = ByteBuffer.wrap(
                    jsonObject(
                            "uid" to anchorUserId,
                            "roomid" to roomId,
                            "protover" to 0 //该值总为 0
                    ).toString().toByteArray()
            )
    )

    /**
     * 心跳包
     * 心跳包的正文内容可能是故意的, 为固定值 [object Object]
     */
    fun heartbeatPacket(content: ByteBuffer = ByteBuffer.wrap("[object Object]".toByteArray())) = Packet(
            packetType = PacketType.HEARTBEAT,
            content = content
    )
}
