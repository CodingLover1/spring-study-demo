package com.ws.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author shuo.wang
 * @date 19-9-25
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port){
        this.port=port;
    }

    public void start() throws Exception{
        EventLoopGroup  group=new NioEventLoopGroup();
        try{
            ServerBootstrap b=new ServerBootstrap();
            b.group(group).channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception{
                            ch.pipeline().addLast(new EchoServerHandler());

                        }
                    });
            ChannelFuture f=b.bind().sync();
            System.out.println(EchoServer.class.getName()+" started and listen on "+f.channel().localAddress());
            f.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            group.shutdownGracefully().sync();
        }
    }


    public static void main(String[] args)throws Exception {
        if(args.length!=1){
            System.out.println("usage "+EchoServer.class.getName()+" port");
            System.exit(0);
        }
        int port=Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }
}
