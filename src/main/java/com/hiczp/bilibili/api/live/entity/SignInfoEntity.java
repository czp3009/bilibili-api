package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SignInfoEntity {
    /**
     * code : 0
     * message : OK
     * data : {"sign_msg":"今天签到已获得<br />&nbsp;辣条<font color='#fea024'>2个<\/font>&nbsp;经验<font color='#fea024'>3000<\/font>&nbsp;","maxday_num":30,"sign_day":4,"days_award":[{"id":1,"award":"silver","count":666,"text":"666银瓜子","day":5,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/5_1.png?20171102172700","width":56,"height":68}},{"id":2,"award":"vip","count":3,"text":"3天月费老爷","day":10,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/10_1.png?20171102172700","width":56,"height":68}},{"id":3,"award":"gift","count":4,"text":"1份喵娘","day":20,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/20_1.png?20171102172700","width":56,"height":68}},{"id":4,"award":"title","count":1,"text":"月老头衔","day":30,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/30_1.png?20171102172700","width":56,"height":68}}]}
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
         * sign_msg : 今天签到已获得<br />&nbsp;辣条<font color='#fea024'>2个</font>&nbsp;经验<font color='#fea024'>3000</font>&nbsp;
         * maxday_num : 30
         * sign_day : 4
         * days_award : [{"id":1,"award":"silver","count":666,"text":"666银瓜子","day":5,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/5_1.png?20171102172700","width":56,"height":68}},{"id":2,"award":"vip","count":3,"text":"3天月费老爷","day":10,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/10_1.png?20171102172700","width":56,"height":68}},{"id":3,"award":"gift","count":4,"text":"1份喵娘","day":20,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/20_1.png?20171102172700","width":56,"height":68}},{"id":4,"award":"title","count":1,"text":"月老头衔","day":30,"img":{"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/30_1.png?20171102172700","width":56,"height":68}}]
         */

        @SerializedName("sign_msg")
        private String signMsg;
        @SerializedName("maxday_num")
        private int maxdayNum;
        @SerializedName("sign_day")
        private int signDay;
        @SerializedName("days_award")
        private List<DaysAwardEntity> daysAward;

        public String getSignMsg() {
            return signMsg;
        }

        public void setSignMsg(String signMsg) {
            this.signMsg = signMsg;
        }

        public int getMaxdayNum() {
            return maxdayNum;
        }

        public void setMaxdayNum(int maxdayNum) {
            this.maxdayNum = maxdayNum;
        }

        public int getSignDay() {
            return signDay;
        }

        public void setSignDay(int signDay) {
            this.signDay = signDay;
        }

        public List<DaysAwardEntity> getDaysAward() {
            return daysAward;
        }

        public void setDaysAward(List<DaysAwardEntity> daysAward) {
            this.daysAward = daysAward;
        }

        public static class DaysAwardEntity {
            /**
             * id : 1
             * award : silver
             * count : 666
             * text : 666银瓜子
             * day : 5
             * img : {"src":"http://static.hdslb.com/live-static/live-app/dayaward/1/5_1.png?20171102172700","width":56,"height":68}
             */

            @SerializedName("id")
            private int id;
            @SerializedName("award")
            private String award;
            @SerializedName("count")
            private int count;
            @SerializedName("text")
            private String text;
            @SerializedName("day")
            private int day;
            @SerializedName("img")
            private ImgEntity img;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAward() {
                return award;
            }

            public void setAward(String award) {
                this.award = award;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public ImgEntity getImg() {
                return img;
            }

            public void setImg(ImgEntity img) {
                this.img = img;
            }

            public static class ImgEntity {
                /**
                 * src : http://static.hdslb.com/live-static/live-app/dayaward/1/5_1.png?20171102172700
                 * width : 56
                 * height : 68
                 */

                @SerializedName("src")
                private String src;
                @SerializedName("width")
                private int width;
                @SerializedName("height")
                private int height;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }
        }
    }
}
