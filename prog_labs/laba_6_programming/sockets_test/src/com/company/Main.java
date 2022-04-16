package com.company;

import com.company.vehicle.Coordinates;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	    String host = "127.0.0.1";
        int port = 8239;
        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            Message message = new Message("default mem", 1488L);
            outputStream.writeObject(12);

        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
