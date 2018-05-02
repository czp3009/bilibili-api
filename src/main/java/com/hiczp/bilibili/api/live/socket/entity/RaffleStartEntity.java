package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class RaffleStartEntity implements DataEntity {
    /**
     * cmd : RAFFLE_START
     * roomid : 234024
     * data : {"raffleId":16915,"type":"flower_rain","from":"爱吃喵姐的鱼","time":60}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private int roomid;
    @SerializedName("data")
    private Data data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * raffleId : 16915
         * type : flower_rain
         * from : 爱吃喵姐的鱼
         * time : 60
         */

        @SerializedName("raffleId")
        private int raffleId;
        @SerializedName("type")
        private String type;
        @SerializedName("from")
        private String from;
        @SerializedName("time")
        private int time;

        public int getRaffleId() {
            return raffleId;
        }

        public void setRaffleId(int raffleId) {
            this.raffleId = raffleId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
