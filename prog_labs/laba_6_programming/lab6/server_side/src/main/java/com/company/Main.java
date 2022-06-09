package com.company;

import com.company.collection.VehicleServiceSingleton;
import com.company.controller.ConnectionHandling;
import com.company.controller.dao.VehicleSQLService;

import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        try {
            java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
            VehicleSQLService vehicleSQLService = new VehicleSQLService();
            VehicleServiceSingleton.getVehicleService()
                    .addAllTree(vehicleSQLService.getAllVehicles());
            ConnectionHandling.startServer();
        }
        catch (Exception ignored) {}
    }
}
