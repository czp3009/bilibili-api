package com.hiczp.bilibili.api.live.socket;

import com.google.gson.Gson;
import com.hiczp.bilibili.api.live.socket.entity.EnterRoomEntity;

public class PackageHelper {
    private static final Gson GSON = new Gson();

    public static Package createEnterRoomPackage(long roomId, long userId) {
        return new Package(
                Package.PackageType.ENTER_ROOM,
                GSON.toJson(new EnterRoomEntity(roomId, userId)).getBytes()
        );
    }

    public static Package createHeartBeatPackage() {
        return new Package(
                Package.PackageType.HEART_BEAT,
                new byte[0]
        );
    }
}
