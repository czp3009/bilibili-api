package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.live.LiveService;
import com.hiczp.bilibili.api.passport.PassportService;

public interface BilibiliServiceProvider {
    PassportService getPassportService();

    LiveService getLiveService();
}
