package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendGiftEntity implements DataEntity {
    /**
     * cmd : SEND_GIFT
     * data : {"giftName":"节奏风暴","num":1,"uname":"爱上熹","rcost":569788,"uid":230845505,"top_list":[{"uid":288348879,"uname":"我爱我家一生","face":"http://i1.hdslb.com/bfs/face/dd52e4f2dfe881751816e45522f504f10458b514.jpg","rank":1,"score":1852300,"guard_level":0,"isSelf":0},{"uid":287551243,"uname":"熹上城的专属天使菲","face":"http://i1.hdslb.com/bfs/face/c3ef04ba6c267c41067cd7708b7abd60c0c5c49f.jpg","rank":2,"score":1245200,"guard_level":3,"isSelf":0},{"uid":32416351,"uname":"镜子。。","face":"http://i1.hdslb.com/bfs/face/08c54c2c97434811a99e9d070d621ccbb5d3f2c4.jpg","rank":3,"score":332862,"guard_level":3,"isSelf":0}],"timestamp":1520992553,"giftId":39,"giftType":0,"action":"赠送","super":1,"price":100000,"rnd":"1980508331","newMedal":0,"newTitle":0,"medal":{"medalId":"95723","medalName":"布丁诶","level":1},"title":"","beatId":"4","biz_source":"live","metadata":"","remain":0,"gold":88570,"silver":127492,"eventScore":0,"eventNum":0,"smalltv_msg":[],"specialGift":{"id":207945,"time":90,"hadJoin":0,"num":1,"content":"你们城里人真会玩","action":"start","storm_gif":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901"},"notice_msg":[],"capsule":{"normal":{"coin":166,"change":10,"progress":{"now":3630,"max":10000}},"colorful":{"coin":2,"change":0,"progress":{"now":0,"max":5000}}},"addFollow":0,"effect_block":0,"coin_type":"gold","total_coin":100000}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

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
         * giftName : 节奏风暴
         * num : 1
         * uname : 爱上熹
         * rcost : 569788
         * uid : 230845505
         * top_list : [{"uid":288348879,"uname":"我爱我家一生","face":"http://i1.hdslb.com/bfs/face/dd52e4f2dfe881751816e45522f504f10458b514.jpg","rank":1,"score":1852300,"guard_level":0,"isSelf":0},{"uid":287551243,"uname":"熹上城的专属天使菲","face":"http://i1.hdslb.com/bfs/face/c3ef04ba6c267c41067cd7708b7abd60c0c5c49f.jpg","rank":2,"score":1245200,"guard_level":3,"isSelf":0},{"uid":32416351,"uname":"镜子。。","face":"http://i1.hdslb.com/bfs/face/08c54c2c97434811a99e9d070d621ccbb5d3f2c4.jpg","rank":3,"score":332862,"guard_level":3,"isSelf":0}]
         * timestamp : 1520992553
         * giftId : 39
         * giftType : 0
         * action : 赠送
         * super : 1
         * super_gift_num : 1
         * price : 100000
         * rnd : 1980508331
         * newMedal : 0
         * newTitle : 0
         * medal : {"medalId":"95723","medalName":"布丁诶","level":1}
         * title :
         * beatId : 4
         * biz_source : live
         * metadata :
         * remain : 0
         * gold : 88570
         * silver : 127492
         * eventScore : 0
         * eventNum : 0
         * smalltv_msg : []
         * specialGift : {"id":"316221038798","time":90,"hadJoin":0,"num":1,"content":"你们城里人真会玩","action":"start","storm_gif":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901"}
         * notice_msg : []
         * capsule : {"normal":{"coin":166,"change":10,"progress":{"now":3630,"max":10000}},"colorful":{"coin":2,"change":0,"progress":{"now":0,"max":5000}},"move": 1}
         * addFollow : 0
         * effect_block : 0
         * coin_type : gold
         * total_coin : 100000
         */

        @SerializedName("giftName")
        private String giftName;
        @SerializedName("num")
        private int number;
        @SerializedName("uname")
        private String username;
        @SerializedName("rcost")
        private int roomCost;
        @SerializedName("uid")
        private long userId;
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
        @SerializedName("super_gift_num")
        private int superGiftNumber;
        @SerializedName("price")
        private int price;
        @SerializedName("rnd")
        private String rnd;
        @SerializedName("newMedal")
        private int newMedal;
        @SerializedName("newTitle")
        private int newTitle;
        /**
         * medal 字段可能是一个空的 JsonArray, 也可能是 JsonObject
         * 为 JsonObject 时, 内部字段如下
         * {
         * "medalId": "95723",
         * "medalName": "布丁诶",
         * "level": 1
         * }
         */
        @SerializedName("medal")
        private JsonElement medal;
        @SerializedName("title")
        private String title;
        @SerializedName("beatId")
        private String beatId;
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
        private SpecialGift specialGift;
        @SerializedName("capsule")
        private Capsule capsule;
        @SerializedName("addFollow")
        private int addFollow;
        @SerializedName("effect_block")
        private int effectBlock;
        @SerializedName("coin_type")
        private String coinType;
        @SerializedName("total_coin")
        private int totalCoin;
        @SerializedName("top_list")
        private List<TopList> topList;
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

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
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

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
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

        public int getSuperGiftNumber() {
            return superGiftNumber;
        }

        public void setSuperGiftNumber(int superGiftNumber) {
            this.superGiftNumber = superGiftNumber;
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

        public JsonElement getMedal() {
            return medal;
        }

        public void setMedal(JsonElement medal) {
            this.medal = medal;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBeatId() {
            return beatId;
        }

        public void setBeatId(String beatId) {
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

        public SpecialGift getSpecialGift() {
            return specialGift;
        }

        public void setSpecialGift(SpecialGift specialGift) {
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

        public int getEffectBlock() {
            return effectBlock;
        }

        public void setEffectBlock(int effectBlock) {
            this.effectBlock = effectBlock;
        }

        public String getCoinType() {
            return coinType;
        }

        public void setCoinType(String coinType) {
            this.coinType = coinType;
        }

        public int getTotalCoin() {
            return totalCoin;
        }

        public void setTotalCoin(int totalCoin) {
            this.totalCoin = totalCoin;
        }

        public List<TopList> getTopList() {
            return topList;
        }

        public void setTopList(List<TopList> topList) {
            this.topList = topList;
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

        public static class Medal {
            /**
             * medalId : 95723
             * medalName : 布丁诶
             * level : 1
             */

            @SerializedName("medalId")
            private String medalId;
            @SerializedName("medalName")
            private String medalName;
            @SerializedName("level")
            private int level;

            public String getMedalId() {
                return medalId;
            }

            public void setMedalId(String medalId) {
                this.medalId = medalId;
            }

            public String getMedalName() {
                return medalName;
            }

            public void setMedalName(String medalName) {
                this.medalName = medalName;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }
        }

        public static class SpecialGift {
            /**
             * id : 316221038798
             * time : 90
             * hadJoin : 0
             * num : 1
             * content : 你们城里人真会玩
             * action : start
             * storm_gif : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901
             */

            @SerializedName("id")
            private String id;
            @SerializedName("time")
            private int time;
            @SerializedName("hadJoin")
            private int hadJoin;
            @SerializedName("num")
            private int number;
            @SerializedName("content")
            private String content;
            @SerializedName("action")
            private String action;
            @SerializedName("storm_gif")
            private String stormGif;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getHadJoin() {
                return hadJoin;
            }

            public void setHadJoin(int hadJoin) {
                this.hadJoin = hadJoin;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public String getStormGif() {
                return stormGif;
            }

            public void setStormGif(String stormGif) {
                this.stormGif = stormGif;
            }
        }

        public static class Capsule {
            /**
             * normal : {"coin":166,"change":10,"progress":{"now":3630,"max":10000}}
             * colorful : {"coin":2,"change":0,"progress":{"now":0,"max":5000}}
             * move : 1
             */

            @SerializedName("normal")
            private Normal normal;
            @SerializedName("colorful")
            private Colorful colorful;
            @SerializedName("move")
            private int move;

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

            public int getMove() {
                return move;
            }

            public void setMove(int move) {
                this.move = move;
            }

            public static class Normal {
                /**
                 * coin : 166
                 * change : 10
                 * progress : {"now":3630,"max":10000}
                 */

                @SerializedName("coin")
                private int coin;
                @SerializedName("change")
                private int change;
                @SerializedName("progress")
                private Progress progress;

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

                public Progress getProgress() {
                    return progress;
                }

                public void setProgress(Progress progress) {
                    this.progress = progress;
                }

                public static class Progress {
                    /**
                     * now : 3630
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
                 * coin : 2
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

        public static class TopList {
            /**
             * uid : 288348879
             * uname : 我爱我家一生
             * face : http://i1.hdslb.com/bfs/face/dd52e4f2dfe881751816e45522f504f10458b514.jpg
             * rank : 1
             * score : 1852300
             * guard_level : 0
             * isSelf : 0
             */

            @SerializedName("uid")
            private long userId;
            @SerializedName("uname")
            private String username;
            @SerializedName("face")
            private String face;
            @SerializedName("rank")
            private int rank;
            @SerializedName("score")
            private int score;
            @SerializedName("guard_level")
            private int guardLevel;
            @SerializedName("isSelf")
            private int isSelf;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

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

            public int getGuardLevel() {
                return guardLevel;
            }

            public void setGuardLevel(int guardLevel) {
                this.guardLevel = guardLevel;
            }

            public int getIsSelf() {
                return isSelf;
            }

            public void setIsSelf(int isSelf) {
                this.isSelf = isSelf;
            }
        }
    }
}
