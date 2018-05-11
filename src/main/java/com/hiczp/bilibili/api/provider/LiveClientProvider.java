package com.hiczp.bilibili.api.provider;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import io.netty.channel.EventLoopGroup;

public interface LiveClientProvider {
    LiveClient getLiveClient(EventLoopGroup eventLoopGroup, long roomId, boolean isRealRoomId);

    default LiveClient getLiveClient(EventLoopGroup eventLoopGroup, long showRoomId) {
        return getLiveClient(eventLoopGroup, showRoomId, false);
    }
}
