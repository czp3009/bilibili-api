package com.hiczp.bilibili.api;

public class BilibiliAccount implements BilibiliSecurityContext {
    private String accessToken;
    private String refreshToken;
    private Long userId;
    private Long expirationTime;
    private Long loginTime;

    private BilibiliAccount() {

    }

    public BilibiliAccount(String accessToken, String refreshToken, Long userId, Long expirationTime, Long loginTime) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userId = userId;
        this.expirationTime = expirationTime;
        this.loginTime = loginTime;
    }

    public BilibiliAccount(BilibiliSecurityContext bilibiliSecurityContext) {
        copyFrom(bilibiliSecurityContext);
    }

    public static BilibiliAccount emptyInstance() {
        return new BilibiliAccount();
    }

    public BilibiliAccount copyFrom(BilibiliSecurityContext bilibiliSecurityContext) {
        this.accessToken = bilibiliSecurityContext.getAccessToken();
        this.refreshToken = bilibiliSecurityContext.getRefreshToken();
        this.userId = bilibiliSecurityContext.getUserId();
        this.expirationTime = bilibiliSecurityContext.getExpirationTime();
        this.loginTime = bilibiliSecurityContext.getLoginTime();
        return this;
    }

    public BilibiliAccount reset() {
        this.accessToken = null;
        this.refreshToken = null;
        this.userId = null;
        this.expirationTime = null;
        this.loginTime = null;
        return this;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    public BilibiliAccount setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    @Override
    public String getRefreshToken() {
        return refreshToken;
    }

    public BilibiliAccount setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    public BilibiliAccount setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public Long getExpirationTime() {
        return expirationTime;
    }

    public BilibiliAccount setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }

    @Override
    public Long getLoginTime() {
        return loginTime;
    }

    public BilibiliAccount setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
        return this;
    }
}
