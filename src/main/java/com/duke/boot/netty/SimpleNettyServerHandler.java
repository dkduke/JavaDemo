package com.duke.boot.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: dengkun11
 * @date: 2022/11/23
 * @description: Netty 服务端处理类Handler
 *      具体业务逻辑代码处理器，该Handler需要用户自定义。
 */
public class SimpleNettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 本方法用于读取客户端发送的信息
     * channelRead()——对于每个传入的消息都需要调用
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("SimpleNettyServerHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        byte[] bytesMsg = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
        result.readBytes(bytesMsg);
        String resultStr = new String(bytesMsg);
        // 接收并打印客户端的信息
        System.out.println("Client said:" + resultStr);
        // 释放资源，这行很关键
        result.release();

        // 向客户端发送消息
        String response = "hello client!";
        // 在当前场景下，发送的数据必须转换成ByteBuf数组
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

    /**
     * 本方法用作处理异常
     * 在读取期间，有异常的时候会调用
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 信息获取完毕后操作
     * 通知ChannelInboundHandler最后一次对channelRead()的调用是当前批量读取中的最后一条消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

}
