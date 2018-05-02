package com.hiczp.bilibili.api.web;

public class BrowserProperties {
    private String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36";

    private BrowserProperties() {

    }

    public static BrowserProperties defaultSetting() {
        return new BrowserProperties();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public BrowserProperties setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }
}
