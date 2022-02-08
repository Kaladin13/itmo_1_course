package com.company.vechile;

import com.company.vechile.parts.Coordinates;
import com.company.vechile.parts.VehicleType;
import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
    private long id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDateTime creationDate;
    @Nullable
    private Long enginePower;
    private Integer numberOfWheels;
    @Nullable
    private Long capacity;
    private VehicleType type;


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", enginePower=" + enginePower +
                ", numberOfWheels=" + numberOfWheels +
                ", capacity=" + capacity +
                ", type=" + type +
                '}';
    }
}
