package com.hiczp.bilibili.api.provider;

import com.hiczp.bilibili.api.passport.SsoService;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface BilibiliSsoProvider {
    SsoService getSsoService(CookieJar cookieJar);

    //获取用于进行 sso 登录的初始 URL
    HttpUrl getSsoUrl(String goUrl);

    //获取当前 token 对应的 cookies
    Map<String, List<Cookie>> toCookies() throws IOException;
}
