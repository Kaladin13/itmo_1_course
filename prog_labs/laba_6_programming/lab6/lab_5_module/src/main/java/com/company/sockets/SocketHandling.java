package com.company.sockets;

import com.company.command.Command;
import com.company.command.ServerAnswerDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketHandling {
    private ServerSocket serverSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Socket socket;
    public static Integer PORT = 8239;
    public static String HOST = "127.0.0.1";

    public SocketHandling() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
        System.out.println("Server is up and running on ".concat(String.valueOf(PORT)));
    }

    public Command receiveCommand() throws IOException {
        try {

            if (socket == null || !socket.isConnected()) {
                socket = serverSocket.accept();
                System.out.println("Connection established");
                this.inputStream = new ObjectInputStream(socket.getInputStream());
                this.outputStream = new ObjectOutputStream(socket.getOutputStream());
            }

            return (Command) inputStream.readObject();
        } catch (Exception e) {
            // TODO log error here
            socket.close();
            socket = null;
            return null;
        }
    }

    public void sendAnswer(ServerAnswerDTO answerDTO) {
        try {
            if (!socket.isConnected()) {
                return;
            }
            outputStream.writeObject(answerDTO);
        } catch (Exception e) {
            System.out.println("exp");
        }
    }
}
