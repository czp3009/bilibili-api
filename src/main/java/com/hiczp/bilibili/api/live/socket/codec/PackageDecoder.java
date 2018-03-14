package com.hiczp.bilibili.api.live.socket.codec;

import com.hiczp.bilibili.api.live.socket.Package;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 数据包解码器
 */
public class PackageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int packageLength = in.readInt();
        short protocolHeadLength = in.readShort();
        Package.DeviceType shortDeviceType = Package.DeviceType.valueOf(in.readShort());
        Package.PackageType packageType = Package.PackageType.valueOf(in.readInt());
        Package.DeviceType longDeviceType = Package.DeviceType.valueOf(in.readInt());
        byte[] content = new byte[packageLength - protocolHeadLength];
        in.readBytes(content);

        out.add(new Package(
                packageLength,
                protocolHeadLength,
                shortDeviceType,
                packageType,
                longDeviceType,
                content
        ));
    }
}
