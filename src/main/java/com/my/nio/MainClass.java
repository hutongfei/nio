package com.my.nio;

import sun.misc.GC;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainClass {

    static byte[] bs = new byte[1024];

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9000);
        serverSocketChannel.bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            System.out.println("select 数量为 " + selector.select());
            System.out.println("监听中....");
            Thread.sleep(2000);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();// 系统调用
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    System.out.println("可连接数据.....");
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, SelectionKey.OP_READ);

                } else if (next.isReadable()) {
                    System.out.println("可读取数据.....");
                    SocketChannel channel = (SocketChannel) next.channel();
                    channel.configureBlocking(false);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    channel.read(byteBuffer);
                    while (byteBuffer.hasRemaining()) {
                        byteBuffer.flip();
                        byteBuffer.get(bs,byteBuffer.position(),byteBuffer.limit());
                        System.out.println(new String(bs));

                    }
                }else {
                    System.out.println("没有数据");
                }
                iterator.remove();
            }

        }

    }

}
