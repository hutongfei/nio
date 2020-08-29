package com.my.nio;


import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// 创建套接字 -> 绑定端口  -> 监听客户端  -> 获取连接  -> 处理
public class TestMain {

    static List<Socket> socketList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            System.out.println("1");
            Socket accept = serverSocket.accept();
            System.out.println("2");
            new Thread(new ServerThread(accept)).start();
            System.out.println("3");
        }
    }
}

class ServerThread implements Runnable {
    Socket serverSocket;
    public ServerThread (Socket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @SneakyThrows
    @Override
    public void run() {
        if (serverSocket == null) {
            throw new RuntimeException("serverSocket is null");
        }
        Thread.sleep(2000);
        InputStream inputStream = serverSocket.getInputStream();
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);

        System.out.println(new String(bytes));
    }
}
