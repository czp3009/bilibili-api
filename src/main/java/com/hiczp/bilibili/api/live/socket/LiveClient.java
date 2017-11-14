package com.hiczp.bilibili.api.live.socket;

import com.hiczp.bilibili.api.BilibiliRESTAPI;
import com.hiczp.bilibili.api.live.LiveService;
import com.hiczp.bilibili.api.live.entity.LiveRoomInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class LiveClient implements Closeable {
    private static final Logger LOGGER = LoggerFactory.getLogger(LiveClient.class);

    private int showRoomId;
    private int roomId;
    private int userId = BilibiliRESTAPI.getMid();
    private LiveService liveService = BilibiliRESTAPI.getLiveService();
    private Vector<BulletScreenListener> bulletScreenListeners = new Vector<>();
    private LiveRoomInfoEntity.LiveRoomEntity liveRoomEntity;
    private SocketChannel socketChannel;
    private Thread bulletScreenDispatcherThread;
    private Timer heartBeatTimer;

    public LiveClient(int showRoomId) {
        this.showRoomId = showRoomId;
    }

    //如果不传入 userId, 将使用默认值 0
    public LiveClient(int showRoomId, int userId) {
        this.showRoomId = showRoomId;
        this.userId = userId;
    }

    public LiveClient addListener(BulletScreenListener bulletScreenListener) {
        bulletScreenListeners.add(bulletScreenListener);
        return this;
    }

    public LiveClient removeListener(BulletScreenListener bulletScreenListener) {
        bulletScreenListeners.remove(bulletScreenListener);
        return this;
    }

    public LiveClient connect() throws IOException {
        LOGGER.info("Entering live room {} with uid {}", showRoomId, userId);
        //获取直播间信息
        LiveRoomInfoEntity liveRoomInfoEntity = liveService.getRoomInfo(showRoomId).execute().body();
        if (liveRoomInfoEntity.getCode() != 0) {
            LOGGER.error("Can't get live room info");
            throw new IOException(liveRoomInfoEntity.getMessage());
        }
        liveRoomEntity = liveRoomInfoEntity.getData();
        roomId = liveRoomEntity.getRoomId();
        LOGGER.debug("Real room id: {}", roomId);

        //socket 连接
        String address = liveRoomEntity.getCmt();
        int port = liveRoomEntity.getCmtPortGoim();
        LOGGER.info("Connect to {}:{}", address, port);
        socketChannel = SocketChannel.open(new InetSocketAddress(address, port));
        //发送进房包
        socketChannel.write(PackageRepository.createEnterRoomPackage(roomId, userId));
        //验证下一个数据包是否是进房成功数据包
        if (PackageRepository.isNextPackageIsEnterRoomSuccessPackage(socketChannel)) {
            LOGGER.info("Socket connection success");
            //调用 onConnect 回调
            Utils.invokeCallback(bulletScreenListeners, BulletScreenListener::onConnect);
        } else {
            LOGGER.error("Socket connection failed");
            socketChannel.close();
            throw new SocketException("Can't connection to Bullet Screen server");
        }

        //启动回调分发线程
        bulletScreenDispatcherThread = new Thread(new BulletScreenDispatcherRunnable(socketChannel, this));
        bulletScreenDispatcherThread.setName("BulletScreenDispatcherThread");
        bulletScreenDispatcherThread.start();
        LOGGER.debug("BulletScreenDispatcherThread started");

        //启动心跳包线程
        heartBeatTimer = new Timer("LiveHeartBeatThread");
        heartBeatTimer.schedule(new TimerTask() {
            private final Logger logger = LoggerFactory.getLogger(TimerTask.class);

            @Override
            public void run() {
                try {
                    socketChannel.socket().getOutputStream().write(PackageRepository.createHeartBeatPackage(roomId, userId).array());
                    logger.debug("Send heart beat package success");
                } catch (IOException e) {
                    logger.debug("Connection closed, cancel HeartBeatTimerTask");
                    cancel();
                    try {
                        close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }, 0, 30 * 1000);
        LOGGER.debug("HeatBeatTimer started");

        return this;
    }

    @Override
    public synchronized void close() throws IOException {
        if (heartBeatTimer != null) {
            heartBeatTimer.cancel();
            LOGGER.debug("HeartBeatTimer canceled");
            heartBeatTimer = null;
        }
        if (socketChannel != null && socketChannel.isConnected()) {
            socketChannel.close();
            LOGGER.debug("Socket closed");
            socketChannel = null;
        }
    }

    public Vector<BulletScreenListener> getBulletScreenListeners() {
        return bulletScreenListeners;
    }

    public void setBulletScreenListeners(Vector<BulletScreenListener> bulletScreenListeners) {
        this.bulletScreenListeners = bulletScreenListeners;
    }

    public LiveRoomInfoEntity.LiveRoomEntity getLiveRoomEntity() {
        return liveRoomEntity;
    }
}
