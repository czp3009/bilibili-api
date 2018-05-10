package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CapsuleInfoEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : {"normal":{"status":1,"coin":65,"change":5,"progress":{"now":1800,"max":10000},"rule":"使用价值累计达到10000瓜子的礼物（包含直接使用瓜子购买、道具包裹，但不包括产生梦幻扭蛋币的活动道具），可以获得1枚扭蛋币。使用扭蛋币可以参与抽奖。","gift":[{"id":22,"name":"经验曜石","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/22.png?20171116172700"},{"id":21,"name":"经验原石","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/21.png?20171116172700"},{"id":30,"name":"爱心便当","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/30.png?20171116172700"},{"id":0,"name":"小号小电视","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/b.png?20171116172700"},{"id":4,"name":"蓝白胖次","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/4.png?20171116172700"},{"id":3,"name":"B坷垃","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/3.png?20171116172700"},{"id":2,"name":"亿圆","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/2.png?20171116172700"},{"id":1,"name":"辣条","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/1.png?20171116172700"}],"list":[{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验曜石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"五河墨子"},{"num":"1","gift":"经验曜石","date":"2018-03-02","name":"五河墨子"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"吃包子的560"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"莯兮吖"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"莯兮吖"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"黎梦的莫语小迷妹"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"ltg86692169"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"亦真亦幻似梦似醒"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"ATICN"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"黎离溱洧"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"龘卛逼"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"FENGHETAO"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"殇璃奏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"= -"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"楠瓜精"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"楠瓜精"}]},"colorful":{"status":0}}
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
         * normal : {"status":1,"coin":65,"change":5,"progress":{"now":1800,"max":10000},"rule":"使用价值累计达到10000瓜子的礼物（包含直接使用瓜子购买、道具包裹，但不包括产生梦幻扭蛋币的活动道具），可以获得1枚扭蛋币。使用扭蛋币可以参与抽奖。","gift":[{"id":22,"name":"经验曜石","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/22.png?20171116172700"},{"id":21,"name":"经验原石","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/21.png?20171116172700"},{"id":30,"name":"爱心便当","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/30.png?20171116172700"},{"id":0,"name":"小号小电视","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/b.png?20171116172700"},{"id":4,"name":"蓝白胖次","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/4.png?20171116172700"},{"id":3,"name":"B坷垃","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/3.png?20171116172700"},{"id":2,"name":"亿圆","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/2.png?20171116172700"},{"id":1,"name":"辣条","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/1.png?20171116172700"}],"list":[{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验曜石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"五河墨子"},{"num":"1","gift":"经验曜石","date":"2018-03-02","name":"五河墨子"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"吃包子的560"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"莯兮吖"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"莯兮吖"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"黎梦的莫语小迷妹"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"ltg86692169"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"亦真亦幻似梦似醒"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"ATICN"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"黎离溱洧"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"龘卛逼"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"FENGHETAO"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"殇璃奏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"= -"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"楠瓜精"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"楠瓜精"}]}
         * colorful : {"status":0}
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
             * status : 1
             * coin : 65
             * change : 5
             * progress : {"now":1800,"max":10000}
             * rule : 使用价值累计达到10000瓜子的礼物（包含直接使用瓜子购买、道具包裹，但不包括产生梦幻扭蛋币的活动道具），可以获得1枚扭蛋币。使用扭蛋币可以参与抽奖。
             * gift : [{"id":22,"name":"经验曜石","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/22.png?20171116172700"},{"id":21,"name":"经验原石","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/21.png?20171116172700"},{"id":30,"name":"爱心便当","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/30.png?20171116172700"},{"id":0,"name":"小号小电视","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/b.png?20171116172700"},{"id":4,"name":"蓝白胖次","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/4.png?20171116172700"},{"id":3,"name":"B坷垃","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/3.png?20171116172700"},{"id":2,"name":"亿圆","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/2.png?20171116172700"},{"id":1,"name":"辣条","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/1.png?20171116172700"}]
             * list : [{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验曜石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"我去取经"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"五河墨子"},{"num":"1","gift":"经验曜石","date":"2018-03-02","name":"五河墨子"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"吃包子的560"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"莯兮吖"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"莯兮吖"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"NShy小马"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"黎梦的莫语小迷妹"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"薄荷and紫苏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"ltg86692169"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"亦真亦幻似梦似醒"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"ATICN"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"黎离溱洧"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"龘卛逼"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"FENGHETAO"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"殇璃奏"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"= -"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"楠瓜精"},{"num":"1","gift":"经验原石","date":"2018-03-02","name":"楠瓜精"}]
             */

            @SerializedName("status")
            private int status;
            @SerializedName("coin")
            private long coin;
            @SerializedName("change")
            private int change;
            @SerializedName("progress")
            private Progress progress;
            @SerializedName("rule")
            private String rule;
            @SerializedName("gift")
            private List<Gift> gift;
            @SerializedName("list")
            private List<Winner> winners;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public long getCoin() {
                return coin;
            }

            public void setCoin(long coin) {
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

            public String getRule() {
                return rule;
            }

            public void setRule(String rule) {
                this.rule = rule;
            }

            public List<Gift> getGift() {
                return gift;
            }

            public void setGift(List<Gift> gift) {
                this.gift = gift;
            }

            public List<Winner> getWinners() {
                return winners;
            }

            public void setWinners(List<Winner> winners) {
                this.winners = winners;
            }

            public static class Progress {
                /**
                 * now : 1800
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
                 * id : 22
                 * name : 经验曜石
                 * img : https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/capsule-toy/normal/22.png?20171116172700
                 */

                @SerializedName("id")
                private int id;
                @SerializedName("name")
                private String name;
                @SerializedName("img")
                private String img;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }

            public static class Winner {
                /**
                 * num : 1
                 * gift : 经验原石
                 * date : 2018-03-02
                 * name : NShy小马
                 */

                @SerializedName("num")
                private String num;
                @SerializedName("gift")
                private String gift;
                @SerializedName("date")
                private String date;
                @SerializedName("name")
                private String name;

                public String getNum() {
                    return num;
                }

                public void setNum(String num) {
                    this.num = num;
                }

                public String getGift() {
                    return gift;
                }

                public void setGift(String gift) {
                    this.gift = gift;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class Colorful {
            /**
             * status : 0
             */

            @SerializedName("status")
            private int status;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
