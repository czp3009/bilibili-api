package com.hiczp.bilibili.api.passport;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import javax.annotation.Nullable;

/**
 * sso 很特别, 它可能返回的是一个 HTML 页面, 所以单独分出来
 * sso 会经过两次 302 跳转, 需要保存其中的 cookie, 然后才能抵达最终页面并且进入 cookie 登录状态
 * 如果 gourl 为 null, 则会跳转到 B站 首页
 */
public interface SsoService {
    @GET("api/login/sso")
    Call<ResponseBody> sso(@Nullable @Query("gourl") String goUrl);
}
