package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class RoomRankEntity implements DataEntity {
    /**
     * cmd : ROOM_RANK
     * data : {"roomid":1241012,"rank_desc":"小时榜 182","color":"#FB7299","h5_url":"https://live.bilibili.com/p/eden/rank-h5-current?anchor_uid=35577726","timestamp":1527148082}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

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

    public static class Data {
        /**
         * roomid : 1241012
         * rank_desc : 小时榜 182
         * color : #FB7299
         * h5_url : https://live.bilibili.com/p/eden/rank-h5-current?anchor_uid=35577726
         * timestamp : 1527148082
         */

        @SerializedName("roomid")
        private long roomId;
        @SerializedName("rank_desc")
        private String rankDescription;
        @SerializedName("color")
        private String color;
        @SerializedName("h5_url")
        private String h5Url;
        @SerializedName("timestamp")
        private long timestamp;

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public String getRankDescription() {
            return rankDescription;
        }

        public void setRankDescription(String rankDescription) {
            this.rankDescription = rankDescription;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getH5Url() {
            return h5Url;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }
}
