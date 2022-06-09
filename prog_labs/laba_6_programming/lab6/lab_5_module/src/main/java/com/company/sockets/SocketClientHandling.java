package com.company.sockets;

import com.company.command.Command;
import com.company.command.CommandNames;
import com.company.command.ServerAnswerDTO;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class SocketClientHandling {
    private Socket socket;
    private SocketChannel socketChannel;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public SocketClientHandling() {
        try {
            this.socketChannel = SocketChannel.open();
            this.socket = new Socket();
        }
        catch (Exception ignored) {}
    }

    public void sendCommand(Command command) {
        try {
            if (!socket.isConnected()) {
                this.socketChannel = SocketChannel.open();
                this.socket = socketChannel.socket();
                socket.connect(new InetSocketAddress(SocketHandling.HOST, SocketHandling.PORT));
                this.outputStream = new ObjectOutputStream(socket.getOutputStream());
                this.inputStream = new ObjectInputStream(socket.getInputStream());
            }
            if (!command.getCommandName().equals(CommandNames.auth) &&
                    !command.getCommandName().equals(CommandNames.register)) {
                command.setUserDTO(Command.currentAuthorisedUser);
            }
            this.outputStream.writeObject(command);
        } catch (Exception e) {
            try {
            System.out.println("Server is currently unreachable");
            System.out.println("Trying to reconnect...");
            TimeUnit.SECONDS.sleep( 10);
            socket.close();
            sendCommand(command);
            }
            catch (Exception ignored){
                System.out.println("Server is out of reach, exiting...");
                System.exit(1);
            }
        }
    }

    public ServerAnswerDTO receiveServerAnswer() {
        try {
            if (!socket.isConnected()) {
                throw new Exception();
            }
            return (ServerAnswerDTO) inputStream.readObject();
        } catch (Exception e) {
            System.out.println("Bad answer from the server");
            System.exit(1);
            return null;
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
