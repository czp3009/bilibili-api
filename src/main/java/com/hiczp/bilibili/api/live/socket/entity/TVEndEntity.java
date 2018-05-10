package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class TVEndEntity implements DataEntity {
    /**
     * cmd : TV_END
     * data : {"id":"39077","uname":"かこゆきこvew","sname":"是你的苏苏吖","giftName":"10W银瓜子","mobileTips":"恭喜 かこゆきこvew 获得10W银瓜子","raffleId":"39077","type":"small_tv","from":"是你的苏苏吖","fromFace":"http://i0.hdslb.com/bfs/face/147f137d24138d1cfec5443d98ac8b03c4332398.jpg","win":{"uname":"かこゆきこvew","face":"http://i0.hdslb.com/bfs/face/4d63bd62322e7f3ef38723a91440bc6930626d9f.jpg","giftName":"银瓜子","giftId":"silver","giftNum":100000}}
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
         * id : 39077
         * uname : かこゆきこvew
         * sname : 是你的苏苏吖
         * giftName : 10W银瓜子
         * mobileTips : 恭喜 かこゆきこvew 获得10W银瓜子
         * raffleId : 39077
         * type : small_tv
         * from : 是你的苏苏吖
         * fromFace : http://i0.hdslb.com/bfs/face/147f137d24138d1cfec5443d98ac8b03c4332398.jpg
         * win : {"uname":"かこゆきこvew","face":"http://i0.hdslb.com/bfs/face/4d63bd62322e7f3ef38723a91440bc6930626d9f.jpg","giftName":"银瓜子","giftId":"silver","giftNum":100000}
         */

        @SerializedName("id")
        private String id;
        @SerializedName("uname")
        private String username;
        @SerializedName("sname")
        private String sname;
        @SerializedName("giftName")
        private String giftName;
        @SerializedName("mobileTips")
        private String mobileTips;
        @SerializedName("raffleId")
        private String raffleId;
        @SerializedName("type")
        private String type;
        @SerializedName("from")
        private String from;
        @SerializedName("fromFace")
        private String fromFace;
        @SerializedName("win")
        private Win win;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getGiftName() {
            return giftName;
        }

        public void setGiftName(String giftName) {
            this.giftName = giftName;
        }

        public String getMobileTips() {
            return mobileTips;
        }

        public void setMobileTips(String mobileTips) {
            this.mobileTips = mobileTips;
        }

        public String getRaffleId() {
            return raffleId;
        }

        public void setRaffleId(String raffleId) {
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
             * uname : かこゆきこvew
             * face : http://i0.hdslb.com/bfs/face/4d63bd62322e7f3ef38723a91440bc6930626d9f.jpg
             * giftName : 银瓜子
             * giftId : silver
             * giftNum : 100000
             */

            @SerializedName("uname")
            private String username;
            @SerializedName("face")
            private String face;
            @SerializedName("giftName")
            private String giftName;
            @SerializedName("giftId")
            private String giftId;
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

            public String getGiftName() {
                return giftName;
            }

            public void setGiftName(String giftName) {
                this.giftName = giftName;
            }

            public String getGiftId() {
                return giftId;
            }

            public void setGiftId(String giftId) {
                this.giftId = giftId;
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
