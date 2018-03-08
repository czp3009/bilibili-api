package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class RoomSilentOnEntity implements DataEntity {
    /**
     * cmd : ROOM_SILENT_ON
     * data : {"type":"level","level":1,"second":1520424615}
     * roomid : 5279
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;
    @SerializedName("roomid")
    private long roomId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public static class Data {
        /**
         * type : level
         * level : 1
         * second : 1520424615
         */

        @SerializedName("type")
        private String type;
        @SerializedName("level")
        private int level;
        @SerializedName("second")
        private long second;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public long getSecond() {
            return second;
        }

        public void setSecond(long second) {
            this.second = second;
        }
    }
}
