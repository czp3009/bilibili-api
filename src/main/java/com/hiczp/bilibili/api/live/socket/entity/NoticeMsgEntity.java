package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class NoticeMsgEntity implements DataEntity {
    /**
     * cmd : NOTICE_MSG
     * full : {"head_icon":"","is_anim":1,"tail_icon":"","background":"#33ffffff","color":"#33ffffff","highlight":"#33ffffff","border":"#33ffffff","time":10}
     * half : {"head_icon":"","is_anim":0,"tail_icon":"","background":"#33ffffff","color":"#33ffffff","highlight":"#33ffffff","border":"#33ffffff","time":8}
     * roomid : 11415406
     * real_roomid : 0
     * msg_common : 恭喜<%汤圆老师%>获得大奖<%23333x银瓜子%>, 感谢<%林发发爱林小兔%>的赠送
     * msg_self : 恭喜<%汤圆老师%>获得大奖<%23333x银瓜子%>, 感谢<%林发发爱林小兔%>的赠送
     * link_url : http://live.bilibili.com/0
     * msg_type : 4
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("full")
    private Full full;
    @SerializedName("half")
    private Half half;
    @SerializedName("roomid")
    private String roomId;
    @SerializedName("real_roomid")
    private String realRoomId;
    @SerializedName("msg_common")
    private String messageCommon;
    @SerializedName("msg_self")
    private String messageSelf;
    @SerializedName("link_url")
    private String linkUrl;
    @SerializedName("msg_type")
    private int messageType;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Full getFull() {
        return full;
    }

    public void setFull(Full full) {
        this.full = full;
    }

    public Half getHalf() {
        return half;
    }

    public void setHalf(Half half) {
        this.half = half;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRealRoomId() {
        return realRoomId;
    }

    public void setRealRoomId(String realRoomId) {
        this.realRoomId = realRoomId;
    }

    public String getMessageCommon() {
        return messageCommon;
    }

    public void setMessageCommon(String messageCommon) {
        this.messageCommon = messageCommon;
    }

    public String getMessageSelf() {
        return messageSelf;
    }

    public void setMessageSelf(String messageSelf) {
        this.messageSelf = messageSelf;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public static class Full {
        /**
         * head_icon :
         * is_anim : 1
         * tail_icon :
         * background : #33ffffff
         * color : #33ffffff
         * highlight : #33ffffff
         * border : #33ffffff
         * time : 10
         */

        @SerializedName("head_icon")
        private String headIcon;
        @SerializedName("is_anim")
        private int isAnimation;
        @SerializedName("tail_icon")
        private String tailIcon;
        @SerializedName("background")
        private String background;
        @SerializedName("color")
        private String color;
        @SerializedName("highlight")
        private String highlight;
        @SerializedName("border")
        private String border;
        @SerializedName("time")
        private int time;

        public String getHeadIcon() {
            return headIcon;
        }

        public void setHeadIcon(String headIcon) {
            this.headIcon = headIcon;
        }

        public int getIsAnimation() {
            return isAnimation;
        }

        public void setIsAnimation(int isAnimation) {
            this.isAnimation = isAnimation;
        }

        public String getTailIcon() {
            return tailIcon;
        }

        public void setTailIcon(String tailIcon) {
            this.tailIcon = tailIcon;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getHighlight() {
            return highlight;
        }

        public void setHighlight(String highlight) {
            this.highlight = highlight;
        }

        public String getBorder() {
            return border;
        }

        public void setBorder(String border) {
            this.border = border;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    public static class Half {
        /**
         * head_icon :
         * is_anim : 0
         * tail_icon :
         * background : #33ffffff
         * color : #33ffffff
         * highlight : #33ffffff
         * border : #33ffffff
         * time : 8
         */

        @SerializedName("head_icon")
        private String headIcon;
        @SerializedName("is_anim")
        private int isAnimation;
        @SerializedName("tail_icon")
        private String tailIcon;
        @SerializedName("background")
        private String background;
        @SerializedName("color")
        private String color;
        @SerializedName("highlight")
        private String highlight;
        @SerializedName("border")
        private String border;
        @SerializedName("time")
        private int time;

        public String getHeadIcon() {
            return headIcon;
        }

        public void setHeadIcon(String headIcon) {
            this.headIcon = headIcon;
        }

        public int getIsAnimation() {
            return isAnimation;
        }

        public void setIsAnimation(int isAnimation) {
            this.isAnimation = isAnimation;
        }

        public String getTailIcon() {
            return tailIcon;
        }

        public void setTailIcon(String tailIcon) {
            this.tailIcon = tailIcon;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getHighlight() {
            return highlight;
        }

        public void setHighlight(String highlight) {
            this.highlight = highlight;
        }

        public String getBorder() {
            return border;
        }

        public void setBorder(String border) {
            this.border = border;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }
}
