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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class LiveClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClient.class);

    private static final String DEFAULT_SERVER_ADDRESS = "livecmt-2.bilibili.com";
    private static final int DEFAULT_SERVER_PORT = 2243;

    private final BilibiliServiceProvider bilibiliServiceProvider;
    private final EventLoopGroup eventLoopGroup;
    private final long userId;
    private Long showRoomId;
    private Long realRoomId;
    private final EventBus eventBus;
    private boolean useRealRoomIdForConstructing;

    private LiveRoomInfoEntity.LiveRoom liveRoom;

    private Channel channel;

    public LiveClient(@Nonnull BilibiliServiceProvider bilibiliServiceProvider, @Nonnull EventLoopGroup eventLoopGroup, long roomId, boolean isRealRoomId, long userId) {
        this.bilibiliServiceProvider = bilibiliServiceProvider;
        this.eventLoopGroup = eventLoopGroup;
        this.useRealRoomIdForConstructing = isRealRoomId;
        if (isRealRoomId) {
            realRoomId = roomId;
        } else {
            showRoomId = roomId;
        }
        this.userId = userId;
        this.eventBus = new EventBus(String.format("BilibiliLiveClientEventBus-%s", getShowRoomIdOrRoomId()));
    }

    public LiveClient(@Nonnull BilibiliServiceProvider bilibiliServiceProvider, @Nonnull EventLoopGroup eventLoopGroup, long showRoomId, long userId) {
        this(bilibiliServiceProvider, eventLoopGroup, showRoomId, false, userId);
    }

    public LiveClient(@Nonnull BilibiliServiceProvider bilibiliServiceProvider, @Nonnull EventLoopGroup eventLoopGroup, long roomId, boolean isRealRoomId) {
        this(bilibiliServiceProvider, eventLoopGroup, roomId, isRealRoomId, 0);
    }

    public LiveClient(@Nonnull BilibiliServiceProvider bilibiliServiceProvider, @Nonnull EventLoopGroup eventLoopGroup, long showRoomId) {
        this(bilibiliServiceProvider, eventLoopGroup, showRoomId, false, 0);
    }

    public Call<LiveRoomInfoEntity> fetchRoomInfoAsync() {
        return bilibiliServiceProvider.getLiveService()
                .getRoomInfo(getShowRoomIdOrRoomId());
    }

    public LiveRoomInfoEntity.LiveRoom fetchRoomInfo() throws IOException {
        LiveRoomInfoEntity.LiveRoom liveRoom =
                fetchRoomInfoAsync()
                        .execute()
                        .body()
                        .getData();
        //此时 code 为 -404
        if (liveRoom != null) {
            return liveRoom;
        } else {
            throw new IllegalArgumentException("Target room " + getShowRoomIdOrRoomId() + " not exists");
        }
    }

    public Callable<LiveClient> connectAsync() {
        return () -> {
            if (channel != null && channel.isActive()) {
                LOGGER.warn("Already connected to server, connect method can not be invoked twice");
                return this;
            }
            if (realRoomId == null) {
                if (liveRoom == null) {
                    LOGGER.debug("Fetching info of live room {}", showRoomId);
                    liveRoom = fetchRoomInfo();
                    LOGGER.debug("Get actual room id {}", liveRoom.getRoomId());
                }
                realRoomId = liveRoom.getRoomId();
            }

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
                                    .addLast(new LiveClientHandler(self(), realRoomId, userId));
                        }
                    });

            String address = liveRoom != null ? liveRoom.getCmt() : DEFAULT_SERVER_ADDRESS;
            int port = liveRoom != null ? liveRoom.getCmtPortGoim() : DEFAULT_SERVER_PORT;
            LOGGER.debug("Connecting to Bullet Screen server {}:{}", address, port);
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
        };
    }

    public LiveClient connect(ExecutorService executorService) throws InterruptedException, ExecutionException {
        Future<LiveClient> future = executorService.submit(connectAsync());
        return future.get();
    }

    public synchronized LiveClient connect() throws Exception {
        return connectAsync().call();
    }

    public synchronized ChannelFuture closeChannelAsync() {
        if (channel != null) {
            LOGGER.debug("Closing connection");
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

    public LiveClient registerListeners(@Nonnull Iterable<Object> objects) {
        objects.forEach(eventBus::register);
        return this;
    }

    public LiveClient unregisterListener(@Nonnull Object object) {
        eventBus.unregister(object);
        return this;
    }

    public LiveClient unregisterListeners(@Nonnull Iterable<Object> objects) {
        objects.forEach(eventBus::unregister);
        return this;
    }

    //TODO 弹幕发送队列

    public Call<SendBulletScreenResponseEntity> sendBulletScreenAsync(@Nonnull String message) {
        return bilibiliServiceProvider.getLiveService()
                .sendBulletScreen(createBulletScreenEntity(message));
    }

    public SendBulletScreenResponseEntity sendBulletScreen(@Nonnull String message) throws IOException {
        return sendBulletScreenAsync(message)
                .execute()
                .body();
    }

    private BulletScreenEntity createBulletScreenEntity(String message) {
        return new BulletScreenEntity(
                getRoomIdOrShowRoomId(),
                userId,
                message
        );
    }

    public long getUserId() {
        return userId;
    }

    public long getRoomIdOrShowRoomId() {
        return realRoomId != null ? realRoomId : showRoomId;
    }

    public long getShowRoomIdOrRoomId() {
        return showRoomId != null ? showRoomId : realRoomId;
    }

    public int getBulletScreenLengthLimitOrDefaultLengthLimit() {
        return liveRoom != null ? liveRoom.getMsgLength() : BulletScreenConstDefinition.DEFAULT_MESSAGE_LENGTH_LIMIT;
    }

    public Channel getChannel() {
        return channel;
    }

    public boolean isUseRealRoomIdForConstructing() {
        return useRealRoomIdForConstructing;
    }

    private LiveClient self() {
        return this;
    }
}
