package com.hiczp.bilibili.api;

public interface BilibiliSecurityContext {
    String getAccessToken();

    String getRefreshToken();

    Long getUserId();

    Long getExpirationTime();

    Long getLoginTime();
}
