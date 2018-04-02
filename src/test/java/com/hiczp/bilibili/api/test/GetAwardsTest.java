package com.hiczp.bilibili.api.test;

import com.hiczp.bilibili.api.BilibiliAPI;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;

import java.util.Collections;

public class GetAwardsTest {
    private static final BilibiliAPI BILIBILI_API = Config.getBilibiliAPI();

    @Test
    public void getAwards() throws Exception {
        BILIBILI_API
                .getLiveService(Collections.emptyList(), HttpLoggingInterceptor.Level.BODY)
                .getAwardRecords()
                .execute()
                .body();
    }
}
