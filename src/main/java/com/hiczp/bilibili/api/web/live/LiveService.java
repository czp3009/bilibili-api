package com.hiczp.bilibili.api.web.live;

import com.hiczp.bilibili.api.web.live.entity.SendHeartBeatResponseEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LiveService {
    //直播间心跳包
    //参数为时间戳(不是 unix 时间戳)
    //未登录时返回 401
    @GET("feed/v1/feed/heartBeat")
    Call<SendHeartBeatResponseEntity> sendHeartBeat(@Query("_") long timestamp);

    default Call<SendHeartBeatResponseEntity> sendHeartBeat() {
        return sendHeartBeat(System.currentTimeMillis());
    }
}
