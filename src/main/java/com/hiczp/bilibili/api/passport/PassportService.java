package com.hiczp.bilibili.api.passport;

import com.hiczp.bilibili.api.passport.entity.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PassportService {
    @POST("api/oauth2/getKey")
    Call<KeyEntity> getKey();

    @POST("api/oauth2/login")
    Call<LoginResponseEntity> login(@Query("username") String username, @Query("password") String password);

    //在一段时间内进行多次错误的登录, 将被要求输入验证码
    //TODO 尚不明确 captcha 是如何工作的
    @Deprecated
    @POST("api/oauth2/login")
    Call<LoginResponseEntity> loginWithCaptcha(@Query("username") String username, @Query("password") String password, @Query("captcha") String captcha);

    @GET("api/oauth2/info")
    Call<InfoEntity> getInfo(@Query("access_token") String accessToken);

    @POST("api/oauth2/refreshToken")
    Call<RefreshTokenResponseEntity> refreshToken(@Query("access_token") String accessToken, @Query("refresh_token") String refreshToken);

    @POST("api/oauth2/revoke")
    Call<LogoutResponseEntity> logout(@Query("access_token") String accessToken);

    //TODO sso 尚不明确
    @Deprecated
    @GET("api/login/sso")
    Call sso(@Query("access_token") String accessToken, @Query("gourl") String goUrl);
}
