package IM.handler;

import IM.codec.PacketCodec;
import IM.packet.Packet;
import IM.packet.login.LoginRequestPacket;
import IM.packet.login.LoginResponsePacket;
import IM.packet.message.MessageRequestPacket;
import IM.packet.message.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author lixt
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf) msg;
//        //解码
//        Packet packet = PacketCodec.INSTANCE.decode(byteBuf);
//        if (packet instanceof LoginRequestPacket) {
//            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
//            //校验账密
//            LoginResponsePacket responsePacket = new LoginResponsePacket();
//            if (true) {
//                responsePacket.setSuccess(true);
//                responsePacket.setReason("登录成功");
//            } else {
//                responsePacket.setSuccess(false);
//                responsePacket.setReason("账号密码错误");
//            }
//            ByteBuf writeBuf = PacketCodec.INSTANCE.encode(ctx.alloc(), responsePacket);
//            ctx.channel().writeAndFlush(writeBuf);
//        } else if (packet instanceof MessageRequestPacket) {
//            MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
//            System.out.println(messageRequestPacket.getMessage());
//            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
//            messageResponsePacket.setMessage("服务端回复：" + messageRequestPacket.getMessage());
//            ByteBuf writeBuf = PacketCodec.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
//            ctx.channel().writeAndFlush(writeBuf);
//        }
    }
}
