package com.ws;

import com.sun.javafx.image.ByteToBytePixelConverter;
import com.sun.org.apache.bcel.internal.generic.Select;
import io.netty.buffer.ByteBuf;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author shuo.wang
 * @date 19-9-25
 */
public class EchoServer {
    public static void main(String[] args) throws Exception{
        final int port=8000;
        Selector selector=Selector.open();

        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        ServerSocket ss=serverSocketChannel.socket();
        InetSocketAddress inetSocketAddress=new InetSocketAddress(port);
        ss.bind(inetSocketAddress);

        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            selector.select();

            Set readyKes=selector.selectedKeys();
            Iterator it=readyKes.iterator();
            while(it.hasNext()){
                SelectionKey selectionKey=(SelectionKey)it.next();
                it.remove();
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel server=(ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel=server.accept();
                    System.out.println("Accepted connection from "+socketChannel);

                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_WRITE|SelectionKey.OP_READ, ByteBuffer.allocate(100));
                }

                if(selectionKey.isReadable()){
                    SocketChannel client=(SocketChannel)selectionKey.channel();
                    ByteBuffer output=(ByteBuffer)selectionKey.attachment();
                    client.read(output);
                    output.flip();
                    client.read(output);

                }
            }
        }
    }
}
