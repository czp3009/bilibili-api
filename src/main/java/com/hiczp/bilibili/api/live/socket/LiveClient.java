package com.hiczp.bilibili.api.live.socket;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.hiczp.bilibili.api.BilibiliServiceProvider;
import com.hiczp.bilibili.api.live.entity.BulletScreenEntity;
import com.hiczp.bilibili.api.live.entity.LiveRoomInfoEntity;
import com.hiczp.bilibili.api.live.entity.SendBulletScreenResponseEntity;
import com.hiczp.bilibili.api.live.socket.codec.PackageDecoder;
import com.hiczp.bilibili.api.live.socket.codec.PackageEncoder;
import com.hiczp.bilibili.api.live.socket.event.ConnectionCloseEvent;
import com.hiczp.bilibili.api.live.socket.handler.LiveClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Optional;

public class LiveClient implements Closeable {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClient.class);

    private final EventBus eventBus = new EventBus("BilibiliLiveClient");
    private final BilibiliServiceProvider bilibiliServiceProvider;
    private final long showRoomId;
    private final long userId;

    private LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity;

    private EventLoopGroup eventLoopGroup;
    private Channel channel;

    private void initEventBus() {
        eventBus.register(new ConnectionCloseListener());
    }

    public LiveClient(BilibiliServiceProvider bilibiliServiceProvider, long showRoomId) {
        this.bilibiliServiceProvider = bilibiliServiceProvider;
        this.showRoomId = showRoomId;
        this.userId = 0;
        initEventBus();
    }

    public LiveClient(BilibiliServiceProvider bilibiliServiceProvider, long showRoomId, long userId) {
        this.bilibiliServiceProvider = bilibiliServiceProvider;
        this.showRoomId = showRoomId;
        this.userId = userId;
        initEventBus();
    }

    public synchronized LiveClient connect() throws IOException {
        if (channel != null && channel.isActive()) {
            LOGGER.warn("Already connected to server, connect method can not be invoked twice");
            return this;
        }

        if (eventLoopGroup != null) {
            eventLoopGroup.shutdownGracefully();
        }

        LOGGER.info("Fetching info of live room {}", showRoomId);
        liveRoomEntity = bilibiliServiceProvider.getLiveService()
                .getRoomInfo(showRoomId)
                .execute()
                .body()
                .getData();
        long roomId = liveRoomEntity.getRoomId();
        LOGGER.info("Get actual room id {}", roomId);

        eventLoopGroup = new NioEventLoopGroup(1);
        LOGGER.debug("Init SocketChannel Bootstrap");
        Bootstrap bootstrap = new Bootstrap()
                .group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new LengthFieldBasedFrameDecoder(
                                        Integer.MAX_VALUE,
                                        0,
                                        Package.LENGTH_FIELD_LENGTH,
                                        -Package.LENGTH_FIELD_LENGTH,
                                        0
                                ))
                                .addLast(new IdleStateHandler(40, 0, 0))
                                .addLast(new PackageEncoder())
                                .addLast(new PackageDecoder())
                                .addLast(new LiveClientHandler(roomId, userId, eventBus));
                    }
                });

        String address = liveRoomEntity.getCmt();
        int port = liveRoomEntity.getCmtPortGoim();
        LOGGER.info("Connecting to Bullet Screen server {}:{}", address, port);
        try {
            channel = bootstrap.connect(address, port)
                    .sync()
                    .channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
            close();
        } catch (Exception e) { //有可能在此时出现网络错误
            close();
            throw new IOException(e);
        }

        return this;
    }

    @Override
    public synchronized void close() {
        if (eventLoopGroup != null) {
            LOGGER.info("Closing connection");
            try {
                eventLoopGroup.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            eventLoopGroup = null;
        }
    }

    private class ConnectionCloseListener {
        @Subscribe
        public void onConnectionClose(ConnectionCloseEvent connectionCloseEvent) {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public LiveClient registerListener(Object object) {
        eventBus.register(object);
        return this;
    }

    public LiveClient unregisterListeners(Object object) {
        eventBus.unregister(object);
        return this;
    }

    public SendBulletScreenResponseEntity sendBulletScreen(String message) throws IOException {
        return sendBulletScreen(
                new BulletScreenEntity(
                        liveRoomEntity != null ? liveRoomEntity.getRoomId() : showRoomId,
                        userId,
                        message
                )
        );
    }

    public SendBulletScreenResponseEntity sendBulletScreen(BulletScreenEntity bulletScreenEntity) throws IOException {
        return bilibiliServiceProvider.getLiveService()
                .sendBulletScreen(bulletScreenEntity)
                .execute()
                .body();
    }

    //TODO 弹幕发送队列
    public void sendBulletScreenInBlockingQueue(String message) {
        throw new UnsupportedOperationException();
    }

    public long getShowRoomId() {
        return showRoomId;
    }

    public long getUserId() {
        return userId;
    }

    public Optional<LiveRoomInfoEntity.LiveRoomEntity> getRoomInfo() {
        return Optional.of(liveRoomEntity);
    }
}
