package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class WelcomeGuardEntity {
    /**
     * cmd : WELCOME_GUARD
     * data : {"uid":23598108,"username":"lovevael","guard_level":3,"water_god":0}
     * roomid : 43001
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private DataEntity data;
    @SerializedName("roomid")
    private long roomId;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public static class DataEntity {
        /**
         * uid : 23598108
         * username : lovevael
         * guard_level : 3
         * water_god : 0
         */

        @SerializedName("uid")
        private int uid;
        @SerializedName("username")
        private String username;
        @SerializedName("guard_level")
        private int guardLevel;
        @SerializedName("water_god")
        private int waterGod;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
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

        public int getWaterGod() {
            return waterGod;
        }

        public void setWaterGod(int waterGod) {
            this.waterGod = waterGod;
        }
    }
}
