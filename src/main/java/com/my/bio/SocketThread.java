package com.my.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketThread implements Runnable {

    private Socket client = null;

    static byte[] bs = new byte[1024];

    public SocketThread(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println(client.getPort() + "  端口 " +  "has accept");
            InputStream si = client.getInputStream();
            si.read(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(bs));
    }
}
