package com.company.collection;

import com.company.collection.comparators.VehicleCapacityComparator;
import com.company.collection.comparators.VehicleNameComparator;
import com.company.controller.VehicleParser;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;
import com.company.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class VehicleService {
    private TreeSet<Vehicle> treeSet;
    private final java.time.LocalDateTime creationDate;


    public VehicleService() {
        Comparator<Vehicle> comparator = new VehicleNameComparator().
                thenComparing(new VehicleCapacityComparator());
        this.treeSet = new TreeSet<>(comparator);
        this.creationDate = java.time.LocalDateTime.now();
    }

    public ArrayList<String> getCollectionToString() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.treeSet.stream()
                .map(Object::toString)
                .forEach(arrayList::add);
        return arrayList;
    }

    public void addVehicle() {
        try {
            InputParser inputParser = new InputParser(InputSource.CONSOLE);
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            treeSet.add(vehicle);
        } catch (Exception ignored) {
        }
    }

    public void updateVehicle(Long id) {
        InputParser inputParser = new InputParser(InputSource.CONSOLE);
    }

    public String getCollectionClassname() {
        return treeSet.getClass().getName();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
