package com.hiczp.bilibili.api.test;

public class Config {
    private static Config config;

    private String username;
    private String password;
    private int roomId;

    static Config getInstance() {
        return config;
    }

    static void setConfig(Config config) {
        Config.config = config;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
