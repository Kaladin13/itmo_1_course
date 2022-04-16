package com.company.collection;

import com.company.collection.comparators.VehicleCapacityComparator;
import com.company.collection.comparators.VehicleNameComparator;
import com.company.controller.VehicleParser;
import com.company.scanner.GsonParserSingleton;
import com.company.scanner.InputParser;
import com.company.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main class, operating with collection
 */
public class VehicleService {
    private TreeSet<Vehicle> treeSet;
    private final java.time.LocalDateTime creationDate;


    public VehicleService() {
        Comparator<Vehicle> comparator = new VehicleNameComparator().
                thenComparing(new VehicleCapacityComparator());
        this.treeSet = new TreeSet<>(comparator);
        this.creationDate = java.time.LocalDateTime.now();
    }

    public void addAllTree(TreeSet<Vehicle> treeSet) {
        this.treeSet.addAll(treeSet);
    }

    public List<String> getCollectionToString() {
        return this.treeSet.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public void addVehicle(InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            treeSet.add(vehicle);
        } catch (Exception ignored) {
        }
    }

    public void updateVehicle(Long id, InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            Vehicle.decreaseId();
            vehicle.setId(id);

            for (Vehicle vehicle1 : this.treeSet) {

                if (vehicle1.getId().equals(id)) {
                    this.treeSet.remove(vehicle1);
                    this.treeSet.add(vehicle);
                    return;
                }

            }

            System.out.println("Id is not present in collection");

        } catch (Exception ignored) {
        }
    }

    public void removeVehicle(Long id) {
        try {
            for (Vehicle vehicle1 : this.treeSet) {

                if (vehicle1.getId().equals(id)) {
                    this.treeSet.remove(vehicle1);
                    return;
                }

            }
            System.out.println("Id is not present in collection");
        } catch (Exception ignored) {
        }
    }

    public String getCollectionClassname() {
        return treeSet.getClass().getName();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void clearCollection() {
        this.treeSet.clear();
    }

    public void saveCollection() {
        GsonParserSingleton.getGsonCollectionParser().storeCollection(this.treeSet);
    }

    public void removeGreaterThen(InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            Vehicle.decreaseId();

            Vehicle vehicle1 = this.treeSet.higher(vehicle);

            while (vehicle1 != null) {
                treeSet.remove(vehicle1);
                vehicle1 = this.treeSet.higher(vehicle);
            }

        } catch (Exception ignored) {
        }

    }

    public void removeLowerThen(InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            Vehicle.decreaseId();

            Vehicle vehicle1 = this.treeSet.lower(vehicle);

            while (vehicle1 != null) {
                treeSet.remove(vehicle1);
                vehicle1 = this.treeSet.lower(vehicle);
            }

        } catch (Exception ignored) {
        }
    }

    public void countPower(Long power) {

        int counter = 0;

        for (Vehicle vehicle1 : this.treeSet) {
            if (vehicle1.getEnginePower() > power) {
                counter++;
            }
        }
        System.out.println("Number of elements with greater engine power: " + counter);
    }

    public void countCapacity(Long capacity) {

        for (Vehicle vehicle1 : this.treeSet) {
            if (vehicle1.getCapacity() > capacity) {
                System.out.println(vehicle1);
            }
        }

    }

    public void printWheels() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Vehicle vehicle1 : this.treeSet) {
            arrayList.add(vehicle1.getNumberOfWheels());
        }
        arrayList.sort(Collections.reverseOrder());

        for (Integer i : arrayList) {
            System.out.println(i);
        }
    }
}
