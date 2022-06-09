package com.company.vehicle;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Main class, that we are operating with
 */
public class Vehicle implements Serializable {
    private long id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDateTime creationDate;
    private Long enginePower;
    private int numberOfWheels;
    private Long capacity;
    private VehicleType type;
    private Long creatorId;

    public Vehicle() {

    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

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
                ", created by user with id=" + creatorId +
                '}';
    }

    public Long getCapacity() {
        return capacity;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Vehicle(String name, Coordinates coordinates, Long enginePower,
                   int numberOfWheels, Long capacity, VehicleType type) {
        this.name = name;
        this.coordinates = coordinates;
        this.enginePower = enginePower;
        this.numberOfWheels = numberOfWheels;
        this.capacity = capacity;
        this.type = type;

        this.creationDate = java.time.LocalDateTime.now();

    }

    public Long getCreatorId() {
        return creatorId;
    }

    public Vehicle(ParsedVehicle vehicle1) {
        this.name = vehicle1.getName();
        this.coordinates = vehicle1.getCoordinates();
        this.enginePower = vehicle1.getEnginePower();
        this.numberOfWheels = vehicle1.getNumberOfWheels();
        this.capacity = vehicle1.getCapacity();
        this.type = vehicle1.getVehicleType();
        this.creationDate = java.time.LocalDateTime.now();
        this.creatorId = vehicle1.getCreatorId();
    }

    public Vehicle(VehicleSQL vehicle1) {
        this.id = vehicle1.getId();
        this.name = vehicle1.getName();
        this.coordinates = new Coordinates(vehicle1.getCoordinates_x(), vehicle1.getCoordinates_y());
        this.enginePower = vehicle1.getEnginePower();
        this.numberOfWheels = vehicle1.getNumberOfWheels();
        this.capacity = vehicle1.getCapacity();
        this.type = VehicleType.valueOf(vehicle1.getType());
        this.creationDate = java.time.LocalDateTime.now();
        this.creatorId = (long) vehicle1.getUserId();
    }
}
