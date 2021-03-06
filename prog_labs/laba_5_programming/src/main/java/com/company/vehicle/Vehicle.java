package com.company.vehicle;

import com.sun.istack.internal.NotNull;

import java.util.Date;

/**
 * Main class, that we are operating with
 */
public class Vehicle {
    private long id;
    @NotNull
    private String name;
    @NotNull
    private Coordinates coordinates;
    @NotNull
    private java.time.LocalDateTime creationDate;
    private Long enginePower;
    private int numberOfWheels;
    private Long capacity;
    private VehicleType type;

    public VehicleType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public Long getEnginePower() {
        return enginePower;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate +
                ", enginePower=" + enginePower +
                ", numberOfWheels=" + numberOfWheels +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }

    public Long getCapacity() {
        return capacity;
    }

    static private long currentId = 0;

    static public void decreaseId() {
        currentId--;
    }

    public Vehicle(String name, Coordinates coordinates, Long enginePower,
                   int numberOfWheels, Long capacity, VehicleType type) {
        this.name = name;
        this.coordinates = coordinates;
        this.enginePower = enginePower;
        this.numberOfWheels = numberOfWheels;
        this.capacity = capacity;
        this.type = type;

        currentId++;
        this.id = currentId;

        this.creationDate = java.time.LocalDateTime.now();

    }

    public Vehicle(ParsedVehicle vehicle1) {
        this.name = vehicle1.getName();
        this.coordinates = vehicle1.getCoordinates();
        this.enginePower = vehicle1.getEnginePower();
        this.numberOfWheels = vehicle1.getNumberOfWheels();
        this.capacity = vehicle1.getCapacity();
        this.type = vehicle1.getVehicleType();

        currentId++;
        this.id = currentId;

        this.creationDate = java.time.LocalDateTime.now();
    }
}
