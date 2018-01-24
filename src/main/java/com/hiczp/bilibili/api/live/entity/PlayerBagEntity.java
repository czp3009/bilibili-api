package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class PlayerBagEntity {
    /**
     * code : 0
     * message : ok
     * data : [{"id":49345439,"uid":20293030,"gift_id":1,"gift_num":2,"expireat":12797,"gift_type":0,"gift_name":"辣条","gift_price":"100 金瓜子/100 银瓜子","img":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift-static-icon/gift-1.png?20171010161652","count_set":"1,2","combo_num":99,"super_num":4500,"count_map":{"1":"","2":"全部"}},{"id":49318691,"uid":20293030,"gift_id":1,"gift_num":30,"expireat":531833,"gift_type":0,"gift_name":"辣条","gift_price":"100 金瓜子/100 银瓜子","img":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift-static-icon/gift-1.png?20171010161652","count_set":"1,10,30","combo_num":99,"super_num":4500,"count_map":{"1":"","30":"全部"}},{"id":48843715,"uid":20293030,"gift_id":102,"gift_num":9,"expireat":2482397,"gift_type":3,"gift_name":"秘银水壶","gift_price":"2000 金瓜子","img":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift-static-icon/gift-102.png?20171010161652","count_set":"1,5,9","combo_num":5,"super_num":225,"count_map":{"1":"","5":"连击","9":"全部"}}]
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<BagGiftEntity> data;

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

    public List<BagGiftEntity> getData() {
        return data;
    }

    public void setData(List<BagGiftEntity> data) {
        this.data = data;
    }

    public static class BagGiftEntity {
        /**
         * id : 49345439
         * uid : 20293030
         * gift_id : 1
         * gift_num : 2
         * expireat : 12797
         * gift_type : 0
         * gift_name : 辣条
         * gift_price : 100 金瓜子/100 银瓜子
         * img : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift-static-icon/gift-1.png?20171010161652
         * count_set : 1,2
         * combo_num : 99
         * super_num : 4500
         * count_map : {"1":"","2":"全部"}
         */

        @SerializedName("id")
        private long id;
        @SerializedName("uid")
        private long uid;
        @SerializedName("gift_id")
        private long giftId;
        @SerializedName("gift_num")
        private long giftNum;
        @SerializedName("expireat")
        private long expireat;
        @SerializedName("gift_type")
        private long giftType;
        @SerializedName("gift_name")
        private String giftName;
        @SerializedName("gift_price")
        private String giftPrice;
        @SerializedName("img")
        private String img;
        @SerializedName("count_set")
        private String countSet;
        @SerializedName("combo_num")
        private long comboNum;
        @SerializedName("super_num")
        private long superNum;
        @SerializedName("count_map")
        private Map<String, String> countMap;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getUid() {
            return uid;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public long getGiftId() {
            return giftId;
        }

        public void setGiftId(long giftId) {
            this.giftId = giftId;
        }

        public long getGiftNum() {
            return giftNum;
        }

        public void setGiftNum(long giftNum) {
            this.giftNum = giftNum;
        }

        public long getExpireat() {
            return expireat;
        }

        public void setExpireat(long expireat) {
            this.expireat = expireat;
        }

        public long getGiftType() {
            return giftType;
        }

        public void setGiftType(long giftType) {
            this.giftType = giftType;
        }

        public String getGiftName() {
            return giftName;
        }

        public void setGiftName(String giftName) {
            this.giftName = giftName;
        }

        public String getGiftPrice() {
            return giftPrice;
        }

        public void setGiftPrice(String giftPrice) {
            this.giftPrice = giftPrice;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getCountSet() {
            return countSet;
        }

        public void setCountSet(String countSet) {
            this.countSet = countSet;
        }

        public long getComboNum() {
            return comboNum;
        }

        public void setComboNum(long comboNum) {
            this.comboNum = comboNum;
        }

        public long getSuperNum() {
            return superNum;
        }

        public void setSuperNum(long superNum) {
            this.superNum = superNum;
        }

        public Map<String, String> getCountMap() {
            return countMap;
        }

        public void setCountMap(Map<String, String> countMap) {
            this.countMap = countMap;
        }
    }
}
