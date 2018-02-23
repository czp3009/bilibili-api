package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class SysMsgEntity implements DataEntity {
    /**
     * cmd : SYS_MSG
     * msg : 【瑾然-】:?在直播间:?【3939852】:?赠送 小电视一个，请前往抽奖
     * msg_text : 【瑾然-】:?在直播间:?【3939852】:?赠送 小电视一个，请前往抽奖
     * rep : 1
     * styleType : 2
     * url : http://live.bilibili.com/3939852
     * roomid : 3939852
     * real_roomid : 3939852
     * rnd : 1510499432
     * tv_id : 29318
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("msg")
    private String msg;
    //B站自己的广告, msgText 可能是空的
    @SerializedName("msg_text")
    private String msgText;
    @SerializedName("rep")
    private int rep;
    @SerializedName("styleType")
    private int styleType;
    @SerializedName("url")
    private String url;
    @SerializedName("roomid")
    private long roomId;
    @SerializedName("real_roomid")
    private long realRoomId;
    @SerializedName("rnd")
    private long rnd;
    @SerializedName("tv_id")
    private String tvId;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public int getStyleType() {
        return styleType;
    }

    public void setStyleType(int styleType) {
        this.styleType = styleType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getRealRoomId() {
        return realRoomId;
    }

    public void setRealRoomId(long realRoomId) {
        this.realRoomId = realRoomId;
    }

    public long getRnd() {
        return rnd;
    }

    public void setRnd(long rnd) {
        this.rnd = rnd;
    }

    public String getTvId() {
        return tvId;
    }

    public void setTvId(String tvId) {
        this.tvId = tvId;
    }
}
