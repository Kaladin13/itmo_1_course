package com.company.sockets;

import com.company.command.Command;
import com.company.command.ServerAnswerDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClientHandling {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public SocketClientHandling() {
        this.socket = new Socket();
    }

    public void sendCommand(Command command) {
        try {
            socket.connect(new InetSocketAddress(SocketHandling.HOST, SocketHandling.PORT));
            this.inputStream = new ObjectInputStream(socket.getInputStream());
            this.outputStream = new ObjectOutputStream(socket.getOutputStream());
            this.outputStream.writeObject(command);
        }
        catch (Exception e) {
            System.out.println("Server is currently unreachable");
            System.exit(1);
        }
    }

    public ServerAnswerDTO receiveServerAnswer() {
        try{
            Object obj = this.inputStream.readObject();
            return (ServerAnswerDTO)obj;
        } catch (Exception e) {
            System.out.println("Bad answer from the server");
            System.exit(1);
            return null;
        }
    }

}
