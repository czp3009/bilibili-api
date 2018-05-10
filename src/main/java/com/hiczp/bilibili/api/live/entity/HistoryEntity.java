package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : {"page":1,"pagesize":20,"list":[{"name":"czp3009","face":"https://i1.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","roomid":1110317,"areaName":"生活娱乐","live_status":0,"round_status":0,"fansNum":44,"area_v2_id":"27","area_v2_name":"学习","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["编程"]},{"name":"3号直播间","face":"https://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","roomid":3,"areaName":"放映厅","live_status":1,"round_status":0,"fansNum":314211,"area_v2_id":"34","area_v2_name":"音乐台","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["ACG音乐"]},{"name":"青衣才不是御姐呢","face":"https://i1.hdslb.com/bfs/face/025fa73e3f1be9d7f4c2b10678d6a0a5a89addee.jpg","roomid":526,"areaName":"生活娱乐","live_status":0,"round_status":0,"fansNum":139168,"area_v2_id":"139","area_v2_name":"美少女","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["御姐","电台","声控","声优"]},{"name":"宫本狗雨","face":"https://i0.hdslb.com/bfs/face/8c49a758216f9bd14b0046afe48a3514f44126f0.jpg","roomid":102,"areaName":"单机联机","live_status":1,"round_status":0,"fansNum":582323,"area_v2_id":"80","area_v2_name":"绝地求生：大逃杀","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["英雄联盟","守望麦克雷","黄金矿工","灵魂唱见"]},{"name":"Tocci椭奇","face":"https://i2.hdslb.com/bfs/face/c67d599dffb6911fdfc3d70c41204363ee41d1bd.jpg","roomid":519,"areaName":"生活娱乐","live_status":0,"round_status":0,"fansNum":124306,"area_v2_id":"32","area_v2_name":"手机直播","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["英雄联盟","宅舞"]},{"name":"叶落莫言","face":"https://i1.hdslb.com/bfs/face/37bfd9a9f40eb9ff52b697e204386ab918ccd742.jpg","roomid":387,"areaName":"单机联机","live_status":1,"round_status":0,"fansNum":143357,"area_v2_id":"80","area_v2_name":"绝地求生：大逃杀","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["守望先锋","绝地求生","唱见","古风翻唱"]},{"name":"Alessa0","face":"https://i2.hdslb.com/bfs/face/c1cd432957bbd9bbb98d2c3c36849b5ad7ece7d5.jpg","roomid":1013,"areaName":"单机联机","live_status":1,"round_status":0,"fansNum":257534,"area_v2_id":"107","area_v2_name":"其他游戏","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":[]},{"name":"游戏彩笔","face":"https://i2.hdslb.com/bfs/face/0433055d4eac3b2314faadb47de64be114571d4c.jpg","roomid":461,"areaName":"手游直播","live_status":0,"round_status":0,"fansNum":91385,"area_v2_id":"40","area_v2_name":"崩坏3","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":["崩坏3","绝地求生大逃杀","300英雄"]},{"name":"就决定是你了长生","face":"https://i0.hdslb.com/bfs/face/941f199204fd885cca123cbe8be6eedb6639d0e0.jpg","roomid":1170236,"areaName":"唱见舞见","live_status":1,"round_status":0,"fansNum":3461,"area_v2_id":"21","area_v2_name":"唱见","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["就决定是你了老头"]},{"name":"大大叔菜的抠脚","face":"https://i1.hdslb.com/bfs/face/f8da5f279cfd1ea08c46f15f4dc0c9ca81647cae.jpg","roomid":7733281,"areaName":"手游直播","live_status":1,"round_status":0,"fansNum":2655,"area_v2_id":"98","area_v2_name":"其他手游","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":[]},{"name":"MURDO-木木","face":"https://i2.hdslb.com/bfs/face/11e653115be367111729e26b71c7a95e2e50a5a4.jpg","roomid":5983722,"areaName":"绘画专区","live_status":0,"round_status":0,"fansNum":2473,"area_v2_id":"51","area_v2_name":"原创绘画","area_v2_parent_name":"绘画","area_v2_parent_id":"4","roomTags":[]},{"name":"hyx5020","face":"https://i0.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg","roomid":29434,"areaName":"放映厅","live_status":0,"round_status":0,"fansNum":548,"area_v2_id":"33","area_v2_name":"映评馆","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["SpaceX","Falcon","重型猎鹰","发射"]},{"name":"两仪滚","face":"https://i1.hdslb.com/bfs/face/4a91427ef035836b1937244bc559ed03f244bfa9.jpg","roomid":388,"areaName":"单机联机","live_status":0,"round_status":1,"fansNum":310591,"area_v2_id":"107","area_v2_name":"其他游戏","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["二五仔","猛男","B站恶霸","吃鸡"]},{"name":"污污_永远的魔法师_","face":"https://i0.hdslb.com/bfs/face/effbe54414657ed89b2a48fd822abeed90d67f67.jpg","roomid":255,"areaName":"绘画专区","live_status":0,"round_status":0,"fansNum":129145,"area_v2_id":"94","area_v2_name":"同人绘画","area_v2_parent_name":"绘画","area_v2_parent_id":"4","roomTags":["绘画","板绘"]},{"name":"Kano_Amigo乐队键盘手","face":"https://i1.hdslb.com/bfs/face/0e8dc590bcbcb986f7898d9eb77cdadbf061fc64.jpg","roomid":673794,"areaName":"御宅文化","live_status":0,"round_status":1,"fansNum":4266,"area_v2_id":"143","area_v2_name":"才艺","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":[]},{"name":"棉花大哥哥","face":"https://i2.hdslb.com/bfs/face/9fc16093743b2692a1a6d4dee19eede911e6712f.jpg","roomid":103,"areaName":"生活娱乐","live_status":0,"round_status":1,"fansNum":116498,"area_v2_id":"145","area_v2_name":"聊天室","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["王者荣耀","声控","颜控"]},{"name":"萌萌哒条码","face":"https://i1.hdslb.com/bfs/face/14b69433ef566f39a236991cbb0ff5ef95cc82f2.jpg","roomid":1325308,"areaName":"手游直播","live_status":0,"round_status":0,"fansNum":23679,"area_v2_id":"98","area_v2_name":"其他手游","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":["minecraft 我的世界","Hypixel 炉石传说","守望先锋 绝地求生","单机游戏 星际争霸"]},{"name":"某幻君","face":"https://i1.hdslb.com/bfs/face/9ed5ebf1e3694d9cd2b4fcd1d353759ee83b3dfe.jpg","roomid":271744,"areaName":"单机联机","live_status":0,"round_status":1,"fansNum":1521416,"area_v2_id":"107","area_v2_name":"其他游戏","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["绝地求生大逃杀"]},{"name":"池田天天","face":"https://i0.hdslb.com/bfs/face/fdb8593ca8a578f5aff6bb744fa1df6fa149d9f1.jpg","roomid":13924,"areaName":"唱见舞见","live_status":0,"round_status":1,"fansNum":48799,"area_v2_id":"21","area_v2_name":"唱见","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["天天","少年音","唱歌"]},{"name":"我就是FISH","face":"https://i1.hdslb.com/bfs/face/a076329348d82164c3f54598ee90239c17817d21.jpg","roomid":4716742,"areaName":"手游直播","live_status":0,"round_status":0,"fansNum":8,"area_v2_id":"98","area_v2_name":"其他手游","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":[]}],"total_page":1}
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
         * page : 1
         * pagesize : 20
         * list : [{"name":"czp3009","face":"https://i1.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg","roomid":1110317,"areaName":"生活娱乐","live_status":0,"round_status":0,"fansNum":44,"area_v2_id":"27","area_v2_name":"学习","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["编程"]},{"name":"3号直播间","face":"https://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","roomid":3,"areaName":"放映厅","live_status":1,"round_status":0,"fansNum":314211,"area_v2_id":"34","area_v2_name":"音乐台","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["ACG音乐"]},{"name":"青衣才不是御姐呢","face":"https://i1.hdslb.com/bfs/face/025fa73e3f1be9d7f4c2b10678d6a0a5a89addee.jpg","roomid":526,"areaName":"生活娱乐","live_status":0,"round_status":0,"fansNum":139168,"area_v2_id":"139","area_v2_name":"美少女","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["御姐","电台","声控","声优"]},{"name":"宫本狗雨","face":"https://i0.hdslb.com/bfs/face/8c49a758216f9bd14b0046afe48a3514f44126f0.jpg","roomid":102,"areaName":"单机联机","live_status":1,"round_status":0,"fansNum":582323,"area_v2_id":"80","area_v2_name":"绝地求生：大逃杀","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["英雄联盟","守望麦克雷","黄金矿工","灵魂唱见"]},{"name":"Tocci椭奇","face":"https://i2.hdslb.com/bfs/face/c67d599dffb6911fdfc3d70c41204363ee41d1bd.jpg","roomid":519,"areaName":"生活娱乐","live_status":0,"round_status":0,"fansNum":124306,"area_v2_id":"32","area_v2_name":"手机直播","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["英雄联盟","宅舞"]},{"name":"叶落莫言","face":"https://i1.hdslb.com/bfs/face/37bfd9a9f40eb9ff52b697e204386ab918ccd742.jpg","roomid":387,"areaName":"单机联机","live_status":1,"round_status":0,"fansNum":143357,"area_v2_id":"80","area_v2_name":"绝地求生：大逃杀","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["守望先锋","绝地求生","唱见","古风翻唱"]},{"name":"Alessa0","face":"https://i2.hdslb.com/bfs/face/c1cd432957bbd9bbb98d2c3c36849b5ad7ece7d5.jpg","roomid":1013,"areaName":"单机联机","live_status":1,"round_status":0,"fansNum":257534,"area_v2_id":"107","area_v2_name":"其他游戏","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":[]},{"name":"游戏彩笔","face":"https://i2.hdslb.com/bfs/face/0433055d4eac3b2314faadb47de64be114571d4c.jpg","roomid":461,"areaName":"手游直播","live_status":0,"round_status":0,"fansNum":91385,"area_v2_id":"40","area_v2_name":"崩坏3","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":["崩坏3","绝地求生大逃杀","300英雄"]},{"name":"就决定是你了长生","face":"https://i0.hdslb.com/bfs/face/941f199204fd885cca123cbe8be6eedb6639d0e0.jpg","roomid":1170236,"areaName":"唱见舞见","live_status":1,"round_status":0,"fansNum":3461,"area_v2_id":"21","area_v2_name":"唱见","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["就决定是你了老头"]},{"name":"大大叔菜的抠脚","face":"https://i1.hdslb.com/bfs/face/f8da5f279cfd1ea08c46f15f4dc0c9ca81647cae.jpg","roomid":7733281,"areaName":"手游直播","live_status":1,"round_status":0,"fansNum":2655,"area_v2_id":"98","area_v2_name":"其他手游","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":[]},{"name":"MURDO-木木","face":"https://i2.hdslb.com/bfs/face/11e653115be367111729e26b71c7a95e2e50a5a4.jpg","roomid":5983722,"areaName":"绘画专区","live_status":0,"round_status":0,"fansNum":2473,"area_v2_id":"51","area_v2_name":"原创绘画","area_v2_parent_name":"绘画","area_v2_parent_id":"4","roomTags":[]},{"name":"hyx5020","face":"https://i0.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg","roomid":29434,"areaName":"放映厅","live_status":0,"round_status":0,"fansNum":548,"area_v2_id":"33","area_v2_name":"映评馆","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["SpaceX","Falcon","重型猎鹰","发射"]},{"name":"两仪滚","face":"https://i1.hdslb.com/bfs/face/4a91427ef035836b1937244bc559ed03f244bfa9.jpg","roomid":388,"areaName":"单机联机","live_status":0,"round_status":1,"fansNum":310591,"area_v2_id":"107","area_v2_name":"其他游戏","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["二五仔","猛男","B站恶霸","吃鸡"]},{"name":"污污_永远的魔法师_","face":"https://i0.hdslb.com/bfs/face/effbe54414657ed89b2a48fd822abeed90d67f67.jpg","roomid":255,"areaName":"绘画专区","live_status":0,"round_status":0,"fansNum":129145,"area_v2_id":"94","area_v2_name":"同人绘画","area_v2_parent_name":"绘画","area_v2_parent_id":"4","roomTags":["绘画","板绘"]},{"name":"Kano_Amigo乐队键盘手","face":"https://i1.hdslb.com/bfs/face/0e8dc590bcbcb986f7898d9eb77cdadbf061fc64.jpg","roomid":673794,"areaName":"御宅文化","live_status":0,"round_status":1,"fansNum":4266,"area_v2_id":"143","area_v2_name":"才艺","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":[]},{"name":"棉花大哥哥","face":"https://i2.hdslb.com/bfs/face/9fc16093743b2692a1a6d4dee19eede911e6712f.jpg","roomid":103,"areaName":"生活娱乐","live_status":0,"round_status":1,"fansNum":116498,"area_v2_id":"145","area_v2_name":"聊天室","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["王者荣耀","声控","颜控"]},{"name":"萌萌哒条码","face":"https://i1.hdslb.com/bfs/face/14b69433ef566f39a236991cbb0ff5ef95cc82f2.jpg","roomid":1325308,"areaName":"手游直播","live_status":0,"round_status":0,"fansNum":23679,"area_v2_id":"98","area_v2_name":"其他手游","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":["minecraft 我的世界","Hypixel 炉石传说","守望先锋 绝地求生","单机游戏 星际争霸"]},{"name":"某幻君","face":"https://i1.hdslb.com/bfs/face/9ed5ebf1e3694d9cd2b4fcd1d353759ee83b3dfe.jpg","roomid":271744,"areaName":"单机联机","live_status":0,"round_status":1,"fansNum":1521416,"area_v2_id":"107","area_v2_name":"其他游戏","area_v2_parent_name":"游戏","area_v2_parent_id":"2","roomTags":["绝地求生大逃杀"]},{"name":"池田天天","face":"https://i0.hdslb.com/bfs/face/fdb8593ca8a578f5aff6bb744fa1df6fa149d9f1.jpg","roomid":13924,"areaName":"唱见舞见","live_status":0,"round_status":1,"fansNum":48799,"area_v2_id":"21","area_v2_name":"唱见","area_v2_parent_name":"娱乐","area_v2_parent_id":"1","roomTags":["天天","少年音","唱歌"]},{"name":"我就是FISH","face":"https://i1.hdslb.com/bfs/face/a076329348d82164c3f54598ee90239c17817d21.jpg","roomid":4716742,"areaName":"手游直播","live_status":0,"round_status":0,"fansNum":8,"area_v2_id":"98","area_v2_name":"其他手游","area_v2_parent_name":"手游","area_v2_parent_id":"3","roomTags":[]}]
         * total_page : 1
         */

        @SerializedName("page")
        private int page;
        @SerializedName("pagesize")
        private int pageSize;
        @SerializedName("total_page")
        private int totalPage;
        @SerializedName("list")
        private List<Room> rooms;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<Room> getRooms() {
            return rooms;
        }

        public void setRooms(List<Room> rooms) {
            this.rooms = rooms;
        }

        public static class Room {
            /**
             * name : czp3009
             * face : https://i1.hdslb.com/bfs/face/4f65e79399ad5a1bf3f877851b2f819d5870b494.jpg
             * roomid : 1110317
             * areaName : 生活娱乐
             * live_status : 0
             * round_status : 0
             * fansNum : 44
             * area_v2_id : 27
             * area_v2_name : 学习
             * area_v2_parent_name : 娱乐
             * area_v2_parent_id : 1
             * roomTags : ["编程"]
             */

            @SerializedName("name")
            private String name;
            @SerializedName("face")
            private String face;
            @SerializedName("roomid")
            private long roomId;
            @SerializedName("areaName")
            private String areaName;
            @SerializedName("live_status")
            private int liveStatus;
            @SerializedName("round_status")
            private int roundStatus;
            @SerializedName("fansNum")
            private long fansNum;
            @SerializedName("area_v2_id")
            private String areaV2Id;
            @SerializedName("area_v2_name")
            private String areaV2Name;
            @SerializedName("area_v2_parent_name")
            private String areaV2ParentName;
            @SerializedName("area_v2_parent_id")
            private String areaV2ParentId;
            @SerializedName("roomTags")
            private List<String> roomTags;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public long getRoomId() {
                return roomId;
            }

            public void setRoomId(long roomId) {
                this.roomId = roomId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public int getLiveStatus() {
                return liveStatus;
            }

            public void setLiveStatus(int liveStatus) {
                this.liveStatus = liveStatus;
            }

            public int getRoundStatus() {
                return roundStatus;
            }

            public void setRoundStatus(int roundStatus) {
                this.roundStatus = roundStatus;
            }

            public long getFansNum() {
                return fansNum;
            }

            public void setFansNum(long fansNum) {
                this.fansNum = fansNum;
            }

            public String getAreaV2Id() {
                return areaV2Id;
            }

            public void setAreaV2Id(String areaV2Id) {
                this.areaV2Id = areaV2Id;
            }

            public String getAreaV2Name() {
                return areaV2Name;
            }

            public void setAreaV2Name(String areaV2Name) {
                this.areaV2Name = areaV2Name;
            }

            public String getAreaV2ParentName() {
                return areaV2ParentName;
            }

            public void setAreaV2ParentName(String areaV2ParentName) {
                this.areaV2ParentName = areaV2ParentName;
            }

            public String getAreaV2ParentId() {
                return areaV2ParentId;
            }

            public void setAreaV2ParentId(String areaV2ParentId) {
                this.areaV2ParentId = areaV2ParentId;
            }

            public List<String> getRoomTags() {
                return roomTags;
            }

            public void setRoomTags(List<String> roomTags) {
                this.roomTags = roomTags;
            }
        }
    }
}
