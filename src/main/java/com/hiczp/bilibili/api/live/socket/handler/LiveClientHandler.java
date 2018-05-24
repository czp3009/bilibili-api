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
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LiveClientHandler extends SimpleChannelInboundHandler<Package> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClientHandler.class);
    private static final Gson GSON = new Gson();
    private static final JsonParser JSON_PARSER = new JsonParser();

    private final LiveClient liveClient;
    private final EventBus eventBus;
    private final long roomId;
    private final long userId;

    public LiveClientHandler(LiveClient liveClient, long roomId, long userId) {
        this.liveClient = liveClient;
        this.eventBus = liveClient.getEventBus();
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
        eventBus.post(new ConnectionCloseEvent(liveClient));
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
                String cmd;
                try {
                    //强制使用 UTF-8, 避免在 NT 平台可能出现的乱码问题
                    jsonObject = JSON_PARSER.parse(new InputStreamReader(new ByteArrayInputStream(msg.getContent()), StandardCharsets.UTF_8))
                            .getAsJsonObject();
                    cmd = jsonObject.get("cmd").getAsString();
                } catch (JsonSyntaxException | IllegalStateException | NullPointerException e) {
                    LOGGER.error("Receive invalid json: \n{}", new String(msg.getContent(), StandardCharsets.UTF_8));
                    e.printStackTrace();
                    break;
                }
                eventBus.post(new ReceiveDataPackageDebugEvent(liveClient, jsonObject, cmd));
                Supplier<Object> eventCreationExpression;   //try 不能写在 switch 外面, 用 lambda 来延迟执行
                switch (cmd) {
                    //弹幕消息
                    case "DANMU_MSG": {
                        eventCreationExpression = () -> new DanMuMsgPackageEvent(liveClient, GSON.fromJson(jsonObject, DanMuMsgEntity.class));
                    }
                    break;
                    //送礼
                    case "SEND_GIFT": {
                        eventCreationExpression = () -> new SendGiftPackageEvent(liveClient, GSON.fromJson(jsonObject, SendGiftEntity.class));
                    }
                    break;
                    //欢迎
                    case "WELCOME": {
                        eventCreationExpression = () -> new WelcomePackageEvent(liveClient, GSON.fromJson(jsonObject, WelcomeEntity.class));
                    }
                    break;
                    //许愿瓶
                    case "WISH_BOTTLE": {
                        eventCreationExpression = () -> new WishBottlePackageEvent(liveClient, GSON.fromJson(jsonObject, WishBottleEntity.class));
                    }
                    break;
                    //欢迎(舰队)
                    case "WELCOME_GUARD": {
                        eventCreationExpression = () -> new WelcomeGuardPackageEvent(liveClient, GSON.fromJson(jsonObject, WelcomeGuardEntity.class));
                    }
                    break;
                    //系统消息(小电视等)
                    case "SYS_MSG": {
                        eventCreationExpression = () -> new SysMsgPackageEvent(liveClient, GSON.fromJson(jsonObject, SysMsgEntity.class));
                    }
                    break;
                    //系统礼物(丰收庆典, 新春抽奖等)
                    case "SYS_GIFT": {
                        eventCreationExpression = () -> new SysGiftPackageEvent(liveClient, GSON.fromJson(jsonObject, SysGiftEntity.class));
                    }
                    break;
                    //活动事件
                    case "ACTIVITY_EVENT": {
                        eventCreationExpression = () -> new ActivityEventPackageEvent(liveClient, GSON.fromJson(jsonObject, ActivityEventEntity.class));
                    }
                    break;
                    case "SPECIAL_GIFT": {
                        eventCreationExpression = () -> new SpecialGiftPackageEvent(liveClient, GSON.fromJson(jsonObject, SpecialGiftEntity.class));
                    }
                    break;
                    //抽奖开始(小奖, 通常是不定期活动)
                    case "RAFFLE_START": {
                        eventCreationExpression = () -> new RaffleStartPackageEvent(liveClient, GSON.fromJson(jsonObject, RaffleStartEntity.class));
                    }
                    break;
                    //抽奖
                    case "RAFFLE_END": {
                        eventCreationExpression = () -> new RaffleEndPackageEvent(liveClient, GSON.fromJson(jsonObject, RaffleEndEntity.class));
                    }
                    break;
                    case "EVENT_CMD": {
                        eventCreationExpression = () -> new EventCmdPackageEvent(liveClient, GSON.fromJson(jsonObject, EventCmdEntity.class));
                    }
                    break;
                    //房间黑名单(添加了一个用户到黑名单)
                    case "ROOM_BLOCK_MSG": {
                        eventCreationExpression = () -> new RoomBlockMsgPackageEvent(liveClient, GSON.fromJson(jsonObject, RoomBlockMsgEntity.class));
                    }
                    break;
                    //房间开启了禁言(禁止某一等级以下的用户发言)
                    case "ROOM_SILENT_ON": {
                        eventCreationExpression = () -> new RoomSilentOnPackageEvent(liveClient, GSON.fromJson(jsonObject, RoomSilentOnEntity.class));
                    }
                    break;
                    //房间结束禁言
                    case "ROOM_SILENT_OFF": {
                        eventCreationExpression = () -> new RoomSilentOffPackageEvent(liveClient, GSON.fromJson(jsonObject, RoomSilentOffEntity.class));
                    }
                    break;
                    //船票购买
                    case "GUARD_BUY": {
                        eventCreationExpression = () -> new GuardBuyPackageEvent(liveClient, GSON.fromJson(jsonObject, GuardBuyEntity.class));
                    }
                    break;
                    //舰队消息(登船)
                    case "GUARD_MSG": {
                        eventCreationExpression = () -> new GuardMsgPackageEvent(liveClient, GSON.fromJson(jsonObject, GuardMsgEntity.class));
                    }
                    break;
                    case "TV_START": {
                        eventCreationExpression = () -> new TVStartPackageEvent(liveClient, GSON.fromJson(jsonObject, TVStartEntity.class));
                    }
                    break;
                    //小电视抽奖结束(大奖的获得者信息)
                    case "TV_END": {
                        eventCreationExpression = () -> new TVEndPackageEvent(liveClient, GSON.fromJson(jsonObject, TVEndEntity.class));
                    }
                    break;
                    case "ROOM_RANK": {
                        eventCreationExpression = () -> new RoomRankPackageEvent(liveClient, GSON.fromJson(jsonObject, RoomRankEntity.class));
                    }
                    break;
                    //欢迎(活动)
                    case "WELCOME_ACTIVITY": {
                        eventCreationExpression = () -> new WelcomeActivityPackageEvent(liveClient, GSON.fromJson(jsonObject, WelcomeActivityEntity.class));
                    }
                    break;
                    //房管变更
                    case "ROOM_ADMINS": {
                        eventCreationExpression = () -> new RoomAdminsPackageEvent(liveClient, GSON.fromJson(jsonObject, RoomAdminsEntity.class));
                    }
                    break;
                    //开始直播
                    case "LIVE": {
                        eventCreationExpression = () -> new LivePackageEvent(liveClient, GSON.fromJson(jsonObject, LiveEntity.class));
                    }
                    break;
                    //停止直播
                    case "PREPARING": {
                        eventCreationExpression = () -> new PreparingPackageEvent(liveClient, GSON.fromJson(jsonObject, PreparingEntity.class));
                    }
                    break;
                    //房间屏蔽
                    case "ROOM_SHIELD": {
                        eventCreationExpression = () -> new RoomShieldPackageEvent(liveClient, GSON.fromJson(jsonObject, RoomShieldEntity.class));
                    }
                    break;
                    //更换房间背景图片
                    case "CHANGE_ROOM_INFO": {
                        eventCreationExpression = () -> new ChangeRoomInfoPackageEvent(liveClient, GSON.fromJson(jsonObject, ChangeRoomInfoEntity.class));
                    }
                    break;
                    //被 B站 管理员强制中断
                    case "CUT_OFF": {
                        eventCreationExpression = () -> new CutOffPackageEvent(liveClient, GSON.fromJson(jsonObject, CutOffEntity.class));
                    }
                    break;
                    //房间被封
                    case "ROOM_LOCK": {
                        eventCreationExpression = () -> new RoomLockPackageEvent(liveClient, GSON.fromJson(jsonObject, RoomLockEntity.class));
                    }
                    break;
                    default: {
                        LOGGER.error("Received unknown json below: \n{}", formatJson(jsonObject));
                        eventCreationExpression = () -> new UnknownPackageEvent(liveClient, jsonObject);
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
                eventBus.post(new ViewerCountPackageEvent(liveClient, ByteBuffer.wrap(msg.getContent()).getInt()));
            }
            break;
            case ENTER_ROOM_SUCCESS: {
                eventBus.post(new ConnectSucceedEvent(liveClient));
                ctx.executor().scheduleAtFixedRate(
                        () -> {
                            ctx.writeAndFlush(PackageHelper.createHeartBeatPackage());
                            eventBus.post(new SendHeartBeatPackageEvent(liveClient));
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
}
