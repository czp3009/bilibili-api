package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppSmallTVEntity {
    /**
     * code : 0
     * msg : OK
     * message : OK
     * data : {"lastid":0,"join":[{"id":39674,"dtime":32}],"unjoin":[{"id":39674,"dtime":32}]}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * lastid : 0
         * join : [{"id":39674,"dtime":32}]
         * unjoin : [{"id":39674,"dtime":32}]
         */

        @SerializedName("lastid")
        private long lastid;
        @SerializedName("join")
        private List<Join> join;
        @SerializedName("unjoin")
        private List<Unjoin> unjoin;

        public long getLastid() {
            return lastid;
        }

        public void setLastid(long lastid) {
            this.lastid = lastid;
        }

        public List<Join> getJoin() {
            return join;
        }

        public void setJoin(List<Join> join) {
            this.join = join;
        }

        public List<Unjoin> getUnjoin() {
            return unjoin;
        }

        public void setUnjoin(List<Unjoin> unjoin) {
            this.unjoin = unjoin;
        }

        public static class Join {
            /**
             * id : 39674
             * dtime : 32
             */

            @SerializedName("id")
            private long id;
            @SerializedName("dtime")
            private int dtime;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getDtime() {
                return dtime;
            }

            public void setDtime(int dtime) {
                this.dtime = dtime;
            }
        }

        public static class Unjoin {
            /**
             * id : 39674
             * dtime : 32
             */

            @SerializedName("id")
            private long id;
            @SerializedName("dtime")
            private int dtime;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getDtime() {
                return dtime;
            }

            public void setDtime(int dtime) {
                this.dtime = dtime;
            }
        }
    }
}
