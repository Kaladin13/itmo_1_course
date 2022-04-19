package com.company;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayDeque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    String host = "127.0.0.1";
        int port = 8239;
        try {
            Socket socket = new Socket();
            System.out.println("no connection");
            socket.connect(new InetSocketAddress(host, port));
//            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//            serverSocketChannel.bind(new InetSocketAddress(host, port));
//            SocketChannel socketChannel = serverSocketChannel.accept();
//            socketChannel.write()
//            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            Message message = new Message("default mem", 1488L);
            ByteOutputStream b = new ByteOutputStream();
            ObjectOutputStream s = new ObjectOutputStream(b);
//            outputStream.writeObject(message);
        while (true) {

        }
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
