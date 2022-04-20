package com.company;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;


public class serverSide {
    public static void main(String[] args) {

        int port = 8239;
        try {
            ServerSocket socket = new ServerSocket(port);
//
                Socket socket1 = socket.accept();
                System.out.println("Socket accepted!");



                ObjectInputStream inputStream = new ObjectInputStream(socket1.getInputStream());
//                Scanner scanner = new Scanner(socket1.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket1.getOutputStream());
////                System.out.println("done");
                Object ob =  inputStream.readObject();
                System.out.println(ob.toString());

//                Message message = (Message)ob;

//                System.out.println("recv message: " + message.toString());

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
