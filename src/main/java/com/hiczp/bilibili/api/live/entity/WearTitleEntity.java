package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WearTitleEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : {"id":"5940800","uid":"2866663","tid":"111","num":"1","score":"0","create_time":"2017-08-03 21:53:22","expire_time":"0000-00-00 00:00:00","status":"1","level":[0],"category":[{"name":"热门","class":"red"}],"pic":[{"id":"title-111-1","title":"2017Blink","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20180302110600","width":0,"height":0,"is_lihui":0,"lihui_img":"","lihui_width":0,"lihui_height":0}],"title_pic":{"id":"title-111-1","title":"2017Blink","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20180302110600","width":0,"height":0,"is_lihui":0,"lihui_img":"","lihui_width":0,"lihui_height":0},"name":"bilibili Link","upgrade_score":1000000}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * id : 5940800
         * uid : 2866663
         * tid : 111
         * num : 1
         * score : 0
         * create_time : 2017-08-03 21:53:22
         * expire_time : 0000-00-00 00:00:00
         * status : 1
         * level : [0]
         * category : [{"name":"热门","class":"red"}]
         * pic : [{"id":"title-111-1","title":"2017Blink","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20180302110600","width":0,"height":0,"is_lihui":0,"lihui_img":"","lihui_width":0,"lihui_height":0}]
         * title_pic : {"id":"title-111-1","title":"2017Blink","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20180302110600","width":0,"height":0,"is_lihui":0,"lihui_img":"","lihui_width":0,"lihui_height":0}
         * name : bilibili Link
         * upgrade_score : 1000000
         */

        @SerializedName("id")
        private String id;
        @SerializedName("uid")
        private String uid;
        @SerializedName("tid")
        private String tid;
        @SerializedName("num")
        private String num;
        @SerializedName("score")
        private String score;
        @SerializedName("create_time")
        private String createTime;
        @SerializedName("expire_time")
        private String expireTime;
        @SerializedName("status")
        private String status;
        @SerializedName("title_pic")
        private TitlePic titlePic;
        @SerializedName("name")
        private String name;
        @SerializedName("upgrade_score")
        private int upgradeScore;
        @SerializedName("level")
        private List<Integer> level;
        @SerializedName("category")
        private List<Category> category;
        @SerializedName("pic")
        private List<Pic> pic;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public TitlePic getTitlePic() {
            return titlePic;
        }

        public void setTitlePic(TitlePic titlePic) {
            this.titlePic = titlePic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUpgradeScore() {
            return upgradeScore;
        }

        public void setUpgradeScore(int upgradeScore) {
            this.upgradeScore = upgradeScore;
        }

        public List<Integer> getLevel() {
            return level;
        }

        public void setLevel(List<Integer> level) {
            this.level = level;
        }

        public List<Category> getCategory() {
            return category;
        }

        public void setCategory(List<Category> category) {
            this.category = category;
        }

        public List<Pic> getPic() {
            return pic;
        }

        public void setPic(List<Pic> pic) {
            this.pic = pic;
        }

        public static class TitlePic {
            /**
             * id : title-111-1
             * title : 2017Blink
             * img : https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20180302110600
             * width : 0
             * height : 0
             * is_lihui : 0
             * lihui_img :
             * lihui_width : 0
             * lihui_height : 0
             */

            @SerializedName("id")
            private String id;
            @SerializedName("title")
            private String title;
            @SerializedName("img")
            private String img;
            @SerializedName("width")
            private int width;
            @SerializedName("height")
            private int height;
            @SerializedName("is_lihui")
            private int isLihui;
            @SerializedName("lihui_img")
            private String lihuiImg;
            @SerializedName("lihui_width")
            private int lihuiWidth;
            @SerializedName("lihui_height")
            private int lihuiHeight;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
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

            public int getIsLihui() {
                return isLihui;
            }

            public void setIsLihui(int isLihui) {
                this.isLihui = isLihui;
            }

            public String getLihuiImg() {
                return lihuiImg;
            }

            public void setLihuiImg(String lihuiImg) {
                this.lihuiImg = lihuiImg;
            }

            public int getLihuiWidth() {
                return lihuiWidth;
            }

            public void setLihuiWidth(int lihuiWidth) {
                this.lihuiWidth = lihuiWidth;
            }

            public int getLihuiHeight() {
                return lihuiHeight;
            }

            public void setLihuiHeight(int lihuiHeight) {
                this.lihuiHeight = lihuiHeight;
            }
        }

        public static class Category {
            /**
             * name : 热门
             * class : red
             */

            @SerializedName("name")
            private String name;
            @SerializedName("class")
            private String classX;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getClassX() {
                return classX;
            }

            public void setClassX(String classX) {
                this.classX = classX;
            }
        }

        public static class Pic {
            /**
             * id : title-111-1
             * title : 2017Blink
             * img : https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20180302110600
             * width : 0
             * height : 0
             * is_lihui : 0
             * lihui_img :
             * lihui_width : 0
             * lihui_height : 0
             */

            @SerializedName("id")
            private String id;
            @SerializedName("title")
            private String title;
            @SerializedName("img")
            private String img;
            @SerializedName("width")
            private int width;
            @SerializedName("height")
            private int height;
            @SerializedName("is_lihui")
            private int isLihui;
            @SerializedName("lihui_img")
            private String lihuiImg;
            @SerializedName("lihui_width")
            private int lihuiWidth;
            @SerializedName("lihui_height")
            private int lihuiHeight;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
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

            public int getIsLihui() {
                return isLihui;
            }

            public void setIsLihui(int isLihui) {
                this.isLihui = isLihui;
            }

            public String getLihuiImg() {
                return lihuiImg;
            }

            public void setLihuiImg(String lihuiImg) {
                this.lihuiImg = lihuiImg;
            }

            public int getLihuiWidth() {
                return lihuiWidth;
            }

            public void setLihuiWidth(int lihuiWidth) {
                this.lihuiWidth = lihuiWidth;
            }

            public int getLihuiHeight() {
                return lihuiHeight;
            }

            public void setLihuiHeight(int lihuiHeight) {
                this.lihuiHeight = lihuiHeight;
            }
        }
    }
}
