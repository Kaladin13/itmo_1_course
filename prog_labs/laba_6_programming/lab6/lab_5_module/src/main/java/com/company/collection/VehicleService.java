package com.company.collection;

import com.company.collection.comparators.VehicleCapacityComparator;
import com.company.collection.comparators.VehicleNameComparator;
import com.company.command.UserDTO;
import com.company.controller.VehicleParser;
import com.company.controller.dao.UserDAO;
import com.company.controller.dao.VehicleSQLService;
import com.company.scanner.GsonParserSingleton;
import com.company.scanner.InputParser;
import com.company.vehicle.ParsedVehicle;
import com.company.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main class, operating with collection
 */
public class VehicleService {
    private SortedSet<Vehicle> treeSet;
    private HistoryStack historyStack;
    private VehicleSQLService sqlService;
    private final LocalDateTime creationDate;


    public VehicleService() {
        Comparator<Vehicle> comparator = new VehicleNameComparator().
                thenComparing(new VehicleCapacityComparator());
        this.treeSet = Collections.synchronizedSortedSet(new TreeSet<>(comparator));
//        this.treeSet = new TreeSet<>(comparator);
        this.historyStack = new HistoryStack();
        this.sqlService = new VehicleSQLService();
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
            sqlService.saveVehicle(vehicle);
        } catch (Exception ignored) {
        }
    }

    public void addVehicle(ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        sqlService.saveVehicle(vehicle);
        treeSet.add(sqlService.getVehicle(vehicle));
    }

    public void updateVehicle(Long id, InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }
            updateVehicleById(id, vehicle);
        } catch (Exception ignored) {
        }
    }

    public boolean updateVehicle(Long id, ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        return updateVehicleById(id, vehicle);
    }

    private boolean updateVehicleById(Long id, Vehicle vehicle) {
        vehicle.setId(id);
        for (Vehicle vehicle1 : this.treeSet) {

            if (vehicle1.getId().equals(id)) {
                if (vehicle1.getCreatorId().equals(vehicle.getCreatorId())) {
                    this.treeSet.remove(vehicle1);
                    sqlService.updateVehicleWithId(vehicle, id);
                    this.treeSet.add(sqlService.getVehicle(vehicle));
                    return true;
                }
            }

        }
        return false;
    }

    public boolean removeVehicle(Long id, UserDTO currentUser) {
        try {
            UserDAO userDAO = new UserDAO();

            for (Vehicle vehicle : this.treeSet) {

                if (vehicle.getId().equals(id)) {
                    vehicle.setCreatorId(userDAO.get(currentUser).getId());
                    if (vehicle.getCreatorId().equals(currentUser.getId())) {
                        this.treeSet.remove(vehicle);
                        sqlService.deleteVehicle(vehicle);
                        return true;
                    }
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

    public int clearCollection(UserDTO currentUser) {
        UserDAO userDAO = new UserDAO();
        currentUser = userDAO.get(currentUser);
        int count = 0;
        for (Vehicle vehicle : treeSet) {
            if (vehicle.getCreatorId().equals(currentUser.getId())) {
                treeSet.remove(vehicle);
                sqlService.deleteVehicle(vehicle);
                count++;
            }
        }
        return count;
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

            this.treeSet = this.treeSet.stream()
                    .filter(vehicle2 -> new VehicleNameComparator().compareBool(vehicle2, vehicle))
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>(new VehicleNameComparator().
                                    thenComparing(new VehicleCapacityComparator()))));

        } catch (Exception ignored) {
        }
    }

    public int removeGreaterThen(ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        int count = 0;
        for (Vehicle vehicle1 : treeSet) {
            if (vehicle1.getEnginePower() > vehicle.getEnginePower()) {
                if (vehicle1.getCreatorId().equals(vehicle.getCreatorId())) {
                    treeSet.remove(vehicle1);
                    sqlService.deleteVehicle(vehicle1);
                    count++;
                }
            }
        }
        return count;
    }

    public void removeLowerThen(InputParser inputParser) {
        try {
            VehicleParser vehicleParser = new VehicleParser(inputParser);
            Vehicle vehicle = vehicleParser.parseVehicle();
            if (vehicle == null) {
                return;
            }

            this.treeSet = this.treeSet.stream()
                    .filter(vehicle2 -> !new VehicleNameComparator().compareBool(vehicle2, vehicle))
                    .collect(Collectors.toCollection(() ->
                            new TreeSet<>(new VehicleNameComparator().
                                    thenComparing(new VehicleCapacityComparator()))));

        } catch (Exception ignored) {
        }
    }

    public int removeLowerThen(ParsedVehicle parsedVehicle) {
        Vehicle vehicle = new Vehicle(parsedVehicle);
        int count = 0;
        for (Vehicle vehicle1 : treeSet) {
            if (vehicle1.getCapacity() > vehicle.getCapacity()) {
                if (vehicle1.getCreatorId().equals(vehicle.getCreatorId())) {
                    treeSet.remove(vehicle1);
                    sqlService.deleteVehicle(vehicle1);
                    count++;
                }
            }
        }
        return count;

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

    public ParsedVehicle setSQLUser(UserDTO userDTO, ParsedVehicle parsedVehicle) {
        UserDAO userDAO = new UserDAO();
        parsedVehicle.setCreatorId(userDAO.get(userDTO).getId());
        return parsedVehicle;
    }
}
