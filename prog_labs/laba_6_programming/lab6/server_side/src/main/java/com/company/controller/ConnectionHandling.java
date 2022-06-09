package com.company.controller;

import com.company.scanner.InputParser;
import com.company.scanner.InputSource;
import com.company.sockets.SocketHandling;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ConnectionHandling {

    public static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(SocketHandling.PORT);
            serverSocket.setReuseAddress(true);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
            while (true) {
                Socket socket = serverSocket.accept();
                InputParser inputParser = new InputParser(InputSource.NET, socket);
                ServerExecutor serverExecutor = new ServerExecutor(inputParser);
                CommandReader commandReader = new CommandReader(inputParser, serverExecutor);
                threadPoolExecutor.submit(commandReader::startService);
            }
        }
        catch (Exception e) {
            System.out.println("Critical error in server work");
            System.out.println("Shutting down...");
        }
    }
}
