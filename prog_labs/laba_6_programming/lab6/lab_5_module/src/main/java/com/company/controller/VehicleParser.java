package com.company.controller;

import com.company.scanner.InputParser;
import com.company.vehicle.Coordinates;
import com.company.vehicle.ParsedVehicle;
import com.company.vehicle.Vehicle;
import com.company.vehicle.VehicleType;

/**
 * Parser of user input with all checks
 */
public class VehicleParser {
    private final InputParser inputParser;

    public VehicleParser(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public Vehicle parseVehicle() {
        try {
            String name = this.parseName();
            Long enginePower = this.parseEnginePower();
            Long capacity = this.parseCapacity();
            int numberOfWheels = this.parseNumberOfWheels();
            Coordinates coordinates = this.parseCoordinates();
            VehicleType vehicleType = this.parseVehicleType();

            return new Vehicle(name, coordinates, enginePower,
                    numberOfWheels, capacity, vehicleType);
        } catch (Exception e) {
            System.out.println("Critical Error in user input!");
            System.exit(1);
            return null;
        }
    }

    public ParsedVehicle parseParsedVehicle() {
        try {
            String name = this.parseName();
            Long enginePower = this.parseEnginePower();
            Long capacity = this.parseCapacity();
            int numberOfWheels = this.parseNumberOfWheels();
            Coordinates coordinates = this.parseCoordinates();
            VehicleType vehicleType = this.parseVehicleType();

            return new ParsedVehicle(name, enginePower, capacity, numberOfWheels, coordinates, vehicleType);
        } catch (Exception e) {
            System.out.println("Critical Error in user input!");
            System.exit(1);
            return null;
        }
    }

    private String parseName() {
        String name;
        while (true) {
            try {
                System.out.println("Enter name of the vehicle");
                name = this.inputParser.getScanner().nextLine();
                if (name.isEmpty() || name.trim().isEmpty()) {
                    System.out.println("Incorrect");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
            return name;
        }
    }

    private Long parseEnginePower() {
        long enginePower;
        while (true) {
            try {
                System.out.println("Enter engine power(>0) of the vehicle");
                enginePower = this.inputParser.getScanner().nextLong();
                if (enginePower <= 0) {
                    System.out.println("Incorrect");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
            return enginePower;
        }
    }

    private int parseNumberOfWheels() {
        int numberOfWheels;
        while (true) {
            try {
                System.out.println("Enter number of wheels(>0) of the vehicle");
                numberOfWheels = this.inputParser.getScanner().nextInt();
                if (numberOfWheels <= 0) {
                    System.out.println("Incorrect");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
            return numberOfWheels;
        }
    }

    private Long parseCapacity() {
        long capacity;
        while (true) {
            try {
                System.out.println("Enter capacity(>0) of the vehicle");
                capacity = this.inputParser.getScanner().nextLong();
                if (capacity <= 0) {
                    System.out.println("Incorrect");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
            return capacity;
        }
    }

    private VehicleType parseVehicleType() {
        String vehicleType;
        System.out.println("Enter vehicle type, you have such options: ");
        for (VehicleType type : VehicleType.values()) {
            System.out.println(type);
        }
        while (true) {
            try {
                vehicleType = this.inputParser.getScanner().nextLine();
                if (vehicleType.isEmpty()) {
                    continue;
                }
                for (VehicleType type : VehicleType.values()) {
                    if (vehicleType.equals(type.toString())) {
                        return type;
                    }
                }
                System.out.println("Incorrect");
            }
            catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
        }
    }

    private Coordinates parseCoordinates() {
        long x, y;
        while (true) {
            try {
                System.out.println("Enter coordinates of vehicle in such format: x y");
                x = this.inputParser.getScanner().nextLong();
                y = this.inputParser.getScanner().nextLong();
            } catch (Exception e) {
                System.out.println("Incorrect");
                this.inputParser.getScanner().nextLine();
                continue;
            }
            return new Coordinates(x, y);
        }
    }
}
