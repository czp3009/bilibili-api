package com.hiczp.bilibili.api.live.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiveClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClient.class);

    private final long showRoomId;
    private final long userId;

    public LiveClient(long showRoomId) {
        this.showRoomId = showRoomId;
        this.userId = 0;
    }

    public LiveClient(long showRoomId, long userId) {
        this.showRoomId = showRoomId;
        this.userId = userId;
    }

    public LiveClient connect() {
        throw new UnsupportedOperationException();
    }
}
