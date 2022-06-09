package com.company.controller.dao;

import com.company.collection.comparators.VehicleCapacityComparator;
import com.company.collection.comparators.VehicleNameComparator;
import com.company.vehicle.Vehicle;
import com.company.vehicle.VehicleSQL;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class VehicleSQLService {
    private final VehicleDAO vehicleDAO = new VehicleDAO();

    public void saveVehicle(Vehicle vehicle) {
        VehicleSQL vehicleSQL = new VehicleSQL(vehicle);
        vehicleDAO.save(vehicleSQL);
    }

    public void deleteVehicle(Vehicle vehicle) {
        VehicleSQL vehicleSQL = new VehicleSQL(vehicle);
        vehicleDAO.delete(vehicleSQL);
    }

    public void updateVehicle(Vehicle vehicle) {
        VehicleSQL vehicleSQL = new VehicleSQL(vehicle);
        vehicleDAO.update(vehicleSQL);
    }

    public void updateVehicleWithId(Vehicle vehicle, long id) {
        VehicleSQL vehicleSQL = new VehicleSQL(vehicle);
        vehicleSQL.setId(id);
        vehicleDAO.update(vehicleSQL);
    }

    public TreeSet<Vehicle> getAllVehicles() {
        List<VehicleSQL> list = vehicleDAO.getAll();
        if (list == null) {
            return null;
        }
        TreeSet<Vehicle> vehicles =
                list.stream().map(Vehicle::new).collect(Collectors.toCollection(() ->
                        new TreeSet<>(new VehicleNameComparator().
                                thenComparing(new VehicleCapacityComparator()))));
        return vehicles;
    }

    public Vehicle getVehicle(Vehicle vehicle) {
        VehicleSQL vehicleSQL = vehicleDAO.get(new VehicleSQL(vehicle));
        System.out.println("veh - " + vehicleSQL.toString());
        return new Vehicle(vehicleSQL);
    }
}
