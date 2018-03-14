package com.hiczp.bilibili.api.passport;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import javax.annotation.Nullable;

/**
 * sso 很特别, 它可能返回的是一个 HTML 页面, 所以单独分出来
 * sso 会经过两次 302 跳转, 需要保存其中的 cookie, 然后才能抵达最终页面并且进入 cookie 登录状态
 */
public interface SsoService {
    /**
     * 通过 token 得到 cookie
     *
     * @param goUrl 全部的跳转完成后, 会进入指定的 URL, 如果 goUrl 为 null, 则跳转到 B站 首页
     * @return 最终跳转完成后的页面
     */
    @GET("api/login/sso")
    Call<ResponseBody> sso(@Nullable @Query("gourl") String goUrl);
}
