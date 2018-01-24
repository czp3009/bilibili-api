package com.hiczp.bilibili.api.live.socket;

import com.google.common.eventbus.EventBus;
import com.hiczp.bilibili.api.BilibiliServiceProvider;
import com.hiczp.bilibili.api.live.entity.LiveRoomInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

public class LiveClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClient.class);

    private final EventBus eventBus = new EventBus("BilibiliLiveClient");
    private final BilibiliServiceProvider bilibiliServiceProvider;
    private final long showRoomId;
    private final long userId;

    private LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity;

    public LiveClient(BilibiliServiceProvider bilibiliServiceProvider, long showRoomId) {
        this.bilibiliServiceProvider = bilibiliServiceProvider;
        this.showRoomId = showRoomId;
        this.userId = 0;
    }

    public LiveClient(BilibiliServiceProvider bilibiliServiceProvider, long showRoomId, long userId) {
        this.bilibiliServiceProvider = bilibiliServiceProvider;
        this.showRoomId = showRoomId;
        this.userId = userId;
    }

    private void fetchRoomInfo() throws IOException {
        liveRoomEntity = bilibiliServiceProvider.getLiveService()
                .getRoomInfo(showRoomId)
                .execute()
                .body()
                .getData();
    }

    public LiveClient connect() throws IOException {
        LOGGER.info("Try to fetch info of live room {}", showRoomId);
        fetchRoomInfo();
        LOGGER.info("Get actual room id {}", liveRoomEntity.getRoomId());

        LOGGER.debug("Init NioEventLoop");

        throw new UnsupportedOperationException();
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public long getShowRoomId() {
        return showRoomId;
    }

    public long getUserId() {
        return userId;
    }

    public Optional<LiveRoomInfoEntity.LiveRoomEntity> getLiveRoomEntity() {
        return Optional.of(liveRoomEntity);
    }
}
