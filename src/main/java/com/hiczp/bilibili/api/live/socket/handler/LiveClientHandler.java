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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LiveClientHandler extends SimpleChannelInboundHandler<Package> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClientHandler.class);
    private static final Gson GSON = new Gson();
    private static final Gson PRETTY_PRINTING_GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final JsonParser JSON_PARSER = new JsonParser();
    private static final Object[] CMD_AND_EVENT_ARRAY = new Object[]{
            "ACTIVITY_EVENT", ActivityEventPackageEvent.class,  //活动事件
            "CHANGE_ROOM_INFO", ChangeRoomInfoPackageEvent.class,   //更换房间背景图片
            "COMBO_END", ComboEndPackageEvent.class,    //COMBO
            "COMBO_SEND", ComboSendPackageEvent.class,
            "CUT_OFF", CutOffPackageEvent.class,    //被 B站 管理员强制中断
            "DANMU_MSG", DanMuMsgPackageEvent.class,    //弹幕消息
            "ENTRY_EFFECT", EntryEffectPackageEvent.class,  //TODO 尚不明确 EntryEffect 和普通 Welcome 的区别
            "EVENT_CMD", EventCmdPackageEvent.class,    //TODO 尚不明确 EVENT_CMD 的含义
            "GUARD_BUY", GuardBuyPackageEvent.class,    //船票购买
            "GUARD_LOTTERY_START", GuardLotteryStartPackageEvent.class,  //船票购买后的抽奖活动
            "GUARD_MSG", GuardMsgPackageEvent.class,    //舰队消息(登船)
            "LIVE", LivePackageEvent.class,  //开始直播
            "NOTICE_MSG", NoticeMsgPackageEvent.class,   //获得大奖的通知消息
            "PK_AGAIN", PkAgainPackageEvent.class,  //PK
            "PK_CLICK_AGAIN", PkClickAgainPackageEvent.class,
            "PK_END", PkEndPackageEvent.class,
            "PK_INVITE_FAIL", PkInviteFailPackageEvent.class,
            "PK_INVITE_INIT", PkInviteInitPackageEvent.class,
            "PK_INVITE_SWITCH_CLOSE", PkInviteSwitchClosePackageEvent.class,
            "PK_INVITE_SWITCH_OPEN", PkInviteSwitchOpenPackageEvent.class,
            "PK_MATCH", PkMatchPackageEvent.class,
            "PK_MIC_END", PkMicEndPackageEvent.class,
            "PK_PRE", PkPrePackageEvent.class,
            "PK_PROCESS", PkProcessPackageEvent.class,
            "PK_SETTLE", PkSettlePackageEvent.class,
            "PK_START", PkStartPackageEvent.class,
            "PREPARING", PreparingPackageEvent.class,    //停止直播
            "RAFFLE_END", RaffleEndPackageEvent.class,  //抽奖结束
            "RAFFLE_START", RaffleStartPackageEvent.class,  //抽奖开始(小奖, 通常是不定期活动)
            "ROOM_ADMINS", RoomAdminsPackageEvent.class,    //房管变更
            "ROOM_BLOCK_MSG", RoomBlockMsgPackageEvent.class,   //房间黑名单(房间管理员添加了一个用户到黑名单)
            "ROOM_LOCK", RoomLockPackageEvent.class,    //房间被封
            "ROOM_RANK", RoomRankPackageEvent.class,    //小时榜
            "ROOM_SHIELD", RoomShieldPackageEvent.class,    //房间屏蔽
            "ROOM_SILENT_OFF", RoomSilentOffPackageEvent.class, //房间结束禁言
            "ROOM_SILENT_ON", RoomSilentOnPackageEvent.class,   //房间开启了禁言(禁止某一等级以下的用户发言)
            "SEND_GIFT", SendGiftPackageEvent.class,    //送礼
            "SPECIAL_GIFT", SpecialGiftPackageEvent.class,  //节奏风暴(20 倍以下的)
            "SYS_GIFT", SysGiftPackageEvent.class,  //系统礼物(节奏风暴, 活动抽奖等)
            "SYS_MSG", SysMsgPackageEvent.class,    //系统消息(小电视等)
            "TV_END", TVEndPackageEvent.class,  //小电视抽奖结束(大奖的获得者信息)
            "TV_START", TVStartPackageEvent.class,  //小电视抽奖开始
            "WARNING", WarningPackageEvent.class,   //警告消息
            "WELCOME_ACTIVITY", WelcomeActivityPackageEvent.class,  //欢迎(活动)
            "WELCOME", WelcomePackageEvent.class,  //欢迎(通常是 VIP)
            "WELCOME_GUARD", WelcomeGuardPackageEvent.class,    //欢迎(舰队)
            "WISH_BOTTLE", WishBottlePackageEvent.class //许愿瓶
    };
    private static final Map<String, Class<? extends ReceiveDataPackageEvent>> EVENT_MAP = new HashMap<>();

    static {
        for (int i = 0; i < CMD_AND_EVENT_ARRAY.length; i += 2) {
            //noinspection unchecked
            EVENT_MAP.put((String) CMD_AND_EVENT_ARRAY[i], (Class<? extends ReceiveDataPackageEvent>) CMD_AND_EVENT_ARRAY[i + 1]);
        }
    }

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
                } catch (JsonSyntaxException | IllegalStateException | NullPointerException e) {    //json 无法解析或者 cmd 字段不存在
                    LOGGER.error("Receive invalid json in room {}: \n{}",
                            liveClient.getRoomIdOrShowRoomId(),
                            new String(msg.getContent(), StandardCharsets.UTF_8)
                    );
                    e.printStackTrace();
                    break;
                }
                eventBus.post(new ReceiveDataPackageDebugEvent(liveClient, jsonObject, cmd));   //debug 用

                Class<? extends ReceiveDataPackageEvent> eventType = EVENT_MAP.get(cmd);

                //UnknownPackage
                if (eventType == null) {
                    LOGGER.error("Received unknown json below in room {}: \n{}",
                            liveClient.getRoomIdOrShowRoomId(),
                            PRETTY_PRINTING_GSON.toJson(jsonObject)
                    );
                    eventBus.post(new UnknownPackageEvent(liveClient, jsonObject, cmd));
                    break;
                }

                @SuppressWarnings("unchecked")
                Class<? extends DataEntity> entityType = (Class<? extends DataEntity>) ((ParameterizedType) eventType.getGenericSuperclass()).getActualTypeArguments()[0];
                DataEntity entityInstance;
                try {
                    entityInstance = GSON.fromJson(jsonObject, entityType);
                } catch (JsonParseException e) {    //json 无法解析
                    LOGGER.error("Json parse error in room {}: {}, json below: \n{}",
                            liveClient.getRoomIdOrShowRoomId(),
                            e.getMessage(),
                            PRETTY_PRINTING_GSON.toJson(jsonObject)
                    );
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
