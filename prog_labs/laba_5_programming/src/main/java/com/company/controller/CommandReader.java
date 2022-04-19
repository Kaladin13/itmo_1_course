package com.company.controller;

import com.company.collection.HistoryStack;
import com.company.scanner.CommandDTO;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

public class CommandReader {
    private CommandExecutor commandExecutor;
    private InputParser inputParser;
    private HistoryStack historyStack;

    public CommandReader(InputParser inputParser, CommandExecutor commandExecutor) {
        this.historyStack = new HistoryStack();
        this.commandExecutor = commandExecutor;
        this.inputParser = inputParser;
    }

    public void startService() {
        Boolean shouldBreak = false;
        CommandDTO commandDTO;
        String command = null;
        Object argument = null;
        System.out.println("Input a command!");
        while (true) {
            if (inputParser.getInputSource().equals(InputSource.FILE)
                    && !inputParser.getScanner().hasNext()) {
                break;
            }
            try {
//                command = inputParser.getScanner().nextLine();
                commandDTO = inputParser.getCommand();
                command = commandDTO.getCommandName();
                argument = commandDTO.getCommandArgument();
            }
            catch (Exception e) {
                System.out.println("Critical error in user input!");
                System.exit(1);
            }
            if (command.isEmpty()) {
                continue;
            }
            switch (command) {
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
                    this.commandExecutor.addCommand(argument);
                    break;
                case ("clear"):
                    this.commandExecutor.clearCommand();
                    break;
                case ("exit"):
                    this.commandExecutor.exitCommand();
                    break;
                case ("remove_greater"):
                    this.commandExecutor.removeGreaterCommand(argument);
                    break;
                case ("remove_lower"):
                    this.commandExecutor.removeLowerCommand(argument);
                    break;
                case ("history"):
                    this.historyStack.show();
                    break;
                case ("print_field_descending_number_of_wheels"):
                    this.commandExecutor.wheelsOrderCommand();
                    break;
                case ("update"):
                    this.commandExecutor.updateCommand(argument);
                    break;
                case ("remove_by_id"):
                    this.commandExecutor.removeCommand(argument);
                    break;
                case ("execute_script"):
                    this.commandExecutor.executeCommand(argument);
                    break;
                case ("count_greater_than_engine_power"):
                    this.commandExecutor.greaterPowerCommand(argument);
                    break;
                case ("filter_greater_than_capacity"):
                    this.commandExecutor.greaterCapacityCommand(argument);
                    break;
                default:
                    System.out.println("No such command available!");
                    break;
            }
            if (shouldBreak) {
                break;
            }
            this.historyStack.add(command);
        }

    }
}
