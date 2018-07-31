package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenCapsuleResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : {"status":1,"text":[{"name":"辣条","num":"1","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/open/normal/1.png?20171116172700"}],"isEntity":0,"coin":43,"progress":{"now":7000,"max":10000}}
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
         * status : 1
         * text : [{"name":"辣条","num":"1","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/open/normal/1.png?20171116172700"}]
         * isEntity : 0
         * coin : 43
         * progress : {"now":7000,"max":10000}
         */

        @SerializedName("status")
        private int status;
        @SerializedName("isEntity")
        private int isEntity;
        @SerializedName("coin")
        private int coin;
        @SerializedName("progress")
        private Progress progress;
        @SerializedName("text")
        private List<Gift> gifts;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getIsEntity() {
            return isEntity;
        }

        public void setIsEntity(int isEntity) {
            this.isEntity = isEntity;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public Progress getProgress() {
            return progress;
        }

        public void setProgress(Progress progress) {
            this.progress = progress;
        }

        public List<Gift> getGifts() {
            return gifts;
        }

        public void setGifts(List<Gift> gifts) {
            this.gifts = gifts;
        }

        public static class Progress {
            /**
             * now : 7000
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

        public static class Gift {
            /**
             * name : 辣条
             * num : 1
             * img : https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/open/normal/1.png?20171116172700
             */

            @SerializedName("name")
            private String name;
            @SerializedName("num")
            private String number;
            @SerializedName("img")
            private String img;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
