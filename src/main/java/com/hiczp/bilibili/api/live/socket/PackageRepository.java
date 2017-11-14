package com.hiczp.bilibili.api.live.socket;

import com.google.gson.Gson;
import com.hiczp.bilibili.api.live.socket.entity.EnterRoomEntity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

//数据包结构说明
//00 00 00 28 00 10 00 00    00 00 00 07 00 00 00 00
//00 00 00 28/00 10/00 00    00 00 00 07/00 00 00 00
//1-4 字节: 数据包长度
//5-6 字节: 协议头长度, 固定值 0x10
//7-8 字节: 设备类型, Android 固定为 0
//9-12 字节: 数据包类型
//13-16 字节: 设备类型, 同 7-8 字节
public class PackageRepository {
    //数据包总长标识占用的 bytes 长度
    static final short PACKAGE_LENGTH_BYTES_LENGTH = 4;
    //协议头长度标识占用的 bytes 长度
    static final short PROTOCOL_HEAD_LENGTH_BYTES_LENGTH = 2;
    //设备类型短标识 bytes
    static final byte[] SHORT_DEVICE_TYPE_BYTES = {0x00, 0x00};
    //数据包类型标识 bytes
    static final short PACKAGE_TYPE_BYTES_LENGTH = 4;
    static final byte[] HEART_BEAT_PACKAGE_TYPE_BYTES = {0x00, 0x00, 0x00, 0x02};   //心跳包
    static final byte[] VIEWER_COUNT_PACKAGE_TYPE_BYTES = {0x00, 0x00, 0x00, 0x03}; //观众人数
    static final byte[] DATA_PACKAGE_TYPE_BYTES = {0x00, 0x00, 0x00, 0x05}; //弹幕, 礼物, 系统消息 etc
    static final byte[] ENTER_ROOM_PACKAGE_TYPE_BYTES = {0x00, 0x00, 0x00, 0x07};    //进入房间
    static final byte[] ENTER_ROOM_SUCCESS_PACKAGE_TYPE_BYTES = {0x00, 0x00, 0x00, 0x08};    //进入房间的响应包
    //设备类型长标识 bytes
    static final byte[] LONG_DEVICE_TYPE_BYTES = {0x00, 0x00, 0x00, 0x00};
    //协议头总长度
    static final short PROTOCOL_HEAD_LENGTH = (short) (PACKAGE_LENGTH_BYTES_LENGTH + PROTOCOL_HEAD_LENGTH_BYTES_LENGTH + SHORT_DEVICE_TYPE_BYTES.length + PACKAGE_TYPE_BYTES_LENGTH + LONG_DEVICE_TYPE_BYTES.length);
    //协议头长度标识 bytes
    static final byte[] PROTOCOL_HEAD_LENGTH_BYTES = ByteBuffer.allocate(PROTOCOL_HEAD_LENGTH_BYTES_LENGTH).putShort(PROTOCOL_HEAD_LENGTH).array();
    private static final Gson GSON = new Gson();

    private static ByteBuffer createPackage(byte[] packageTypeBytes, String content) {
        int totalLength = PROTOCOL_HEAD_LENGTH + content.length();
        ByteBuffer byteBuffer = ByteBuffer.allocate(totalLength)
                .putInt(totalLength)
                .put(PROTOCOL_HEAD_LENGTH_BYTES)
                .put(SHORT_DEVICE_TYPE_BYTES)
                .put(packageTypeBytes)
                .put(LONG_DEVICE_TYPE_BYTES)
                .put(content.getBytes());
        byteBuffer.flip();
        return byteBuffer;
    }

    private static void readDataFromSocketChannel(SocketChannel socketChannel, ByteBuffer byteBuffer) throws IOException {
        while (byteBuffer.hasRemaining()) {
            socketChannel.read(byteBuffer);
        }
    }

    //userId 为 0 表示用户未登录, 并不影响弹幕推送, 但是可能和用户统计有关
    public static ByteBuffer createEnterRoomPackage(int roomId, int userId) {
        return createPackage(ENTER_ROOM_PACKAGE_TYPE_BYTES, GSON.toJson(new EnterRoomEntity(roomId, userId)));
    }

    public static ByteBuffer createHeartBeatPackage(int roomId, int userId) {
        return createPackage(HEART_BEAT_PACKAGE_TYPE_BYTES, GSON.toJson(new EnterRoomEntity(roomId, userId)));
    }

