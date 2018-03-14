package com.hiczp.bilibili.api.web.live;

import com.hiczp.bilibili.api.web.live.entity.SendHeartBeatResponseEntity;
import com.hiczp.bilibili.api.web.live.entity.UserInfoEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LiveService {
    /**
     * 直播间心跳包
     *
     * @param timestamp 时间戳(不是 unix 时间戳)
     * @return 未登录时返回 401
     */
    @GET("feed/v1/feed/heartBeat")
    Call<SendHeartBeatResponseEntity> sendHeartBeat(@Query("_") long timestamp);

    default Call<SendHeartBeatResponseEntity> sendHeartBeat() {
        return sendHeartBeat(System.currentTimeMillis());
    }

    /**
     * 获取用户信息
     *
     * @param timestamp 成功时, code 为 "REPONSE_OK"
     * @return 未登录时返回 500
     */
    @GET("User/getUserInfo")
    Call<UserInfoEntity> getUserInfo(@Query("ts") long timestamp);

    default Call<UserInfoEntity> getUserInfo() {
        return getUserInfo(System.currentTimeMillis());
    }
}
