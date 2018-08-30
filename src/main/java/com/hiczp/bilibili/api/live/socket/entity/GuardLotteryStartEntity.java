package com.hiczp.bilibili.api.live.socket.entity;

import com.google.gson.annotations.SerializedName;

public class GuardLotteryStartEntity implements DataEntity {
    /**
     * cmd : GUARD_LOTTERY_START
     * data : {"id":396410,"roomid":56998,"message":"ちゆき蝙蝠公主 在【56998】购买了舰长，请前往抽奖","type":"guard","privilege_type":3,"link":"https://live.bilibili.com/56998","lottery":{"id":396410,"sender":{"uid":11206312,"uname":"ちゆき蝙蝠公主","face":"http://i0.hdslb.com/bfs/face/06d0d58131100acf13d75d3c092b1a58d41b0129.jpg"},"keyword":"guard","time":1200,"status":1,"mobile_display_mode":2,"mobile_static_asset":"","mobile_animation_asset":""}}
     */

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("data")
    private Data data;

    @Override
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * id : 396410
         * roomid : 56998
         * message : ちゆき蝙蝠公主 在【56998】购买了舰长，请前往抽奖
         * type : guard
         * privilege_type : 3
         * link : https://live.bilibili.com/56998
         * lottery : {"id":396410,"sender":{"uid":11206312,"uname":"ちゆき蝙蝠公主","face":"http://i0.hdslb.com/bfs/face/06d0d58131100acf13d75d3c092b1a58d41b0129.jpg"},"keyword":"guard","time":1200,"status":1,"mobile_display_mode":2,"mobile_static_asset":"","mobile_animation_asset":""}
         */

        @SerializedName("id")
        private long id;
        @SerializedName("roomid")
        private long roomId;
        @SerializedName("message")
        private String message;
        @SerializedName("type")
        private String type;
        @SerializedName("privilege_type")
        private int privilegeType;
        @SerializedName("link")
        private String link;
        @SerializedName("lottery")
        private Lottery lottery;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getPrivilegeType() {
            return privilegeType;
        }

        public void setPrivilegeType(int privilegeType) {
            this.privilegeType = privilegeType;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Lottery getLottery() {
            return lottery;
        }

        public void setLottery(Lottery lottery) {
            this.lottery = lottery;
        }

        public static class Lottery {
            /**
             * id : 396410
             * sender : {"uid":11206312,"uname":"ちゆき蝙蝠公主","face":"http://i0.hdslb.com/bfs/face/06d0d58131100acf13d75d3c092b1a58d41b0129.jpg"}
             * keyword : guard
             * time : 1200
             * status : 1
             * mobile_display_mode : 2
             * mobile_static_asset :
             * mobile_animation_asset :
             */

            @SerializedName("id")
            private long id;
            @SerializedName("sender")
            private Sender sender;
            @SerializedName("keyword")
            private String keyword;
            @SerializedName("time")
            private int time;
            @SerializedName("status")
            private int status;
            @SerializedName("mobile_display_mode")
            private int mobileDisplayMode;
            @SerializedName("mobile_static_asset")
            private String mobileStaticAsset;
            @SerializedName("mobile_animation_asset")
            private String mobileAnimationAsset;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public Sender getSender() {
                return sender;
            }

            public void setSender(Sender sender) {
                this.sender = sender;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getMobileDisplayMode() {
                return mobileDisplayMode;
            }

            public void setMobileDisplayMode(int mobileDisplayMode) {
                this.mobileDisplayMode = mobileDisplayMode;
            }

            public String getMobileStaticAsset() {
                return mobileStaticAsset;
            }

            public void setMobileStaticAsset(String mobileStaticAsset) {
                this.mobileStaticAsset = mobileStaticAsset;
            }

            public String getMobileAnimationAsset() {
                return mobileAnimationAsset;
            }

            public void setMobileAnimationAsset(String mobileAnimationAsset) {
                this.mobileAnimationAsset = mobileAnimationAsset;
            }

            public static class Sender {
                /**
                 * uid : 11206312
                 * uname : ちゆき蝙蝠公主
                 * face : http://i0.hdslb.com/bfs/face/06d0d58131100acf13d75d3c092b1a58d41b0129.jpg
                 */

                @SerializedName("uid")
                private long userId;
                @SerializedName("uname")
                private String userName;
                @SerializedName("face")
                private String face;

                public long getUserId() {
                    return userId;
                }

                public void setUserId(long userId) {
                    this.userId = userId;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }
            }
        }
    }
}
