package com.hiczp.bilibili.api.live.socket;

/**
 * 数据包结构说明
 * 00 00 00 28/00 10/00 00    00 00 00 07/00 00 00 00
 * 1-4 字节: 数据包长度
 * 5-6 字节: 协议头长度, 固定值 0x10
 * 7-8 字节: 设备类型, Android 固定为 0
 * 9-12 字节: 数据包类型
 * 13-16 字节: 设备类型, 同 7-8 字节
 * 之后的字节为数据包正文, 大多数情况下为 JSON
 */
public class Package {
    public static final short LENGTH_FIELD_LENGTH = 4;

    private static final short PROTOCOL_HEAD_LENGTH = 16;

    private final int packageLength;
    private final short protocolHeadLength;
    private final DeviceType shortDeviceType;
    private final PackageType packageType;
    private final DeviceType longDeviceType;
    private final byte[] content;

    public Package(int packageLength, short protocolHeadLength, DeviceType shortDeviceType, PackageType packageType, DeviceType longDeviceType, byte[] content) {
        this.packageLength = packageLength;
        this.protocolHeadLength = protocolHeadLength;
        this.shortDeviceType = shortDeviceType;
        this.packageType = packageType;
        this.longDeviceType = longDeviceType;
        this.content = content;
    }

    public Package(PackageType packageType, byte[] content) {
        this(PROTOCOL_HEAD_LENGTH + content.length,
                PROTOCOL_HEAD_LENGTH,
                DeviceType.ANDROID,
                packageType,
                DeviceType.ANDROID,
                content
        );
    }

    public int getPackageLength() {
        return packageLength;
    }

    public short getProtocolHeadLength() {
        return protocolHeadLength;
    }

    public DeviceType getShortDeviceType() {
        return shortDeviceType;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public DeviceType getLongDeviceType() {
        return longDeviceType;
    }

    public byte[] getContent() {
        return content;
    }

    public enum DeviceType {
        ANDROID(0x00);

        private final int value;

        DeviceType(int value) {
            this.value = value;
        }

        public static DeviceType valueOf(int value) {
            for (DeviceType deviceType : DeviceType.values()) {
                if (deviceType.value == value) {
                    return deviceType;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + value + "]");
        }

        public int getValue() {
            return value;
        }
    }

    public enum PackageType {
        HEART_BEAT(0x02),
        VIEWER_COUNT(0x03),
        DATA(0x05),
        ENTER_ROOM(0x07),
        ENTER_ROOM_SUCCESS(0x08);

        private final int value;

        PackageType(int value) {
            this.value = value;
        }

        public static PackageType valueOf(int value) {
            for (PackageType packageType : PackageType.values()) {
                if (packageType.value == value) {
                    return packageType;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + value + "]");
        }

        public int getValue() {
            return value;
        }
    }
}
