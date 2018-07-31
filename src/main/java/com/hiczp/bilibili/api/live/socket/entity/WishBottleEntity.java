package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WishBottleEntity implements DataEntity {
    /**
     * cmd : WISH_BOTTLE
     * data : {"action":"update","id":1832,"wish":{"id":1832,"uid":110631,"type":1,"type_id":7,"wish_limit":99999,"wish_progress":14381,"status":1,"content":"女装直播","ctime":"2018-01-12 17:25:58","count_map":[1,3,5]}}
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
         * action : update
         * id : 1832
         * wish : {"id":1832,"uid":110631,"type":1,"type_id":7,"wish_limit":99999,"wish_progress":14381,"status":1,"content":"女装直播","ctime":"2018-01-12 17:25:58","count_map":[1,3,5]}
         */

        @SerializedName("action")
        private String action;
        @SerializedName("id")
        private long id;
        @SerializedName("wish")
        private Wish wish;

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Wish getWish() {
            return wish;
        }

        public void setWish(Wish wish) {
            this.wish = wish;
        }

        public static class Wish {
            /**
             * id : 1832
             * uid : 110631
             * type : 1
             * type_id : 7
             * wish_limit : 99999
             * wish_progress : 14381
             * status : 1
             * content : 女装直播
             * ctime : 2018-01-12 17:25:58
             * count_map : [1,3,5]
             */

            @SerializedName("id")
            private long id;
            @SerializedName("uid")
            private long userId;
            @SerializedName("type")
            private int type;
            @SerializedName("type_id")
            private int typeId;
            @SerializedName("wish_limit")
            private int wishLimit;
            @SerializedName("wish_progress")
            private int wishProgress;
            @SerializedName("status")
            private int status;
            @SerializedName("content")
            private String content;
            @SerializedName("ctime")
            private String ctime;
            @SerializedName("count_map")
            private List<Integer> countMap;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public int getWishLimit() {
                return wishLimit;
            }

            public void setWishLimit(int wishLimit) {
                this.wishLimit = wishLimit;
            }

            public int getWishProgress() {
                return wishProgress;
            }

            public void setWishProgress(int wishProgress) {
                this.wishProgress = wishProgress;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public List<Integer> getCountMap() {
                return countMap;
            }

            public void setCountMap(List<Integer> countMap) {
                this.countMap = countMap;
            }
        }
    }
}
