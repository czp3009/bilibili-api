package com.hiczp.bilibili.api.live.websocket

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
