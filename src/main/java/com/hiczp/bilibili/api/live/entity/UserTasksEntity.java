package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserTasksEntity extends ResponseEntity {
    /**
     * code : 0
     * msg : success
     * message : success
     * data : {"share_info":{"task_id":"share_task","share_count":0,"progress":{"now":0,"max":1},"status":0,"awards":[{"name":"扭蛋币","type":"toycoin","num":5},{"name":"亲密度","type":"intimacy","num":10}]},"watch_info":{"task_id":"single_watch_task","status":0,"progress":{"now":0,"max":1},"awards":[{"name":"银瓜子","type":"silver","num":500}]},"double_watch_info":{"task_id":"double_watch_task","status":2,"web_watch":1,"mobile_watch":1,"progress":{"now":2,"max":2},"awards":[{"name":"银瓜子","type":"silver","num":700},{"name":"友爱金","type":"union_money","num":1000},{"name":"亲密度","type":"intimacy","num":20}]}}
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
         * share_info : {"task_id":"share_task","share_count":0,"progress":{"now":0,"max":1},"status":0,"awards":[{"name":"扭蛋币","type":"toycoin","num":5},{"name":"亲密度","type":"intimacy","num":10}]}
         * watch_info : {"task_id":"single_watch_task","status":0,"progress":{"now":0,"max":1},"awards":[{"name":"银瓜子","type":"silver","num":500}]}
         * double_watch_info : {"task_id":"double_watch_task","status":2,"web_watch":1,"mobile_watch":1,"progress":{"now":2,"max":2},"awards":[{"name":"银瓜子","type":"silver","num":700},{"name":"友爱金","type":"union_money","num":1000},{"name":"亲密度","type":"intimacy","num":20}]}
         */

        @SerializedName("share_info")
        private ShareInfo shareInfo;
        @SerializedName("watch_info")
        private WatchInfo watchInfo;
        @SerializedName("double_watch_info")
        private DoubleWatchInfo doubleWatchInfo;

        public ShareInfo getShareInfo() {
            return shareInfo;
        }

        public void setShareInfo(ShareInfo shareInfo) {
            this.shareInfo = shareInfo;
        }

        public WatchInfo getWatchInfo() {
            return watchInfo;
        }

        public void setWatchInfo(WatchInfo watchInfo) {
            this.watchInfo = watchInfo;
        }

        public DoubleWatchInfo getDoubleWatchInfo() {
            return doubleWatchInfo;
        }

        public void setDoubleWatchInfo(DoubleWatchInfo doubleWatchInfo) {
            this.doubleWatchInfo = doubleWatchInfo;
        }

        public static class ShareInfo {
            /**
             * task_id : share_task
             * share_count : 0
             * progress : {"now":0,"max":1}
             * status : 0
             * awards : [{"name":"扭蛋币","type":"toycoin","num":5},{"name":"亲密度","type":"intimacy","num":10}]
             */

            @SerializedName("task_id")
            private String taskId;
            @SerializedName("share_count")
            private int shareCount;
            @SerializedName("progress")
            private Progress progress;
            @SerializedName("status")
            private int status;
            @SerializedName("awards")
            private List<Award> awards;

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public Progress getProgress() {
                return progress;
            }

            public void setProgress(Progress progress) {
                this.progress = progress;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public List<Award> getAwards() {
                return awards;
            }

            public void setAwards(List<Award> awards) {
                this.awards = awards;
            }

            public static class Progress {
                /**
                 * now : 0
                 * max : 1
                 */

                @SerializedName("now")
                private int now;
                @SerializedName("max")
                private int max;

                public int getNow() {
                    return now;
                }

                public void setNow(int now) {
                    this.now = now;
                }

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }
            }

            public static class Award {
                /**
                 * name : 扭蛋币
                 * type : toycoin
                 * num : 5
                 */

                @SerializedName("name")
                private String name;
                @SerializedName("type")
                private String type;
                @SerializedName("num")
                private int number;

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

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }
            }
        }

        public static class WatchInfo {
            /**
             * task_id : single_watch_task
             * status : 0
             * progress : {"now":0,"max":1}
             * awards : [{"name":"银瓜子","type":"silver","num":500}]
             */

            @SerializedName("task_id")
            private String taskId;
            @SerializedName("status")
            private int status;
            @SerializedName("progress")
            private ProgressX progress;
            @SerializedName("awards")
            private List<AwardX> awards;

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public ProgressX getProgress() {
                return progress;
            }

            public void setProgress(ProgressX progress) {
                this.progress = progress;
            }

            public List<AwardX> getAwards() {
                return awards;
            }

            public void setAwards(List<AwardX> awards) {
                this.awards = awards;
            }

            public static class ProgressX {
                /**
                 * now : 0
                 * max : 1
                 */

                @SerializedName("now")
                private int now;
                @SerializedName("max")
                private int max;

                public int getNow() {
                    return now;
                }

                public void setNow(int now) {
                    this.now = now;
                }

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }
            }

            public static class AwardX {
                /**
                 * name : 银瓜子
                 * type : silver
                 * num : 500
                 */

                @SerializedName("name")
                private String name;
                @SerializedName("type")
                private String type;
                @SerializedName("num")
                private int number;

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

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }
            }
        }

        public static class DoubleWatchInfo {
            /**
             * task_id : double_watch_task
             * status : 2
             * web_watch : 1
             * mobile_watch : 1
             * progress : {"now":2,"max":2}
             * awards : [{"name":"银瓜子","type":"silver","num":700},{"name":"友爱金","type":"union_money","num":1000},{"name":"亲密度","type":"intimacy","num":20}]
             */

            @SerializedName("task_id")
            private String taskId;
            @SerializedName("status")
            private int status;
            @SerializedName("web_watch")
            private int webWatch;
            @SerializedName("mobile_watch")
            private int mobileWatch;
            @SerializedName("progress")
            private ProgressXX progress;
            @SerializedName("awards")
            private List<AwardXX> awards;

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getWebWatch() {
                return webWatch;
            }

            public void setWebWatch(int webWatch) {
                this.webWatch = webWatch;
            }

            public int getMobileWatch() {
                return mobileWatch;
            }

            public void setMobileWatch(int mobileWatch) {
                this.mobileWatch = mobileWatch;
            }

            public ProgressXX getProgress() {
                return progress;
            }

            public void setProgress(ProgressXX progress) {
                this.progress = progress;
            }

            public List<AwardXX> getAwards() {
                return awards;
            }

            public void setAwards(List<AwardXX> awards) {
                this.awards = awards;
            }

            public static class ProgressXX {
                /**
                 * now : 2
                 * max : 2
                 */

                @SerializedName("now")
                private int now;
                @SerializedName("max")
                private int max;

                public int getNow() {
                    return now;
                }

                public void setNow(int now) {
                    this.now = now;
                }

                public int getMax() {
                    return max;
                }

                public void setMax(int max) {
                    this.max = max;
                }
            }

            public static class AwardXX {
                /**
                 * name : 银瓜子
                 * type : silver
                 * num : 700
                 */

                @SerializedName("name")
                private String name;
                @SerializedName("type")
                private String type;
                @SerializedName("num")
                private int number;

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

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }
            }
        }
    }
}
