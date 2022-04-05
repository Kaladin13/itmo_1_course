package com.company.collection;

public class VehicleServiceSingleton {
    static private VehicleService vehicleService;

    static public VehicleService getVehicleService() {
        if (vehicleService == null) {
            vehicleService = new VehicleService();
        }
        return vehicleService;
    }

    private VehicleServiceSingleton() {}
}
