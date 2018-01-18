package com.hiczp.bilibili.api.test;

import com.google.gson.Gson;
import com.hiczp.bilibili.api.BilibiliRESTAPI;
import com.hiczp.bilibili.api.live.entity.BulletScreenEntity;
import com.hiczp.bilibili.api.live.entity.LiveRoomInfoEntity;
import com.hiczp.bilibili.api.live.entity.SendBulletScreenResponseEntity;
import com.hiczp.bilibili.api.live.socket.BulletScreenListenerAdaptor;
import com.hiczp.bilibili.api.live.socket.LiveClient;
import com.hiczp.bilibili.api.live.socket.PackageRepository;
import com.hiczp.bilibili.api.live.socket.Utils;
import com.hiczp.bilibili.api.live.socket.entity.DanMuMSGEntity;
import com.hiczp.bilibili.api.live.socket.entity.LiveEntity;
import com.hiczp.bilibili.api.live.socket.entity.PreparingEntity;
import com.hiczp.bilibili.api.live.socket.entity.SendGiftEntity;
import com.hiczp.bilibili.api.live.socket.entity.SysGiftEntity;
import com.hiczp.bilibili.api.live.socket.entity.SysMSGEntity;
import com.hiczp.bilibili.api.live.socket.entity.WelcomeEntity;
import com.hiczp.bilibili.api.live.socket.entity.WelcomeGuardEntity;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Ignore
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LiveRoomTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveRoomTest.class);
    private static final Config CONFIG = Config.getInstance();
    private static final int USER_ID = BilibiliRESTAPI.getMid();
    private static final int STOP_AFTER_N_HEART_BEATS = 3;
    private static final int STOP_AFTER_SECOND = 90;

    @Ignore
    @Test
    public void _0socketTest() throws IOException {
        LOGGER.info("Start socket connection to live Bullet Screen stream server, test continue for {} heart beat", STOP_AFTER_N_HEART_BEATS);
        LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity = BilibiliRESTAPI.getLiveService().getRoomInfo(CONFIG.getRoomId()).execute().body().getData();
        int roomId = liveRoomEntity.getRoomId();

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(liveRoomEntity.getCmt(), liveRoomEntity.getCmtPortGoim()));
        socketChannel.write(PackageRepository.createEnterRoomPackage(roomId, USER_ID));
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Utils.printBytes(PackageRepository.readNextPackage(socketChannel).array());
                    System.out.println();
                } catch (IOException e) {
                    break;
                }
            }
        });
        thread.start();

        for (int i = STOP_AFTER_N_HEART_BEATS; i > 0; i--) {
            socketChannel.write(PackageRepository.createHeartBeatPackage(roomId, USER_ID));
            LOGGER.debug("Send heart beat package");
            BilibiliRESTAPI.getLiveService().sendBulletScreen(new BulletScreenEntity(roomId, "send heart beat")).enqueue(new Callback<SendBulletScreenResponseEntity>() {
                private Gson gson = new Gson();

                @Override
                public void onResponse(Call<SendBulletScreenResponseEntity> call, Response<SendBulletScreenResponseEntity> response) {
                    gson.toJson(response.body(), System.out);
                    System.out.println();
                }

                @Override
                public void onFailure(Call<SendBulletScreenResponseEntity> call, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        socketChannel.close();
    }

    @Ignore
    @Test
    public void _1liveClientTest() throws IOException {
        int roomId = CONFIG.getRoomId();
        LOGGER.info("Start LiveClientTest for room {}", roomId);
        LiveClient liveClient = new LiveClient(roomId, USER_ID)
                .addListener(new BulletScreenListenerAdaptor() {
                    @Override
                    public void onConnect() {
                        LOGGER.info("Connected");
                    }

                    @Override
                    public void onDisconnect() {
                        LOGGER.info("Disconnected");
                    }

                    @Override
                    public void onViewerCountPackage(int viewerCount) {
                        LOGGER.info("Current viewers: {}", viewerCount);
                    }

                    @Override
                    public void onDanMuMSGPackage(DanMuMSGEntity danMuMSGEntity) {
                        LOGGER.info("[{}]{}", danMuMSGEntity.getUsername(), danMuMSGEntity.getMessage());
                    }

                    @Override
                    public void onSendGiftPackage(SendGiftEntity sendGiftEntity) {
                        SendGiftEntity.DataEntity dataEntity = sendGiftEntity.getData();
                        LOGGER.info("{} send {} * {}", dataEntity.getUserName(), dataEntity.getGiftName(), dataEntity.getNum());
                    }

                    @Override
                    public void onSysMSGPackage(SysMSGEntity sysMSGEntity) {
                        LOGGER.info("System message: {} {}", sysMSGEntity.getMsg(), sysMSGEntity.getUrl());
                    }

                    @Override
                    public void onSysGiftPackage(SysGiftEntity sysGiftEntity) {
                        LOGGER.info("System gift: {} {}", sysGiftEntity.getMsg(), sysGiftEntity.getUrl());
                    }

                    @Override
                    public void onWelcomePackage(WelcomeEntity welcomeEntity) {
                        LOGGER.info("Welcome {}", welcomeEntity.getData().getUserName());
                    }

                    @Override
                    public void onWelcomeGuardPackage(WelcomeGuardEntity welcomeGuardEntity) {
                        WelcomeGuardEntity.DataEntity dataEntity = welcomeGuardEntity.getData();
                        LOGGER.info("Welcome guard [Lv{}]{}", dataEntity.getGuardLevel(), dataEntity.getUsername());
                    }

                    @Override
                    public void onLivePackage(LiveEntity liveEntity) {
                        LOGGER.info("Room {} start live", liveEntity.getRoomId());
                    }

                    @Override
                    public void onPreparingPackage(PreparingEntity preparingEntity) {
                        LOGGER.info("Room {} stop live", preparingEntity.getRoomId());
                    }
                })
                .connect();
        try {
            Thread.sleep(STOP_AFTER_SECOND * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liveClient.close();
    }
}
