package com.hiczp.bilibili.api.live.socket.handler;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.hiczp.bilibili.api.live.socket.Package;
import com.hiczp.bilibili.api.live.socket.PackageHelper;
import com.hiczp.bilibili.api.live.socket.entity.*;
import com.hiczp.bilibili.api.live.socket.event.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LiveClientHandler extends SimpleChannelInboundHandler<Package> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClientHandler.class);
    private static final Gson GSON = new Gson();
    private static final JsonParser JSON_PARSER = new JsonParser();

    private long roomId;
    private long userId;
    private EventBus eventBus;

    public LiveClientHandler(long roomId, long userId, EventBus eventBus) {
        this.roomId = roomId;
        this.userId = userId;
        this.eventBus = eventBus;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        LOGGER.debug("Sending Enter Room package");
        ctx.writeAndFlush(PackageHelper.createEnterRoomPackage(roomId, userId));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        eventBus.post(new ConnectionCloseEvent(this));
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                ctx.close();
            }
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Package msg) throws Exception {
        switch (msg.getPackageType()) {
            case VIEWER_COUNT: {
                eventBus.post(new ViewerCountPackageEvent(this, ByteBuffer.wrap(msg.getContent()).getInt()));
            }
            break;
            case ENTER_ROOM_SUCCESS: {
                eventBus.post(new ConnectSucceedEvent(this));
                ctx.executor().scheduleAtFixedRate(
                        () -> {
                            ctx.writeAndFlush(PackageHelper.createHeartBeatPackage());
                            eventBus.post(new SendHeartBeatPackageEvent(this));
                        },
                        0L,
                        30L,
                        TimeUnit.SECONDS
                );
            }
            break;
            case DATA: {
                String content = new String(msg.getContent());
                String cmd = JSON_PARSER.parse(content)
                        .getAsJsonObject()
                        .get("cmd")
                        .getAsString();
                Supplier<Object> eventCreationExpression;   //try 不能写在 switch 外面, 用 lambda 来延迟执行
                switch (cmd) {
                    case "DANMU_MSG": {
                        eventCreationExpression = () -> new DanMuMsgPackageEvent(this, GSON.fromJson(content, DanMuMsgEntity.class));
                    }
                    break;
                    case "SEND_GIFT": {
                        eventCreationExpression = () -> new SendGiftPackageEvent(this, GSON.fromJson(content, SendGiftEntity.class));
                    }
                    break;
                    case "SYS_GIFT": {
                        eventCreationExpression = () -> new SysGiftPackageEvent(this, GSON.fromJson(content, SysGiftEntity.class));
                    }
                    break;
                    case "SYS_MSG": {
                        eventCreationExpression = () -> new SysMsgPackageEvent(this, GSON.fromJson(content, SysMsgEntity.class));
                    }
                    break;
                    case "WELCOME": {
                        eventCreationExpression = () -> new WelcomePackageEvent(this, GSON.fromJson(content, WelcomeEntity.class));
                    }
                    break;
                    case "WELCOME_GUARD": {
                        eventCreationExpression = () -> new WelcomeGuardPackageEvent(this, GSON.fromJson(content, WelcomeGuardEntity.class));
                    }
                    break;
                    case "LIVE": {
                        eventCreationExpression = () -> new LivePackageEvent(this, GSON.fromJson(content, LiveEntity.class));
                    }
                    break;
                    case "PREPARING": {
                        eventCreationExpression = () -> new PreparingPackageEvent(this, GSON.fromJson(content, PreparingEntity.class));
                    }
                    break;
                    case "ACTIVITY_EVENT": {
                        eventCreationExpression = () -> new ActivityEventPackageEvent(this, GSON.fromJson(content, ActivityEventEntity.class));
                    }
                    break;
                    case "WISH_BOTTLE": {
                        eventCreationExpression = () -> new WishBottlePackageEvent(this, GSON.fromJson(content, WishBottleEntity.class));
                    }
                    break;
                    case "ROOM_BLOCK_MSG": {
                        eventCreationExpression = () -> new RoomBlockMsgPackageEvent(this, GSON.fromJson(content, RoomBlockMsgEntity.class));
                    }
                    break;
                    case "ROOM_SILENT_OFF": {
                        eventCreationExpression = () -> new RoomSilentOffPackageEvent(this, GSON.fromJson(content, RoomSilentOffEntity.class));
                    }
                    break;
                    case "GUARD_MSG": {
                        eventCreationExpression = () -> new GuardMsgPackageEvent(this, GSON.fromJson(content, GuardMsgEntity.class));
                    }
                    break;
                    default: {
                        LOGGER.error("Received unknown json below: \n{}", formatJson(content));
                        eventCreationExpression = () -> new UnknownPackageEvent(this, content);
                    }
                    break;
                }

                try {
                    eventBus.post(eventCreationExpression.get());
                } catch (JsonParseException e) {
                    LOGGER.error("Json parse error: {}, json below: \n{}", e.getMessage(), formatJson(content));
                }
            }
            break;
        }
    }

    private String formatJson(String json) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(JSON_PARSER.parse(json));
    }
}
