package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoverEntity {
    /**
     * code : 0
     * message : OK
     * msg : OK
     * data : {"cover":"https://i0.hdslb.com/bfs/live/b4d4dbf35f7a30fb6b0a2ea4077514235262797e.jpg","status":1,"reason":"","isup":0,"cover_list":[{"id":381657,"iscover":1,"cover":"https://i0.hdslb.com/bfs/live/b4d4dbf35f7a30fb6b0a2ea4077514235262797e.jpg","status":1,"reason":"","isup":1,"lock":0},{"id":0,"reason":"","cover":"","isup":0,"lock":1,"status":2,"iscover":0},{"id":0,"reason":"","cover":"","isup":0,"lock":1,"status":2,"iscover":0},{"id":0,"reason":"","cover":"","isup":0,"lock":1,"status":2,"iscover":0}]}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private Data data;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * cover : https://i0.hdslb.com/bfs/live/b4d4dbf35f7a30fb6b0a2ea4077514235262797e.jpg
         * status : 1
         * reason :
         * isup : 0
         * cover_list : [{"id":381657,"iscover":1,"cover":"https://i0.hdslb.com/bfs/live/b4d4dbf35f7a30fb6b0a2ea4077514235262797e.jpg","status":1,"reason":"","isup":1,"lock":0},{"id":0,"reason":"","cover":"","isup":0,"lock":1,"status":2,"iscover":0},{"id":0,"reason":"","cover":"","isup":0,"lock":1,"status":2,"iscover":0},{"id":0,"reason":"","cover":"","isup":0,"lock":1,"status":2,"iscover":0}]
         */

        @SerializedName("cover")
        private String cover;
        @SerializedName("status")
        private int status;
        @SerializedName("reason")
        private String reason;
        @SerializedName("isup")
        private int isup;
        @SerializedName("cover_list")
        private List<CoverList> coverList;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public int getIsup() {
            return isup;
        }

        public void setIsup(int isup) {
            this.isup = isup;
        }

        public List<CoverList> getCoverList() {
            return coverList;
        }

        public void setCoverList(List<CoverList> coverList) {
            this.coverList = coverList;
        }

        public static class CoverList {
            /**
             * id : 381657
             * iscover : 1
             * cover : https://i0.hdslb.com/bfs/live/b4d4dbf35f7a30fb6b0a2ea4077514235262797e.jpg
             * status : 1
             * reason :
             * isup : 1
             * lock : 0
             */

            @SerializedName("id")
            private int id;
            @SerializedName("iscover")
            private int iscover;
            @SerializedName("cover")
            private String cover;
            @SerializedName("status")
            private int status;
            @SerializedName("reason")
            private String reason;
            @SerializedName("isup")
            private int isup;
            @SerializedName("lock")
            private int lock;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIscover() {
                return iscover;
            }

            public void setIscover(int iscover) {
                this.iscover = iscover;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public int getIsup() {
                return isup;
            }

            public void setIsup(int isup) {
                this.isup = isup;
            }

            public int getLock() {
                return lock;
            }

            public void setLock(int lock) {
                this.lock = lock;
            }
        }
    }
}
