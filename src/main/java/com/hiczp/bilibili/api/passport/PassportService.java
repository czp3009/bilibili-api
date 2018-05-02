package com.hiczp.bilibili.api.passport;

import com.hiczp.bilibili.api.passport.entity.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PassportService {
    /**
     * 获得公钥
     */
    @POST("api/oauth2/getKey")
    Call<KeyEntity> getKey();

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @POST("api/oauth2/login")
    Call<LoginResponseEntity> login(@Query("username") String username, @Query("password") String password);

    /**
     * 带验证码的登录
     * 在一段时间内进行多次错误的登录, 将被要求输入验证码
     *
     * @param username 用户名
     * @param password 密码
     * @param captcha  验证码
     * @param cookies  cookies
     * @see CaptchaService
     */
    @POST("api/oauth2/login")
    Call<LoginResponseEntity> login(@Query("username") String username, @Query("password") String password, @Query("captcha") String captcha, @Header("Cookie") String cookies);

    /**
     * 获得账户信息
     *
     * @param accessToken token
     */
    @GET("api/oauth2/info")
    Call<InfoEntity> getInfo(@Query("access_token") String accessToken);

    /**
     * 刷新 token
     *
     * @param accessToken  token
     * @param refreshToken refreshToken
     */
    @POST("api/oauth2/refreshToken")
    Call<RefreshTokenResponseEntity> refreshToken(@Query("access_token") String accessToken, @Query("refresh_token") String refreshToken);

    /**
     * 注销
     *
     * @param accessToken token
     */
    @POST("api/oauth2/revoke")
    Call<LogoutResponseEntity> logout(@Query("access_token") String accessToken);
}
