package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class GetAppSmallTVRewardResponseEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : ok
     * message : ok
     * data : {"fname":"","sname":"麦麦0w0","win":0,"reward":{"id":7,"num":2,"name":"辣条","url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-1.png?20171118161652"},"status":0}
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
         * fname :
         * sname : 麦麦0w0
         * win : 0
         * reward : {"id":7,"num":2,"name":"辣条","url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-1.png?20171118161652"}
         * status : 0
         */

        @SerializedName("fname")
        private String fname;
        @SerializedName("sname")
        private String sname;
        @SerializedName("win")
        private int win;
        @SerializedName("reward")
        private Reward reward;
        @SerializedName("status")
        private int status;

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public int getWin() {
            return win;
        }

        public void setWin(int win) {
            this.win = win;
        }

        public Reward getReward() {
            return reward;
        }

        public void setReward(Reward reward) {
            this.reward = reward;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public static class Reward {
            /**
             * id : 7
             * num : 2
             * name : 辣条
             * url : http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-1.png?20171118161652
             */

            @SerializedName("id")
            private int id;
            @SerializedName("num")
            private int num;
            @SerializedName("name")
            private String name;
            @SerializedName("url")
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
