package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Handling implements Runnable {
    private Socket socket;

    public Handling(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Server.handleSocketInputEcho(socket);
    }
}