    public static ByteBuffer readNextPackage(SocketChannel socketChannel) throws IOException {
        //获取数据包总长度
        ByteBuffer packageLengthByteBuffer = ByteBuffer.allocate(PACKAGE_LENGTH_BYTES_LENGTH);
        readDataFromSocketChannel(socketChannel, packageLengthByteBuffer);
        packageLengthByteBuffer.flip();
        int packageLength = packageLengthByteBuffer.getInt();
        packageLengthByteBuffer.rewind();

        //获取数据包剩下的部分
        ByteBuffer restPackageByteBuffer = ByteBuffer.allocate(packageLength - PACKAGE_LENGTH_BYTES_LENGTH);
        readDataFromSocketChannel(socketChannel, restPackageByteBuffer);
        restPackageByteBuffer.flip();

        //合并 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(packageLengthByteBuffer.limit() + restPackageByteBuffer.limit());
        byteBuffer.put(packageLengthByteBuffer).put(restPackageByteBuffer);
        byteBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer[] readNextPackageSplit(SocketChannel socketChannel) throws IOException {
        //获取数据包总长度
        ByteBuffer packageLengthByteBuffer = ByteBuffer.allocate(PACKAGE_LENGTH_BYTES_LENGTH);
        readDataFromSocketChannel(socketChannel, packageLengthByteBuffer);
        packageLengthByteBuffer.flip();
        int packageLength = packageLengthByteBuffer.getInt();
        packageLengthByteBuffer.rewind();

        //获取协议头长度
        ByteBuffer protocolHeadLengthByteBuffer = ByteBuffer.allocate(PROTOCOL_HEAD_LENGTH_BYTES_LENGTH);
        readDataFromSocketChannel(socketChannel, protocolHeadLengthByteBuffer);
        protocolHeadLengthByteBuffer.flip();
        int protocolHeadLength = protocolHeadLengthByteBuffer.getShort();
        protocolHeadLengthByteBuffer.rewind();

        //获取剩余的协议头
        ByteBuffer restProtocolHeadByteBuffer = ByteBuffer.allocate(protocolHeadLength - PACKAGE_LENGTH_BYTES_LENGTH - PROTOCOL_HEAD_LENGTH_BYTES_LENGTH);
        readDataFromSocketChannel(socketChannel, restProtocolHeadByteBuffer);
        restProtocolHeadByteBuffer.flip();

        //得到设备类型短标识
        ByteBuffer shortDeviceTypeByteBuffer = ByteBuffer.allocate(SHORT_DEVICE_TYPE_BYTES.length);
        shortDeviceTypeByteBuffer.putShort(restProtocolHeadByteBuffer.getShort());
        shortDeviceTypeByteBuffer.flip();

        //得到数据包类型
        ByteBuffer packageTypeByteBuffer = ByteBuffer.allocate(PACKAGE_TYPE_BYTES_LENGTH);
        packageTypeByteBuffer.putInt(restProtocolHeadByteBuffer.getInt());
        packageTypeByteBuffer.flip();

        //得到设备类型长标识
        ByteBuffer longDeviceTypeByteBuffer = ByteBuffer.allocate(LONG_DEVICE_TYPE_BYTES.length);
        longDeviceTypeByteBuffer.putInt(restProtocolHeadByteBuffer.getInt());
        longDeviceTypeByteBuffer.flip();

        //获取正文
        ByteBuffer contentByteBuffer = ByteBuffer.allocate(packageLength - protocolHeadLength);
        readDataFromSocketChannel(socketChannel, contentByteBuffer);
        contentByteBuffer.flip();

        //组成数组
        return new ByteBuffer[]{
                packageLengthByteBuffer,        //0
                protocolHeadLengthByteBuffer,   //1
                shortDeviceTypeByteBuffer,      //2
                packageTypeByteBuffer,          //3
                longDeviceTypeByteBuffer,       //4
                contentByteBuffer               //5
        };
    }

    public static boolean isNextPackageIsEnterRoomSuccessPackage(SocketChannel socketChannel) throws IOException {
        return Arrays.equals(readNextPackageSplit(socketChannel)[3].array(), ENTER_ROOM_SUCCESS_PACKAGE_TYPE_BYTES);
    }
}
