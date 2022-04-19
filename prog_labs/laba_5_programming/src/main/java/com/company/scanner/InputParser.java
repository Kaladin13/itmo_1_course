package com.company.scanner;

import com.company.command.Command;
import com.company.sockets.SocketHandling;

import java.io.File;
import java.util.Scanner;

public class InputParser {
    private Scanner scanner;
    private final InputSource inputSource;
    private SocketHandling socketHandling;

    public InputParser(InputSource inputSource) throws Exception {
        this.inputSource = inputSource;
        if (this.inputSource.equals(InputSource.CONSOLE)) {
            this.scanner = new Scanner(System.in);
        }
        if (this.inputSource.equals(InputSource.NET)) {
            this.socketHandling = new SocketHandling();
        }
    }

    public SocketHandling getSocketHandling() {
        return socketHandling;
    }

    public InputParser(InputSource inputSource, String fileName) throws Exception {
        this.inputSource = inputSource;
        File file = new File(fileName);
        if (!this.inputSource.equals(InputSource.FILE) || fileName.equals("")) {
            throw new Exception("Scanner with file name can only be file-reader!");
        }
        if (!file.exists()) {
            throw new Exception("File doesn't exist!");
        }
        if (!file.canRead()) {
            throw new Exception("File doesn't provide reading writes!");
        }
        this.scanner = new Scanner(file);
    }

    public CommandDTO getCommand() {
        if (this.inputSource == InputSource.CONSOLE || this.inputSource == InputSource.FILE) {
            try{
                String command = this.scanner.nextLine();
                String[] parsedCommand = command.split(" ");
                if (parsedCommand.length < 2) {
                    return new CommandDTO(parsedCommand[0], null);
                }
                else {
                    return new CommandDTO(parsedCommand[0], parsedCommand[1]);
                }
            }
            catch (Exception e) {
                System.out.println("error in new module");
                System.out.println(e);
            }
        }
        if (this.inputSource == InputSource.NET) {
            try{
                Command command = this.socketHandling.receiveCommand();
                return new CommandDTO(command.getCommandName().name(), command);
            }
            catch (Exception e) {
                System.out.println("error in reading");
                System.out.println(e);
            }
        }
        return null;
    }

    // scanner change with open/close
    // new command handlers with interfaces
    public Scanner getScanner() {
        return scanner;
    }

    public InputSource getInputSource() {
        return inputSource;
    }
}
