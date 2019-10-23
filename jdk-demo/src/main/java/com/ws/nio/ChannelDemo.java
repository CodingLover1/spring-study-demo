package com.ws.nio;

import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author shuo.wang
 * @date 19-9-26
 */
public class ChannelDemo {

    public static void main(String[] args) throws Exception{
       RandomAccessFile file=new RandomAccessFile("/home/shuowang/IdeaProject/study-demo/jdk-demo/src/main/resources/data.txt","rw");
        FileChannel inChannel=file.getChannel();

        ByteBuffer buffer= ByteBuffer.allocate(1024);
        int readBytes=inChannel.read(buffer);
        while(readBytes!=-1){
            System.out.println("Read "+readBytes);
            buffer.flip();
            while(buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            buffer.clear();
            readBytes=inChannel.read(buffer);
        }

        file.close();

    }
}
