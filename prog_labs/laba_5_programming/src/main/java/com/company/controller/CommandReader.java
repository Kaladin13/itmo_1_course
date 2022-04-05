package com.company.controller;

import com.company.collection.HistoryStack;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

import java.util.ArrayList;

public class CommandReader {
    private CommandExecutor commandExecutor;
    private InputParser inputParser;
    private HistoryStack historyStack;

    public CommandReader(InputParser inputParser) {
        this.historyStack = new HistoryStack();
        this.commandExecutor = new CommandExecutor(inputParser);
        this.inputParser = inputParser;
    }

    public void startService() throws Exception {
        Boolean shouldBreak = false;
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
                case ("clear"):
                    this.commandExecutor.clearCommand();
                    break;
                case ("save"):
                    this.commandExecutor.saveCommand();
                    break;
                case ("exit"):
                    shouldBreak = true;
                    break;
                case ("remove_greater"):
                    this.commandExecutor.removeGreaterCommand();
                    break;
                case ("remove_lower"):
                    this.commandExecutor.removeLowerCommand();
                    break;
                case ("history"):
                    this.historyStack.show();
                    break;
                case ("print_field_descending_number_of_wheels"):
                    this.commandExecutor.wheelsOrder();
                    break;
                case ("update"):
                    this.commandExecutor.updateCommand(parsedCommand[1]);
                    break;
                case ("remove_by_id"):
                    this.commandExecutor.removeCommand(parsedCommand[1]);
                    break;
                case ("execute_script"):
                    this.commandExecutor.executeCommand(parsedCommand[1]);
                    break;
                case ("count_greater_than_engine_power"):
                    this.commandExecutor.greaterPowerCommand(parsedCommand[1]);
                    break;
                case ("filter_greater_than_capacity"):
                    this.commandExecutor.greaterCapacity(parsedCommand[1]);
                    break;
                default:
                    System.out.println("No such command available!");
                    break;
            }
            if (shouldBreak) {
                break;
            }
            this.historyStack.add(parsedCommand[0]);
        }

    }
}
