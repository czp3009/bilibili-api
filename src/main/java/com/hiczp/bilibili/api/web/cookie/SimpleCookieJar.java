package com.hiczp.bilibili.api.web.cookie;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SimpleCookieJar implements CookieJar {
    private final Map<String, List<Cookie>> cookiesMap;

    public SimpleCookieJar() {
        cookiesMap = new ConcurrentHashMap<>();
    }

    public SimpleCookieJar(@Nonnull Map<String, List<Cookie>> cookiesMap) {
        this();
        cookiesMap.forEach((domain, cookies) ->
                this.cookiesMap.put(domain, new Vector<>(cookies))
        );
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookies.forEach(cookie -> {
            String domain = cookie.domain();
            List<Cookie> savedCookies;
            synchronized (cookiesMap) {
                savedCookies = cookiesMap.get(domain);
                if (savedCookies == null) {
                    savedCookies = new Vector<>();
                    savedCookies.add(cookie);
                    cookiesMap.put(domain, savedCookies);
                    return;
                }
            }
            for (int i = savedCookies.size() - 1; i >= 0; i--) {
                Cookie current = savedCookies.get(i);
                if (current.name().equals(cookie.name())) {
                    savedCookies.remove(current);
                }
            }
            savedCookies.add(cookie);
        });
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return getCookiesForHost(url.host());
    }

    public List<Cookie> getCookiesForHost(@Nonnull String host) {
        List<Cookie> cookieList = new ArrayList<>();
        cookiesMap.forEach((domain, cookies) -> {
            if (host.endsWith(domain)) {
                //移除过期的 cookies
                for (int i = cookies.size() - 1; i >= 0; i--) {
                    Cookie current = cookies.get(i);
                    if (current.expiresAt() < System.currentTimeMillis()) {
                        cookies.remove(current);
                    }
                }
                cookieList.addAll(cookies);
            }
        });
        return cookieList;
    }

    public String getCookiesStringForHost(String host) {
        return getCookiesForHost(host).stream()
                .map(cookie -> String.format("%s=%s", cookie.name(), cookie.value()))
                .collect(Collectors.joining(";"));
    }

    public Map<String, List<Cookie>> getCookiesMap() {
        return cookiesMap;
    }
}
