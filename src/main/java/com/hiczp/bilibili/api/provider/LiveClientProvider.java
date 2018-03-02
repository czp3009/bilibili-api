package com.hiczp.bilibili.api.provider;

import com.hiczp.bilibili.api.live.socket.LiveClient;

public interface LiveClientProvider {
    LiveClient getLiveClient(long showRoomId);
}
