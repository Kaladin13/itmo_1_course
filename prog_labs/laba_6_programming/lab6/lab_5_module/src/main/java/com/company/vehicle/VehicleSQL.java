package com.company.vehicle;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "vehicle", schema = "lab7")
@Table(name = "vehicle", schema = "s335095")
public class VehicleSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private Long coordinates_x;
    @Column
    private Long coordinates_y;
    @Column(name = "creation_date")
    private java.time.LocalDateTime creationDate;
    @Column(name = "engine_power")
    private Long enginePower;
    @Column(name = "number_of_wheels")
    private int numberOfWheels;
    @Column
    private Long capacity;
    @Column
    private String type;
    @Column(name = "user_id")
    private int userId;

    public VehicleSQL(Vehicle vehicle) {
        this.capacity = vehicle.getCapacity();
        this.coordinates_x = vehicle.getCoordinates().getX();
        this.coordinates_y = vehicle.getCoordinates().getY();
        this.creationDate = vehicle.getCreationDate();
        this.enginePower = vehicle.getEnginePower();
        this.name = vehicle.getName();
        this.type = vehicle.getType().name();
        this.numberOfWheels = vehicle.getNumberOfWheels();
        this.userId = Math.toIntExact(vehicle.getCreatorId());
    }

    @Override
    public String toString() {
        return "VehicleSQL{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates_x=" + coordinates_x +
                ", coordinates_y=" + coordinates_y +
                ", creationDate=" + creationDate +
                ", enginePower=" + enginePower +
                ", numberOfWheels=" + numberOfWheels +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                ", userId=" + userId +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCoordinates_x() {
        return coordinates_x;
    }

    public Long getCoordinates_y() {
        return coordinates_y;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getEnginePower() {
        return enginePower;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public Long getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public int getUserId() {
        return userId;
    }

    public VehicleSQL() {

    }
}
