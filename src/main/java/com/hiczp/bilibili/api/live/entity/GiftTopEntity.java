package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiftTopEntity {
    /**
     * code : 0
     * message : OK
     * data : {"unlogin":0,"uname":"czp3009","rank":1,"coin":25000,"list":[{"uid":20293030,"rank":1,"isSelf":1,"score":25000,"uname":"czp3009","coin":25000,"face":"http://i0.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","guard_level":0},{"uid":19946822,"rank":2,"isSelf":0,"score":8000,"uname":"罗非鱼追上来了","coin":8000,"face":"http://i2.hdslb.com/bfs/face/e71031a931125617fad2c148213381bb6e0e9f26.jpg","guard_level":0},{"uid":8353249,"rank":3,"isSelf":0,"score":3500,"uname":"TcCoke","coin":3500,"face":"http://i2.hdslb.com/bfs/face/7c3c131f89380db0046024d1a903d3a6e4dc6128.jpg","guard_level":0},{"uid":12872641,"rank":4,"isSelf":0,"score":2000,"uname":"biggy2","coin":2000,"face":"http://i2.hdslb.com/bfs/face/418ac05726b3e6d4c35ff6bcda7a2751266126b5.jpg","guard_level":0},{"uid":33577376,"rank":5,"isSelf":0,"score":1100,"uname":"SASA协会-MF设计局","coin":1100,"face":"http://i2.hdslb.com/bfs/face/33ac7325236b34bb36a34dc58502c322c6ceaced.jpg","guard_level":0},{"uid":35225572,"rank":6,"isSelf":0,"score":100,"uname":"kk东子","coin":100,"face":"http://i0.hdslb.com/bfs/face/278f12f9993c84ef673785a48968aef78dbde92e.jpg","guard_level":0}]}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * unlogin : 0
         * uname : czp3009
         * rank : 1
         * coin : 25000
         * list : [{"uid":20293030,"rank":1,"isSelf":1,"score":25000,"uname":"czp3009","coin":25000,"face":"http://i0.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","guard_level":0},{"uid":19946822,"rank":2,"isSelf":0,"score":8000,"uname":"罗非鱼追上来了","coin":8000,"face":"http://i2.hdslb.com/bfs/face/e71031a931125617fad2c148213381bb6e0e9f26.jpg","guard_level":0},{"uid":8353249,"rank":3,"isSelf":0,"score":3500,"uname":"TcCoke","coin":3500,"face":"http://i2.hdslb.com/bfs/face/7c3c131f89380db0046024d1a903d3a6e4dc6128.jpg","guard_level":0},{"uid":12872641,"rank":4,"isSelf":0,"score":2000,"uname":"biggy2","coin":2000,"face":"http://i2.hdslb.com/bfs/face/418ac05726b3e6d4c35ff6bcda7a2751266126b5.jpg","guard_level":0},{"uid":33577376,"rank":5,"isSelf":0,"score":1100,"uname":"SASA协会-MF设计局","coin":1100,"face":"http://i2.hdslb.com/bfs/face/33ac7325236b34bb36a34dc58502c322c6ceaced.jpg","guard_level":0},{"uid":35225572,"rank":6,"isSelf":0,"score":100,"uname":"kk东子","coin":100,"face":"http://i0.hdslb.com/bfs/face/278f12f9993c84ef673785a48968aef78dbde92e.jpg","guard_level":0}]
         */

        @SerializedName("unlogin")
        private int unlogin;
        @SerializedName("uname")
        private String uname;
        @SerializedName("rank")
        private int rank;
        @SerializedName("coin")
        private int coin;
        @SerializedName("list")
        private List<ListEntity> list;

        public int getUnlogin() {
            return unlogin;
        }

        public void setUnlogin(int unlogin) {
            this.unlogin = unlogin;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class ListEntity {
            /**
             * uid : 20293030
             * rank : 1
             * isSelf : 1
             * score : 25000
             * uname : czp3009
             * coin : 25000
             * face : http://i0.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg
             * guard_level : 0
             */

            @SerializedName("uid")
            private int uid;
            @SerializedName("rank")
            private int rank;
            @SerializedName("isSelf")
            private int isSelf;
            @SerializedName("score")
            private int score;
            @SerializedName("uname")
            private String uname;
            @SerializedName("coin")
            private int coin;
            @SerializedName("face")
            private String face;
            @SerializedName("guard_level")
            private int guardLevel;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getIsSelf() {
                return isSelf;
            }

            public void setIsSelf(int isSelf) {
                this.isSelf = isSelf;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
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
        }
    }
}
