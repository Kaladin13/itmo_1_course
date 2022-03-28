package com.company.controller;

import com.company.collection.VehicleService;
import com.company.collection.VehicleServiceSingleton;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class CommandExecutor {
    private VehicleService vehicleService;

    public CommandExecutor() {
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
        ArrayList<String> arrayList = this.vehicleService.getCollectionToString();
        arrayList.forEach(System.out::println);
    }

    public void addCommand() {
        this.vehicleService.addVehicle();
    }

    public void updateCommand(String id) {
        try {
            Long castedId = Long.parseLong(id);

        }
        catch (Exception e) {
            System.out.println("Incorrect id");
        }
    }
}
