package com.hiczp.bilibili.api.live.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayUrlEntity {
    /**
     * durl : [{"order":1,"length":0,"url":"http://live-play.acgvideo.com/live/241/live_2866663_332_c521e483.flv?wsSecret=562496ace51d8a998295656e7ef50a56&wsTime=59d68da4"}]
     * accept_quality : [4]
     * current_quality : 4
     */

    @SerializedName("current_quality")
    private int currentQuality;
    @SerializedName("durl")
    private List<DUrl> dUrl;
    @SerializedName("accept_quality")
    private List<Integer> acceptQuality;

    public int getCurrentQuality() {
        return currentQuality;
    }

    public void setCurrentQuality(int currentQuality) {
        this.currentQuality = currentQuality;
    }

    public List<DUrl> getdUrl() {
        return dUrl;
    }

    public void setdUrl(List<DUrl> dUrl) {
        this.dUrl = dUrl;
    }

    public List<Integer> getAcceptQuality() {
        return acceptQuality;
    }

    public void setAcceptQuality(List<Integer> acceptQuality) {
        this.acceptQuality = acceptQuality;
    }

    public static class DUrl {
        /**
         * order : 1
         * length : 0
         * url : http://live-play.acgvideo.com/live/241/live_2866663_332_c521e483.flv?wsSecret=562496ace51d8a998295656e7ef50a56&wsTime=59d68da4
         */

        @SerializedName("order")
        private int order;
        @SerializedName("length")
        private int length;
        @SerializedName("url")
        private String url;

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
