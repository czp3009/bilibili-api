package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyTitleListEntity extends ResponseEntity {
    /**
     * code : 0
     * message : 获取成功
     * data : {"list":[{"uid":2866663,"had":true,"title":"title-111-1","status":0,"activity":"2017Blink","score":0,"level":[],"category":[{"name":"热门","class":"red"}],"title_pic":{"id":"title-111-1","title":"2017Blink","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20171116172700","width":0,"height":0,"is_lihui":0,"lihui_img":"","lihui_width":0,"lihui_height":0}}]}
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
        @SerializedName("list")
        private List<Title> list;

        public List<Title> getList() {
            return list;
        }

        public void setList(List<Title> list) {
            this.list = list;
        }

        public static class Title {
            /**
             * uid : 2866663
             * had : true
             * title : title-111-1
             * status : 0
             * activity : 2017Blink
             * score : 0
             * level : []
             * category : [{"name":"热门","class":"red"}]
             * title_pic : {"id":"title-111-1","title":"2017Blink","img":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20171116172700","width":0,"height":0,"is_lihui":0,"lihui_img":"","lihui_width":0,"lihui_height":0}
             */

            @SerializedName("uid")
            private long userId;
            @SerializedName("had")
            private boolean had;
            @SerializedName("title")
            private String title;
            @SerializedName("status")
            private int status;
            @SerializedName("activity")
            private String activity;
            @SerializedName("score")
            private int score;
            @SerializedName("title_pic")
            private TitlePic titlePic;
            @SerializedName("level")
            private List<JsonElement> level;
            @SerializedName("category")
            private List<Category> category;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public boolean isHad() {
                return had;
            }

            public void setHad(boolean had) {
                this.had = had;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getActivity() {
                return activity;
            }

            public void setActivity(String activity) {
                this.activity = activity;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public TitlePic getTitlePic() {
                return titlePic;
            }

            public void setTitlePic(TitlePic titlePic) {
                this.titlePic = titlePic;
            }

            public List<JsonElement> getLevel() {
                return level;
            }

            public void setLevel(List<JsonElement> level) {
                this.level = level;
            }

            public List<Category> getCategory() {
                return category;
            }

            public void setCategory(List<Category> category) {
                this.category = category;
            }

            public static class TitlePic {
                /**
                 * id : title-111-1
                 * title : 2017Blink
                 * img : https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/titles/title/3/title-111-1.png?20171116172700
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
                private int isLiHui;
                @SerializedName("lihui_img")
                private String liHuiImg;
                @SerializedName("lihui_width")
                private int liHuiWidth;
                @SerializedName("lihui_height")
                private int liHuiHeight;

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

                public int getIsLiHui() {
                    return isLiHui;
                }

                public void setIsLiHui(int isLiHui) {
                    this.isLiHui = isLiHui;
                }

                public String getLiHuiImg() {
                    return liHuiImg;
                }

                public void setLiHuiImg(String liHuiImg) {
                    this.liHuiImg = liHuiImg;
                }

                public int getLiHuiWidth() {
                    return liHuiWidth;
                }

                public void setLiHuiWidth(int liHuiWidth) {
                    this.liHuiWidth = liHuiWidth;
                }

                public int getLiHuiHeight() {
                    return liHuiHeight;
                }

                public void setLiHuiHeight(int liHuiHeight) {
                    this.liHuiHeight = liHuiHeight;
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
        }
    }
}
