package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class SysGiftEntity implements DataEntity {
    /**
     * cmd : SYS_GIFT
     * msg : あさひなみよう在直播间5135178开启了丰收祭典，一起来分享收获的福利吧！
     * msg_text : あさひなみよう在直播间5135178开启了丰收祭典，一起来分享收获的福利吧！
     * tips : あさひなみよう在直播间5135178开启了丰收祭典，一起来分享收获的福利吧！
     * url : http://live.bilibili.com/5135178
     * roomid : 5135178
     * real_roomid : 5135178
     * giftId : 103
     * msgTips : 0
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("msg")
    private String msg;
    @SerializedName("msg_text")
    private String msgText;
    @SerializedName("tips")
    private String tips;
    @SerializedName("url")
    private String url;
    @SerializedName("roomid")
    private long roomId;
    @SerializedName("real_roomid")
    private long realRoomId;
    @SerializedName("giftId")
    private int giftId;
    @SerializedName("msgTips")
    private int msgTips;

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

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
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

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public int getMsgTips() {
        return msgTips;
    }

    public void setMsgTips(int msgTips) {
        this.msgTips = msgTips;
    }
}
