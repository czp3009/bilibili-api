package com.hiczp.bilibili.api;

import java.util.Objects;

public class BilibiliClientProperties {
    private String appKey = "1d8b6e7d45233436";
    private String appSecret = "560c52ccd288fed045859ed18bffd973";
    private String hardwareId = "JxdyESFAJkcjEicQbBBsCTlbal5uX2Y";
    private String scale = "xxhdpi";
    private String version = "5.15.0.515000";
    private String build;
    private String buvId = "JxdyESFAJkcjEicQbBBsCTlbal5uX2Yinfoc";

    private BilibiliClientProperties() {
        generateBuildProperty();
    }

    public static BilibiliClientProperties defaultSetting() {
        return new BilibiliClientProperties();
    }

    private void generateBuildProperty() {
        this.build = version.substring(version.lastIndexOf(".") + 1);
    }

    public String getAppKey() {
        return appKey;
    }

    public BilibiliClientProperties setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public BilibiliClientProperties setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public BilibiliClientProperties setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
        return this;
    }

    public String getScale() {
        return scale;
    }

    public BilibiliClientProperties setScale(String scale) {
        this.scale = scale;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public BilibiliClientProperties setVersion(String version) {
        Objects.requireNonNull(version);
        this.version = version;
        generateBuildProperty();
        return this;
    }

    public String getBuild() {
        return build;
    }

    public String getBuvId() {
        return buvId;
    }

    public BilibiliClientProperties setBuvId(String buvId) {
        this.buvId = buvId;
        return this;
    }
}
