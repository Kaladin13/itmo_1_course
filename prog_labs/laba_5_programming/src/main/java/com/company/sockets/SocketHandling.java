package com.company.sockets;

import com.company.command.Command;
import com.company.command.ServerAnswerDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandling {
    private ServerSocket serverSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    public static Integer PORT = 8239;
    public static String HOST = "127.0.0.1";

    public SocketHandling() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    public Command receiveCommand() {
        try{
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            this.inputStream = inputStream;
            this.outputStream = new ObjectOutputStream(socket.getOutputStream());
            return (Command)inputStream.readObject();
        }
        catch (Exception e) {
            // TODO log error here
            System.out.println("command input error");
            return null;
        }
    }

    public void sendAnswer(ServerAnswerDTO answerDTO) {
        try{
            if (this.outputStream == null) {
                throw new Exception("bad socket connection");
            }
            outputStream.writeObject(answerDTO);
        }
        catch (Exception e) {
            System.out.println("exp");
        }
    }
}
