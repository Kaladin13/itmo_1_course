package com.company.controller;

import com.company.collection.VehicleService;
import com.company.collection.VehicleServiceSingleton;
import com.company.command.Command;
import com.company.command.ServerAnswerDTO;
import com.company.scanner.InputParser;
import com.company.sockets.SocketHandling;
import com.company.vehicle.ParsedVehicle;
import com.company.vehicle.Vehicle;

import java.util.ArrayDeque;

public class ServerExecutor implements CommandExecutor{
    private VehicleService vehicleService;
    private InputParser inputParser;
    private SocketHandling socketHandling;

    public ServerExecutor(InputParser inputParser) {
        this.inputParser = inputParser;
        this.socketHandling = inputParser.getSocketHandling();
        this.vehicleService = VehicleServiceSingleton.getVehicleService();
    }

    @Override
    public void helpCommand() {
        String helpInfo = "command help info printed out";
        ServerAnswerDTO answerDTO = new ServerAnswerDTO(helpInfo);
        socketHandling.sendAnswer(answerDTO);
    }

    @Override
    public void infoCommand() {
        ArrayDeque<String> collectionInfo = new ArrayDeque<>();
        collectionInfo.addLast("Collection type: "
                .concat(vehicleService.getCollectionClassname()));
        collectionInfo.addLast("Collection creation date: "
                .concat(vehicleService.getCreationDate().toString()));
        String answer = "Information about the collection";
        ServerAnswerDTO answerDTO = new ServerAnswerDTO(answer, collectionInfo);
        socketHandling.sendAnswer(answerDTO);
    }

    @Override
    public void showCommand() {
        ArrayDeque<Vehicle> arrayDeque = vehicleService.getCollectionOfVehicles();
        String answer = "Elements of the collection";
        ServerAnswerDTO answerDTO = new ServerAnswerDTO(answer);
        answerDTO.setVehicles(arrayDeque);
        socketHandling.sendAnswer(answerDTO);
    }

    @Override
    public void addCommand(Object obj) {
        Command command = (Command)obj;
        ParsedVehicle vehicle = command.getParsedVehicle();
        String answer;
        try {
            vehicleService.addVehicle(vehicle);
            answer = "Added new vehicle to the collection";
        }
        catch (Exception e) {
            answer = "Failed to add new vehicle";
        }
        socketHandling.sendAnswer(new ServerAnswerDTO(answer));
    }

    @Override
    public void updateCommand(Object obj) {
        Command command = (Command)obj;
        Long id = command.getAdditionalParameter();
        ParsedVehicle vehicle = command.getParsedVehicle();
        boolean result = vehicleService.updateVehicle(id, vehicle);
        String answer = result ?
                "Updated vehicle in the collection by id"
                :
                "Failed to update vehicle by id";
        socketHandling.sendAnswer(new ServerAnswerDTO(answer));
    }

    @Override
    public void removeCommand(Object obj) {
        Command command = (Command)obj;
        Long id = command.getAdditionalParameter();
        boolean result = vehicleService.removeVehicle(id);
        String answer = result ?
                "Removed vehicle in the collection by id"
                :
                "Failed to remove vehicle by id";
        socketHandling.sendAnswer(new ServerAnswerDTO(answer));
    }

    @Override
    public void clearCommand() {
        vehicleService.clearCollection();
        String answer = "Cleared collection";
        socketHandling.sendAnswer(new ServerAnswerDTO(answer));
    }

    @Override
    public void removeGreaterCommand(Object obj) {
        Command command = (Command)obj;
        ParsedVehicle vehicle = command.getParsedVehicle();
        vehicleService.removeGreaterThen(vehicle);
        String answer = "Removed vehicles greater then present";
        socketHandling.sendAnswer(new ServerAnswerDTO(answer));
    }

    @Override
    public void removeLowerCommand(Object obj) {
        Command command = (Command)obj;
        ParsedVehicle vehicle = command.getParsedVehicle();
        vehicleService.removeLowerThen(vehicle);
        String answer = "Removed vehicles lower then present";
        socketHandling.sendAnswer(new ServerAnswerDTO(answer));
    }

    @Override
    public void greaterPowerCommand(Object obj) {
        Command command = (Command)obj;
        Long enginePower = command.getAdditionalParameter();
        int count = vehicleService.countPower(enginePower);
        String answer = "Number of elements with greater engine power: ".concat(String.valueOf(count));
        socketHandling.sendAnswer(new ServerAnswerDTO(answer));
    }

    @Override
    public void greaterCapacityCommand(Object obj) {
        Command command = (Command)obj;
        Long capacity = command.getAdditionalParameter();
        ArrayDeque<Vehicle> vehicles = vehicleService.countCapacity(capacity);
        String answer = "Vehicles with greater capacity";
        ServerAnswerDTO answerDTO = new ServerAnswerDTO(answer);
        answerDTO.setVehicles(vehicles);
        socketHandling.sendAnswer(answerDTO);
    }

    @Override
    public void wheelsOrderCommand() {
        ArrayDeque<String> arrayDeque = vehicleService.printWheels();
        String answer = "Number of wheels for each vehicle in descending order";
        socketHandling.sendAnswer(new ServerAnswerDTO(answer, arrayDeque));
    }

    @Override
    public void historyCommand() {
        ArrayDeque<String> arrayDeque = vehicleService.getHistory();
        String answer = "Command history";
        socketHandling.sendAnswer(new ServerAnswerDTO(answer, arrayDeque));
    }

    @Override
    public void executeCommand(Object obj) {

    }

    @Override
    public void exitCommand() {

    }
}
