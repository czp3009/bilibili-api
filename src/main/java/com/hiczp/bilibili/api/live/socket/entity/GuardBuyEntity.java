package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class GuardBuyEntity implements DataEntity {
    /**
     * cmd : GUARD_BUY
     * data : {"uid":4561799,"username":"微笑The迪妮莎","guard_level":1,"num":1}
     * roomid : 5279
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;
    @SerializedName("roomid")
    private String roomId;

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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public static class Data {
        /**
         * uid : 4561799
         * username : 微笑The迪妮莎
         * guard_level : 1
         * num : 1
         */

        @SerializedName("uid")
        private long userId;
        @SerializedName("username")
        private String username;
        @SerializedName("guard_level")
        private int guardLevel;
        @SerializedName("num")
        private int number;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getGuardLevel() {
            return guardLevel;
        }

        public void setGuardLevel(int guardLevel) {
            this.guardLevel = guardLevel;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
