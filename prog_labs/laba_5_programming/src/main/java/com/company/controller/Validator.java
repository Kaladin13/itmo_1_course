package com.company.controller;

import com.company.vehicle.Vehicle;

public class Validator {

    public static boolean isValidVehicle(Vehicle vehicle) {
        return vehicle.getId() != null &&
                !vehicle.getName().trim().isEmpty() &&
                (vehicle.getEnginePower() > 0) &&
                (vehicle.getNumberOfWheels() > 0) &&
                (vehicle.getType() != null);
    }
}
