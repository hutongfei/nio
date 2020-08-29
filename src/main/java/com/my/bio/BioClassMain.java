package com.my.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class BioClassMain {

    static byte[] bs = new byte[1024];

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        // new socket -> 绑定端口 -> 监听客户端 -> 调用
        while (true) {
            System.out.println("is begin");
            Socket client = serverSocket.accept();

            SocketThread socketThread = new SocketThread(client);
            new Thread(socketThread).start();
        }

    }
}
