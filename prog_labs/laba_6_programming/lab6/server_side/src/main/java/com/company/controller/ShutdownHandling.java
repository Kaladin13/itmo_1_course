package com.company.controller;

import com.company.collection.VehicleServiceSingleton;

public class ShutdownHandling {

    public static void addCollectionSavingHook() {
        Thread savingHook = new Thread(() -> VehicleServiceSingleton.getVehicleService().saveCollection());
        Runtime.getRuntime().addShutdownHook(savingHook);
    }
}
