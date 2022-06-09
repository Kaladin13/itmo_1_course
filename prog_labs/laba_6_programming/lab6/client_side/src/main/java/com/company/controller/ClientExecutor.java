package com.company.controller;

import com.company.collection.VehicleService;
import com.company.collection.VehicleServiceSingleton;
import com.company.command.*;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;
import com.company.sockets.SocketClientHandling;
import com.company.vehicle.ParsedVehicle;
import com.company.vehicle.Vehicle;

import java.io.IOException;

public class ClientExecutor implements CommandExecutor {
    private VehicleService vehicleService;
    private InputParser inputParser;
    private SocketClientHandling socketClientHandling;

    public ClientExecutor(InputParser inputParser) {
        this.vehicleService = VehicleServiceSingleton.getVehicleService();
        this.socketClientHandling = new SocketClientHandling();
        this.inputParser = inputParser;
    }

    private void printServerAnswer(ServerAnswerDTO answerDTO) {
        System.out.println(answerDTO.getAnswer());
        if (answerDTO.getArgument() != null && !answerDTO.getArgument().isEmpty()) {
            answerDTO.getArgument().forEach(System.out::println);
        }
        if (answerDTO.getVehicles() != null && !answerDTO.getVehicles().isEmpty()) {
            answerDTO.getVehicles().stream()
                    .map(Vehicle::toString)
                    .forEach(System.out::println);
        }
    }

    public void closeConnection() throws IOException {
        socketClientHandling.getSocket().close();
    }

    @Override
    public void helpCommand() {
        socketClientHandling.sendCommand(new Command(CommandNames.help));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void infoCommand() {
        socketClientHandling.sendCommand(new Command(CommandNames.info));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void showCommand() {
        socketClientHandling.sendCommand(new Command(CommandNames.show));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void addCommand(Object obj) {
        VehicleParser vehicleParser = new VehicleParser(this.inputParser);
        ParsedVehicle parsedVehicle = vehicleParser.parseParsedVehicle();
        socketClientHandling.sendCommand(new Command(CommandNames.add, parsedVehicle));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void updateCommand(Object obj) {
        try {
            Long castedId = Long.parseLong((String) obj);
            VehicleParser vehicleParser = new VehicleParser(this.inputParser);
            ParsedVehicle parsedVehicle = vehicleParser.parseParsedVehicle();
            socketClientHandling.sendCommand(new Command(CommandNames.update, castedId, parsedVehicle));
            ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
            printServerAnswer(answerDTO);
        } catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }

    @Override
    public void removeCommand(Object obj) {
        try {
            Long castedId = Long.parseLong((String) obj);
            socketClientHandling.sendCommand(new Command(CommandNames.remove_by_id, castedId));
            ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
            printServerAnswer(answerDTO);
        } catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }

    @Override
    public void clearCommand(Object obj) {
        socketClientHandling.sendCommand(new Command(CommandNames.clear));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void removeGreaterCommand(Object obj) {
        VehicleParser vehicleParser = new VehicleParser(this.inputParser);
        ParsedVehicle parsedVehicle = vehicleParser.parseParsedVehicle();
        socketClientHandling.sendCommand(new Command(CommandNames.remove_greater, parsedVehicle));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void removeLowerCommand(Object obj) {
        VehicleParser vehicleParser = new VehicleParser(this.inputParser);
        ParsedVehicle parsedVehicle = vehicleParser.parseParsedVehicle();
        socketClientHandling.sendCommand(new Command(CommandNames.remove_lower, parsedVehicle));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void greaterPowerCommand(Object obj) {
        try {
            Long castedPower = Long.parseLong((String) obj);
            socketClientHandling.sendCommand(new Command(CommandNames.count_greater_than_engine_power, castedPower));
            ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
            printServerAnswer(answerDTO);
        } catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }

    @Override
    public void greaterCapacityCommand(Object obj) {
        try {
            Long castedCapacity = Long.parseLong((String) obj);
            socketClientHandling.sendCommand(new Command(CommandNames.filter_greater_than_capacity, castedCapacity));
            ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
            printServerAnswer(answerDTO);
        } catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }

    @Override
    public void wheelsOrderCommand() {
        socketClientHandling.sendCommand(new Command(CommandNames.print_field_descending_number_of_wheels));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void historyCommand() {
        socketClientHandling.sendCommand(new Command(CommandNames.history));
        ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
        printServerAnswer(answerDTO);
    }

    @Override
    public void executeCommand(Object obj) {
        InputParser temp = this.inputParser;
        try {
            String filename = (String) obj;
            InputParser inputParser = new InputParser(InputSource.FILE, filename);
            this.inputParser = inputParser;
            CommandReader commandReader = new CommandReader(inputParser, this);
            if (!CallStackController.addCall(filename)) {
                this.inputParser = temp;
                return;
            }
            commandReader.startService();
            this.inputParser = temp;
        } catch (Exception e) {
            this.inputParser = temp;
            System.out.println("Bad file for script");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exitCommand() {
        System.out.println("Exiting program");
        System.exit(0);
    }

    @Override
    public void registerCommand(Object obj) {
        try {
            UserParser userParser = new UserParser();
            UserDTO userDTO = userParser.getUserData();
            socketClientHandling.sendCommand(new Command(CommandNames.register, userDTO));
            ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
            printServerAnswer(answerDTO);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void authCommand(Object obj) {
        try {
            UserParser userParser = new UserParser();
            UserDTO userDTO = userParser.getUserData();
            socketClientHandling.sendCommand(new Command(CommandNames.auth, userDTO));
            ServerAnswerDTO answerDTO = socketClientHandling.receiveServerAnswer();
            printServerAnswer(answerDTO);
            if (answerDTO.getAnswer().equals(AuthorisationAnswers.SUCCESS.toString())) {
                Command.currentAuthorisedUser = userDTO;
            }
        }
        catch (Exception ignored) {}
    }

}
