package com.company.collection.comparators;

import com.company.vehicle.Vehicle;

import java.util.Comparator;

public class VehicleNameComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
