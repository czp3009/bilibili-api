package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class SpecialGiftEntity implements DataEntity {
    /**
     * cmd : SPECIAL_GIFT
     * data : {"39":{"id":202090,"time":90,"hadJoin":0,"num":1,"content":"月轮来袭","action":"start","storm_gif":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901"}}
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
         * 39 : {"id":202090,"time":90,"hadJoin":0,"num":1,"content":"月轮来袭","action":"start","storm_gif":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901"}
         */

        @SerializedName("39")
        private _$39 $39;

        public _$39 get$39() {
            return $39;
        }

        public void set$39(_$39 $39) {
            this.$39 = $39;
        }

        public static class _$39 {
            /**
             * id : 202090
             * time : 90
             * hadJoin : 0
             * num : 1
             * content : 月轮来袭
             * action : start
             * storm_gif : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901
             */

            @SerializedName("id")
            private long id;
            @SerializedName("time")
            private int time;
            @SerializedName("hadJoin")
            private int hadJoin;
            @SerializedName("num")
            private int num;
            @SerializedName("content")
            private String content;
            @SerializedName("action")
            private String action;
            @SerializedName("storm_gif")
            private String stormGif;

            public long getId() {
                return id;
            }

            public void setId(long id) {
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

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
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
    }
}
