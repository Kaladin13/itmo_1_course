package com.company.collection;

import com.company.collection.comparators.VehicleCapacityComparator;
import com.company.collection.comparators.VehicleNameComparator;
import com.company.controller.VehicleParser;
import com.company.scanner.GsonParserSingleton;
import com.company.scanner.InputParser;
import com.company.vehicle.ParsedVehicle;
import com.company.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Main class, operating with collection
 */
public class VehicleService {
    private TreeSet<Vehicle> treeSet;
    private HistoryStack historyStack;
    private final LocalDateTime creationDate;


    public VehicleService() {
        Comparator<Vehicle> comparator = new VehicleNameComparator().
                thenComparing(new VehicleCapacityComparator());
        this.treeSet = new TreeSet<>(comparator);
        this.historyStack = new HistoryStack();
        this.creationDate = LocalDateTime.now();
    }

    public void addAllTree(TreeSet<Vehicle> treeSet) {
        this.treeSet.addAll(treeSet);
    }

    public ArrayDeque<Vehicle> getCollectionOfVehicles() {
        return new ArrayDeque<>(this.treeSet);
    }

    public void addToHistory(String command) {
        this.historyStack.add(command);
    }

    public ArrayDeque<String> getHistory() {
        return this.historyStack.show();
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

    public void addVehicle(ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        treeSet.add(vehicle);
    }

    public void updateVehicle(Long id, InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            updateVehicleById(id, vehicle);

            System.out.println("Id is not present in collection");

        } catch (Exception ignored) {
        }
    }

    public boolean updateVehicle(Long id, ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        return updateVehicleById(id, vehicle);
    }

    private boolean updateVehicleById(Long id, Vehicle vehicle) {
        Vehicle.decreaseId();
        vehicle.setId(id);

        for (Vehicle vehicle1 : this.treeSet) {

            if (vehicle1.getId().equals(id)) {
                this.treeSet.remove(vehicle1);
                this.treeSet.add(vehicle);
                return true;
            }

        }
        return false;
    }

    public boolean removeVehicle(Long id) {
        try {
            for (Vehicle vehicle1 : this.treeSet) {

                if (vehicle1.getId().equals(id)) {
                    this.treeSet.remove(vehicle1);
                    return true;
                }

            }
            System.out.println("Id is not present in collection");
            return false;
        } catch (Exception ignored) {
            return false;
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
        System.out.println("Saving collection in the file...");
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

            this.treeSet = this.treeSet.stream()
                    .filter(vehicle2 -> new VehicleNameComparator().compareBool(vehicle2, vehicle))
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>(new VehicleNameComparator().
                                    thenComparing(new VehicleCapacityComparator()))));

        } catch (Exception ignored) {
        }
    }

    public void removeGreaterThen(ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        Vehicle.decreaseId();

        this.treeSet = this.treeSet.stream()
                .filter(vehicle2 -> new VehicleNameComparator().compareBool(vehicle2, vehicle))
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(new VehicleNameComparator().
                                thenComparing(new VehicleCapacityComparator()))));
    }

    public void removeLowerThen(InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            Vehicle.decreaseId();

            this.treeSet = this.treeSet.stream()
                    .filter(vehicle2 -> !new VehicleNameComparator().compareBool(vehicle2, vehicle))
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>(new VehicleNameComparator().
                                    thenComparing(new VehicleCapacityComparator()))));

        } catch (Exception ignored) {
        }
    }

    public void removeLowerThen(ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        Vehicle.decreaseId();

        this.treeSet = this.treeSet.stream()
                .filter(vehicle2 -> !new VehicleNameComparator().compareBool(vehicle2, vehicle))
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(new VehicleNameComparator().
                                thenComparing(new VehicleCapacityComparator()))));
    }

    public int countPower(Long power) {

        int counter = 0;

        for (Vehicle vehicle1 : this.treeSet) {
            if (vehicle1.getEnginePower() > power) {
                counter++;
            }
        }
        return counter;
    }

    public ArrayDeque<Vehicle> countCapacity(Long capacity) {
        return this.treeSet.stream()
                .filter(vehicle2 -> vehicle2.getCapacity() > capacity)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public ArrayDeque<String> printWheels() {
        ArrayDeque<String> arrayList = new ArrayDeque<>();

        for (Vehicle vehicle1 : this.treeSet) {
            arrayList.addLast(String.valueOf(vehicle1.getNumberOfWheels()));
        }

//        arrayList.sort(Collections.reverseOrder());
        return arrayList;
    }
}
