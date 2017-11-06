package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;
import com.hiczp.bilibili.api.BilibiliRESTAPI;

public class BulletScreenEntity {
    private int cid;

    private int mid = BilibiliRESTAPI.getMid();

    @SerializedName("msg")
    private String message;

    //该随机数不包括符号位有 9 位
    @SerializedName("rnd")
    private long random = (long) (Math.random() * (999999999 - (-999999999)) + (-999999999));

    private int mode = 1;

    private int pool = 0;

    private String type = "json";

    private int color = 16777215;

    @SerializedName("fontsize")
    private int fontSize = 25;

    private String playTime = "0.0";

    public BulletScreenEntity(int cid, String message) {
        this.cid = cid;
        this.message = message;
    }

    public int getCid() {
        return cid;
    }

    public BulletScreenEntity setCid(int cid) {
        this.cid = cid;
        return this;
    }

    public int getMid() {
        return mid;
    }

    public BulletScreenEntity setMid(int mid) {
        this.mid = mid;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BulletScreenEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public long getRandom() {
        return random;
    }

    public BulletScreenEntity setRandom(long random) {
        this.random = random;
        return this;
    }

    public int getMode() {
        return mode;
    }

    public BulletScreenEntity setMode(int mode) {
        this.mode = mode;
        return this;
    }

    public int getPool() {
        return pool;
    }

    public BulletScreenEntity setPool(int pool) {
        this.pool = pool;
        return this;
    }

    public String getType() {
        return type;
    }

    public BulletScreenEntity setType(String type) {
        this.type = type;
        return this;
    }

    public int getColor() {
        return color;
    }

    public BulletScreenEntity setColor(int color) {
        this.color = color;
        return this;
    }

    public int getFontSize() {
        return fontSize;
    }

    public BulletScreenEntity setFontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public String getPlayTime() {
        return playTime;
    }

    public BulletScreenEntity setPlayTime(String playTime) {
        this.playTime = playTime;
        return this;
    }
}
