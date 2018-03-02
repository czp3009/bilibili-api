package com.hiczp.bilibili.api.web.cookie;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleCookieJar implements CookieJar {
    private Map<String, List<Cookie>> cookiesMap;

    public SimpleCookieJar() {
        cookiesMap = new HashMap<>();
    }

    public SimpleCookieJar(Map<String, List<Cookie>> cookiesMap) {
        this.cookiesMap = new HashMap<>(cookiesMap);
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookies.forEach(cookie -> {
            String domain = cookie.domain();
            List<Cookie> savedCookies = cookiesMap.get(domain);
            if (savedCookies == null) {
                savedCookies = new ArrayList<>();
                savedCookies.add(cookie);
                cookiesMap.put(domain, savedCookies);
            } else {
                for (Cookie savedCookie : savedCookies) {
                    if (savedCookie.name().equals(cookie.name())) {
                        savedCookies.remove(savedCookie);
                        break;
                    }
                }
                savedCookies.add(cookie);
            }
        });
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return getCookiesForHost(url.host());
    }

    public List<Cookie> getCookiesForHost(String host) {
        List<Cookie> cookieList = new ArrayList<>();
        cookiesMap.forEach((domain, cookies) -> {
            if (host.endsWith(domain)) {
                for (int i = cookies.size() - 1; i >= 0; i--) {
                    if (cookies.get(i).expiresAt() < System.currentTimeMillis()) {
                        cookies.remove(i);
                    }
                }
                cookieList.addAll(cookies);
            }
        });
        return cookieList;
    }

    public Map<String, List<Cookie>> getCookiesMap() {
        return cookiesMap;
    }
}
