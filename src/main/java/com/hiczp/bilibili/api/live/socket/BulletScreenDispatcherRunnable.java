package com.hiczp.bilibili.api.live.socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hiczp.bilibili.api.live.socket.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.function.Consumer;

public class BulletScreenDispatcherRunnable implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(BulletScreenDispatcherRunnable.class);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final JsonParser JSON_PARSER = new JsonParser();
    private SocketChannel socketChannel;
    private LiveClient liveClient;

    public BulletScreenDispatcherRunnable(SocketChannel socketChannel, LiveClient liveClient) {
        this.socketChannel = socketChannel;
        this.liveClient = liveClient;
    }

    private void invokeCallback(Consumer<BulletScreenListener> consumer) {
        Utils.invokeCallback(liveClient.getBulletScreenListeners(), consumer);
    }

    @Override
    public void run() {
        while (true) {
            try {
                ByteBuffer[] byteBuffers = PackageRepository.readNextPackageSplit(socketChannel);
                //如果没有回调则不解析数据包, 直接开始接收下一个数据包
                if (liveClient.getBulletScreenListeners().size() == 0) {
                    continue;
                }

                //判断数据包类型
                byte[] packageTypeBytes = byteBuffers[3].array();
                Consumer<BulletScreenListener> consumer = null;
                if (Arrays.equals(packageTypeBytes, PackageRepository.DATA_PACKAGE_TYPE_BYTES)) {   //弹幕
                    String json = new String(byteBuffers[5].array());
                    JsonObject jsonObject = JSON_PARSER.parse(json).getAsJsonObject();
                    String cmd = jsonObject.get("cmd").getAsString();
                    //判断 cmd
                    switch (cmd) {
                        case "DANMU_MSG": {
                            consumer = bulletScreenListener -> bulletScreenListener.onDanMuMSGPackage(GSON.fromJson(json, DanMuMSGEntity.class));
                        }
                        break;
                        case "SEND_GIFT": {
                            consumer = bulletScreenListener -> bulletScreenListener.onSendGiftPackage(GSON.fromJson(json, SendGiftEntity.class));
                        }
                        break;
                        case "SYS_MSG": {
                            consumer = bulletScreenListener -> bulletScreenListener.onSysMSGPackage(GSON.fromJson(json, SysMSGEntity.class));
                        }
                        break;
                        case "SYS_GIFT": {
                            consumer = bulletScreenListener -> bulletScreenListener.onSysGiftPackage(GSON.fromJson(json, SysGiftEntity.class));
                        }
                        break;
                        case "WELCOME": {
                            consumer = bulletScreenListener -> bulletScreenListener.onWelcomePackage(GSON.fromJson(json, WelcomeEntity.class));
                        }
                        break;
                        case "WELCOME_GUARD": {
                            consumer = bulletScreenListener -> bulletScreenListener.onWelcomeGuardPackage(GSON.fromJson(json, WelcomeGuardEntity.class));
                        }
                        break;
                        case "LIVE": {
                            consumer = bulletScreenListener -> bulletScreenListener.onLivePackage(GSON.fromJson(json, LiveEntity.class));
                        }
                        break;
                        case "PREPARING": {
                            consumer = bulletScreenListener -> bulletScreenListener.onPreparingPackage(GSON.fromJson(json, PreparingEntity.class));
                        }
                        break;
                        default: {   //未知的 cmd
                            LOGGER.error("Unknown json below: ");
                            GSON.toJson(jsonObject, System.out);
                            System.out.println();
                        }
                    }
                } else if (Arrays.equals(packageTypeBytes, PackageRepository.VIEWER_COUNT_PACKAGE_TYPE_BYTES)) { //在线人数
                    consumer = bulletScreenListener -> bulletScreenListener.onViewerCountPackage(byteBuffers[5].getInt());
                } else {    //未知类型
                    ByteBuffer byteBuffer = ByteBuffer.allocate(Arrays.stream(byteBuffers).mapToInt(ByteBuffer::limit).sum());
                    Arrays.stream(byteBuffers).forEach(byteBuffer::put);
                    byte[] bytes = byteBuffer.array();
                    LOGGER.error("Unknown package below: ");
                    Utils.printBytes(bytes);
                    consumer = bulletScreenListener -> bulletScreenListener.onUnknownPackage(bytes);
                }

                //执行回调
                invokeCallback(consumer);
            } catch (IOException e) {
                LOGGER.debug("Connection closed, BulletScreenDispatcherThread prepare to exit");
                try {
                    liveClient.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //调用 onDisconnect 回调
                invokeCallback(BulletScreenListener::onDisconnect);
                break;
            }
        }
    }
}
