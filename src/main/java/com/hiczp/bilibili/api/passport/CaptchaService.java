package com.hiczp.bilibili.api.passport;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.io.IOException;
import java.io.InputStream;

public interface CaptchaService {
    /**
     * 获得验证码(图形)
     *
     * @param cookies 请求时使用的 cookies 与返回的验证码是配对的
     * @return 返回一张 PNG
     */
    @GET("captcha")
    Call<ResponseBody> getCaptcha(@Header("Cookie") String cookies);

    /**
     * 以流的形式获得验证码
     *
     * @param cookies 请求时使用的 cookies 与返回的验证码是配对的
     * @return 一张 PNG 图片的输入流
     * @throws IOException 网络错误
     */
    default InputStream getCaptchaAsStream(String cookies) throws IOException {
        return getCaptcha(cookies)
                .execute()
                .body()
                .byteStream();
    }
}
