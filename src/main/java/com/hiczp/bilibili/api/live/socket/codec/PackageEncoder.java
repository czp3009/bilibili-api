package com.hiczp.bilibili.api.live.socket.codec;

import com.hiczp.bilibili.api.live.socket.Package;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 数据包编码器
 */
public class PackageEncoder extends MessageToByteEncoder<Package> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Package msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getPackageLength())
                .writeShort(msg.getProtocolHeadLength())
                .writeShort(msg.getShortDeviceType().getValue())
                .writeInt(msg.getPackageType().getValue())
                .writeInt(msg.getLongDeviceType().getValue())
                .writeBytes(msg.getContent());
    }
}
