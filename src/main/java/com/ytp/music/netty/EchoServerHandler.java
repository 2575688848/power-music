package com.ytp.music.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @author a043
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 覆盖channelRead()事件处理程序方法
        ByteBuf in = (ByteBuf) msg;
        System.out.println(
                "Server received: " + in.toString(CharsetUtil.UTF_8));
        ByteBuf out = getByteBuf(ctx);
        // 发送数据
        ctx.channel().writeAndFlush(out);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "这里是服务端将要写出发往客户端的数据".getBytes(Charset.forName("utf-8"));
        // 申请一个数据结构存储信息
        ByteBuf buffer = ctx.alloc().buffer();
        // 将信息放入数据结构中
        buffer.writeBytes(bytes);
        return buffer;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)
            throws Exception {
        // channelRead()执行完成后，关闭channel连接
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}