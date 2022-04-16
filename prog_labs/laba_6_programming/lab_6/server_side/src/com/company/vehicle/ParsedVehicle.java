package com.company.vehicle;

public class ParsedVehicle {
    String name;
    Long enginePower;
    Long capacity;
    int numberOfWheels;
    Coordinates coordinates;
    VehicleType vehicleType;

    public ParsedVehicle(String name, Long enginePower, Long capacity, int numberOfWheels, Coordinates coordinates, VehicleType vehicleType) {
        this.name = name;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.numberOfWheels = numberOfWheels;
        this.coordinates = coordinates;
        this.vehicleType = vehicleType;
    }
}
