package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AreaListEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : [{"id":"56","parent_id":"2","old_area_id":"1","name":"我的世界","act_id":"0"},{"id":"57","parent_id":"2","old_area_id":"1","name":"以撒","act_id":"0"},{"id":"64","parent_id":"2","old_area_id":"1","name":"饥荒","act_id":"0"},{"id":"65","parent_id":"2","old_area_id":"1","name":"彩虹六号","act_id":"0"},{"id":"78","parent_id":"2","old_area_id":"3","name":"DNF","act_id":"0"},{"id":"80","parent_id":"2","old_area_id":"1","name":"绝地求生：大逃杀","act_id":"0"},{"id":"81","parent_id":"2","old_area_id":"3","name":"三国杀","act_id":"0"},{"id":"82","parent_id":"2","old_area_id":"3","name":"剑网3","act_id":"0"},{"id":"83","parent_id":"2","old_area_id":"3","name":"魔兽世界","act_id":"0"},{"id":"84","parent_id":"2","old_area_id":"3","name":"300英雄","act_id":"0"},{"id":"86","parent_id":"2","old_area_id":"4","name":"英雄联盟","act_id":"0"},{"id":"87","parent_id":"2","old_area_id":"3","name":"守望先锋","act_id":"0"},{"id":"88","parent_id":"2","old_area_id":"4","name":"穿越火线","act_id":"0"},{"id":"89","parent_id":"2","old_area_id":"4","name":"CS：GO","act_id":"0"},{"id":"90","parent_id":"2","old_area_id":"4","name":"CS","act_id":"0"},{"id":"91","parent_id":"2","old_area_id":"3","name":"炉石传说","act_id":"0"},{"id":"92","parent_id":"2","old_area_id":"4","name":"DOTA2","act_id":"0"},{"id":"93","parent_id":"2","old_area_id":"4","name":"星际争霸2","act_id":"0"},{"id":"102","parent_id":"2","old_area_id":"3","name":"最终幻想14","act_id":"0"},{"id":"112","parent_id":"2","old_area_id":"3","name":"龙之谷","act_id":"0"},{"id":"114","parent_id":"2","old_area_id":"4","name":"风暴英雄","act_id":"0"},{"id":"115","parent_id":"2","old_area_id":"3","name":"坦克世界","act_id":"0"},{"id":"138","parent_id":"2","old_area_id":"1","name":"超级马里奥奥德赛","act_id":"0"},{"id":"147","parent_id":"2","old_area_id":"1","name":"怪物猎人：世界","act_id":"0"},{"id":"107","parent_id":"2","old_area_id":"1","name":"其他游戏","act_id":"0"}]
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
         * id : 56
         * parent_id : 2
         * old_area_id : 1
         * name : 我的世界
         * act_id : 0
         */

        @SerializedName("id")
        private String id;
        @SerializedName("parent_id")
        private String parentId;
        @SerializedName("old_area_id")
        private String oldAreaId;
        @SerializedName("name")
        private String name;
        @SerializedName("act_id")
        private String actId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getOldAreaId() {
            return oldAreaId;
        }

        public void setOldAreaId(String oldAreaId) {
            this.oldAreaId = oldAreaId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getActId() {
            return actId;
        }

        public void setActId(String actId) {
            this.actId = actId;
        }
    }
}
