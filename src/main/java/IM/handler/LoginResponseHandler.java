package IM.handler;

import IM.packet.login.LoginRequestPacket;
import IM.packet.login.LoginResponsePacket;
import IM.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author lixt
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        LoginRequestPacket requestPacket = new LoginRequestPacket();
        requestPacket.setUserId(1);
        requestPacket.setUsername("lixt");
        requestPacket.setPassword("000000");
        //写数据
        ctx.channel().writeAndFlush(requestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket responsePacket) throws Exception {
        System.out.println(responsePacket.getReason());
        if (responsePacket.isSuccess()) {
            //标记用户登录成功
            LoginUtil.markAsLogin(ctx.channel());
        }
    }
}
