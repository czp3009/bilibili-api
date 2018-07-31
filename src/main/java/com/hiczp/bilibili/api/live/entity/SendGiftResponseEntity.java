package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendGiftResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : {"silver":"2696","gold":"0","data":{"giftName":"辣条","num":1,"uname":"czp3009","rcost":31134,"uid":20293030,"top_list":[{"uid":20293030,"uname":"czp3009","coin":25100,"face":"http://i0.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","guard_level":0,"rank":1,"score":25100},{"uid":19946822,"uname":"罗非鱼追上来了","coin":8000,"face":"http://i2.hdslb.com/bfs/face/e71031a931125617fad2c148213381bb6e0e9f26.jpg","guard_level":0,"rank":2,"score":8000},{"uid":8353249,"uname":"TcCoke","coin":3500,"face":"http://i2.hdslb.com/bfs/face/7c3c131f89380db0046024d1a903d3a6e4dc6128.jpg","guard_level":0,"rank":3,"score":3500}],"timestamp":1509972225,"giftId":1,"giftType":0,"action":"喂食","super":0,"price":100,"rnd":"1430788195","newMedal":0,"newTitle":0,"medal":[],"title":"","beatId":0,"biz_source":"live","metadata":"","remain":1,"gold":0,"silver":0,"eventScore":0,"eventNum":0,"smalltv_msg":[],"specialGift":null,"notice_msg":[],"capsule":{"normal":{"coin":10,"change":0,"progress":{"now":2900,"max":10000}},"colorful":{"coin":0,"change":0,"progress":{"now":0,"max":5000}}},"addFollow":0},"remain":1}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * silver : 2696
         * gold : 0
         * data : {"giftName":"辣条","num":1,"uname":"czp3009","rcost":31134,"uid":20293030,"top_list":[{"uid":20293030,"uname":"czp3009","coin":25100,"face":"http://i0.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","guard_level":0,"rank":1,"score":25100},{"uid":19946822,"uname":"罗非鱼追上来了","coin":8000,"face":"http://i2.hdslb.com/bfs/face/e71031a931125617fad2c148213381bb6e0e9f26.jpg","guard_level":0,"rank":2,"score":8000},{"uid":8353249,"uname":"TcCoke","coin":3500,"face":"http://i2.hdslb.com/bfs/face/7c3c131f89380db0046024d1a903d3a6e4dc6128.jpg","guard_level":0,"rank":3,"score":3500}],"timestamp":1509972225,"giftId":1,"giftType":0,"action":"喂食","super":0,"price":100,"rnd":"1430788195","newMedal":0,"newTitle":0,"medal":[],"title":"","beatId":0,"biz_source":"live","metadata":"","remain":1,"gold":0,"silver":0,"eventScore":0,"eventNum":0,"smalltv_msg":[],"specialGift":null,"notice_msg":[],"capsule":{"normal":{"coin":10,"change":0,"progress":{"now":2900,"max":10000}},"colorful":{"coin":0,"change":0,"progress":{"now":0,"max":5000}}},"addFollow":0}
         * remain : 1
         */

        @SerializedName("silver")
        private String silver;
        @SerializedName("gold")
        private String gold;
        @SerializedName("data")
        private DataX dataX;
        @SerializedName("remain")
        private int remain;

        public String getSilver() {
            return silver;
        }

        public void setSilver(String silver) {
            this.silver = silver;
        }

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public DataX getDataX() {
            return dataX;
        }

        public void setDataX(DataX dataX) {
            this.dataX = dataX;
        }

        public int getRemain() {
            return remain;
        }

        public void setRemain(int remain) {
            this.remain = remain;
        }

        public static class DataX {
            /**
             * giftName : 辣条
             * num : 1
             * uname : czp3009
             * rcost : 31134
             * uid : 20293030
             * top_list : [{"uid":20293030,"uname":"czp3009","coin":25100,"face":"http://i0.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","guard_level":0,"rank":1,"score":25100},{"uid":19946822,"uname":"罗非鱼追上来了","coin":8000,"face":"http://i2.hdslb.com/bfs/face/e71031a931125617fad2c148213381bb6e0e9f26.jpg","guard_level":0,"rank":2,"score":8000},{"uid":8353249,"uname":"TcCoke","coin":3500,"face":"http://i2.hdslb.com/bfs/face/7c3c131f89380db0046024d1a903d3a6e4dc6128.jpg","guard_level":0,"rank":3,"score":3500}]
             * timestamp : 1509972225
             * giftId : 1
             * giftType : 0
             * action : 喂食
             * super : 0
             * price : 100
             * rnd : 1430788195
             * newMedal : 0
             * newTitle : 0
             * medal : []
             * title :
             * beatId : 0
             * biz_source : live
             * metadata :
             * remain : 1
             * gold : 0
             * silver : 0
             * eventScore : 0
             * eventNum : 0
             * smalltv_msg : []
             * specialGift : null
             * notice_msg : []
             * capsule : {"normal":{"coin":10,"change":0,"progress":{"now":2900,"max":10000}},"colorful":{"coin":0,"change":0,"progress":{"now":0,"max":5000}}}
             * addFollow : 0
             */

            @SerializedName("giftName")
            private String giftName;
            @SerializedName("num")
            private int num;
            @SerializedName("uname")
            private String username;
            @SerializedName("rcost")
            private int roomCost;
            @SerializedName("uid")
            private int uid;
            @SerializedName("timestamp")
            private long timestamp;
            @SerializedName("giftId")
            private int giftId;
            @SerializedName("giftType")
            private int giftType;
            @SerializedName("action")
            private String action;
            @SerializedName("super")
            private int superX;
            @SerializedName("price")
            private int price;
            @SerializedName("rnd")
            private String rnd;
            @SerializedName("newMedal")
            private int newMedal;
            @SerializedName("newTitle")
            private int newTitle;
            @SerializedName("title")
            private String title;
            @SerializedName("beatId")
            private int beatId;
            @SerializedName("biz_source")
            private String bizSource;
            @SerializedName("metadata")
            private String metadata;
            @SerializedName("remain")
            private int remain;
            @SerializedName("gold")
            private int gold;
            @SerializedName("silver")
            private int silver;
            @SerializedName("eventScore")
            private int eventScore;
            @SerializedName("eventNum")
            private int eventNum;
            @SerializedName("specialGift")
            private JsonElement specialGift;
            @SerializedName("capsule")
            private Capsule capsule;
            @SerializedName("addFollow")
            private int addFollow;
            @SerializedName("top_list")
            private List<TopListData> topList;
            /**
             * medal 可能是空的 JsonArray, 也可能是一个 JsonObject
             */
            @SerializedName("medal")
            private JsonElement medal;
            @SerializedName("smalltv_msg")
            private JsonElement smallTvMsg;
            @SerializedName("notice_msg")
            private JsonElement noticeMsg;

            public String getGiftName() {
                return giftName;
            }

            public void setGiftName(String giftName) {
                this.giftName = giftName;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public int getRoomCost() {
                return roomCost;
            }

            public void setRoomCost(int roomCost) {
                this.roomCost = roomCost;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(long timestamp) {
                this.timestamp = timestamp;
            }

            public int getGiftId() {
                return giftId;
            }

            public void setGiftId(int giftId) {
                this.giftId = giftId;
            }

            public int getGiftType() {
                return giftType;
            }

            public void setGiftType(int giftType) {
                this.giftType = giftType;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public int getSuperX() {
                return superX;
            }

            public void setSuperX(int superX) {
                this.superX = superX;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getRnd() {
                return rnd;
            }

            public void setRnd(String rnd) {
                this.rnd = rnd;
            }

            public int getNewMedal() {
                return newMedal;
            }

            public void setNewMedal(int newMedal) {
                this.newMedal = newMedal;
            }

            public int getNewTitle() {
                return newTitle;
            }

            public void setNewTitle(int newTitle) {
                this.newTitle = newTitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getBeatId() {
                return beatId;
            }

            public void setBeatId(int beatId) {
                this.beatId = beatId;
            }

            public String getBizSource() {
                return bizSource;
            }

            public void setBizSource(String bizSource) {
                this.bizSource = bizSource;
            }

            public String getMetadata() {
                return metadata;
            }

            public void setMetadata(String metadata) {
                this.metadata = metadata;
            }

            public int getRemain() {
                return remain;
            }

            public void setRemain(int remain) {
                this.remain = remain;
            }

            public int getGold() {
                return gold;
            }

            public void setGold(int gold) {
                this.gold = gold;
            }

            public int getSilver() {
                return silver;
            }

            public void setSilver(int silver) {
                this.silver = silver;
            }

            public int getEventScore() {
                return eventScore;
            }

            public void setEventScore(int eventScore) {
                this.eventScore = eventScore;
            }

            public int getEventNum() {
                return eventNum;
            }

            public void setEventNum(int eventNum) {
                this.eventNum = eventNum;
            }

            public JsonElement getSpecialGift() {
                return specialGift;
            }

            public void setSpecialGift(JsonObject specialGift) {
                this.specialGift = specialGift;
            }

            public Capsule getCapsule() {
                return capsule;
            }

            public void setCapsule(Capsule capsule) {
                this.capsule = capsule;
            }

            public int getAddFollow() {
                return addFollow;
            }

            public void setAddFollow(int addFollow) {
                this.addFollow = addFollow;
            }

            public List<TopListData> getTopList() {
                return topList;
            }

            public void setTopList(List<TopListData> topList) {
                this.topList = topList;
            }

            public JsonElement getMedal() {
                return medal;
            }

            public void setMedal(JsonElement medal) {
                this.medal = medal;
            }

            public JsonElement getSmallTvMsg() {
                return smallTvMsg;
            }

            public void setSmallTvMsg(JsonElement smallTvMsg) {
                this.smallTvMsg = smallTvMsg;
            }

            public JsonElement getNoticeMsg() {
                return noticeMsg;
            }

            public void setNoticeMsg(JsonElement noticeMsg) {
                this.noticeMsg = noticeMsg;
            }

            public static class Capsule {
                /**
                 * normal : {"coin":10,"change":0,"progress":{"now":2900,"max":10000}}
                 * colorful : {"coin":0,"change":0,"progress":{"now":0,"max":5000}}
                 */

                @SerializedName("normal")
                private Normal normal;
                @SerializedName("colorful")
                private Colorful colorful;

                public Normal getNormal() {
                    return normal;
                }

                public void setNormal(Normal normal) {
                    this.normal = normal;
                }

                public Colorful getColorful() {
                    return colorful;
                }

                public void setColorful(Colorful colorful) {
                    this.colorful = colorful;
                }

                public static class Normal {
                    /**
                     * coin : 10
                     * change : 0
                     * progress : {"now":2900,"max":10000}
                     */

                    @SerializedName("coin")
                    private int coin;
                    @SerializedName("change")
                    private int change;
                    @SerializedName("progress")
                    private ProgressEntity progress;

                    public int getCoin() {
                        return coin;
                    }

                    public void setCoin(int coin) {
                        this.coin = coin;
                    }

                    public int getChange() {
                        return change;
                    }

                    public void setChange(int change) {
                        this.change = change;
                    }

                    public ProgressEntity getProgress() {
                        return progress;
                    }

                    public void setProgress(ProgressEntity progress) {
                        this.progress = progress;
                    }

                    public static class ProgressEntity {
                        /**
                         * now : 2900
                         * max : 10000
                         */

                        @SerializedName("now")
                        private int now;
                        @SerializedName("max")
                        private int max;

                        public int getNow() {
                            return now;
                        }

                        public void setNow(int now) {
                            this.now = now;
                        }

                        public int getMax() {
                            return max;
                        }

                        public void setMax(int max) {
                            this.max = max;
                        }
                    }
                }

                public static class Colorful {
                    /**
                     * coin : 0
                     * change : 0
                     * progress : {"now":0,"max":5000}
                     */

                    @SerializedName("coin")
                    private int coin;
                    @SerializedName("change")
                    private int change;
                    @SerializedName("progress")
                    private ProgressX progress;

                    public int getCoin() {
                        return coin;
                    }

                    public void setCoin(int coin) {
                        this.coin = coin;
                    }

                    public int getChange() {
                        return change;
                    }

                    public void setChange(int change) {
                        this.change = change;
                    }

                    public ProgressX getProgress() {
                        return progress;
                    }

                    public void setProgress(ProgressX progress) {
                        this.progress = progress;
                    }

                    public static class ProgressX {
                        /**
                         * now : 0
                         * max : 5000
                         */

                        @SerializedName("now")
                        private int now;
                        @SerializedName("max")
                        private int max;

                        public int getNow() {
                            return now;
                        }

                        public void setNow(int now) {
                            this.now = now;
                        }

                        public int getMax() {
                            return max;
                        }

                        public void setMax(int max) {
                            this.max = max;
                        }
                    }
                }
            }

            public static class TopListData {
                /**
                 * uid : 20293030
                 * uname : czp3009
                 * coin : 25100
                 * face : http://i0.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg
                 * guard_level : 0
                 * rank : 1
                 * score : 25100
                 */

                @SerializedName("uid")
                private int uid;
                @SerializedName("uname")
                private String username;
                @SerializedName("coin")
                private int coin;
                @SerializedName("face")
                private String face;
                @SerializedName("guard_level")
                private int guardLevel;
                @SerializedName("rank")
                private int rank;
                @SerializedName("score")
                private int score;

                public int getUid() {
                    return uid;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public int getCoin() {
                    return coin;
                }

                public void setCoin(int coin) {
                    this.coin = coin;
                }

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public int getGuardLevel() {
                    return guardLevel;
                }

                public void setGuardLevel(int guardLevel) {
                    this.guardLevel = guardLevel;
                }

                public int getRank() {
                    return rank;
                }

                public void setRank(int rank) {
                    this.rank = rank;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }
            }
        }
    }
}
