package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ActivityGiftsEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : [{"id":102,"bag_id":48843715,"name":"秘银水壶","num":9,"img":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift-static-icon/gift-102.png?20171010161652","gift_url":"http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/3/102.gif?20171010161652","combo_num":5,"super_num":225,"count_set":"1,5,9","count_map":{"1":"","5":"连击","9":"全部"}}]
     */

    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private List<Data> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        /**
         * id : 102
         * bag_id : 48843715
         * name : 秘银水壶
         * num : 9
         * img : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift-static-icon/gift-102.png?20171010161652
         * gift_url : http://static.hdslb.com/live-static/live-room/images/gift-section/mobilegift/3/102.gif?20171010161652
         * combo_num : 5
         * super_num : 225
         * count_set : 1,5,9
         * count_map : {"1":"","5":"连击","9":"全部"}
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
        private String img;
        @SerializedName("gift_url")
        private String giftUrl;
        @SerializedName("combo_num")
        private int comboNum;
        @SerializedName("super_num")
        private int superNum;
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
