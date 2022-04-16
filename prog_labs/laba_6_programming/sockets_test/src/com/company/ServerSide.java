package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSide {
    public static void main(String[] args) {

        int port = 8239;
        try {
            ServerSocket socket = new ServerSocket(port);

                Socket socket1 = socket.accept();
//                System.out.println("Socket accepted!");
                ObjectInputStream inputStream = new ObjectInputStream(socket1.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket1.getOutputStream());
//                System.out.println("done");
                Object obj =  inputStream.readObject();

                System.out.println(obj);

                Message message = (Message)obj;

                System.out.println("recv message: " + message.toString());
                socket1.close();


        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
