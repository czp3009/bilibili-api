package com.hiczp.bilibili.api.test;

import com.google.common.eventbus.Subscribe;
import com.hiczp.bilibili.api.BilibiliAPI;
import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.entity.*;
import com.hiczp.bilibili.api.live.socket.event.*;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LiveClientTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClientTest.class);
    private static final BilibiliAPI BILIBILI_API = Config.getBilibiliAPI();
    private static final Config CONFIG = Config.getInstance();
    private static final long TEST_TIME = 70 * 1000;

    @Ignore
    @Test
    public void _0_duplicateConnectAndCloseTest() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        LiveClient liveClient = BILIBILI_API
                .getLiveClient(eventLoopGroup, CONFIG.getRoomId());
        LOGGER.debug("Connecting!");
        liveClient.connect();
        Thread.sleep(5000);
        LOGGER.debug("Connecting!");
        liveClient.connect();
        Thread.sleep(5000);
        LOGGER.debug("Disconnecting!");
        liveClient.closeChannel();
        Thread.sleep(5000);
        LOGGER.debug("Disconnecting!");
        liveClient.closeChannel();
        Thread.sleep(5000);
        LOGGER.debug("Connecting!");
        liveClient.connect();
        Thread.sleep(5000);
        LOGGER.debug("Disconnecting!");
        liveClient.closeChannel();
        Thread.sleep(5000);
        eventLoopGroup.shutdownGracefully();
    }

    @Ignore
    @Test
    public void _1_longTimeTest() throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        LiveClient liveClient = BILIBILI_API
                .getLiveClient(eventLoopGroup, CONFIG.getRoomId())
                .registerListener(new Listener());
        LOGGER.debug("Start long-time test");
        LOGGER.debug("Connecting!");
        liveClient.connect();
        Thread.sleep(TEST_TIME);
        LOGGER.debug("Disconnecting!");
        liveClient.closeChannel();
        eventLoopGroup.shutdownGracefully();
        Thread.sleep(5000);
    }

    private class Listener {
        private final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

        @Subscribe
        public void activityEvent(ActivityEventPackageEvent activityEventPackageEvent) {
            ActivityEventEntity.Data data = activityEventPackageEvent.getEntity().getData();
            LOGGER.info("[ActivityEvent] keyword: {}, type: {}, progress: {}%",
                    data.getKeyword(),
                    data.getType(),
                    ((float) data.getProgress() / data.getLimit()) * 100
            );
        }

        @Subscribe
        public void connectionClose(ConnectionCloseEvent connectionCloseEvent) {
            LOGGER.info("[ConnectionClose] Connection closed");
        }

        @Subscribe
        public void connectSucceed(ConnectSucceedEvent connectSucceedEvent) {
            LOGGER.info("[ConnectSucceed] Connect succeed");
        }

        @Subscribe
        public void danMuMsg(DanMuMsgPackageEvent danMuMsgPackageEvent) {
            DanMuMsgEntity danMuMsgEntity = danMuMsgPackageEvent.getEntity();
            StringBuilder stringBuilder = new StringBuilder("[DanMuMsg] ");

            danMuMsgEntity.getFansMedalName().ifPresent(fansMedalName ->
                    stringBuilder.append(String.format("[%s %d] ", fansMedalName, danMuMsgEntity.getFansMedalLevel().get()))
            );

            List<String> userTitles = danMuMsgEntity.getUserTitles();
            if (!userTitles.isEmpty()) {
                stringBuilder.append(userTitles.get(0))
                        .append(" ");
            }

            stringBuilder.append(String.format("[UL %d] ", danMuMsgEntity.getUserLevel()));

            stringBuilder.append(String.format("%s: ", danMuMsgEntity.getUsername()));

            stringBuilder.append(danMuMsgEntity.getMessage());

            LOGGER.info(stringBuilder.toString());
        }

        @Subscribe
        public void live(LivePackageEvent livePackageEvent) {
            LOGGER.info("[Live] Room {} start live", livePackageEvent.getEntity().getRoomId());
        }

        @Subscribe
        public void preparing(PreparingPackageEvent preparingPackageEvent) {
            LOGGER.info("[Preparing] Room {} stop live", preparingPackageEvent.getEntity().getRoomId());
        }

        @Subscribe
        public void sendGift(SendGiftPackageEvent sendGiftPackageEvent) {
            SendGiftEntity.Data data = sendGiftPackageEvent.getEntity().getData();
            LOGGER.info("[SendGift] {} give {}*{}",
                    data.getUsername(),
                    data.getGiftName(),
                    data.getNumber()
            );
        }

        @Subscribe
        public void sysGift(SysGiftPackageEvent sysGiftPackageEvent) {
            SysGiftEntity sysGiftEntity = sysGiftPackageEvent.getEntity();
            LOGGER.info("[SysGift] {}: {}",
                    sysGiftEntity.getMsg(),
                    sysGiftEntity.getUrl()
            );
        }

        @Subscribe
        public void sysMsg(SysMsgPackageEvent sysMsgPackageEvent) {
            SysMsgEntity sysMsgEntity = sysMsgPackageEvent.getEntity();
            LOGGER.info("[SysMsg] {}: {}",
                    sysMsgEntity.getMsg(),
                    sysMsgEntity.getUrl()
            );
        }

        @Subscribe
        public void tvEnd(TVEndPackageEvent tvEndPackageEvent) {
            TVEndEntity tvEndEntity = tvEndPackageEvent.getEntity();
            LOGGER.info("[TVEnd] user {} win the {}",
                    tvEndEntity.getData().getUsername(),
                    tvEndEntity.getData().getType()
            );
        }

        @Subscribe
        public void welcome(WelcomePackageEvent welcomePackageEvent) {
            WelcomeEntity.Data data = welcomePackageEvent.getEntity().getData();
            StringBuilder stringBuilder = new StringBuilder("[Welcome] ");
            if (data.isAdmin()) {
                stringBuilder.append("[ADMIN] ");
            }
            stringBuilder.append(String.format("[VIP %d] ", data.getVip()))
                    .append(data.getUserName());
            LOGGER.info(stringBuilder.toString());
        }

        @Subscribe
        public void welcomeGuard(WelcomeGuardPackageEvent welcomeGuardPackageEvent) {
            WelcomeGuardEntity.Data data = welcomeGuardPackageEvent.getEntity().getData();
            LOGGER.info("[WelcomeGuard] [GL {}] {}",
                    data.getGuardLevel(),
                    data.getUsername()
            );
        }

        @Subscribe
        public void viewerCount(ViewerCountPackageEvent viewerCountPackageEvent) {
            LOGGER.info("[ViewerCount] {}", viewerCountPackageEvent.getViewerCount());
        }
    }
}
