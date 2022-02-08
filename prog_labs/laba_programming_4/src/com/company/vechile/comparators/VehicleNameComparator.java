package com.company.vechile.comparators;

import com.company.vechile.Vehicle;

import java.util.Comparator;

public class VehicleNameComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle vehicle1, Vehicle vehicle2) {
        return vehicle1.getName().compareTo(vehicle2.getName());
    }
}

