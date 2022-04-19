package com.company;

import com.company.collection.VehicleServiceSingleton;
import com.company.controller.CommandReader;
import com.company.controller.ServerExecutor;
import com.company.controller.ShutdownHandling;
import com.company.scanner.GsonParserSingleton;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Incorrect number of arguments");
            return;
        }
        try {
            ShutdownHandling.addCollectionSavingHook();
            GsonParserSingleton.getGsonCollectionParser().initGsonParser(args[0]);
            VehicleServiceSingleton.getVehicleService().addAllTree(GsonParserSingleton.getGsonCollectionParser().getCollection());
            InputParser inputParser = new InputParser(InputSource.NET);
            ServerExecutor serverExecutor = new ServerExecutor(inputParser);
            CommandReader commandReader = new CommandReader(inputParser, serverExecutor);
            commandReader.startService();
        }
        catch (Exception ignored) {}
        finally {
            VehicleServiceSingleton.getVehicleService().saveCollection();
        }
    }
}
