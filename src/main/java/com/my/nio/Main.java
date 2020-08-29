package com.my.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 1、打开ServerSocketChannel，监听客户端连接；
 * 2、绑定监听端口，设置连接为非阻塞模式；
 * 3、创建Reactor线程，创建多路复用器并启动线程。
 * 4、将ServerSocketChannel注册到Reactor线程中的Selector上，监听ACCEPT事件
 * 5、Selector轮询准备就绪的key
 * 6、Selector监听到新的客户端接入，处理新的接入请求，完成TCP三次握手，简历物理链路
 * 7、设置客户端链路为非阻塞模式
 * 8、将新接入的客户端连接注册到Reactor线程的Selector上，监听读操作，读取客户端发送的网络消息
 * 9、异步读取客户端消息到缓冲区
 * 10、对Buffer编解码，处理半包消息，将解码成功的消息封装成Task
 * 11、将应答消息编码为Buffer，调用SocketChannel的write将消息异步发送给客户端
 */
public class Main {

    static byte[] bs = new byte[1024];

    public static void main(String[] args) throws IOException, InterruptedException {
        // 获取socket 通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8080);
        //绑定端口
        serverSocketChannel.bind(inetSocketAddress);
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //创建选择器
        Selector selector = Selector.open();
        // 注册到selector上
        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        /**
         * selector 中的
         */
        while (true) {
            System.out.println("select 数量为 " + selector.select());// 此处select（）阻塞接口
            Set<SelectionKey> selectionKeys = selector.selectedKeys();// 系统调用
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            System.out.println("连接中......");
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
