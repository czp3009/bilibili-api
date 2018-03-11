package com.hiczp.bilibili.api.live.socket;

import com.google.common.eventbus.EventBus;
import com.hiczp.bilibili.api.live.bulletScreen.BulletScreenConstDefinition;
import com.hiczp.bilibili.api.live.entity.BulletScreenEntity;
import com.hiczp.bilibili.api.live.entity.LiveRoomInfoEntity;
import com.hiczp.bilibili.api.live.entity.SendBulletScreenResponseEntity;
import com.hiczp.bilibili.api.live.socket.codec.PackageDecoder;
import com.hiczp.bilibili.api.live.socket.codec.PackageEncoder;
import com.hiczp.bilibili.api.live.socket.handler.LiveClientHandler;
import com.hiczp.bilibili.api.provider.BilibiliServiceProvider;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Optional;

public class LiveClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClient.class);

    private final BilibiliServiceProvider bilibiliServiceProvider;
    private final EventLoopGroup eventLoopGroup;
    private final long showRoomId;
    private final long userId;
    private final EventBus eventBus = new EventBus("BilibiliLiveClientEventBus");

    private LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity;

    private Channel channel;

    public LiveClient(@Nonnull BilibiliServiceProvider bilibiliServiceProvider, EventLoopGroup eventLoopGroup, long showRoomId, long userId) {
        this.bilibiliServiceProvider = bilibiliServiceProvider;
        this.eventLoopGroup = eventLoopGroup;
        this.showRoomId = showRoomId;
        this.userId = userId;
    }

    public LiveClient(@Nonnull BilibiliServiceProvider bilibiliServiceProvider, EventLoopGroup eventLoopGroup, long showRoomId) {
        this(bilibiliServiceProvider, eventLoopGroup, showRoomId, 0);
    }

    public Call<LiveRoomInfoEntity> fetchRoomInfoAsync() {
        return bilibiliServiceProvider.getLiveService()
                .getRoomInfo(showRoomId);
    }

    public LiveRoomInfoEntity.LiveRoomEntity fetchRoomInfo() throws IOException {
        LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity =
                fetchRoomInfoAsync()
                        .execute()
                        .body()
                        .getData();
        if (liveRoomEntity != null) {
            return liveRoomEntity;
        } else {
            throw new IllegalArgumentException("Target room " + showRoomId + " not exists");
        }
    }

    public synchronized LiveClient connect() throws IOException {
        if (channel != null && channel.isActive()) {
            LOGGER.warn("Already connected to server, connect method can not be invoked twice");
            return this;
        }

        LOGGER.info("Fetching info of live room {}", showRoomId);
        liveRoomEntity = fetchRoomInfo();
        long roomId = liveRoomEntity.getRoomId();
        LOGGER.info("Get actual room id {}", roomId);

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
                                .addLast(new LiveClientHandler(self(), showRoomId, roomId, userId));
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
        } catch (Exception e) { //有可能在此时出现网络错误
            throw new IOException(e);
        }

        return this;
    }

    public synchronized ChannelFuture closeChannelAsync() {
        if (channel != null) {
            LOGGER.info("Closing connection");
            ChannelFuture channelFuture = channel.close();
            channel = null;
            return channelFuture;
        } else {
            return null;
        }
    }

    public void closeChannel() {
        ChannelFuture channelFuture = closeChannelAsync();
        if (channelFuture != null) {
            channelFuture.awaitUninterruptibly();
        }
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public LiveClient registerListener(@Nonnull Object object) {
        eventBus.register(object);
        return this;
    }

    public LiveClient unregisterListeners(@Nonnull Object object) {
        eventBus.unregister(object);
        return this;
    }

    public Call<SendBulletScreenResponseEntity> sendBulletScreenAsync(@Nonnull String message) {
        return bilibiliServiceProvider.getLiveService()
                .sendBulletScreen(createBulletScreenEntity(message));
    }

    public SendBulletScreenResponseEntity sendBulletScreen(@Nonnull String message) throws IOException {
        return sendBulletScreenAsync(message)
                .execute()
                .body();
    }

    private LiveClient self() {
        return this;
    }

    //TODO 弹幕发送队列

    private BulletScreenEntity createBulletScreenEntity(String message) {
        return new BulletScreenEntity(
                getRoomIdOrShowRoomId(),
                userId,
                message
        );
    }

    public long getShowRoomId() {
        return showRoomId;
    }

    public long getUserId() {
        return userId;
    }

    public Optional<LiveRoomInfoEntity.LiveRoomEntity> getRoomInfo() {
        if (liveRoomEntity == null) {
            try {
                liveRoomEntity = fetchRoomInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Optional.of(liveRoomEntity);
    }

    public long getRoomIdOrShowRoomId() {
        return getRoomInfo().map(LiveRoomInfoEntity.LiveRoomEntity::getRoomId).orElse(showRoomId);
    }

    public int getBulletScreenLengthLimitOrDefaultLengthLimit() {
        return getRoomInfo().map(LiveRoomInfoEntity.LiveRoomEntity::getMsgLength).orElse(BulletScreenConstDefinition.DEFAULT_MESSAGE_LENGTH_LIMIT);
    }

    public Channel getChannel() {
        return channel;
    }
}
