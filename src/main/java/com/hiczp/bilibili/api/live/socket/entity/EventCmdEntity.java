package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class EventCmdEntity implements DataEntity {
    /**
     * roomid : 234024
     * cmd : EVENT_CMD
     * data : {"event_type":"flower_rain-16915","event_img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/activity/lover_2018/raffle.png"}
     */

    @SerializedName("roomid")
    private long roomId;
    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

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

    public static class Data {
        /**
         * event_type : flower_rain-16915
         * event_img : http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/activity/lover_2018/raffle.png
         */

        @SerializedName("event_type")
        private String eventType;
        @SerializedName("event_img")
        private String eventImg;

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String getEventImg() {
            return eventImg;
        }

        public void setEventImg(String eventImg) {
            this.eventImg = eventImg;
        }
    }
}
