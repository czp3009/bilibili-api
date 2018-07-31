package com.hiczp.bilibili.api.live.entity;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class LiveRoomInfoEntity extends ResponseEntity {
    /**
     * code : 0
     * data : {"room_id":23058,"title":"哔哩哔哩音悦台","cover":"http://i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg","mid":11153765,"uname":"3号直播间","face":"http://i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","m_face":"http://i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg","background_id":1,"attention":313994,"is_attention":1,"online":25101,"create":1434695375,"create_at":"2015-06-19 14:29:35","sch_id":0,"status":"LIVE","area":"放映厅","area_id":7,"area_v2_id":34,"area_v2_parent_id":1,"area_v2_name":"音乐台","area_v2_parent_name":"娱乐","schedule":{"cid":10023058,"sch_id":0,"title":"哔哩哔哩音悦台","mid":11153765,"manager":[],"start":1434695375,"start_at":"2015-06-19 14:29:35","aid":0,"stream_id":13998,"online":25101,"status":"LIVE","meta_id":0,"pending_meta_id":0},"meta":{"tag":["ACG音乐"],"description":"<p>这里是哔哩哔哩官方音乐台喔！<\/p><p>一起来听音乐吧ε=ε=(ノ≧∇≦)ノ<\/p><p>没想到蒸汽配圣诞下装，意外的很暴露呢=3=<\/p>\n","typeid":1,"tag_ids":{"0":24},"cover":"http://i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg","check_status":"VERIFY","aid":0},"cmt":"livecmt-2.bilibili.com","cmt_port":88,"cmt_port_goim":2243,"recommend":[{"owner":{"face":"http://i2.hdslb.com/bfs/face/941f199204fd885cca123cbe8be6eedb6639d0e0.jpg","mid":14117221,"name":"就决定是你了长生"},"cover":{"src":"http://i0.hdslb.com/bfs/live/1170236.jpg?03160920"},"title":"【长生】唱的不好听算我输！","room_id":1170236,"online":3649},{"owner":{"face":"http://i2.hdslb.com/bfs/face/2af1a482007bee57d176559defc861cd39481dcf.jpg","mid":2756858,"name":"咿呀哥哥"},"cover":{"src":"http://i0.hdslb.com/bfs/live/2532274.jpg?03160920"},"title":"暖音哥哥 数羊哄睡","room_id":2532274,"online":92}],"toplist":[{"name":"桃花榜","type":"lover_2018"}],"isvip":0,"opentime":33690,"prepare":"主播正在嘿嘿嘿中...","isadmin":0,"hot_word":[{"id":48,"words":"打call"},{"id":47,"words":"囍"},{"id":44,"words":"还有这种操作！"},{"id":41,"words":"gay里gay气"},{"id":39,"words":"请大家注意弹幕礼仪哦！"},{"id":36,"words":"向大佬低头"},{"id":25,"words":"prprpr"},{"id":21,"words":"gg"},{"id":20,"words":"你为什么这么熟练啊"},{"id":19,"words":"老司机带带我"},{"id":13,"words":"666666666"},{"id":12,"words":"啪啪啪啪啪"},{"id":11,"words":"Yooooooo"},{"id":10,"words":"FFFFFFFFFF"},{"id":9,"words":"色情主播"},{"id":7,"words":"红红火火恍恍惚惚"},{"id":5,"words":"喂，妖妖零吗"},{"id":2,"words":"2333333"}],"roomgifts":[{"id":116,"name":"情书","price":2000,"type":2,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-116.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/116.gif?20180314161652","count_set":"1,5,10,99,225","combo_num":5,"super_num":225,"count_map":{"1":"","5":"","10":"","99":"","225":"高能"}},{"id":25,"name":"小电视","price":1245000,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-25.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/25.gif?20180314161652","count_set":"1,2,3,4,5","combo_num":1,"super_num":1,"count_map":{"1":"高能","2":"高能","3":"高能","4":"高能","5":"高能"}},{"id":3,"name":"B坷垃","price":9900,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-3.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/3.gif?20180314161652","count_set":"1,10,46,520,1314","combo_num":1,"super_num":46,"count_map":{"1":"","10":"","46":"高能","520":"高能","1314":"高能"}},{"id":4,"name":"喵娘","price":5200,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-4.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/4.gif?20180314161652","count_set":"1,2,10,87,520","combo_num":2,"super_num":87,"count_map":{"1":"","2":"","10":"","87":"高能","520":"高能"}},{"id":6,"name":"亿圆","price":1000,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-6.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/6.gif?20180314161652","count_set":"1,10,99,450,1314","combo_num":10,"super_num":450,"count_map":{"1":"","10":"","99":"","450":"高能","1314":"高能"}},{"id":7,"name":"666","price":666,"type":1,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-7.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/7.gif?20180314161652","count_set":"1,2,3,4,5","combo_num":0,"super_num":0,"count_map":{"1":"","2":"","3":"","4":"","5":""}},{"id":8,"name":"233","price":233,"type":1,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-8.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/8.gif?20180314161652","count_set":"1,2,3,4,5","combo_num":0,"super_num":0,"count_map":{"1":"","2":"","3":"","4":"","5":""}},{"id":1,"name":"辣条","price":100,"type":0,"coin_type":{"silver":"silver"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-1.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/1.gif?20180314161652","count_set":"1,10,99,520,4500","combo_num":0,"super_num":0,"count_map":{"1":"","10":"","99":"","520":"","4500":""}}],"ignore_gift":[{"id":1,"num":10},{"id":21,"num":10}],"msg_mode":1,"msg_color":16777215,"msg_length":30,"master_level":36,"master_level_color":16746162,"broadcast_type":0,"activity_gift":[{"id":115,"bag_id":67456406,"name":"桃花","num":1,"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-115.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/115.gif?20180314161652","combo_num":0,"super_num":0,"count_set":"1,1","count_map":{"1":"全部"}}],"check_version":0,"activity_id":0,"event_corner":[],"guard_level":0,"guard_info":{"heart_status":0,"heart_time":300},"guard_notice":0,"guard_tip_flag":1,"new_year_ceremony":0,"special_gift_gif":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901","show_room_id":3}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private LiveRoom data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LiveRoom getData() {
        return data;
    }

    public void setData(LiveRoom data) {
        this.data = data;
    }

    public static class LiveRoom {
        /**
         * room_id : 23058
         * title : 哔哩哔哩音悦台
         * cover : http://i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg
         * mid : 11153765
         * uname : 3号直播间
         * face : http://i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
         * m_face : http://i0.hdslb.com/bfs/face/5d35da6e93fbfb1a77ad6d1f1004b08413913f9a.jpg
         * background_id : 1
         * attention : 313994
         * is_attention : 1
         * online : 25101
         * create : 1434695375
         * create_at : 2015-06-19 14:29:35
         * sch_id : 0
         * status : LIVE
         * area : 放映厅
         * area_id : 7
         * area_v2_id : 34
         * area_v2_parent_id : 1
         * area_v2_name : 音乐台
         * area_v2_parent_name : 娱乐
         * schedule : {"cid":10023058,"sch_id":0,"title":"哔哩哔哩音悦台","mid":11153765,"manager":[],"start":1434695375,"start_at":"2015-06-19 14:29:35","aid":0,"stream_id":13998,"online":25101,"status":"LIVE","meta_id":0,"pending_meta_id":0}
         * meta : {"tag":["ACG音乐"],"description":"<p>这里是哔哩哔哩官方音乐台喔！<\/p><p>一起来听音乐吧ε=ε=(ノ≧∇≦)ノ<\/p><p>没想到蒸汽配圣诞下装，意外的很暴露呢=3=<\/p>\n","typeid":1,"tag_ids":{"0":24},"cover":"http://i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg","check_status":"VERIFY","aid":0}
         * cmt : livecmt-2.bilibili.com
         * cmt_port : 88
         * cmt_port_goim : 2243
         * recommend : [{"owner":{"face":"http://i2.hdslb.com/bfs/face/941f199204fd885cca123cbe8be6eedb6639d0e0.jpg","mid":14117221,"name":"就决定是你了长生"},"cover":{"src":"http://i0.hdslb.com/bfs/live/1170236.jpg?03160920"},"title":"【长生】唱的不好听算我输！","room_id":1170236,"online":3649},{"owner":{"face":"http://i2.hdslb.com/bfs/face/2af1a482007bee57d176559defc861cd39481dcf.jpg","mid":2756858,"name":"咿呀哥哥"},"cover":{"src":"http://i0.hdslb.com/bfs/live/2532274.jpg?03160920"},"title":"暖音哥哥 数羊哄睡","room_id":2532274,"online":92}]
         * toplist : [{"name":"桃花榜","type":"lover_2018"}]
         * isvip : 0
         * opentime : 33690
         * prepare : 主播正在嘿嘿嘿中...
         * isadmin : 0
         * hot_word : [{"id":48,"words":"打call"},{"id":47,"words":"囍"},{"id":44,"words":"还有这种操作！"},{"id":41,"words":"gay里gay气"},{"id":39,"words":"请大家注意弹幕礼仪哦！"},{"id":36,"words":"向大佬低头"},{"id":25,"words":"prprpr"},{"id":21,"words":"gg"},{"id":20,"words":"你为什么这么熟练啊"},{"id":19,"words":"老司机带带我"},{"id":13,"words":"666666666"},{"id":12,"words":"啪啪啪啪啪"},{"id":11,"words":"Yooooooo"},{"id":10,"words":"FFFFFFFFFF"},{"id":9,"words":"色情主播"},{"id":7,"words":"红红火火恍恍惚惚"},{"id":5,"words":"喂，妖妖零吗"},{"id":2,"words":"2333333"}]
         * roomgifts : [{"id":116,"name":"情书","price":2000,"type":2,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-116.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/116.gif?20180314161652","count_set":"1,5,10,99,225","combo_num":5,"super_num":225,"count_map":{"1":"","5":"","10":"","99":"","225":"高能"}},{"id":25,"name":"小电视","price":1245000,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-25.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/25.gif?20180314161652","count_set":"1,2,3,4,5","combo_num":1,"super_num":1,"count_map":{"1":"高能","2":"高能","3":"高能","4":"高能","5":"高能"}},{"id":3,"name":"B坷垃","price":9900,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-3.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/3.gif?20180314161652","count_set":"1,10,46,520,1314","combo_num":1,"super_num":46,"count_map":{"1":"","10":"","46":"高能","520":"高能","1314":"高能"}},{"id":4,"name":"喵娘","price":5200,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-4.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/4.gif?20180314161652","count_set":"1,2,10,87,520","combo_num":2,"super_num":87,"count_map":{"1":"","2":"","10":"","87":"高能","520":"高能"}},{"id":6,"name":"亿圆","price":1000,"type":0,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-6.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/6.gif?20180314161652","count_set":"1,10,99,450,1314","combo_num":10,"super_num":450,"count_map":{"1":"","10":"","99":"","450":"高能","1314":"高能"}},{"id":7,"name":"666","price":666,"type":1,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-7.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/7.gif?20180314161652","count_set":"1,2,3,4,5","combo_num":0,"super_num":0,"count_map":{"1":"","2":"","3":"","4":"","5":""}},{"id":8,"name":"233","price":233,"type":1,"coin_type":{"gold":"gold"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-8.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/8.gif?20180314161652","count_set":"1,2,3,4,5","combo_num":0,"super_num":0,"count_map":{"1":"","2":"","3":"","4":"","5":""}},{"id":1,"name":"辣条","price":100,"type":0,"coin_type":{"silver":"silver"},"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-1.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/1.gif?20180314161652","count_set":"1,10,99,520,4500","combo_num":0,"super_num":0,"count_map":{"1":"","10":"","99":"","520":"","4500":""}}]
         * ignore_gift : [{"id":1,"num":10},{"id":21,"num":10}]
         * msg_mode : 1
         * msg_color : 16777215
         * msg_length : 30
         * master_level : 36
         * master_level_color : 16746162
         * broadcast_type : 0
         * activity_gift : [{"id":115,"bag_id":67456406,"name":"桃花","num":1,"img":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-115.png?20180314161652","gift_url":"http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/115.gif?20180314161652","combo_num":0,"super_num":0,"count_set":"1,1","count_map":{"1":"全部"}}]
         * check_version : 0
         * activity_id : 0
         * event_corner : []
         * guard_level : 0
         * guard_info : {"heart_status":0,"heart_time":300}
         * guard_notice : 0
         * guard_tip_flag : 1
         * new_year_ceremony : 0
         * special_gift_gif : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/2/jiezou.gif?2017011901
         * show_room_id : 3
         */

        @SerializedName("room_id")
        private long roomId;
        @SerializedName("title")
        private String title;
        @SerializedName("cover")
        private String cover;
        @SerializedName("mid")
        private long userId;
        @SerializedName("uname")
        private String username;
        @SerializedName("face")
        private String face;
        @SerializedName("m_face")
        private String mobileFace;
        @SerializedName("background_id")
        private int backgroundId;
        @SerializedName("attention")
        private int attention;
        @SerializedName("is_attention")
        private int isAttention;
        @SerializedName("online")
        private int online;
        @SerializedName("create")
        private int create;
        @SerializedName("create_at")
        private String createAt;
        @SerializedName("sch_id")
        private int scheduleId;
        @SerializedName("status")
        private String status;
        @SerializedName("area")
        private String area;
        @SerializedName("area_id")
        private int areaId;
        @SerializedName("area_v2_id")
        private int areaV2Id;
        @SerializedName("area_v2_parent_id")
        private int areaV2ParentId;
        @SerializedName("area_v2_name")
        private String areaV2Name;
        @SerializedName("area_v2_parent_name")
        private String areaV2ParentName;
        @SerializedName("schedule")
        private Schedule schedule;
        @SerializedName("meta")
        private Meta meta;
        @SerializedName("cmt")
        private String cmt;
        @SerializedName("cmt_port")
        private int cmtPort;
        @SerializedName("cmt_port_goim")
        private int cmtPortGoim;
        @SerializedName("isvip")
        private int isVip;
        @SerializedName("opentime")
        private int openTime;
        @SerializedName("prepare")
        private String prepare;
        @SerializedName("isadmin")
        private int isAdmin;
        @SerializedName("msg_mode")
        private int msgMode;
        @SerializedName("msg_color")
        private int msgColor;
        @SerializedName("msg_length")
        private int msgLength;
        @SerializedName("master_level")
        private int masterLevel;
        @SerializedName("master_level_color")
        private int masterLevelColor;
        @SerializedName("broadcast_type")
        private int broadcastType;
        @SerializedName("check_version")
        private int checkVersion;
        @SerializedName("activity_id")
        private int activityId;
        @SerializedName("guard_level")
        private int guardLevel;
        @SerializedName("guard_info")
        private GuardInfo guardInfo;
        @SerializedName("guard_notice")
        private int guardNotice;
        @SerializedName("guard_tip_flag")
        private int guardTipFlag;
        @SerializedName("new_year_ceremony")
        private int newYearCeremony;
        @SerializedName("special_gift_gif")
        private String specialGiftGif;
        @SerializedName("show_room_id")
        private long showRoomId;
        @SerializedName("recommend")
        private List<Recommend> recommend;
        @SerializedName("toplist")
        private List<TopListData> topList;
        @SerializedName("hot_word")
        private List<HotWord> hotWords;
        @SerializedName("roomgifts")
        private List<RoomGift> roomGifts;
        @SerializedName("ignore_gift")
        private List<IgnoreGift> ignoreGift;
        @SerializedName("activity_gift")
        private List<ActivityGift> activityGift;
        @SerializedName("event_corner")
        private JsonElement eventCorner;

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getMobileFace() {
            return mobileFace;
        }

        public void setMobileFace(String mobileFace) {
            this.mobileFace = mobileFace;
        }

        public int getBackgroundId() {
            return backgroundId;
        }

        public void setBackgroundId(int backgroundId) {
            this.backgroundId = backgroundId;
        }

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getIsAttention() {
            return isAttention;
        }

        public void setIsAttention(int isAttention) {
            this.isAttention = isAttention;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public int getCreate() {
            return create;
        }

        public void setCreate(int create) {
            this.create = create;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public int getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(int scheduleId) {
            this.scheduleId = scheduleId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public int getAreaV2Id() {
            return areaV2Id;
        }

        public void setAreaV2Id(int areaV2Id) {
            this.areaV2Id = areaV2Id;
        }

        public int getAreaV2ParentId() {
            return areaV2ParentId;
        }

        public void setAreaV2ParentId(int areaV2ParentId) {
            this.areaV2ParentId = areaV2ParentId;
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

        public Schedule getSchedule() {
            return schedule;
        }

        public void setSchedule(Schedule schedule) {
            this.schedule = schedule;
        }

        public Meta getMeta() {
            return meta;
        }

        public void setMeta(Meta meta) {
            this.meta = meta;
        }

        public String getCmt() {
            return cmt;
        }

        public void setCmt(String cmt) {
            this.cmt = cmt;
        }

        public int getCmtPort() {
            return cmtPort;
        }

        public void setCmtPort(int cmtPort) {
            this.cmtPort = cmtPort;
        }

        public int getCmtPortGoim() {
            return cmtPortGoim;
        }

        public void setCmtPortGoim(int cmtPortGoim) {
            this.cmtPortGoim = cmtPortGoim;
        }

        public int getIsVip() {
            return isVip;
        }

        public void setIsVip(int isVip) {
            this.isVip = isVip;
        }

        public int getOpenTime() {
            return openTime;
        }

        public void setOpenTime(int openTime) {
            this.openTime = openTime;
        }

        public String getPrepare() {
            return prepare;
        }

        public void setPrepare(String prepare) {
            this.prepare = prepare;
        }

        public int getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(int isAdmin) {
            this.isAdmin = isAdmin;
        }

        public int getMsgMode() {
            return msgMode;
        }

        public void setMsgMode(int msgMode) {
            this.msgMode = msgMode;
        }

        public int getMsgColor() {
            return msgColor;
        }

        public void setMsgColor(int msgColor) {
            this.msgColor = msgColor;
        }

        public int getMsgLength() {
            return msgLength;
        }

        public void setMsgLength(int msgLength) {
            this.msgLength = msgLength;
        }

        public int getMasterLevel() {
            return masterLevel;
        }

        public void setMasterLevel(int masterLevel) {
            this.masterLevel = masterLevel;
        }

        public int getMasterLevelColor() {
            return masterLevelColor;
        }

        public void setMasterLevelColor(int masterLevelColor) {
            this.masterLevelColor = masterLevelColor;
        }

        public int getBroadcastType() {
            return broadcastType;
        }

        public void setBroadcastType(int broadcastType) {
            this.broadcastType = broadcastType;
        }

        public int getCheckVersion() {
            return checkVersion;
        }

        public void setCheckVersion(int checkVersion) {
            this.checkVersion = checkVersion;
        }

        public int getActivityId() {
            return activityId;
        }

        public void setActivityId(int activityId) {
            this.activityId = activityId;
        }

        public int getGuardLevel() {
            return guardLevel;
        }

        public void setGuardLevel(int guardLevel) {
            this.guardLevel = guardLevel;
        }

        public GuardInfo getGuardInfo() {
            return guardInfo;
        }

        public void setGuardInfo(GuardInfo guardInfo) {
            this.guardInfo = guardInfo;
        }

        public int getGuardNotice() {
            return guardNotice;
        }

        public void setGuardNotice(int guardNotice) {
            this.guardNotice = guardNotice;
        }

        public int getGuardTipFlag() {
            return guardTipFlag;
        }

        public void setGuardTipFlag(int guardTipFlag) {
            this.guardTipFlag = guardTipFlag;
        }

        public int getNewYearCeremony() {
            return newYearCeremony;
        }

        public void setNewYearCeremony(int newYearCeremony) {
            this.newYearCeremony = newYearCeremony;
        }

        public String getSpecialGiftGif() {
            return specialGiftGif;
        }

        public void setSpecialGiftGif(String specialGiftGif) {
            this.specialGiftGif = specialGiftGif;
        }

        public long getShowRoomId() {
            return showRoomId;
        }

        public void setShowRoomId(long showRoomId) {
            this.showRoomId = showRoomId;
        }

        public List<Recommend> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<Recommend> recommend) {
            this.recommend = recommend;
        }

        public List<TopListData> getTopList() {
            return topList;
        }

        public void setTopList(List<TopListData> topList) {
            this.topList = topList;
        }

        public List<HotWord> getHotWords() {
            return hotWords;
        }

        public void setHotWords(List<HotWord> hotWords) {
            this.hotWords = hotWords;
        }

        public List<RoomGift> getRoomGifts() {
            return roomGifts;
        }

        public void setRoomGifts(List<RoomGift> roomGifts) {
            this.roomGifts = roomGifts;
        }

        public List<IgnoreGift> getIgnoreGift() {
            return ignoreGift;
        }

        public void setIgnoreGift(List<IgnoreGift> ignoreGift) {
            this.ignoreGift = ignoreGift;
        }

        public List<ActivityGift> getActivityGift() {
            return activityGift;
        }

        public void setActivityGift(List<ActivityGift> activityGift) {
            this.activityGift = activityGift;
        }

        public JsonElement getEventCorner() {
            return eventCorner;
        }

        public void setEventCorner(JsonElement eventCorner) {
            this.eventCorner = eventCorner;
        }

        public static class Schedule {
            /**
             * cid : 10023058
             * sch_id : 0
             * title : 哔哩哔哩音悦台
             * mid : 11153765
             * manager : []
             * start : 1434695375
             * start_at : 2015-06-19 14:29:35
             * aid : 0
             * stream_id : 13998
             * online : 25101
             * status : LIVE
             * meta_id : 0
             * pending_meta_id : 0
             */

            @SerializedName("cid")
            private long cid;
            @SerializedName("sch_id")
            private int scheduleId;
            @SerializedName("title")
            private String title;
            @SerializedName("mid")
            private long userId;
            @SerializedName("start")
            private long start;
            @SerializedName("start_at")
            private String startAt;
            @SerializedName("aid")
            private int aid;
            @SerializedName("stream_id")
            private int streamId;
            @SerializedName("online")
            private int online;
            @SerializedName("status")
            private String status;
            @SerializedName("meta_id")
            private int metaId;
            @SerializedName("pending_meta_id")
            private int pendingMetaId;
            @SerializedName("manager")
            private List<JsonElement> manager;

            public long getCid() {
                return cid;
            }

            public void setCid(long cid) {
                this.cid = cid;
            }

            public int getScheduleId() {
                return scheduleId;
            }

            public void setScheduleId(int scheduleId) {
                this.scheduleId = scheduleId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public long getStart() {
                return start;
            }

            public void setStart(long start) {
                this.start = start;
            }

            public String getStartAt() {
                return startAt;
            }

            public void setStartAt(String startAt) {
                this.startAt = startAt;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public int getStreamId() {
                return streamId;
            }

            public void setStreamId(int streamId) {
                this.streamId = streamId;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getMetaId() {
                return metaId;
            }

            public void setMetaId(int metaId) {
                this.metaId = metaId;
            }

            public int getPendingMetaId() {
                return pendingMetaId;
            }

            public void setPendingMetaId(int pendingMetaId) {
                this.pendingMetaId = pendingMetaId;
            }

            public List<JsonElement> getManager() {
                return manager;
            }

            public void setManager(List<JsonElement> manager) {
                this.manager = manager;
            }
        }

        public static class Meta {
            /**
             * tag : ["ACG音乐"]
             * description : <p>这里是哔哩哔哩官方音乐台喔！</p><p>一起来听音乐吧ε=ε=(ノ≧∇≦)ノ</p><p>没想到蒸汽配圣诞下装，意外的很暴露呢=3=</p>

             * typeid : 1
             * tag_ids : {"0":24}
             * cover : http://i0.hdslb.com/bfs/live/6029764557e3cbe91475faae26e6e244de8c1d3c.jpg
             * check_status : VERIFY
             * aid : 0
             */

            @SerializedName("description")
            private String description;
            @SerializedName("typeid")
            private int typeId;
            @SerializedName("tag_ids")
            private Map<String, Integer> tagIds;
            @SerializedName("cover")
            private String cover;
            @SerializedName("check_status")
            private String checkStatus;
            @SerializedName("aid")
            private int aid;
            @SerializedName("tag")
            private List<String> tag;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public Map<String, Integer> getTagIds() {
                return tagIds;
            }

            public void setTagIds(Map<String, Integer> tagIds) {
                this.tagIds = tagIds;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCheckStatus() {
                return checkStatus;
            }

            public void setCheckStatus(String checkStatus) {
                this.checkStatus = checkStatus;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public List<String> getTag() {
                return tag;
            }

            public void setTag(List<String> tag) {
                this.tag = tag;
            }
        }

        public static class GuardInfo {
            /**
             * heart_status : 0
             * heart_time : 300
             */

            @SerializedName("heart_status")
            private int heartStatus;
            @SerializedName("heart_time")
            private int heartTime;

            public int getHeartStatus() {
                return heartStatus;
            }

            public void setHeartStatus(int heartStatus) {
                this.heartStatus = heartStatus;
            }

            public int getHeartTime() {
                return heartTime;
            }

            public void setHeartTime(int heartTime) {
                this.heartTime = heartTime;
            }
        }

        public static class Recommend {
            /**
             * owner : {"face":"http://i2.hdslb.com/bfs/face/941f199204fd885cca123cbe8be6eedb6639d0e0.jpg","mid":14117221,"name":"就决定是你了长生"}
             * cover : {"src":"http://i0.hdslb.com/bfs/live/1170236.jpg?03160920"}
             * title : 【长生】唱的不好听算我输！
             * room_id : 1170236
             * online : 3649
             */

            @SerializedName("owner")
            private Owner owner;
            @SerializedName("cover")
            private Cover cover;
            @SerializedName("title")
            private String title;
            @SerializedName("room_id")
            private int roomId;
            @SerializedName("online")
            private int online;

            public Owner getOwner() {
                return owner;
            }

            public void setOwner(Owner owner) {
                this.owner = owner;
            }

            public Cover getCover() {
                return cover;
            }

            public void setCover(Cover cover) {
                this.cover = cover;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getRoomId() {
                return roomId;
            }

            public void setRoomId(int roomId) {
                this.roomId = roomId;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public static class Owner {
                /**
                 * face : http://i2.hdslb.com/bfs/face/941f199204fd885cca123cbe8be6eedb6639d0e0.jpg
                 * mid : 14117221
                 * name : 就决定是你了长生
                 */

                @SerializedName("face")
                private String face;
                @SerializedName("mid")
                private long userId;
                @SerializedName("name")
                private String name;

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                public long getUserId() {
                    return userId;
                }

                public void setUserId(long userId) {
                    this.userId = userId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class Cover {
                /**
                 * src : http://i0.hdslb.com/bfs/live/1170236.jpg?03160920
                 */

                @SerializedName("src")
                private String src;

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }
            }
        }

        public static class TopListData {
            /**
             * name : 桃花榜
             * type : lover_2018
             */

            @SerializedName("name")
            private String name;
            @SerializedName("type")
            private String type;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class HotWord {
            /**
             * id : 48
             * words : 打call
             */

            @SerializedName("id")
            private int id;
            @SerializedName("words")
            private String words;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getWords() {
                return words;
            }

            public void setWords(String words) {
                this.words = words;
            }
        }

        public static class RoomGift {
            /**
             * id : 116
             * name : 情书
             * price : 2000
             * type : 2
             * coin_type : {"gold":"gold"}
             * img : http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-116.png?20180314161652
             * gift_url : http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/116.gif?20180314161652
             * count_set : 1,5,10,99,225
             * combo_num : 5
             * super_num : 225
             * count_map : {"1":"","5":"","10":"","99":"","225":"高能"}
             */

            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("price")
            private int price;
            @SerializedName("type")
            private int type;
            @SerializedName("coin_type")
            private Map<String, String> coinType;
            @SerializedName("img")
            private String img;
            @SerializedName("gift_url")
            private String giftUrl;
            @SerializedName("count_set")
            private String countSet;
            @SerializedName("combo_num")
            private int comboNum;
            @SerializedName("super_num")
            private int superNum;
            @SerializedName("count_map")
            private Map<String, String> countMap;

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

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Map<String, String> getCoinType() {
                return coinType;
            }

            public void setCoinType(Map<String, String> coinType) {
                this.coinType = coinType;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getGiftUrl() {
                return giftUrl;
            }

            public void setGiftUrl(String giftUrl) {
                this.giftUrl = giftUrl;
            }

            public String getCountSet() {
                return countSet;
            }

            public void setCountSet(String countSet) {
                this.countSet = countSet;
            }

            public int getComboNum() {
                return comboNum;
            }

            public void setComboNum(int comboNum) {
                this.comboNum = comboNum;
            }

            public int getSuperNum() {
                return superNum;
            }

            public void setSuperNum(int superNum) {
                this.superNum = superNum;
            }

            public Map<String, String> getCountMap() {
                return countMap;
            }

            public void setCountMap(Map<String, String> countMap) {
                this.countMap = countMap;
            }
        }

        public static class IgnoreGift {
            /**
             * id : 1
             * num : 10
             */

            @SerializedName("id")
            private int id;
            @SerializedName("num")
            private int number;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }
        }

        public static class ActivityGift {
            /**
             * id : 115
             * bag_id : 67456406
             * name : 桃花
             * num : 1
             * img : http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift-static-icon/gift-115.png?20180314161652
             * gift_url : http://s1.hdslb.com/bfs/static/blive/live-assets/mobile/gift/mobilegift/2/115.gif?20180314161652
             * combo_num : 0
             * super_num : 0
             * count_set : 1,1
             * count_map : {"1":"全部"}
             */

            @SerializedName("id")
            private int id;
            @SerializedName("bag_id")
            private int bagId;
            @SerializedName("name")
            private String name;
            @SerializedName("num")
            private int number;
            @SerializedName("img")
            private String image;
            @SerializedName("gift_url")
            private String giftUrl;
            @SerializedName("combo_num")
            private int comboNumber;
            @SerializedName("super_num")
            private int superNumber;
            @SerializedName("count_set")
            private String countSet;
            @SerializedName("count_map")
            private Map<String, String> countMap;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getBagId() {
                return bagId;
            }

            public void setBagId(int bagId) {
                this.bagId = bagId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getGiftUrl() {
                return giftUrl;
            }

            public void setGiftUrl(String giftUrl) {
                this.giftUrl = giftUrl;
            }

            public int getComboNumber() {
                return comboNumber;
            }

            public void setComboNumber(int comboNumber) {
                this.comboNumber = comboNumber;
            }

            public int getSuperNumber() {
                return superNumber;
            }

            public void setSuperNumber(int superNumber) {
                this.superNumber = superNumber;
            }

            public String getCountSet() {
                return countSet;
            }

            public void setCountSet(String countSet) {
                this.countSet = countSet;
            }

            public Map<String, String> getCountMap() {
                return countMap;
            }

            public void setCountMap(Map<String, String> countMap) {
                this.countMap = countMap;
            }
        }
    }
}
