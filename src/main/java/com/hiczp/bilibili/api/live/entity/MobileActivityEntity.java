package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

public class MobileActivityEntity extends ResponseEntity {
    /**
     * code : 0
     * msg :
     * message :
     * data : {"activity":{"keyword":"lover_2018","icon_web":"","jump_web":"","icon_mobile":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/activity/lover_2018/mobile.png","jump_mobile":"https://live.bilibili.com/blackboard/hour-rank.html#/?1110317","status":1},"task":{"keyword":"task_2017","icon_web":"//i0.hdslb.com/bfs/live/b86792f129a641d8fd4f1ee4a337fcb9d4eac25c.png","jump_web":"//link.bilibili.com/p/center/index#/user-center/achievement/task","jump_mobile":"https://live.bilibili.com/p/eden/task-h5#/","icon_mobile":"https://i0.hdslb.com/bfs/live/61f1b388c1f4ed2838800a4d928dae5ab03d7c44.png","status":0}}
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
         * activity : {"keyword":"lover_2018","icon_web":"","jump_web":"","icon_mobile":"https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/activity/lover_2018/mobile.png","jump_mobile":"https://live.bilibili.com/blackboard/hour-rank.html#/?1110317","status":1}
         * task : {"keyword":"task_2017","icon_web":"//i0.hdslb.com/bfs/live/b86792f129a641d8fd4f1ee4a337fcb9d4eac25c.png","jump_web":"//link.bilibili.com/p/center/index#/user-center/achievement/task","jump_mobile":"https://live.bilibili.com/p/eden/task-h5#/","icon_mobile":"https://i0.hdslb.com/bfs/live/61f1b388c1f4ed2838800a4d928dae5ab03d7c44.png","status":0}
         */

        @SerializedName("activity")
        private Activity activity;
        @SerializedName("task")
        private Task task;

        public Activity getActivity() {
            return activity;
        }

        public void setActivity(Activity activity) {
            this.activity = activity;
        }

        public Task getTask() {
            return task;
        }

        public void setTask(Task task) {
            this.task = task;
        }

        public static class Activity {
            /**
             * keyword : lover_2018
             * icon_web :
             * jump_web :
             * icon_mobile : https://s1.hdslb.com/bfs/static/blive/live-assets/mobile/activity/lover_2018/mobile.png
             * jump_mobile : https://live.bilibili.com/blackboard/hour-rank.html#/?1110317
             * status : 1
             */

            @SerializedName("keyword")
            private String keyword;
            @SerializedName("icon_web")
            private String iconWeb;
            @SerializedName("jump_web")
            private String jumpWeb;
            @SerializedName("icon_mobile")
            private String iconMobile;
            @SerializedName("jump_mobile")
            private String jumpMobile;
            @SerializedName("status")
            private int status;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getIconWeb() {
                return iconWeb;
            }

            public void setIconWeb(String iconWeb) {
                this.iconWeb = iconWeb;
            }

            public String getJumpWeb() {
                return jumpWeb;
            }

            public void setJumpWeb(String jumpWeb) {
                this.jumpWeb = jumpWeb;
            }

            public String getIconMobile() {
                return iconMobile;
            }

            public void setIconMobile(String iconMobile) {
                this.iconMobile = iconMobile;
            }

            public String getJumpMobile() {
                return jumpMobile;
            }

            public void setJumpMobile(String jumpMobile) {
                this.jumpMobile = jumpMobile;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class Task {
            /**
             * keyword : task_2017
             * icon_web : //i0.hdslb.com/bfs/live/b86792f129a641d8fd4f1ee4a337fcb9d4eac25c.png
             * jump_web : //link.bilibili.com/p/center/index#/user-center/achievement/task
             * jump_mobile : https://live.bilibili.com/p/eden/task-h5#/
             * icon_mobile : https://i0.hdslb.com/bfs/live/61f1b388c1f4ed2838800a4d928dae5ab03d7c44.png
             * status : 0
             */

            @SerializedName("keyword")
            private String keyword;
            @SerializedName("icon_web")
            private String iconWeb;
            @SerializedName("jump_web")
            private String jumpWeb;
            @SerializedName("jump_mobile")
            private String jumpMobile;
            @SerializedName("icon_mobile")
            private String iconMobile;
            @SerializedName("status")
            private int status;

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public String getIconWeb() {
                return iconWeb;
            }

            public void setIconWeb(String iconWeb) {
                this.iconWeb = iconWeb;
            }

            public String getJumpWeb() {
                return jumpWeb;
            }

            public void setJumpWeb(String jumpWeb) {
                this.jumpWeb = jumpWeb;
            }

            public String getJumpMobile() {
                return jumpMobile;
            }

            public void setJumpMobile(String jumpMobile) {
                this.jumpMobile = jumpMobile;
            }

            public String getIconMobile() {
                return iconMobile;
            }

            public void setIconMobile(String iconMobile) {
                this.iconMobile = iconMobile;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
