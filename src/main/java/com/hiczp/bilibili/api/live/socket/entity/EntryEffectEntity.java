package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class EntryEffectEntity implements DataEntity {
    /**
     * cmd : ENTRY_EFFECT
     * data : {"id":3,"uid":9359447,"target_id":275592903,"show_avatar":1,"copy_writing":"欢迎 <%藏拙当成玉%> 进入房间","highlight_color":"#FFF100","basemap_url":"http://i0.hdslb.com/bfs/live/d208b9654b93a70b4177e1aa7e2f0343f8a5ff1a.png","effective_time":1,"priority":50,"privilege_type":0,"face":"http://i1.hdslb.com/bfs/face/12cb1ea6eea79667e3fb722bbd8995bb96f4cd6f.jpg"}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

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

    public static class Data {
        /**
         * id : 3
         * uid : 9359447
         * target_id : 275592903
         * show_avatar : 1
         * copy_writing : 欢迎 <%藏拙当成玉%> 进入房间
         * highlight_color : #FFF100
         * basemap_url : http://i0.hdslb.com/bfs/live/d208b9654b93a70b4177e1aa7e2f0343f8a5ff1a.png
         * effective_time : 1
         * priority : 50
         * privilege_type : 0
         * face : http://i1.hdslb.com/bfs/face/12cb1ea6eea79667e3fb722bbd8995bb96f4cd6f.jpg
         */

        @SerializedName("id")
        private long id;
        @SerializedName("uid")
        private long uid;
        @SerializedName("target_id")
        private long targetId;
        @SerializedName("show_avatar")
        private int showAvatar;
        @SerializedName("copy_writing")
        private String copyWriting;
        @SerializedName("highlight_color")
        private String highlightColor;
        @SerializedName("basemap_url")
        private String baseMapUrl;
        @SerializedName("effective_time")
        private int effectiveTime;
        @SerializedName("priority")
        private int priority;
        @SerializedName("privilege_type")
        private int privilegeType;
        @SerializedName("face")
        private String face;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public long getTargetId() {
            return targetId;
        }

        public void setTargetId(long targetId) {
            this.targetId = targetId;
        }

        public int getShowAvatar() {
            return showAvatar;
        }

        public void setShowAvatar(int showAvatar) {
            this.showAvatar = showAvatar;
        }

        public String getCopyWriting() {
            return copyWriting;
        }

        public void setCopyWriting(String copyWriting) {
            this.copyWriting = copyWriting;
        }

        public String getHighlightColor() {
            return highlightColor;
        }

        public void setHighlightColor(String highlightColor) {
            this.highlightColor = highlightColor;
        }

        public String getBaseMapUrl() {
            return baseMapUrl;
        }

        public void setBaseMapUrl(String baseMapUrl) {
            this.baseMapUrl = baseMapUrl;
        }

        public int getEffectiveTime() {
            return effectiveTime;
        }

        public void setEffectiveTime(int effectiveTime) {
            this.effectiveTime = effectiveTime;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getPrivilegeType() {
            return privilegeType;
        }

        public void setPrivilegeType(int privilegeType) {
            this.privilegeType = privilegeType;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }
    }
}
