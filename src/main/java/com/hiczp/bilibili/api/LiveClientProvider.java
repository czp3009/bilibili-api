package com.hiczp.bilibili.api;

import com.hiczp.bilibili.api.live.socket.LiveClient;

public interface LiveClientProvider {
    LiveClient getLiveClient(long showRoomId);
}
