package com.company;

import com.company.collection.VehicleServiceSingleton;
import com.company.controller.CommandReader;
import com.company.scanner.GsonParserSingleton;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Incorrect number of arguments");
            return;
        }
        try {
            GsonParserSingleton.getGsonCollectionParser().initGsonParser(args[0]);
            VehicleServiceSingleton.getVehicleService().addAllTree(GsonParserSingleton.getGsonCollectionParser().getCollection());
            InputParser inputParser = new InputParser(InputSource.CONSOLE);
            CommandReader commandReader = new CommandReader(inputParser);
            commandReader.startService();
        }
        catch (Exception ignored) {}
    }
}
