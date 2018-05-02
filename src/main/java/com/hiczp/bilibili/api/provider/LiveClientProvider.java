package com.hiczp.bilibili.api.provider;

import com.hiczp.bilibili.api.live.socket.LiveClient;
import io.netty.channel.EventLoopGroup;

public interface LiveClientProvider {
    LiveClient getLiveClient(EventLoopGroup eventLoopGroup, long showRoomId);
}
