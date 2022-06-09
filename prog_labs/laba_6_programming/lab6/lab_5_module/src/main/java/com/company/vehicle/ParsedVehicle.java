package com.company.vehicle;

import java.io.Serializable;

public class ParsedVehicle implements Serializable {
    String name;
    Long enginePower;
    Long capacity;
    int numberOfWheels;
    Coordinates coordinates;
    VehicleType vehicleType;
    Long creatorId;

    public Long getCreatorId() {
        return creatorId;
    }

    public String getName() {
        return name;
    }

    public Long getEnginePower() {
        return enginePower;
    }

    public Long getCapacity() {
        return capacity;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParsedVehicle(String name, Long enginePower, Long capacity, int numberOfWheels, Coordinates coordinates, VehicleType vehicleType, Long creatorId) {
        this.name = name;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.numberOfWheels = numberOfWheels;
        this.coordinates = coordinates;
        this.vehicleType = vehicleType;
        this.creatorId = creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}
