package test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author lixt
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //获取
        ByteBuf byteBuf = getByteBuf(ctx);
        byteBuf.capacity();
        byteBuf.maxCapacity();
        byteBuf.readableBytes();
        byteBuf.isReadable();
        byteBuf.writableBytes();
        byteBuf.isWritable();
        byteBuf.maxWritableBytes();
        //引用加1
        byteBuf.retain();
        //引用减1
        byteBuf.release();
        //和 元 byteBuf 引用的相同内存地址 元 数据回收 截取的byteBuf 调用 报错
        //截取 [readerIndex, writerIndex]
        byteBuf.slice();
        //截取 [readerIndex, writerIndex] 引用+1
        byteBuf.retainedSlice();
        //截取byteBuf 全部
        ByteBuf duplicate = byteBuf.duplicate();
        //截取byteBuf 全部 引用+1
        ByteBuf byteBuf1 = byteBuf.retainedDuplicate();
        // 复制元数据 不再是同一地址
        ByteBuf copy = byteBuf.copy();


        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(byteBuf.toString(Charset.forName("utf-8")));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        ByteBuf buffer = ctx.alloc().buffer();
        String context = "Hello Netty!";
        byte[] bytes = context.getBytes(Charset.forName("utf-8"));
        buffer.writeBytes(bytes);
        return buffer;
    }
}
