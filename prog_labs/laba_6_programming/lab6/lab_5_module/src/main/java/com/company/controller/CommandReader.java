package com.company.controller;

import com.company.collection.HistoryStack;
import com.company.collection.VehicleServiceSingleton;
import com.company.command.Command;
import com.company.command.CommandNames;
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
        CommandDTO commandDTO;
        String command = null;
        Object argument = null;
        while (true) {
            if (!inputParser.getInputSource().equals(InputSource.NET)) {
                System.out.println("Input a command");
            }
            if (inputParser.getInputSource().equals(InputSource.FILE)
                    && !inputParser.getScanner().hasNext()) {
                break;
            }
            try {
//                command = inputParser.getScanner().nextLine();
                commandDTO = inputParser.getCommand();
                if (commandDTO == null) {
                    return;
//                    continue;
                }
                command = commandDTO.getCommandName();
                argument = commandDTO.getCommandArgument();
            } catch (Exception e) {
                System.out.println("Critical error in user input!");
                System.exit(1);
            }
            if (command.isEmpty()) {
                continue;
            }
            if (!this.inputParser.getInputSource().equals(InputSource.NET)
                    && (!command.equals(CommandNames.register.name()) && !command.equals(CommandNames.auth.name()))) {
                if (Command.currentAuthorisedUser == null) {
                    System.out.println("You are not allowed to input commands before authentication");
                    System.out.println("Try ".concat(CommandNames.register.name())
                            .concat(" or ").concat(CommandNames.auth.name()));
                    continue;
                }
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
                    this.commandExecutor.clearCommand(argument);
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
                    this.commandExecutor.historyCommand();
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
                case ("register"):
                    this.commandExecutor.registerCommand(argument);
                    break;
                case ("auth"):
                    this.commandExecutor.authCommand(argument);
                    break;
                default:
                    System.out.println("No such command available!");
                    break;
            }

            if (inputParser.getInputSource().equals(InputSource.NET)) {
                VehicleServiceSingleton.getVehicleService().addToHistory(command);
            }
        }

    }
}
