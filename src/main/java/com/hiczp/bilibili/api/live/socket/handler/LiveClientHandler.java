package com.hiczp.bilibili.api.live.socket.handler;

import com.google.common.eventbus.EventBus;
import com.google.gson.*;
import com.hiczp.bilibili.api.live.socket.LiveClient;
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

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LiveClientHandler extends SimpleChannelInboundHandler<Package> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClientHandler.class);
    private static final Gson GSON = new Gson();
    private static final JsonParser JSON_PARSER = new JsonParser();

    private final LiveClient liveClient;
    private final EventBus eventBus;
    private final long showRoomId;
    private final long roomId;
    private final long userId;

    public LiveClientHandler(LiveClient liveClient, long showRoomId, long roomId, long userId) {
        this.liveClient = liveClient;
        this.eventBus = liveClient.getEventBus();
        this.showRoomId = showRoomId;
        this.roomId = roomId;
        this.userId = userId;
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
            case DATA: {
                JsonObject jsonObject;
                try {
                    jsonObject = JSON_PARSER.parse(new InputStreamReader(new ByteArrayInputStream(msg.getContent())))
                            .getAsJsonObject();
                } catch (JsonSyntaxException | IllegalStateException e) {
                    LOGGER.error("Receive invalid json: \n{}", new String(msg.getContent()));
                    e.printStackTrace();
                    break;
                }
                eventBus.post(new ReceiveDataPackageDebugEvent(this, jsonObject));
                String cmd = jsonObject.get("cmd").getAsString();
                Supplier<Object> eventCreationExpression;   //try 不能写在 switch 外面, 用 lambda 来延迟执行
                switch (cmd) {
                    //弹幕消息
                    case "DANMU_MSG": {
                        eventCreationExpression = () -> new DanMuMsgPackageEvent(this, GSON.fromJson(jsonObject, DanMuMsgEntity.class));
                    }
                    break;
                    //送礼
                    case "SEND_GIFT": {
                        eventCreationExpression = () -> new SendGiftPackageEvent(this, GSON.fromJson(jsonObject, SendGiftEntity.class));
                    }
                    break;
                    //欢迎
                    case "WELCOME": {
                        eventCreationExpression = () -> new WelcomePackageEvent(this, GSON.fromJson(jsonObject, WelcomeEntity.class));
                    }
                    break;
                    //许愿瓶
                    case "WISH_BOTTLE": {
                        eventCreationExpression = () -> new WishBottlePackageEvent(this, GSON.fromJson(jsonObject, WishBottleEntity.class));
                    }
                    break;
                    //欢迎(舰队)
                    case "WELCOME_GUARD": {
                        eventCreationExpression = () -> new WelcomeGuardPackageEvent(this, GSON.fromJson(jsonObject, WelcomeGuardEntity.class));
                    }
                    break;
                    //系统消息(小电视等)
                    case "SYS_MSG": {
                        eventCreationExpression = () -> new SysMsgPackageEvent(this, GSON.fromJson(jsonObject, SysMsgEntity.class));
                    }
                    break;
                    //系统礼物(丰收庆典, 新春抽奖等)
                    case "SYS_GIFT": {
                        eventCreationExpression = () -> new SysGiftPackageEvent(this, GSON.fromJson(jsonObject, SysGiftEntity.class));
                    }
                    break;
                    //活动事件
                    case "ACTIVITY_EVENT": {
                        eventCreationExpression = () -> new ActivityEventPackageEvent(this, GSON.fromJson(jsonObject, ActivityEventEntity.class));
                    }
                    break;
                    case "SPECIAL_GIFT": {
                        eventCreationExpression = () -> new SpecialGiftPackageEvent(this, GSON.fromJson(jsonObject, SpecialGiftEntity.class));
                    }
                    break;
                    //抽奖开始(小奖, 通常是不定期活动)
                    case "RAFFLE_START": {
                        eventCreationExpression = () -> new RaffleStartPackageEvent(this, GSON.fromJson(jsonObject, RaffleStartEntity.class));
                    }
                    break;
                    //抽奖
                    case "RAFFLE_END": {
                        eventCreationExpression = () -> new RaffleEndPackageEvent(this, GSON.fromJson(jsonObject, RaffleEndEntity.class));
                    }
                    break;
                    case "EVENT_CMD": {
                        eventCreationExpression = () -> new EventCmdPackageEvent(this, GSON.fromJson(jsonObject, EventCmdEntity.class));
                    }
                    break;
                    //房间黑名单(添加了一个用户到黑名单)
                    case "ROOM_BLOCK_MSG": {
                        eventCreationExpression = () -> new RoomBlockMsgPackageEvent(this, GSON.fromJson(jsonObject, RoomBlockMsgEntity.class));
                    }
                    break;
                    //房间开启了禁言(禁止某一等级以下的用户发言)
                    case "ROOM_SILENT_ON": {
                        eventCreationExpression = () -> new RoomSilentOnPackageEvent(this, GSON.fromJson(jsonObject, RoomSilentOnEntity.class));
                    }
                    break;
                    //房间结束禁言
                    case "ROOM_SILENT_OFF": {
                        eventCreationExpression = () -> new RoomSilentOffPackageEvent(this, GSON.fromJson(jsonObject, RoomSilentOffEntity.class));
                    }
                    break;
                    //船票购买
                    case "GUARD_BUY": {
                        eventCreationExpression = () -> new GuardBuyPackageEvent(this, GSON.fromJson(jsonObject, GuardBuyEntity.class));
                    }
                    break;
                    //舰队消息(登船)
                    case "GUARD_MSG": {
                        eventCreationExpression = () -> new GuardMsgPackageEvent(this, GSON.fromJson(jsonObject, GuardMsgEntity.class));
                    }
                    break;
                    case "TV_START": {
                        eventCreationExpression = () -> new TVStartPackageEvent(this, GSON.fromJson(jsonObject, TVStartEntity.class));
                    }
                    break;
                    //小电视抽奖结束(大奖的获得者信息)
                    case "TV_END": {
                        eventCreationExpression = () -> new TVEndPackageEvent(this, GSON.fromJson(jsonObject, TVEndEntity.class));
                    }
                    break;
                    //房管变更
                    case "ROOM_ADMINS": {
                        eventCreationExpression = () -> new RoomAdminsPackageEvent(this, GSON.fromJson(jsonObject, RoomAdminsEntity.class));
                    }
                    break;
                    //开始直播
                    case "LIVE": {
                        eventCreationExpression = () -> new LivePackageEvent(this, GSON.fromJson(jsonObject, LiveEntity.class));
                    }
                    break;
                    //停止直播
                    case "PREPARING": {
                        eventCreationExpression = () -> new PreparingPackageEvent(this, GSON.fromJson(jsonObject, PreparingEntity.class));
                    }
                    break;
                    //房间屏蔽
                    case "ROOM_SHIELD": {
                        eventCreationExpression = () -> new RoomShieldPackageEvent(this, GSON.fromJson(jsonObject, RoomShieldEntity.class));
                    }
                    break;
                    default: {
                        LOGGER.error("Received unknown json below: \n{}", formatJson(jsonObject));
                        eventCreationExpression = () -> new UnknownPackageEvent(this, jsonObject);
                    }
                    break;
                }

                try {
                    eventBus.post(eventCreationExpression.get());
                } catch (JsonParseException e) {
                    LOGGER.error("Json parse error: {}, json below: \n{}", e.getMessage(), formatJson(jsonObject));
                }
            }
            break;
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
        }
    }

    private String formatJson(JsonElement jsonElement) {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(jsonElement);
    }

    public LiveClient getLiveClient() {
        return liveClient;
    }

    public long getShowRoomId() {
        return showRoomId;
    }

    public long getRoomId() {
        return roomId;
    }

    public long getUserId() {
        return userId;
    }
}
