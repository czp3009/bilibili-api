package com.hiczp.bilibili.api.live.socket;

import com.google.gson.Gson;
import com.hiczp.bilibili.api.live.socket.entity.EnterRoomEntity;

public class PackageHelper {
    private static final Gson GSON = new Gson();

    /**
     * 创建一个进房数据包
     *
     * @param roomId 房间号
     * @param userId 用户号
     * @return 进房数据包
     */
    public static Package createEnterRoomPackage(long roomId, long userId) {
        return new Package(
                Package.PackageType.ENTER_ROOM,
                GSON.toJson(new EnterRoomEntity(roomId, userId)).getBytes()
        );
    }

    /**
     * 创建一个心跳包
     * @return 心跳包
     */
    public static Package createHeartBeatPackage() {
        return new Package(
                Package.PackageType.HEART_BEAT,
                new byte[0]
        );
    }
}
