package IM.handler;

import IM.codec.PacketCodec;
import IM.packet.Packet;
import IM.packet.login.LoginRequestPacket;
import IM.packet.login.LoginResponsePacket;
import IM.packet.message.MessageResponsePacket;
import IM.util.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author lixt
 * @description TODO
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        LoginRequestPacket requestPacket = new LoginRequestPacket();
//        requestPacket.setUserId(1);
//        requestPacket.setUsername("lixt");
//        requestPacket.setPassword("000000");
//
//        //编码
//        PacketCodec packetCodec = PacketCodec.INSTANCE;
//        ByteBuf byteBuf = packetCodec.encode(ctx.alloc(), requestPacket);
//        //写数据
//        ctx.channel().writeAndFlush(byteBuf);
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf) msg;
//        Packet packet = PacketCodec.INSTANCE.decode(byteBuf);
//        if (packet instanceof LoginResponsePacket) {
//            LoginResponsePacket responsePacket = (LoginResponsePacket) packet;
//            System.out.println(responsePacket.getReason());
//            if (responsePacket.isSuccess()) {
//                //标记用户登录成功
//                LoginUtil.markAsLogin(ctx.channel());
//            }
//        } else if (packet instanceof MessageResponsePacket) {
//            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
//            System.out.println(messageResponsePacket.getMessage());
//        }
//    }

}
