package com.hiczp.bilibili.api.provider;

import com.hiczp.bilibili.api.web.BilibiliWebAPI;

import java.io.IOException;

public interface BilibiliWebAPIProvider {
    BilibiliWebAPI getBilibiliWebAPI() throws IOException;
}
