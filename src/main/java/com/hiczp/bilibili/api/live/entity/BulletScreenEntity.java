package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class BulletScreenEntity {
    private long cid;

    private long mid;

    /**
     * 弹幕长度限制为 LiveRoomInfoEntity.getData().getMsgLength(), 对于每个用户而言, 每个房间都一样
     * 通过完成 B站 有关任务, 获得成就, 可以加大这个限制(舰长, 老爷等可以直接加大限制), 最长好像是 40 个字
     */
    @SerializedName("msg")
    private String message;

    /**
     * 在 web 端发送弹幕, 该字段是固定的, 为用户进入直播页面的时间的时间戳. 但是在 Android 端, 这是一个随机数
     * 该随机数不包括符号位有 9 位
     */
    @SerializedName("rnd")
    private long random = (long) (Math.random() * (999999999 - (-999999999)) + (-999999999));

    /**
     * 1 普通
     * 4 底端
     * 5 顶端
     * 6 逆向
     * 7 特殊
     * 9 高级
     * 一些模式需要 VIP
     */
    private int mode = 1;

    /**
     * 弹幕池
     * 尚且只见过为 0 的情况
     */
    private int pool = 0;

    private String type = "json";

    private int color = 16777215;

    @SerializedName("fontsize")
    private int fontSize = 25;

    private String playTime = "0.0";

    /**
     * 实际上并不需要包含 mid 就可以正常发送弹幕, 但是真实的 Android 客户端确实发送了 mid
     */
    public BulletScreenEntity(long cid, long mid, String message) {
        this.cid = cid;
        this.mid = mid;
        this.message = message;
    }

    public long getCid() {
        return cid;
    }

    public BulletScreenEntity setCid(long cid) {
        this.cid = cid;
        return this;
    }

    public long getMid() {
        return mid;
    }

    public BulletScreenEntity setMid(long mid) {
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
