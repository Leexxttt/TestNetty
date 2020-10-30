package IM.handler;

import IM.packet.login.LoginRequestPacket;
import IM.packet.login.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author lixt
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        if (msg.getPassword().equals("000000") && msg.getUsername().equals("lixt")) {
            responsePacket.setSuccess(true);
            responsePacket.setReason("登录成功");
            System.out.println("登录成功");
        } else {
            responsePacket.setSuccess(false);
            responsePacket.setReason("账号密码错误");
            System.out.println("登录失败");
        }
        ctx.channel().writeAndFlush(responsePacket);
    }
}
