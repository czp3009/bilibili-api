package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class TVStartEntity implements DataEntity {
    /**
     * cmd : TV_START
     * data : {"id":"40072","dtime":180,"msg":{"cmd":"SYS_MSG","msg":"【杰宝Yvan生命倒计时】:?在直播间:?【102】:?赠送 小电视一个，请前往抽奖","msg_text":"【杰宝Yvan生命倒计时】:?在直播间:?【102】:?赠送 小电视一个，请前往抽奖","rep":1,"styleType":2,"url":"http://live.bilibili.com/102","roomid":102,"real_roomid":5279,"rnd":12987955,"tv_id":"40072"},"raffleId":40072,"type":"small_tv","from":"杰宝Yvan生命倒计时","time":180}
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
         * id : 40072
         * dtime : 180
         * msg : {"cmd":"SYS_MSG","msg":"【杰宝Yvan生命倒计时】:?在直播间:?【102】:?赠送 小电视一个，请前往抽奖","msg_text":"【杰宝Yvan生命倒计时】:?在直播间:?【102】:?赠送 小电视一个，请前往抽奖","rep":1,"styleType":2,"url":"http://live.bilibili.com/102","roomid":102,"real_roomid":5279,"rnd":12987955,"tv_id":"40072"}
         * raffleId : 40072
         * type : small_tv
         * from : 杰宝Yvan生命倒计时
         * time : 180
         */

        @SerializedName("id")
        private String id;
        @SerializedName("dtime")
        private int dtime;
        @SerializedName("msg")
        private Msg msg;
        @SerializedName("raffleId")
        private int raffleId;
        @SerializedName("type")
        private String type;
        @SerializedName("from")
        private String from;
        @SerializedName("time")
        private int time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getDtime() {
            return dtime;
        }

        public void setDtime(int dtime) {
            this.dtime = dtime;
        }

        public Msg getMsg() {
            return msg;
        }

        public void setMsg(Msg msg) {
            this.msg = msg;
        }

        public int getRaffleId() {
            return raffleId;
        }

        public void setRaffleId(int raffleId) {
            this.raffleId = raffleId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public static class Msg {
            /**
             * cmd : SYS_MSG
             * msg : 【杰宝Yvan生命倒计时】:?在直播间:?【102】:?赠送 小电视一个，请前往抽奖
             * msg_text : 【杰宝Yvan生命倒计时】:?在直播间:?【102】:?赠送 小电视一个，请前往抽奖
             * rep : 1
             * styleType : 2
             * url : http://live.bilibili.com/102
             * roomid : 102
             * real_roomid : 5279
             * rnd : 12987955
             * tv_id : 40072
             */

            @SerializedName("cmd")
            private String cmd;
            @SerializedName("msg")
            private String msg;
            @SerializedName("msg_text")
            private String msgText;
            @SerializedName("rep")
            private int rep;
            @SerializedName("styleType")
            private int styleType;
            @SerializedName("url")
            private String url;
            @SerializedName("roomid")
            private int roomId;
            @SerializedName("real_roomid")
            private int realRoomId;
            @SerializedName("rnd")
            private int rnd;
            @SerializedName("tv_id")
            private String tvId;

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

            public int getRoomId() {
                return roomId;
            }

            public void setRoomId(int roomId) {
                this.roomId = roomId;
            }

            public int getRealRoomId() {
                return realRoomId;
            }

            public void setRealRoomId(int realRoomId) {
                this.realRoomId = realRoomId;
            }

            public int getRnd() {
                return rnd;
            }

            public void setRnd(int rnd) {
                this.rnd = rnd;
            }

            public String getTvId() {
                return tvId;
            }

            public void setTvId(String tvId) {
                this.tvId = tvId;
            }
        }
    }
}
