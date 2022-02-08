package com.company.vechile.comparators;

import com.company.vechile.Vehicle;

import java.util.Comparator;

public class VehicleNumberOfWheelsComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return vehicle1.getNumberOfWheels().compareTo(vehicle2.getNumberOfWheels());
    }
}
