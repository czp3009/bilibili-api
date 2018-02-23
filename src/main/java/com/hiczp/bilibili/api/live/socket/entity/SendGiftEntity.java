package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendGiftEntity implements DataEntity {
    /**
     * cmd : SEND_GIFT
     * data : {"giftName":"辣条","num":64,"uname":"明暗纠结星","rcost":66347035,"uid":12768615,"top_list":[{"uid":9256,"userName":"SSR丶尧","coin":2905900,"face":"http://i0.hdslb.com/bfs/face/eba52abb1daaf3aecd7b986b9731451872d66613.jpg","guard_level":"3","rank":1,"score":2905900},{"uid":4986301,"userName":"乄夏沫丶","coin":1386000,"face":"http://i2.hdslb.com/bfs/face/b3969027a263d2610711317addf437fe59a9b97e.jpg","guard_level":0,"rank":2,"score":1386000},{"uid":5211302,"userName":"朝雾怜","coin":805700,"face":"http://i1.hdslb.com/bfs/face/d366be69d716469514d355642aa324ceba3fa122.jpg","guard_level":0,"rank":3,"score":805700}],"timestamp":1510498496,"giftId":1,"giftType":0,"action":"喂食","super":0,"price":100,"rnd":"1510498460","newMedal":0,"newTitle":0,"medal":[],"title":"","beatId":"0","biz_source":"live","metadata":"","remain":0,"gold":0,"silver":0,"eventScore":0,"eventNum":0,"smalltv_msg":[],"notice_msg":[],"capsule":{"normal":{"coin":13,"change":1,"progress":{"now":4000,"max":10000}},"colorful":{"coin":0,"change":0,"progress":{"now":0,"max":5000}}},"addFollow":0}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private DataEntity data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * giftName : 辣条
         * num : 64
         * uname : 明暗纠结星
         * rcost : 66347035
         * uid : 12768615
         * top_list : [{"uid":9256,"uname":"SSR丶尧","coin":2905900,"face":"http://i0.hdslb.com/bfs/face/eba52abb1daaf3aecd7b986b9731451872d66613.jpg","guard_level":"3","rank":1,"score":2905900},{"uid":4986301,"userName":"乄夏沫丶","coin":1386000,"face":"http://i2.hdslb.com/bfs/face/b3969027a263d2610711317addf437fe59a9b97e.jpg","guard_level":0,"rank":2,"score":1386000},{"uid":5211302,"userName":"朝雾怜","coin":805700,"face":"http://i1.hdslb.com/bfs/face/d366be69d716469514d355642aa324ceba3fa122.jpg","guard_level":0,"rank":3,"score":805700}]
         * timestamp : 1510498496
         * giftId : 1
         * giftType : 0
         * action : 喂食
         * super : 0
         * price : 100
         * rnd : 1510498460
         * newMedal : 0
         * newTitle : 0
         * medal : []
         * title :
         * beatId : 0
         * biz_source : live
         * metadata :
         * remain : 0
         * gold : 0
         * silver : 0
         * eventScore : 0
         * eventNum : 0
         * smalltv_msg : []
         * notice_msg : []
         * capsule : {"normal":{"coin":13,"change":1,"progress":{"now":4000,"max":10000}},"colorful":{"coin":0,"change":0,"progress":{"now":0,"max":5000}}}
         * addFollow : 0
         */

        @SerializedName("giftName")
        private String giftName;
        @SerializedName("num")
        private int num;
        @SerializedName("uname")
        private String userName;
        @SerializedName("rcost")
        private int rCost;
        @SerializedName("uid")
        private long uid;
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
        @SerializedName("capsule")
        private CapsuleEntity capsule;
        @SerializedName("addFollow")
        private int addFollow;
        @SerializedName("top_list")
        private List<TopListEntity> topList;
        @SerializedName("medal")
        private JsonElement medal;
        @SerializedName("smalltv_msg")
        private JsonElement smallTVMsg;
        @SerializedName("notice_msg")
        private List<?> noticeMsg;

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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getrCost() {
            return rCost;
        }

        public void setrCost(int rCost) {
            this.rCost = rCost;
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
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

        public CapsuleEntity getCapsule() {
            return capsule;
        }

        public void setCapsule(CapsuleEntity capsule) {
            this.capsule = capsule;
        }

        public int getAddFollow() {
            return addFollow;
        }

        public void setAddFollow(int addFollow) {
            this.addFollow = addFollow;
        }

        public List<TopListEntity> getTopList() {
            return topList;
        }

        public void setTopList(List<TopListEntity> topList) {
            this.topList = topList;
        }

        public JsonElement getMedal() {
            return medal;
        }

        public void setMedal(JsonElement medal) {
            this.medal = medal;
        }

        public JsonElement getSmallTVMsg() {
            return smallTVMsg;
        }

        public void setSmallTVMsg(JsonObject smallTVMsg) {
            this.smallTVMsg = smallTVMsg;
        }

        public List<?> getNoticeMsg() {
            return noticeMsg;
        }

        public void setNoticeMsg(List<?> noticeMsg) {
            this.noticeMsg = noticeMsg;
        }

        public static class CapsuleEntity {
            /**
             * normal : {"coin":13,"change":1,"progress":{"now":4000,"max":10000}}
             * colorful : {"coin":0,"change":0,"progress":{"now":0,"max":5000}}
             */

            @SerializedName("normal")
            private NormalEntity normal;
            @SerializedName("colorful")
            private ColorfulEntity colorful;

            public NormalEntity getNormal() {
                return normal;
            }

            public void setNormal(NormalEntity normal) {
                this.normal = normal;
            }

            public ColorfulEntity getColorful() {
                return colorful;
            }

            public void setColorful(ColorfulEntity colorful) {
                this.colorful = colorful;
            }

            public static class NormalEntity {
                /**
                 * coin : 13
                 * change : 1
                 * progress : {"now":4000,"max":10000}
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
                     * now : 4000
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

            public static class ColorfulEntity {
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
                private ProgressEntityX progress;

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

                public ProgressEntityX getProgress() {
                    return progress;
                }

                public void setProgress(ProgressEntityX progress) {
                    this.progress = progress;
                }

                public static class ProgressEntityX {
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

        public static class TopListEntity {
            /**
             * uid : 9256
             * uname : SSR丶尧
             * coin : 2905900
             * face : http://i0.hdslb.com/bfs/face/eba52abb1daaf3aecd7b986b9731451872d66613.jpg
             * guard_level : 3
             * rank : 1
             * score : 2905900
             */

            @SerializedName("uid")
            private int uid;
            @SerializedName("uname")
            private String userName;
            @SerializedName("coin")
            private int coin;
            @SerializedName("face")
            private String face;
            @SerializedName("guard_level")
            private String guardLevel;
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

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
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

            public String getGuardLevel() {
                return guardLevel;
            }

            public void setGuardLevel(String guardLevel) {
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
