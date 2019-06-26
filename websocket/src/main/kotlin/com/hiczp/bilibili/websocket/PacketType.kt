package com.hiczp.bilibili.websocket

enum class PacketType(val value: Int) {
    //impossible
    UNKNOWN(0),

    HEARTBEAT(2),

    POPULARITY(3),

    COMMAND(5),

    ENTER_ROOM(7),

    ENTER_ROOM_RESPONSE(8);

    companion object {
        private val byValueMap = values().associateBy { it.value }

        fun getByValue(value: Int) = byValueMap[value] ?: UNKNOWN
    }
}
