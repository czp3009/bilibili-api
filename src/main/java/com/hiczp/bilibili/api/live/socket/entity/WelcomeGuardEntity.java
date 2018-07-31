package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class WelcomeGuardEntity implements DataEntity {
    /**
     * cmd : WELCOME_GUARD
     * data : {"uid":23598108,"username":"lovevael","guard_level":3,"water_god":0}
     * roomid : 43001
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
         * uid : 23598108
         * username : lovevael
         * guard_level : 3
         * water_god : 0
         */

        @SerializedName("uid")
        private long userId;
        @SerializedName("username")
        private String username;
        @SerializedName("guard_level")
        private int guardLevel;
        @SerializedName("water_god")
        private Integer waterGod;

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

        public Integer getWaterGod() {
            return waterGod;
        }

        public void setWaterGod(Integer waterGod) {
            this.waterGod = waterGod;
        }
    }
}
