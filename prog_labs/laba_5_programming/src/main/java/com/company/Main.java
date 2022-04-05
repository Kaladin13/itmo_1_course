package com.company;

import com.company.controller.CommandReader;
import com.company.scanner.GsonParserSingleton;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Incorrect number of arguments");
            return;
        }
        GsonParserSingleton.getGsonCollectionParser().initGsonParser(args[0]);
        InputParser inputParser = new InputParser(InputSource.CONSOLE);
        CommandReader commandReader = new CommandReader(inputParser);
        commandReader.startService();
    }
}
