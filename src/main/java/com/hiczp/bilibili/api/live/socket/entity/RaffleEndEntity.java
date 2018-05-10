package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class RaffleEndEntity implements DataEntity {
    /**
     * cmd : RAFFLE_END
     * roomid : 521429
     * data : {"raffleId":16897,"type":"flower_rain","from":"鷺沢怜人","fromFace":"http://i1.hdslb.com/bfs/face/09eafe44f913012512014e91f25001edf6e072d0.jpg","win":{"uname":"nbqgd","face":"http://i1.hdslb.com/bfs/face/09eafe44f913012512014e91f25001edf6e072d0.jpg","giftId":115,"giftName":"桃花","giftNum":66}}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("roomid")
    private long roomId;
    @SerializedName("data")
    private Data data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * raffleId : 16897
         * type : flower_rain
         * from : 鷺沢怜人
         * fromFace : http://i1.hdslb.com/bfs/face/09eafe44f913012512014e91f25001edf6e072d0.jpg
         * win : {"uname":"nbqgd","face":"http://i1.hdslb.com/bfs/face/09eafe44f913012512014e91f25001edf6e072d0.jpg","giftId":115,"giftName":"桃花","giftNum":66}
         */

        @SerializedName("raffleId")
        private int raffleId;
        @SerializedName("type")
        private String type;
        @SerializedName("from")
        private String from;
        @SerializedName("fromFace")
        private String fromFace;
        @SerializedName("win")
        private Win win;

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

        public String getFromFace() {
            return fromFace;
        }

        public void setFromFace(String fromFace) {
            this.fromFace = fromFace;
        }

        public Win getWin() {
            return win;
        }

        public void setWin(Win win) {
            this.win = win;
        }

        public static class Win {
            /**
             * uname : nbqgd
             * face : http://i1.hdslb.com/bfs/face/09eafe44f913012512014e91f25001edf6e072d0.jpg
             * giftId : 115
             * giftName : 桃花
             * giftNum : 66
             */

            @SerializedName("uname")
            private String username;
            @SerializedName("face")
            private String face;
            @SerializedName("giftId")
            private String giftId;  //礼物如果是 经验原石 一类的东西, 它的 id 是个字符串, 例如 "stuff-1"
            @SerializedName("giftName")
            private String giftName;
            @SerializedName("giftNum")
            private int giftNum;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public String getGiftId() {
                return giftId;
            }

            public void setGiftId(String giftId) {
                this.giftId = giftId;
            }

            public String getGiftName() {
                return giftName;
            }

            public void setGiftName(String giftName) {
                this.giftName = giftName;
            }

            public int getGiftNum() {
                return giftNum;
            }

            public void setGiftNum(int giftNum) {
                this.giftNum = giftNum;
            }
        }
    }
}
