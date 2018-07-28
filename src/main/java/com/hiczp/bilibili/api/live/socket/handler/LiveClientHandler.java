package com.hiczp.bilibili.api.live.socket.handler;

import com.google.common.eventbus.EventBus;
import com.google.gson.*;
import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.Package;
import com.hiczp.bilibili.api.live.socket.PackageHelper;
import com.hiczp.bilibili.api.live.socket.entity.DataEntity;
import com.hiczp.bilibili.api.live.socket.event.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class LiveClientHandler extends SimpleChannelInboundHandler<Package> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClientHandler.class);
    private static final Gson GSON = new Gson();
    private static final Gson PRETTY_PRINTING_GSON = new GsonBuilder().setPrettyPrinting().create();
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
                Class<? extends ReceiveDataPackageEvent> eventType = null;
                switch (cmd) {
                    //弹幕消息
                    case "DANMU_MSG": {
                        eventType = DanMuMsgPackageEvent.class;
                    }
                    break;
                    //送礼
                    case "SEND_GIFT": {
                        eventType = SendGiftPackageEvent.class;
                    }
                    break;
                    //combo
                    case "COMBO_SEND": {
                        eventType = ComboSendPackageEvent.class;
                    }
                    break;
                    case "COMBO_END": {
                        eventType = ComboEndPackageEvent.class;
                    }
                    break;
                    //欢迎
                    case "WELCOME": {
                        eventType = WelcomePackageEvent.class;
                    }
                    break;
                    //许愿瓶
                    case "WISH_BOTTLE": {
                        eventType = WishBottlePackageEvent.class;
                    }
                    break;
                    //欢迎(舰队)
                    case "WELCOME_GUARD": {
                        eventType = WelcomeGuardPackageEvent.class;
                    }
                    break;
                    //TODO 尚不明确 EntryEffect 和普通 Welcome 的区别
                    case "ENTRY_EFFECT": {
                        eventType = EntryEffectPackageEvent.class;
                    }
                    break;
                    //PK
                    case "PK_MATCH": {
                        eventType = PkMatchPackageEvent.class;
                    }
                    break;
                    case "PK_PRE": {
                        eventType = PkPrePackageEvent.class;
                    }
                    break;
                    case "PK_START": {
                        eventType = PkStartPackageEvent.class;
                    }
                    break;
                    case "PK_PROCESS": {
                        eventType = PkProcessPackageEvent.class;
                    }
                    break;
                    case "PK_END": {
                        eventType = PkEndPackageEvent.class;
                    }
                    break;
                    case "PK_MIC_END": {
                        eventType = PkMicEndPackageEvent.class;
                    }
                    break;
                    case "PK_SETTLE": {
                        eventType = PkSettlePackageEvent.class;
                    }
                    break;
                    case "PK_AGAIN": {
                        eventType = PkAgainPackageEvent.class;
                    }
                    break;
                    case "PK_CLICK_AGAIN": {
                        eventType = PkClickAgainPackageEvent.class;
                    }
                    break;
                    //系统消息(小电视等)
                    case "SYS_MSG": {
                        eventType = SysMsgPackageEvent.class;
                    }
                    break;
                    //系统礼物(节奏风暴, 活动抽奖等)
                    case "SYS_GIFT": {
                        eventType = SysGiftPackageEvent.class;
                    }
                    break;
                    //活动事件
                    case "ACTIVITY_EVENT": {
                        eventType = ActivityEventPackageEvent.class;
                    }
                    break;
                    //节奏风暴(20 倍以下的)
                    case "SPECIAL_GIFT": {
                        eventType = SpecialGiftPackageEvent.class;
                    }
                    break;
                    //抽奖开始(小奖, 通常是不定期活动)
                    case "RAFFLE_START": {
                        eventType = RaffleStartPackageEvent.class;
                    }
                    break;
                    //抽奖结束
                    case "RAFFLE_END": {
                        eventType = RaffleEndPackageEvent.class;
                    }
                    break;
                    //TODO 尚不明确 EVENT_CMD 的含义
                    case "EVENT_CMD": {
                        eventType = EventCmdPackageEvent.class;
                    }
                    break;
                    //房间黑名单(房间管理员添加了一个用户到黑名单)
                    case "ROOM_BLOCK_MSG": {
                        eventType = RoomBlockMsgPackageEvent.class;
                    }
                    break;
                    //房间开启了禁言(禁止某一等级以下的用户发言)
                    case "ROOM_SILENT_ON": {
                        eventType = RoomSilentOnPackageEvent.class;
                    }
                    break;
                    //房间结束禁言
                    case "ROOM_SILENT_OFF": {
                        eventType = RoomSilentOffPackageEvent.class;
                    }
                    break;
                    //船票购买
                    case "GUARD_BUY": {
                        eventType = GuardBuyPackageEvent.class;
                    }
                    break;
                    //舰队消息(登船)
                    case "GUARD_MSG": {
                        eventType = GuardMsgPackageEvent.class;
                    }
                    break;
                    //小电视抽奖开始
                    case "TV_START": {
                        eventType = TVStartPackageEvent.class;
                    }
                    break;
                    //小电视抽奖结束(大奖的获得者信息)
                    case "TV_END": {
                        eventType = TVEndPackageEvent.class;
                    }
                    break;
                    //小时榜
                    case "ROOM_RANK": {
                        eventType = RoomRankPackageEvent.class;
                    }
                    break;
                    //欢迎(活动)
                    case "WELCOME_ACTIVITY": {
                        eventType = WelcomeActivityPackageEvent.class;
                    }
                    break;
                    //房管变更
                    case "ROOM_ADMINS": {
                        eventType = RoomAdminsPackageEvent.class;
                    }
                    break;
                    //开始直播
                    case "LIVE": {
                        eventType = LivePackageEvent.class;
                    }
                    break;
                    //停止直播
                    case "PREPARING": {
                        eventType = PreparingPackageEvent.class;
                    }
                    break;
                    //房间屏蔽
                    case "ROOM_SHIELD": {
                        eventType = RoomShieldPackageEvent.class;
                    }
                    break;
                    //更换房间背景图片
                    case "CHANGE_ROOM_INFO": {
                        eventType = ChangeRoomInfoPackageEvent.class;
                    }
                    break;
                    //被 B站 管理员强制中断
                    case "CUT_OFF": {
                        eventType = CutOffPackageEvent.class;
                    }
                    break;
                    //房间被封
                    case "ROOM_LOCK": {
                        eventType = RoomLockPackageEvent.class;
                    }
                    break;
                }

                //UnknownPackage
                if (eventType == null) {
                    LOGGER.error("Received unknown json below: \n{}", PRETTY_PRINTING_GSON.toJson(jsonObject));
                    eventBus.post(new UnknownPackageEvent(liveClient, jsonObject));
                    break;
                }

                @SuppressWarnings("unchecked")
                Class<? extends DataEntity> entityType = (Class<? extends DataEntity>) ((ParameterizedType) eventType.getGenericSuperclass()).getActualTypeArguments()[0];
                DataEntity entityInstance;
                try {
                    entityInstance = GSON.fromJson(jsonObject, entityType);
                } catch (JsonParseException e) {
                    LOGGER.error("Json parse error: {}, json below: \n{}", e.getMessage(), PRETTY_PRINTING_GSON.toJson(jsonObject));
                    break;
                }

                ReceiveDataPackageEvent eventInstance = eventType.getConstructor(LiveClient.class, entityType).newInstance(liveClient, entityInstance);
                eventBus.post(eventInstance);
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
}
