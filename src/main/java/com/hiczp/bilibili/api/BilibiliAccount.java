package com.hiczp.bilibili.api;

public class BilibiliAccount implements BilibiliSecurityContext {
    private String accessToken;
    private String refreshToken;
    private Long userId;
    private Long expirationTime;
    private Long loginTime;

    private BilibiliAccount() {

    }

    public BilibiliAccount(String accessToken, String refreshToken, long userId, long expirationTime, long loginTime) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userId = userId;
        this.expirationTime = expirationTime;
        this.loginTime = loginTime;
    }

    public BilibiliAccount(BilibiliAccount bilibiliAccount) {
        copyFrom(bilibiliAccount);
    }

    public static BilibiliAccount emptyInstance() {
        return new BilibiliAccount();
    }

    public BilibiliAccount copyFrom(BilibiliAccount bilibiliAccount) {
        this.accessToken = bilibiliAccount.accessToken;
        this.refreshToken = bilibiliAccount.refreshToken;
        this.userId = bilibiliAccount.userId;
        this.expirationTime = bilibiliAccount.expirationTime;
        this.loginTime = bilibiliAccount.loginTime;
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
