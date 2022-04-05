package com.company.collection.comparators;

import com.company.vehicle.Vehicle;

import java.util.Comparator;

public class VehicleCapacityComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getCapacity().compareTo(o2.getCapacity());
    }
}
