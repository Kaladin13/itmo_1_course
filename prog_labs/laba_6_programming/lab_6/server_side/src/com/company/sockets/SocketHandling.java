package com.company.sockets;

import com.company.command.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketHandling {
    private ServerSocket serverSocket;
    public static Integer PORT = 8239;

    public SocketHandling() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    public Command receiveCommand() {
        try{
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Command command = (Command)inputStream.readObject();
            return command;
        }
        catch (Exception e) {
            // TODO log error here
            System.out.println("command input error");
            return null;
        }
    }
}
