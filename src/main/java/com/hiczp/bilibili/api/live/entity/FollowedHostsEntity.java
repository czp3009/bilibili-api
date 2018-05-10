package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FollowedHostsEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : {"page":1,"pagesize":20,"count":19,"total_page":1,"total_status":1,"total_desc":"快打开喜欢主播的开播提醒吧,再也不错过ta的直播啦","list":[{"uid":11153765,"name":"3号直播间","face":"https://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","roomid":23058,"areaName":"放映厅","area_v2_id":34,"area_v2_name":"音乐台","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":314474,"roomTags":["ACG音乐"],"live_status":1,"round_status":0},{"uid":32786875,"name":"real信誓蛋蛋","face":"https://i1.hdslb.com/bfs/face/f425590c6c720b7952f18e63028d0d5eec89e74d.jpg","roomid":906677,"areaName":"生活娱乐","area_v2_id":32,"area_v2_name":"手机直播","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":295364,"live_status":0,"round_status":1},{"uid":819554,"name":"池田天天","face":"https://i1.hdslb.com/bfs/face/fdb8593ca8a578f5aff6bb744fa1df6fa149d9f1.jpg","roomid":13924,"areaName":"唱见舞见","area_v2_id":21,"area_v2_name":"唱见","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":49026,"roomTags":["天天","少年音","唱歌"],"live_status":0,"round_status":1},{"uid":85835398,"name":"TASTEBUDS伶牙俐吃","face":"https://i1.hdslb.com/bfs/face/b72b49c4a38df59d287e12e3f8f59b57b7cd442c.jpg","roomid":4024675,"areaName":"生活娱乐","area_v2_id":26,"area_v2_name":"日常","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":144294,"live_status":0,"round_status":1},{"uid":176037767,"name":"我是郭杰瑞","face":"https://i0.hdslb.com/bfs/face/6182455e4d61159121c223ddc7a3a381f2d4d056.jpg","roomid":5084304,"areaName":"御宅文化","area_v2_id":143,"area_v2_name":"才艺","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":598231,"live_status":0,"round_status":1},{"uid":11284967,"name":"我是嘿老外","face":"https://i2.hdslb.com/bfs/face/536cce524ef0d14396927d8f678cd2e59f6c2245.jpg","roomid":901547,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":455899,"live_status":0,"round_status":1},{"uid":32820037,"name":"歪果仁研究协会","face":"https://i0.hdslb.com/bfs/face/bc03f2d20bf588f0597bd2b5979dd4740acd5056.jpg","roomid":907059,"areaName":"生活娱乐","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":1249996,"live_status":0,"round_status":1},{"uid":19220722,"name":"陈小麦Mr.BowTie","face":"https://i0.hdslb.com/bfs/face/443f0c3a524a825a0def5d08a1b59c1fc5476ec3.jpg","roomid":888383,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":4496,"live_status":0,"round_status":1},{"uid":5793775,"name":"Sanjay·衰傑","face":"https://i1.hdslb.com/bfs/face/5f22337565aa16a2bf22d124a7e9a9352dd36c8a.jpg","roomid":926157,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":13,"live_status":0,"round_status":1},{"uid":15834498,"name":"拂菻坊","face":"https://i1.hdslb.com/bfs/face/59caded2aa9e6f0350ec41d4d57ad7c8835265b9.jpg","roomid":439728,"areaName":"生活娱乐","area_v2_id":145,"area_v2_name":"聊天室","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":1764054,"roomTags":["日常聊天","pubg"],"live_status":0,"round_status":1},{"uid":12526468,"name":"PandaBros熊猫兄弟","face":"https://i1.hdslb.com/bfs/face/489e3dc94adeda13f92d12e234c58b3d52f58f9a.jpg","roomid":545141,"areaName":"电子竞技","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":56358,"roomTags":["英雄联盟"],"live_status":0,"round_status":1},{"uid":14558631,"name":"王霸胆英语","face":"https://i1.hdslb.com/bfs/face/55a3de63bf59205d05521e9b26622048827eda8d.jpg","roomid":79324,"areaName":"生活娱乐","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":429121,"roomTags":["海外留学"],"live_status":0,"round_status":1},{"uid":18739124,"name":"TrevorJames吃货老外","face":"https://i2.hdslb.com/bfs/face/3dc1747e97029a7085f9433ea2bb75a01c60e6d6.jpg","roomid":544814,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":507338,"live_status":0,"round_status":1},{"uid":6549181,"name":"Arias丶","face":"https://i1.hdslb.com/bfs/face/dc433e06c62385abc849003c8d94e3258155da31.jpg","roomid":19175,"areaName":"电子竞技","area_v2_id":92,"area_v2_name":"DOTA2","area_v2_parent_id":2,"area_v2_parent_name":"游戏","tstatus":0,"fansNum":14,"live_status":0,"round_status":0},{"uid":14614133,"name":"我就是FISH","face":"https://i1.hdslb.com/bfs/face/a076329348d82164c3f54598ee90239c17817d21.jpg","roomid":4716742,"areaName":"手游直播","area_v2_id":98,"area_v2_name":"其他手游","area_v2_parent_id":3,"area_v2_parent_name":"手游","tstatus":0,"fansNum":8,"live_status":0,"round_status":0},{"uid":10775090,"name":"SEeleLAO","face":"https://i2.hdslb.com/bfs/face/1213c81a1da304629061705edb65b78f78f25281.jpg","roomid":3300253,"areaName":"单机联机","area_v2_id":107,"area_v2_name":"其他游戏","area_v2_parent_id":2,"area_v2_parent_name":"游戏","tstatus":0,"fansNum":89,"roomTags":["守望先锋","收获日2"],"live_status":0,"round_status":0},{"uid":122879,"name":"敖厂长","face":"https://i0.hdslb.com/bfs/face/5fad8f73b16577e27e6e9072a174c632efb36867.jpg","roomid":544586,"areaName":"单机联机","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":3160187,"roomTags":["敖厂长"],"live_status":0,"round_status":0},{"uid":2866663,"name":"hyx5020","face":"https://i1.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg","roomid":29434,"areaName":"放映厅","area_v2_id":33,"area_v2_name":"映评馆","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":547,"roomTags":["SpaceX","Falcon","重型猎鹰","发射"],"live_status":0,"round_status":0},{"uid":6857104,"name":"张逗张花","face":"https://i0.hdslb.com/bfs/face/95273c9962066dd944078e42cb1e5a0269b73e9a.jpg","roomid":78735,"areaName":"生活娱乐","area_v2_id":32,"area_v2_name":"手机直播","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":1068934,"roomTags":["张逗张花"],"live_status":0,"round_status":0}]}
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
         * count : 19
         * total_page : 1
         * total_status : 1
         * total_desc : 快打开喜欢主播的开播提醒吧,再也不错过ta的直播啦
         * list : [{"uid":11153765,"name":"3号直播间","face":"https://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","roomid":23058,"areaName":"放映厅","area_v2_id":34,"area_v2_name":"音乐台","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":314474,"roomTags":["ACG音乐"],"live_status":1,"round_status":0},{"uid":32786875,"name":"real信誓蛋蛋","face":"https://i1.hdslb.com/bfs/face/f425590c6c720b7952f18e63028d0d5eec89e74d.jpg","roomid":906677,"areaName":"生活娱乐","area_v2_id":32,"area_v2_name":"手机直播","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":295364,"live_status":0,"round_status":1},{"uid":819554,"name":"池田天天","face":"https://i1.hdslb.com/bfs/face/fdb8593ca8a578f5aff6bb744fa1df6fa149d9f1.jpg","roomid":13924,"areaName":"唱见舞见","area_v2_id":21,"area_v2_name":"唱见","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":49026,"roomTags":["天天","少年音","唱歌"],"live_status":0,"round_status":1},{"uid":85835398,"name":"TASTEBUDS伶牙俐吃","face":"https://i1.hdslb.com/bfs/face/b72b49c4a38df59d287e12e3f8f59b57b7cd442c.jpg","roomid":4024675,"areaName":"生活娱乐","area_v2_id":26,"area_v2_name":"日常","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":144294,"live_status":0,"round_status":1},{"uid":176037767,"name":"我是郭杰瑞","face":"https://i0.hdslb.com/bfs/face/6182455e4d61159121c223ddc7a3a381f2d4d056.jpg","roomid":5084304,"areaName":"御宅文化","area_v2_id":143,"area_v2_name":"才艺","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":598231,"live_status":0,"round_status":1},{"uid":11284967,"name":"我是嘿老外","face":"https://i2.hdslb.com/bfs/face/536cce524ef0d14396927d8f678cd2e59f6c2245.jpg","roomid":901547,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":455899,"live_status":0,"round_status":1},{"uid":32820037,"name":"歪果仁研究协会","face":"https://i0.hdslb.com/bfs/face/bc03f2d20bf588f0597bd2b5979dd4740acd5056.jpg","roomid":907059,"areaName":"生活娱乐","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":1249996,"live_status":0,"round_status":1},{"uid":19220722,"name":"陈小麦Mr.BowTie","face":"https://i0.hdslb.com/bfs/face/443f0c3a524a825a0def5d08a1b59c1fc5476ec3.jpg","roomid":888383,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":4496,"live_status":0,"round_status":1},{"uid":5793775,"name":"Sanjay·衰傑","face":"https://i1.hdslb.com/bfs/face/5f22337565aa16a2bf22d124a7e9a9352dd36c8a.jpg","roomid":926157,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":13,"live_status":0,"round_status":1},{"uid":15834498,"name":"拂菻坊","face":"https://i1.hdslb.com/bfs/face/59caded2aa9e6f0350ec41d4d57ad7c8835265b9.jpg","roomid":439728,"areaName":"生活娱乐","area_v2_id":145,"area_v2_name":"聊天室","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":1764054,"roomTags":["日常聊天","pubg"],"live_status":0,"round_status":1},{"uid":12526468,"name":"PandaBros熊猫兄弟","face":"https://i1.hdslb.com/bfs/face/489e3dc94adeda13f92d12e234c58b3d52f58f9a.jpg","roomid":545141,"areaName":"电子竞技","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":56358,"roomTags":["英雄联盟"],"live_status":0,"round_status":1},{"uid":14558631,"name":"王霸胆英语","face":"https://i1.hdslb.com/bfs/face/55a3de63bf59205d05521e9b26622048827eda8d.jpg","roomid":79324,"areaName":"生活娱乐","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":429121,"roomTags":["海外留学"],"live_status":0,"round_status":1},{"uid":18739124,"name":"TrevorJames吃货老外","face":"https://i2.hdslb.com/bfs/face/3dc1747e97029a7085f9433ea2bb75a01c60e6d6.jpg","roomid":544814,"areaName":"","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":507338,"live_status":0,"round_status":1},{"uid":6549181,"name":"Arias丶","face":"https://i1.hdslb.com/bfs/face/dc433e06c62385abc849003c8d94e3258155da31.jpg","roomid":19175,"areaName":"电子竞技","area_v2_id":92,"area_v2_name":"DOTA2","area_v2_parent_id":2,"area_v2_parent_name":"游戏","tstatus":0,"fansNum":14,"live_status":0,"round_status":0},{"uid":14614133,"name":"我就是FISH","face":"https://i1.hdslb.com/bfs/face/a076329348d82164c3f54598ee90239c17817d21.jpg","roomid":4716742,"areaName":"手游直播","area_v2_id":98,"area_v2_name":"其他手游","area_v2_parent_id":3,"area_v2_parent_name":"手游","tstatus":0,"fansNum":8,"live_status":0,"round_status":0},{"uid":10775090,"name":"SEeleLAO","face":"https://i2.hdslb.com/bfs/face/1213c81a1da304629061705edb65b78f78f25281.jpg","roomid":3300253,"areaName":"单机联机","area_v2_id":107,"area_v2_name":"其他游戏","area_v2_parent_id":2,"area_v2_parent_name":"游戏","tstatus":0,"fansNum":89,"roomTags":["守望先锋","收获日2"],"live_status":0,"round_status":0},{"uid":122879,"name":"敖厂长","face":"https://i0.hdslb.com/bfs/face/5fad8f73b16577e27e6e9072a174c632efb36867.jpg","roomid":544586,"areaName":"单机联机","area_v2_id":0,"area_v2_name":"","area_v2_parent_id":0,"area_v2_parent_name":"","tstatus":0,"fansNum":3160187,"roomTags":["敖厂长"],"live_status":0,"round_status":0},{"uid":2866663,"name":"hyx5020","face":"https://i1.hdslb.com/bfs/face/0434dccc0ec4de223e8ca374dea06a6e1e8eb471.jpg","roomid":29434,"areaName":"放映厅","area_v2_id":33,"area_v2_name":"映评馆","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":547,"roomTags":["SpaceX","Falcon","重型猎鹰","发射"],"live_status":0,"round_status":0},{"uid":6857104,"name":"张逗张花","face":"https://i0.hdslb.com/bfs/face/95273c9962066dd944078e42cb1e5a0269b73e9a.jpg","roomid":78735,"areaName":"生活娱乐","area_v2_id":32,"area_v2_name":"手机直播","area_v2_parent_id":1,"area_v2_parent_name":"娱乐","tstatus":0,"fansNum":1068934,"roomTags":["张逗张花"],"live_status":0,"round_status":0}]
         */

        @SerializedName("page")
        private long page;
        @SerializedName("pagesize")
        private long pageSize;
        @SerializedName("count")
        private long count;
        @SerializedName("total_page")
        private long totalPage;
        @SerializedName("total_status")
        private int totalStatus;
        @SerializedName("total_desc")
        private String totalDesc;
        @SerializedName("list")
        private List<Room> list;

        public long getPage() {
            return page;
        }

        public void setPage(long page) {
            this.page = page;
        }

        public long getPageSize() {
            return pageSize;
        }

        public void setPageSize(long pageSize) {
            this.pageSize = pageSize;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public long getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(long totalPage) {
            this.totalPage = totalPage;
        }

        public int getTotalStatus() {
            return totalStatus;
        }

        public void setTotalStatus(int totalStatus) {
            this.totalStatus = totalStatus;
        }

        public String getTotalDesc() {
            return totalDesc;
        }

        public void setTotalDesc(String totalDesc) {
            this.totalDesc = totalDesc;
        }

        public List<Room> getList() {
            return list;
        }

        public void setList(List<Room> list) {
            this.list = list;
        }

        public static class Room {
            /**
             * uid : 11153765
             * name : 3号直播间
             * face : https://i1.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
             * roomid : 23058
             * areaName : 放映厅
             * area_v2_id : 34
             * area_v2_name : 音乐台
             * area_v2_parent_id : 1
             * area_v2_parent_name : 娱乐
             * tstatus : 0
             * fansNum : 314474
             * roomTags : ["ACG音乐"]
             * live_status : 1
             * round_status : 0
             */

            @SerializedName("uid")
            private long uid;
            @SerializedName("name")
            private String name;
            @SerializedName("face")
            private String face;
            @SerializedName("roomid")
            private int roomId;
            @SerializedName("areaName")
            private String areaName;
            @SerializedName("area_v2_id")
            private int areaV2Id;
            @SerializedName("area_v2_name")
            private String areaV2Name;
            @SerializedName("area_v2_parent_id")
            private int areaV2ParentId;
            @SerializedName("area_v2_parent_name")
            private String areaV2ParentName;
            @SerializedName("tstatus")
            private int tstatus;
            @SerializedName("fansNum")
            private long fansNum;
            @SerializedName("live_status")
            private int liveStatus;
            @SerializedName("round_status")
            private int roundStatus;
            @SerializedName("roomTags")
            private List<String> roomTags;

            public long getUid() {
                return uid;
            }

            public void setUid(long uid) {
                this.uid = uid;
            }

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

            public int getRoomId() {
                return roomId;
            }

            public void setRoomId(int roomId) {
                this.roomId = roomId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public int getAreaV2Id() {
                return areaV2Id;
            }

            public void setAreaV2Id(int areaV2Id) {
                this.areaV2Id = areaV2Id;
            }

            public String getAreaV2Name() {
                return areaV2Name;
            }

            public void setAreaV2Name(String areaV2Name) {
                this.areaV2Name = areaV2Name;
            }

            public int getAreaV2ParentId() {
                return areaV2ParentId;
            }

            public void setAreaV2ParentId(int areaV2ParentId) {
                this.areaV2ParentId = areaV2ParentId;
            }

            public String getAreaV2ParentName() {
                return areaV2ParentName;
            }

            public void setAreaV2ParentName(String areaV2ParentName) {
                this.areaV2ParentName = areaV2ParentName;
            }

            public int getTstatus() {
                return tstatus;
            }

            public void setTstatus(int tstatus) {
                this.tstatus = tstatus;
            }

            public long getFansNum() {
                return fansNum;
            }

            public void setFansNum(long fansNum) {
                this.fansNum = fansNum;
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

            public List<String> getRoomTags() {
                return roomTags;
            }

            public void setRoomTags(List<String> roomTags) {
                this.roomTags = roomTags;
            }
        }
    }
}
