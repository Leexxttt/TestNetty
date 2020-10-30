package IM.handler;

import IM.codec.PacketCodec;
import IM.packet.message.MessageRequestPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author lixt
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 1000; i++) {
            //ByteBuf byteBuf = getByteBuf(ctx);
            MessageRequestPacket packet = new MessageRequestPacket();
            packet.setMessage("hello netty!");
            ByteBuf encode = PacketCodec.INSTANCE.encode(ctx.alloc().ioBuffer(), packet);
            ctx.channel().writeAndFlush(encode);
        }
    }

//    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
//        byte[] bytes = "你好，欢迎使用Netty!".getBytes(Charset.forName("utf-8"));
//        ByteBuf buffer = ctx.alloc().buffer();
//        buffer.writeBytes(bytes);
//
//        return buffer;
//    }
}
