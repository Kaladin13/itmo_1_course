package com.company.controller;

import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

import java.util.ArrayList;

public class CommandReader {
    private CommandExecutor commandExecutor;
    private InputParser inputParser;

    public CommandReader(InputParser inputParser) {
        this.commandExecutor = new CommandExecutor();
        this.inputParser = inputParser;
    }

    public void startService() throws Exception {
        String command;
        while (true) {
            if (!inputParser.getScanner().hasNext()
                    && inputParser.getInputSource().equals(InputSource.FILE)) {
                break;
            }
            command = inputParser.getScanner().nextLine();
            String[] parsedCommand = command.split(" ");
            switch (parsedCommand[0]) {
                case ("help"):
                    this.commandExecutor.helpCommand();
                    break;
                case ("info"):
                    this.commandExecutor.infoCommand();
                    break;
                case ("show"):
                    this.commandExecutor.showCommand();
                    break;
                case ("add"):
                    this.commandExecutor.addCommand();
                    break;
                case ("update"):
                    this.commandExecutor.updateCommand(parsedCommand[0]);
                    break;
            }
        }
    }
}
