package com.company.controller;

import com.company.collection.VehicleService;
import com.company.collection.VehicleServiceSingleton;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;
import com.company.vehicle.Vehicle;

import java.util.ArrayDeque;

/**
 * Class that executes all commands
 */
public class ConsoleExecutor implements CommandExecutor {
    private VehicleService vehicleService;
    private InputParser inputParser;

    public ConsoleExecutor(InputParser inputParser) {
        this.inputParser = inputParser;
        this.vehicleService = VehicleServiceSingleton.getVehicleService();
    }

    public ConsoleExecutor() {
        this.vehicleService = VehicleServiceSingleton.getVehicleService();
    }

    public void setInputParser(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public void helpCommand() {
        System.out.println("help commands info printed out");
    }

    public void infoCommand() {
        System.out.println("Info about collection: ");
        System.out.println("Collection class - " + vehicleService.getCollectionClassname());
        System.out.println("Collection creation date - " + vehicleService.getCreationDate());
    }

    public void showCommand() {
        ArrayDeque<Vehicle> arrayList = this.vehicleService.getCollectionOfVehicles();
        arrayList.forEach(System.out::println);
    }

    public void addCommand(Object obj) {
        this.vehicleService.addVehicle(this.inputParser);
    }

    public void updateCommand(Object obj) {
        try {
            Long castedId = Long.parseLong((String)obj);
            this.vehicleService.updateVehicle(castedId, this.inputParser);
        }
        catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }

    public void removeCommand(Object obj) {
        try {
            Long castedId = Long.parseLong((String)obj);
            this.vehicleService.removeVehicle(castedId);
        }
        catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }

    public void clearCommand() {
        this.vehicleService.clearCollection();
    }

    public void saveCommand() {
        this.vehicleService.saveCollection();
    }

    public void removeGreaterCommand(Object obj) {
        this.vehicleService.removeGreaterThen(this.inputParser);
    }

    public void removeLowerCommand(Object obj) {
        this.vehicleService.removeLowerThen(this.inputParser);
    }

    public void greaterPowerCommand(Object obj) {
        try {
            Long castedPower = Long.parseLong((String)obj);
            int counter = this.vehicleService.countPower(castedPower);
            System.out.println("Number of elements with greater engine power: " + counter);
        }
        catch (Exception e) {
            System.out.println("Incorrect engine power");
        }
    }

    public void greaterCapacityCommand(Object obj) {
        try {
            Long castedCapacity = Long.parseLong((String)obj);
            ArrayDeque<Vehicle> arrayDeque = this.vehicleService.countCapacity(castedCapacity);
            arrayDeque.forEach(System.out::println);
        }
        catch (Exception e) {
            System.out.println("Incorrect capacity");
        }
    }

    public void wheelsOrderCommand() {
        ArrayDeque<String> arrayDeque =  this.vehicleService.printWheels();
        arrayDeque.forEach(System.out::println);
    }

    @Override
    public void historyCommand() {

    }

    public void executeCommand(Object obj) {
        try {
            String filename = (String)obj;
            InputParser inputParser = new InputParser(InputSource.FILE, filename);
            ConsoleExecutor consoleExecutor = new ConsoleExecutor(inputParser);
            CommandReader commandReader = new CommandReader(inputParser, consoleExecutor);
            if (!CallStackController.addCall(filename)) {
                return;
            }
            commandReader.startService();
        }
        catch (Exception e) {
            System.out.println("Bad file for script");
            System.out.println(e.getMessage());
        }
    }

    public void exitCommand() {
        System.exit(0);
    }

}
