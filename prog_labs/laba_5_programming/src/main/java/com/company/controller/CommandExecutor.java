package com.company.controller;

import com.company.collection.VehicleService;
import com.company.collection.VehicleServiceSingleton;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that executes all commands
 */
public class CommandExecutor {
    private VehicleService vehicleService;
    private InputParser inputParser;

    public CommandExecutor(InputParser inputParser) {
        this.inputParser = inputParser;
        this.vehicleService = VehicleServiceSingleton.getVehicleService();
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
        List<String> arrayList = this.vehicleService.getCollectionToString();
        arrayList.forEach(System.out::println);
    }

    public void addCommand() {
        this.vehicleService.addVehicle(this.inputParser);
    }

    public void updateCommand(String id) {
        try {
            Long castedId = Long.parseLong(id);
            this.vehicleService.updateVehicle(castedId, this.inputParser);
        }
        catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }

    public void removeCommand(String id) {
        try {
            Long castedId = Long.parseLong(id);
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

    public void removeGreaterCommand() {
        this.vehicleService.removeGreaterThen(this.inputParser);
    }

    public void removeLowerCommand() {
        this.vehicleService.removeLowerThen(this.inputParser);
    }

    public void greaterPowerCommand(String enginePower) {
        try {
            Long castedPower = Long.parseLong(enginePower);
            this.vehicleService.countPower(castedPower);
        }
        catch (Exception e) {
            System.out.println("Incorrect engine power");
        }
    }

    public void greaterCapacity(String capacity) {
        try {
            Long castedCapacity = Long.parseLong(capacity);
            this.vehicleService.countCapacity(castedCapacity);
        }
        catch (Exception e) {
            System.out.println("Incorrect capacity");
        }
    }

    public void wheelsOrder() {
        this.vehicleService.printWheels();
    }

    public void executeCommand(String filename) {
        try {
            InputParser inputParser = new InputParser(InputSource.FILE, filename);
            CommandReader commandReader = new CommandReader(inputParser);
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

}
