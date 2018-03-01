package com.hiczp.bilibili.api.passport;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.io.IOException;
import java.io.InputStream;

public interface CaptchaService {
    @GET("captcha")
    Call<ResponseBody> getCaptcha(@Header("Cookie") String cookies);

    default InputStream getCaptchaAsStream(String cookies) throws IOException {
        return getCaptcha(cookies)
                .execute()
                .body()
                .byteStream();
    }
}
