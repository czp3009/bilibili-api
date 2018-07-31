package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AwardsEntity extends ResponseEntity {
    /**
     * code : 0
     * message : OK
     * data : {"list":[{"id":100000,"uid":1000000,"gift_name":"小电视","gift_type":"2","gift_num":1,"user_name":"打码","user_phone":"打码","user_address":"打码","user_extra_field":"{\"user_area\":\"打码\",\"user_post_code\":\"打码\",\"user_city\":\"打码\",\"user_province\":\"打码\"}","source":"小电视抽奖","source_id":10000,"create_time":"2018-02-01 00:00:00","update_time":null,"expire_time":"2018-02-16 00:00:00","comment":null,"status":0,"expire":true,"finished":true},{"id":10000,"uid":1000000,"gift_name":"小米Max2手机","gift_type":"2","gift_num":1,"user_name":"打码","user_phone":"打码","user_address":"打码","user_extra_field":"{\"user_province\":\"\\u6253\\u7801\",\"user_city\":\"\\u6253\\u7801\",\"user_area\":\"\\u6253\\u7801\",\"user_post_code\":\"打码\"}","source":"小米Max2超耐久直播第二季","source_id":1,"create_time":"2017-06-01 00:00:00","update_time":"2017-06-01 00:00:00","expire_time":"2017-06-30 00:00:00","comment":null,"status":0,"expire":true,"finished":true}],"use_count":0,"count":2}
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
         * list : [{"id":100000,"uid":1000000,"gift_name":"小电视","gift_type":"2","gift_num":1,"user_name":"打码","user_phone":"打码","user_address":"打码","user_extra_field":"{\"user_area\":\"打码\",\"user_post_code\":\"打码\",\"user_city\":\"打码\",\"user_province\":\"打码\"}","source":"小电视抽奖","source_id":10000,"create_time":"2018-02-01 00:00:00","update_time":null,"expire_time":"2018-02-16 00:00:00","comment":null,"status":0,"expire":true,"finished":true},{"id":10000,"uid":1000000,"gift_name":"小米Max2手机","gift_type":"2","gift_num":1,"user_name":"打码","user_phone":"打码","user_address":"打码","user_extra_field":"{\"user_province\":\"\\u6253\\u7801\",\"user_city\":\"\\u6253\\u7801\",\"user_area\":\"\\u6253\\u7801\",\"user_post_code\":\"打码\"}","source":"小米Max2超耐久直播第二季","source_id":1,"create_time":"2017-06-01 00:00:00","update_time":"2017-06-01 00:00:00","expire_time":"2017-06-30 00:00:00","comment":null,"status":0,"expire":true,"finished":true}]
         * use_count : 0
         * count : 2
         */

        @SerializedName("use_count")
        private int useCount;
        @SerializedName("count")
        private int count;
        @SerializedName("list")
        private List<Award> awardList;

        public int getUseCount() {
            return useCount;
        }

        public void setUseCount(int useCount) {
            this.useCount = useCount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<Award> getAwardList() {
            return awardList;
        }

        public void setAwardList(List<Award> awardList) {
            this.awardList = awardList;
        }

        public static class Award {
            /**
             * id : 100000
             * uid : 1000000
             * gift_name : 小电视
             * gift_type : 2
             * gift_num : 1
             * user_name : 打码
             * user_phone : 打码
             * user_address : 打码
             * user_extra_field : {"user_area":"打码","user_post_code":"打码","user_city":"打码","user_province":"打码"}
             * source : 小电视抽奖
             * source_id : 10000
             * create_time : 2018-02-01 00:00:00
             * update_time : null
             * expire_time : 2018-02-16 00:00:00
             * comment : null
             * status : 0
             * expire : true
             * finished : true
             */

            @SerializedName("id")
            private int id;
            @SerializedName("uid")
            private long userId;
            @SerializedName("gift_name")
            private String giftName;
            @SerializedName("gift_type")
            private String giftType;
            @SerializedName("gift_num")
            private int giftNum;
            @SerializedName("user_name")
            private String userName;
            @SerializedName("user_phone")
            private String userPhone;
            @SerializedName("user_address")
            private String userAddress;
            @SerializedName("user_extra_field")
            private String userExtraField;
            @SerializedName("source")
            private String source;
            @SerializedName("source_id")
            private int sourceId;
            @SerializedName("create_time")
            private String createTime;
            @SerializedName("update_time")
            private Object updateTime;
            @SerializedName("expire_time")
            private String expireTime;
            @SerializedName("comment")
            private Object comment;
            @SerializedName("status")
            private int status;
            @SerializedName("expire")
            private boolean expire;
            @SerializedName("finished")
            private boolean finished;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public String getGiftName() {
                return giftName;
            }

            public void setGiftName(String giftName) {
                this.giftName = giftName;
            }

            public String getGiftType() {
                return giftType;
            }

            public void setGiftType(String giftType) {
                this.giftType = giftType;
            }

            public int getGiftNum() {
                return giftNum;
            }

            public void setGiftNum(int giftNum) {
                this.giftNum = giftNum;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserAddress() {
                return userAddress;
            }

            public void setUserAddress(String userAddress) {
                this.userAddress = userAddress;
            }

            public String getUserExtraField() {
                return userExtraField;
            }

            public void setUserExtraField(String userExtraField) {
                this.userExtraField = userExtraField;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getSourceId() {
                return sourceId;
            }

            public void setSourceId(int sourceId) {
                this.sourceId = sourceId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public String getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(String expireTime) {
                this.expireTime = expireTime;
            }

            public Object getComment() {
                return comment;
            }

            public void setComment(Object comment) {
                this.comment = comment;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public boolean isExpire() {
                return expire;
            }

            public void setExpire(boolean expire) {
                this.expire = expire;
            }

            public boolean isFinished() {
                return finished;
            }

            public void setFinished(boolean finished) {
                this.finished = finished;
            }
        }
    }
}
